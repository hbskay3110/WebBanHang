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
 * Servlet implementation class DuyetXoaXemDonHang
 */
@WebServlet("/startbootstrap-sb-admin-2-master/DuyetXoaXemDonHang")
public class DuyetXoaXemDonHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DuyetXoaXemDonHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String maDH = request.getParameter("id");
		String chucNang = request.getParameter("chucNang");
		String index = request.getParameter("index");
		DonHangDAO dhDAO = new DonHangDAO();
		DS_DonHangDAO dsDH_DAO = new DS_DonHangDAO();
		if(chucNang.equals("Xoa")) {
			dhDAO.delete(maDH);
			dsDH_DAO.delete(maDH);
			request.getRequestDispatcher("/startbootstrap-sb-admin-2-master/manageOder?loai=oder&index="+index+"").forward(request, response);
		}else if(chucNang.equals("Duyet")) {
			DonHang dh = dhDAO.mapDonHang.get(maDH);
			DonHang dhNew = new DonHang(maDH, dh.getTenTaiKhoan(), dh.getNgayDatHang(), dh.getTongTien(), dh.getSoDienThoai(), dh.getTenNguoiNhan(), dh.getDiaChi(), dh.getGhiChu(), "1");
			dhDAO.edit(maDH, dhNew);
			request.getRequestDispatcher("/startbootstrap-sb-admin-2-master/manageOder?loai=oder&index="+index+"").forward(request, response);
		}else if(chucNang.equals("Xem")){
			DS_DonHangDAO ds = new DS_DonHangDAO();
			List<DS_DonHang> listDS = ds.dsDHByMaDH(maDH);
			SanPhamDAO spDAO = new SanPhamDAO();
			List<BillProduct> listBill = new ArrayList<BillProduct>();
			for (DS_DonHang d : listDS) {
					SanPham s = spDAO.mapSanPham.get(d.getMaSP());
					BillProduct bill = new BillProduct(s.getMaSP(), s.getTenSP(), s.getGiaGiam(),d.getSlMua(),d.getGia(),s.getHinhAnh());
					listBill.add(bill);
			}
			System.out.println(listBill);
			DonHang donHang = DonHangDAO.mapDonHang.get(maDH);
			request.setAttribute("donHang", donHang);
			request.setAttribute("index", index);
			request.setAttribute("listBill", listBill);
			request.getRequestDispatcher("/startbootstrap-sb-admin-2-master/DetailOder.jsp").forward(request, response);
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
