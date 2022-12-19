package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BillProduct;
import model.DS_DonHang;
import model.DonHang;
import dao.DS_DonHangDAO;
import dao.DonHangDAO;
import model.TaiKhoan;

/**
 * Servlet implementation class DonHang
 */
@WebServlet("/DonHang")
public class DonHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @param date 
     * @param string2 
     * @param string 
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fName= request.getParameter("Firstname");
		String addressDetail = request.getParameter("address");
		String city = request.getParameter("city");
		String telephone = request.getParameter("telephone");
		String note = request.getParameter("note");
		HttpSession session = request.getSession();
		TaiKhoan tk = (TaiKhoan) session.getAttribute("userLogin");
		Map<String, BillProduct> ds = (Map<String, BillProduct>) session.getAttribute("cart");
		double tong = (double) session.getAttribute("fullPrice");
		String tongS = String.valueOf(tong);

		if(fName==null) fName = tk.getTenKhachHang();
		if(addressDetail == null) addressDetail = tk.getDiaChi();
		if(telephone==null) telephone = tk.getSoDienThoai();
		
		String maxMa = new DonHangDAO().maxMaDH();
		if(maxMa==null || maxMa =="") {
			maxMa="000";
		}
		int maDHInt = Integer.valueOf(maxMa) +1;
		String maDH = String.valueOf(maDHInt);
		if(maDH.length()==1) {
			maDH="00"+ maDHInt;
		}
		if(maDH.length()==2) {
			maDH="0"+ maDHInt;
		}
	
		String date = String.valueOf(java.time.LocalDate.now());
		
		String address = addressDetail + " " + city;
		DonHang dh = new DonHang(maDH, tk.getTenTaiKhoan(), date, tongS, telephone, fName, address, note, "0");
		new DonHangDAO().add(dh);
		for (BillProduct product : ds.values()) {
		
			DS_DonHang ds_dh = new DS_DonHang(maDH, product.getMaSP(), product.getSoLuong(), product.getTong());
			new DS_DonHangDAO().add(ds_dh);
		}
		
		session.removeAttribute("sizeCart");
		session.removeAttribute("cart");
		request.getRequestDispatcher("/renderSP").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
