package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ChiTietSanPhamDAO;
import dao.NhaCungCapDAO;
import dao.SanPhamDAO;
import model.ChiTiet_SanPham;
import model.NhaCungCap;
import model.SanPham;

/**
 * Servlet implementation class forwardRepair
 */
@WebServlet("/startbootstrap-sb-admin-2-master/forwardRepair")
public class forwardRepair extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forwardRepair() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maSP= request.getParameter("id");
		SanPham sanPham = new SanPhamDAO().mapSanPham.get(maSP);
		ChiTiet_SanPham chiTiet_SanPham = ChiTietSanPhamDAO.mapChiTiet_SanPham.get(maSP);

		System.out.println(sanPham);
		NhaCungCap ncc = NhaCungCapDAO.mapNhaCC.get(chiTiet_SanPham.getMaNCC());
		request.setAttribute("sp", sanPham);
		request.setAttribute("ct_sp", chiTiet_SanPham);
		request.setAttribute("ncc", ncc);
		getServletContext().getRequestDispatcher("/startbootstrap-sb-admin-2-master/repairSP.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
