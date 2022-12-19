package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DonHangDAO;
import dao.SanPhamDAO;
import dao.TaiKhoanDAO;
import model.DonHang;
import model.SanPham;
import model.TaiKhoan;

/**
 * Servlet implementation class manageOder
 */
@WebServlet("/startbootstrap-sb-admin-2-master/manageOder")
public class ManageOder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageOder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loai = request.getParameter("loai");
		String searchTxt = request.getParameter("searchTXT");
		String indexString = request.getParameter("index");
		if(indexString== null) {
			indexString="1";
		}
		if(loai.equals("oder")) {
			DonHangDAO dhDAO = new DonHangDAO();
			Map<String, DonHang> dsDonHang = dhDAO.mapDonHang;
			int count = dhDAO.mapDonHang.size();
			int pageSize = 2;
			int endPage =0;
			endPage = count/pageSize;
			if(count% pageSize !=0 && count> pageSize) {
				endPage ++;
			}
			if(endPage==0) {
				endPage=1;
			}
			int index = Integer.parseInt(indexString);
			List<DonHang> dh = new DonHangDAO().searchByAttribute(index, pageSize, searchTxt);
			System.out.println(dh);
			if(searchTxt!=null) {
				request.setAttribute("searchTxt", searchTxt);
			}
			request.setAttribute("dsDonHang", dh);
			request.setAttribute("endPage", endPage);
			request.setAttribute("index", index);
			request.getRequestDispatcher("/startbootstrap-sb-admin-2-master/ManageOder.jsp").forward(request, response);
			
		}		
		if(loai.equals("product")) {
			int count = SanPhamDAO.mapSanPham.size();
			int pageSize = 20;
			int endPage =0;
			endPage = count/pageSize;
			if(count% pageSize !=0 && count> pageSize) {
				endPage ++;
			}
			if(endPage==0) {
				endPage=1;
			}
			int index = Integer.parseInt(indexString);
			List<SanPham> listSP = new SanPhamDAO().searchByAttribute(index, pageSize, "ASC", "MaSP", searchTxt, null);
			if(searchTxt!=null) {
				request.setAttribute("searchTxt", searchTxt);
			}
			request.setAttribute("listSP", listSP);
			request.setAttribute("endPage", endPage);
			request.setAttribute("index", index);
			request.getRequestDispatcher("/startbootstrap-sb-admin-2-master/sampham.jsp").forward(request, response);
		}
		if(loai.equals("user")) {
			int count = TaiKhoanDAO.mapTaiKhoan.size();
			int pageSize = 20;
			int endPage =0;
			endPage = count/pageSize;
			if(count% pageSize !=0 && count> pageSize) {
				endPage ++;
			}
			if(endPage==0) {
				endPage=1;
			}
			int index = Integer.parseInt(indexString);
			List<TaiKhoan> listUser = new TaiKhoanDAO().searchByAttribute(index, pageSize, searchTxt);
			if(searchTxt!=null) {
				request.setAttribute("searchTxt", searchTxt);
				
			}
			request.setAttribute("listUser", listUser);
			request.setAttribute("endPage", endPage);
			request.setAttribute("index", index);
			request.getRequestDispatcher("/startbootstrap-sb-admin-2-master/manageUser.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		doGet(request, response);
	}

}
