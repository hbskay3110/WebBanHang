package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ChiTietSanPhamDAO;
import dao.SanPhamDAO;
import model.ChiTiet_SanPham;
import model.SanPham;
import model.BillProduct;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/product/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maSP = request.getParameter("maSP");
		System.out.println(maSP);
		String soLuong = request.getParameter("quantity");
		System.out.println(soLuong);
		SanPham sp = SanPhamDAO.mapSanPham.get(maSP);
		ChiTiet_SanPham ct_sp = ChiTietSanPhamDAO.mapChiTiet_SanPham.get(maSP);
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("cart");
		double gia= 0;
		int tongSanPham = 0;
		double tongTien=0;
		int sizeCart=0;
		String action = request.getParameter("action"); // gọi tới dữ liệu có tên là action 
		if( action.equals("Them")) {
			// nếu chưa có session cart
			if(obj==null) {
				try {
					 gia = Double.parseDouble(sp.getGiaGiam());
					 tongSanPham = Integer.parseInt(soLuong);
				} catch (Exception e) {
					// TODO: handle exception
					e.getMessage();
				}
				tongTien = gia * tongSanPham;	
				BillProduct billProduct = new BillProduct(maSP, sp.getTenSP(),sp.getGiaGiam(),tongSanPham, tongTien, sp.getHinhAnh());
				
				Map<String, BillProduct> mapCart = new HashMap<String, BillProduct>();
				mapCart.put(maSP, billProduct);
				sizeCart = mapCart.size();   
				session.setAttribute("cart", mapCart);
				session.setAttribute("total", billProduct.getTong());
			}else {
				Map<String, BillProduct> mapCart = (Map<String, BillProduct>)obj;
				BillProduct billProduct = mapCart.get(maSP);
				double total=0;
				
				// chưa có sản phẩm đó trong giỏ hàng
				if(billProduct==null) {
					try {
						 gia = Double.parseDouble(sp.getGiaGiam());
						 tongSanPham = Integer.parseInt(soLuong);
					} catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
					 tongTien = gia * tongSanPham;
					 System.out.println(tongTien);
					billProduct = new BillProduct(maSP, sp.getTenSP(),sp.getGiaGiam(),tongSanPham, tongTien, sp.getHinhAnh());			
					mapCart.put(maSP, billProduct);
				}else { // đã có sản phẩm đó trong giỏ hàng
					try {
						 gia = Double.parseDouble(sp.getGiaGiam());
						 tongSanPham = Integer.parseInt(soLuong) + billProduct.getSoLuong();
					} catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
					 tongTien = gia * tongSanPham;
				
					billProduct.setSoLuong(tongSanPham);
					billProduct.setTong(tongTien);
				}
				for (BillProduct b : mapCart.values()) {
					total+= b.getTong();
				}
				sizeCart = mapCart.size();   
				session.setAttribute("cart", mapCart);
				session.setAttribute("total", total);
			}
		}
		if(action.equals("Xoa")) {
			Map<String, BillProduct> mapCart = (Map<String, BillProduct>)obj;
			mapCart.remove(maSP);
			session.setAttribute("cart", mapCart);
			sizeCart = mapCart.size();   
		}
		
		session.setAttribute("sizeCart", sizeCart);
		getServletContext().getRequestDispatcher("/product/cart.jsp").forward(request, response);;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
