package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ChiTietSanPhamDAO;
import dao.NhaCungCapDAO;
import dao.SanPhamDAO;
import dao.TaiKhoanDAO;
import model.ChiTiet_SanPham;
import model.NhaCungCap;
import model.SanPham;


/**
 * Servlet implementation class ThemSuaXoaSanPham
 */
@MultipartConfig
@WebServlet("/startbootstrap-sb-admin-2-master/ThemSuaXoaSanPham")
public class ThemSuaXoaSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemSuaXoaSanPham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chucNang = request.getParameter("chucNang");
		
		// set Tiếng Việt cho serverlet
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		if(chucNang.equals("Xoa")) {
			String maSP =  request.getParameter("maSP");
			new ChiTietSanPhamDAO().delete(maSP);
			new SanPhamDAO().delete(maSP);
			TaiKhoanDAO tk = new TaiKhoanDAO();
			getServletContext().getRequestDispatcher("/startbootstrap-sb-admin-2-master/manageOder?loai=product").forward(request, response);
		}else if(chucNang.equals("Them")) {
			String maSP = request.getParameter("maSP");
			String tenSP = request.getParameter("productName");
			String gia = request.getParameter("maSP");
			String giaBanSP = request.getParameter("priceOld");
			String giaGiam = request.getParameter("priceParent");
			String soLuongNhap = request.getParameter("numberImport");
			String sanPhamMoi = request.getParameter("new");
			String yeuThich = request.getParameter("like");
			String hinhAnh = request.getParameter("imageProduct");
			String sale = request.getParameter("sale");
			String tenNCC = request.getParameter("nameSupplier");
			String moTa = request.getParameter("description");
			String loaiSP = request.getParameter("type");
			String gioiTinh = request.getParameter("sex");
			String chatLieu = request.getParameter("material");
			String kieuDang = request.getParameter("design");
			String xuatXu = request.getParameter("origin");
			String phongCach = request.getParameter("style");
			
			// load ảnh
			Part part = request.getPart("imageProduct");
			String realPart = request.getServletContext().getRealPath("assets/img/product");
			String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
			if(!Files.exists(Path.of(realPart))) {
				Files.createDirectory(Path.of(realPart));
				
			}
			System.out.println(fileName);
			String fullPatr = realPart + "/" + fileName;
			System.out.println(fullPatr);
			part.write(fullPatr);
			Map<String, String> erorr = new HashMap<String, String>();
			boolean ok = true;
			SanPham maSPDAO = new SanPhamDAO().mapSanPham.get(maSP);
			if(maSPDAO != null) {
				erorr.put("duplicateMa", "Mã sảm phẩm đã tồn tại");
				ok = false;
			}
			if(maSP == null || maSP.equals("")) {
				erorr.put("NoID", "Vui lòng nhập trường này");
				ok = false;
			}
			if(tenSP == null || tenSP.equals("")) {
				erorr.put("NoName", "Vui lòng nhập trường này");
				ok = false;
			}

			if(giaGiam == null || giaGiam.equals("")) {
				erorr.put("NoPrice", "Vui lòng nhập trường này");
				ok = false;
			}
			if(soLuongNhap == null || soLuongNhap.equals("")) {
				erorr.put("NoNumberOf", "Vui lòng nhập trường này");
				ok = false;
			}
			if(!ok) {
				request.setAttribute("erorr", erorr);
				getServletContext().getRequestDispatcher("/startbootstrap-sb-admin-2-master/addProduct.jsp").forward(request, response);	
			}else {
				SanPham sp = new SanPham(maSP, tenSP, giaBanSP, giaGiam, sanPhamMoi, soLuongNhap, "0", fileName, sale,"1");
				String maNCC = "";
				for (NhaCungCap ncc : NhaCungCapDAO.mapNhaCC.values()) {
					if(ncc.getTenNCC().equals(tenNCC)) {
						maNCC = ncc.getMaNCC();
					}else {
						maNCC = "NCC0"+ NhaCungCapDAO.mapNhaCC.size();
					}
				}
				
				ChiTiet_SanPham ct_sp = new ChiTiet_SanPham(maSP, maNCC, moTa, loaiSP, gioiTinh, chatLieu, kieuDang, xuatXu, soLuongNhap, phongCach, "1");
				System.out.println(ct_sp);
				System.out.println(sp);
				new SanPhamDAO().add(sp);
				new ChiTietSanPhamDAO().add(ct_sp);
			
				getServletContext().getRequestDispatcher("/startbootstrap-sb-admin-2-master/manageOder?loai=product").forward(request, response);	
				
			}
			
		}else if(chucNang.equals("Sua")) {
			String maSP = request.getParameter("maSP");
			String tenSP = request.getParameter("productName");
			String giaBanSP = request.getParameter("priceOld");
			String giaGiam = request.getParameter("priceParent");
			String soLuongNhap = request.getParameter("numberImport");
			String sanPhamMoi = request.getParameter("new");
			String yeuThich = request.getParameter("like");
			String hinhAnh = request.getParameter("imageProduct");
			String sale = request.getParameter("sale");
			String tenNCC = request.getParameter("nameSupplier");
			String moTa = request.getParameter("description");
			String loaiSP = request.getParameter("type");
			String gioiTinh = request.getParameter("sex");
			String chatLieu = request.getParameter("material");
			String kieuDang = request.getParameter("design");
			String xuatXu = request.getParameter("origin");
			String phongCach = request.getParameter("style");
			
			SanPham sp = new SanPhamDAO().mapSanPham.get(maSP);
			SanPham sanpham = new SanPham(maSP, tenSP, giaBanSP, giaGiam, sanPhamMoi,soLuongNhap, sp.getSoLuongBan(),  hinhAnh, sale, yeuThich);
			
			ChiTiet_SanPham ct_sp = new ChiTietSanPhamDAO().mapChiTiet_SanPham.get(maSP);
			ChiTiet_SanPham newCT_SP = new ChiTiet_SanPham(maSP, ct_sp.getMaNCC(), moTa, loaiSP, gioiTinh, chatLieu, kieuDang, xuatXu, ct_sp.getSoLuongSPConLai(), phongCach, ct_sp.getTgBaoHanh());
			new SanPhamDAO().edit(maSP, sanpham);
			new ChiTietSanPhamDAO().edit(maSP, newCT_SP);
			System.out.println(maSP);
			getServletContext().getRequestDispatcher("/startbootstrap-sb-admin-2-master/manageOder?loai=product").forward(request, response);	
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		doGet(request, response);
	}

}
