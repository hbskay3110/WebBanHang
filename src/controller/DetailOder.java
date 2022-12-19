package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DS_DonHangDAO;
import dao.DonHangDAO;
import dao.SanPhamDAO;
import model.BillProduct;
import model.DS_DonHang;
import model.DonHang;
import model.SanPham;

/**
 * Servlet implementation class DetailOder
 */
@WebServlet("/product/DetailOder")
public class DetailOder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DetailOder() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maDH = request.getParameter("maDH");
		DS_DonHangDAO ds = new DS_DonHangDAO();
		
		List<DS_DonHang> listDS = ds.dsDHByMaDH(maDH);
		SanPhamDAO spDAO = new SanPhamDAO();
		List<SanPham> listSP = spDAO.getSanPhamByDH(listDS);
		System.out.println(listSP);
		List<BillProduct> listBill = new ArrayList<BillProduct>();
		
		for (DS_DonHang d : listDS) {
				SanPham s = spDAO.mapSanPham.get(d.getMaSP());
				BillProduct bill = new BillProduct(s.getMaSP(), s.getTenSP(), s.getGiaGiam(),d.getSlMua(),d.getGia(),s.getHinhAnh());
				listBill.add(bill);
		}
		request.setAttribute("listBill", listBill);
		request.getRequestDispatcher("/product/DetailOder.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
