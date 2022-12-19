package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaiKhoanDAO;
import model.ConnectToDatabase;
import model.TaiKhoan;
import util.EncryptionPass;

@WebServlet("/startbootstrap-sb-admin-2-master/ThemSuaXoaServerlet")
public class ThemSuaXoaServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ThemSuaXoaServerlet() {
        super();
      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chucNang = request.getParameter("chucNang");
		Map<String, String> erorr = new HashMap<String, String>();
		// set Tiếng Việt cho serverlet
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// kiểm tra chức năng
		// lấy dữ liệu
		System.out.println("chucNang " +chucNang);
		if(chucNang==null) {
			chucNang="Them";
		}
		String a = request.getParameter("action");
		System.out.println(a);
		//Xóa
		if(chucNang.equals("Xoa")) {
			chucNang = request.getParameter("chucNang");
			String id = request.getParameter("id");
			System.out.println(id);
			new TaiKhoanDAO().delete(id);
			TaiKhoanDAO tk = new TaiKhoanDAO();
			System.out.println(tk.mapTaiKhoan);
			request.setAttribute("tkAdmin", tk.mapTaiKhoan);
			getServletContext().getRequestDispatcher("/startbootstrap-sb-admin-2-master/manageOder?loai=user").forward(request, response);
		}
		//Thêm 
		if(chucNang.equals("Them")) {
			boolean isOk = true;
			String tenTaiKhoan = request.getParameter("userName");
			String matKhau = request.getParameter("passWord");
			String reMatKhau = request.getParameter("rePassWord");
			
			ConnectToDatabase con = new ConnectToDatabase();
			try {
				ResultSet rs = con.selectData("select * from TAI_KHOAN");
				while (rs.next()) {
					if(rs.getString(2).equals(tenTaiKhoan)) {
						erorr.put("duplicateUserName", "Tài khoản đã tồn tại");
						isOk =false;
					}
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(tenTaiKhoan== null || tenTaiKhoan.equals("")) {
				erorr.put("NoUserName", "Trường này không được bỏ trống");
				isOk =false;
			}
			if(matKhau== null || matKhau.equals("")) {
				erorr.put("NoPass", "Trường này không được bỏ trống");
				isOk =false;
			}
			if(reMatKhau== null || reMatKhau.equals("")) {
				erorr.put("NoRePass", "Trường này không được bỏ trống");
				isOk =false;
			}
			//check có trùng tài khoản không

			// check mật khẩu
			if(!matKhau.equals(reMatKhau)) {
				erorr.put("erorrRepass", "Mật khẩu không trùng khớp");
				isOk =false;
			}
			if(isOk) {
				try {					
						String tenKhachHang = request.getParameter("NameKH");
						System.out.println(tenKhachHang);
						String gioiTinh = request.getParameter("sex");
						String sdt = request.getParameter("telephone");
						String email = request.getParameter("email");
						String ngaySinh = request.getParameter("dayOfBith");
						String diaChi = request.getParameter("address");
						String quyen =  request.getParameter("rights");
						TaiKhoan user = new TaiKhoan(tenTaiKhoan, matKhau, tenKhachHang, gioiTinh, sdt, email, ngaySinh, diaChi, quyen);
						new TaiKhoanDAO().add(user);
						request.setAttribute("tkAdmin",  new TaiKhoanDAO().mapTaiKhoan);
						getServletContext().getRequestDispatcher("/startbootstrap-sb-admin-2-master/manageOder?loai=user").forward(request, response);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println(e.getMessage());
					}
			}else {
				request.setAttribute("erorr", erorr);
				getServletContext().getRequestDispatcher("/startbootstrap-sb-admin-2-master/addUser.jsp").forward(request, response);
			}


		}
		String taikhoan = request.getParameter("userName");
		if(chucNang.equals("Sua")) {
			ServletContext contextID = getServletContext();
			String id = (String) contextID.getAttribute("id");
			String tenTaiKhoan = request.getParameter("userName");
			String matKhau = request.getParameter("passWord");
			String reMatKhau = request.getParameter("rePassWord");
			ConnectToDatabase con = new ConnectToDatabase();
			boolean isOk = true;
			try {
				ResultSet rs = con.selectData("select * from TAI_KHOAN");
				while (rs.next()) {
					if(rs.getString(1).equals(tenTaiKhoan) && taikhoan!= tenTaiKhoan) {
						erorr.put("duplicateUserName", "Tài khoản đã tồn tại");
						isOk =false;
					}
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(isOk) {			
				String tenKhachHang = request.getParameter("NameKH");
				String gioiTinh = request.getParameter("sex");
				String sdt = request.getParameter("telephone");
				String email = request.getParameter("email");
				String ngaySinh = request.getParameter("dayOfBith");
				String diaChi = request.getParameter("address");
				String quyen =  request.getParameter("rights");
				matKhau = EncryptionPass.toSHA1(matKhau);
				TaiKhoan user = new TaiKhoan(id, matKhau, tenKhachHang, gioiTinh, sdt, email, ngaySinh, diaChi, quyen);
				new TaiKhoanDAO().edit(id, user);
				TaiKhoanDAO tk = new TaiKhoanDAO();
				System.out.println(tk.mapTaiKhoan);
				request.setAttribute("tkAdmin", tk.mapTaiKhoan);
				getServletContext().getRequestDispatcher("/startbootstrap-sb-admin-2-master/manageOder?loai=user").forward(request, response);	
			}else {
				request.setAttribute("erorr", erorr);
				getServletContext().getRequestDispatcher("/startbootstrap-sb-admin-2-master/addUser.jsp").forward(request, response);	
			}

		}
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
