  package controller;

import java.io.IOException;
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

/**
 * Servlet implementation class productDetail
 */
@WebServlet("/product/productDetail")
public class productDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public productDetail() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String maSP = request.getParameter("maSP");
		if(session.getAttribute("userLogin")==null) {
			request.setAttribute("maSP", maSP);
			response.sendRedirect("/WebsBanHang/Login.jsp");
		}else {	
			SanPham sp = SanPhamDAO.mapSanPham.get(maSP);
			ChiTiet_SanPham ct_sp = ChiTietSanPhamDAO.mapChiTiet_SanPham.get(maSP);
			request.setAttribute("sp", sp);
			System.out.println(ct_sp.toString());
			request.setAttribute("CT_SP", ct_sp);
			getServletContext().getRequestDispatcher("/product/product-details.jsp").forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
