package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SanPhamDAO;
import dao.TaiKhoanDAO;
import model.ConnectToDatabase;
import model.SanPham;
import model.TaiKhoan;
import util.EncryptionPass;

/**
 * Servlet implementation class LoginSerlet
 */
@WebServlet("/Login")
public class LoginSerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// set Tiếng Việt cho serverlet
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//
		Map<String, String> erorr = new HashMap<String, String>();
		String action = request.getParameter("action");
		System.out.println(action);
		if (action == null) {
			System.out.println("Không thực hiện");
		}
		if (action.equals("Logout")) {
			
			HttpSession session = request.getSession();
			session.invalidate();
			getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		
		if (action.equals("Login")) {
			String userName = request.getParameter("email");
			String passOld = request.getParameter("pass");
			String pass = EncryptionPass.toSHA1(passOld);
			System.out.println(pass);
			System.out.println(userName);
			if (new TaiKhoanDAO().checkLogin(userName, pass)) {
				HttpSession session = request.getSession();
				TaiKhoan tk = TaiKhoanDAO.mapTaiKhoan.get(userName);
				System.out.println(tk);
				session.setAttribute("userLogin", tk);
				request.getRequestDispatcher("/renderSP").forward(request, response);
			} else {
				TaiKhoan tk = TaiKhoanDAO.mapTaiKhoan.get(userName);
				if (tk == null) {
					erorr.put("erorrUser", "Tên đăng nhập không tồn tại");
				} else {
					erorr.put("erorrPass", "Sai mật khẩu");
				}
				request.setAttribute("email", userName);
				request.setAttribute("erorr", erorr);
				getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);

			}

		} else if (action.equals("forgot")) {
//			String userName = request.getParameter("userName");
//			System.out.println(userName);
//			String email = request.getParameter("email");
//			try {
//				if (new TaiKhoanDAO().passRecorvery(userName, email)) {
//				HttpSession session = request.getSession();
//				session.setAttribute("openDiaLog", "ok");
//				getServletContext().getRequestDispatcher("/forgotPass.jsp").forward(request, response);
//				} else {
//					TaiKhoan tk = TaiKhoanDAO.mapTaiKhoan.get(userName);
//					System.out.println(tk);
//					if (tk == null) {
//						erorr.put("erorrUser", "Tên đăng nhập không tồn tại");
//						getServletContext().getRequestDispatcher("/forgotPass.jsp").forward(request, response);
//					} else {
//						erorr.put("erorrEmail", "Email không hợp lệ");
//						getServletContext().getRequestDispatcher("/forgotPass.jsp").forward(request, response);
//				}
		}else if (action.equals("Res")) {
			String ho = request.getParameter("lastName");
			String ten = request.getParameter("firstName");
			String tenTaiKhoan = request.getParameter("userName");
			String matKhau = request.getParameter("pass");
			String reMatKhau = request.getParameter("repass");
			String gioiTinh = request.getParameter("sex");
			String ngaySinh = request.getParameter("dob");
			String sdt = request.getParameter("telephone");
			boolean ok = true;
			TaiKhoan user = TaiKhoanDAO.mapTaiKhoan.get(tenTaiKhoan);
			if(user != null) {
				erorr.put("erorrTK", "Tài khoản đã tồn tại");
				ok =false;
			}
			if(!matKhau.equals(reMatKhau)){
				erorr.put("erorrRepass", "Mật khẩu không trùng khớp");
				ok =false;
				
			}
			if(ok) {
			try {
				matKhau = EncryptionPass.toSHA1(matKhau);
			TaiKhoan tk = new TaiKhoan( tenTaiKhoan, matKhau, ho+" "+ten, gioiTinh, sdt, null, ngaySinh, null, "user");
			HttpSession session = request.getSession();
			TaiKhoanDAO.mapTaiKhoan.put(tk.getTenTaiKhoan(), tk);
			session.setAttribute("userLogin", tk);
			// add vào db
			new TaiKhoanDAO().add(tk);
			getServletContext().getRequestDispatcher("/renderSP").forward(request, response);	

			}catch(Exception e){
				e.getStackTrace();
			}
			}else {
				request.setAttribute("erorr", erorr);
				getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);	
			}
		}else if(action.equals("change")) {
			String passOld = request.getParameter("passOld");
			String passNew = request.getParameter("passNew");
			String rePassNew  = request.getParameter("rePassNew");
			HttpSession session = request.getSession();
			TaiKhoan tk = (TaiKhoan) session.getAttribute("userLogin");
			boolean ok = true;
			if(!tk.getMatKhau().equals(EncryptionPass.toSHA1(passOld))) {
				erorr.put("FaslePass", "Sai mật khẩu");
				ok= false;
			}
			if(!passNew.equals(rePassNew)) {
				erorr.put("notMatch", "Mật khẩu không khớp");
				ok =false;
			}
			if(ok) {
				String pass = EncryptionPass.toSHA1(passNew);
				
				TaiKhoan user = new TaiKhoan(tk.getTenTaiKhoan(), pass, tk.getTenKhachHang(), tk.getGioiTinh(), tk.getSoDienThoai(), tk.getEmail(), tk.getNgaySinh(), tk.getDiaChi(), tk.getQuyen());
				new TaiKhoanDAO().edit(tk.getTenTaiKhoan(), user);
				session.setAttribute("userLogin", user);
				request.getRequestDispatcher("renderSP").forward(request, response);	
			}else {
				request.setAttribute("erorr", erorr);
				getServletContext().getRequestDispatcher("/changePass.jsp").forward(request, response);	
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set Tiếng Việt cho serverlet
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//
		doGet(request, response);

	}

}
