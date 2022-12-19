package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.mail.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import model.ConnectToDatabase;
import model.DonHang;
import model.TaiKhoan;

public class TaiKhoanDAO implements ObjectDAO {
	public static Map<String, TaiKhoan> mapTaiKhoan = loadData();

	public TaiKhoanDAO() {
		// TODO Auto-generated constructor stub
	}

	private static Map<String, TaiKhoan> loadData() {
		Map<String, TaiKhoan> mapTemp = new HashMap<String, TaiKhoan>();
		try {
			ResultSet rs = new ConnectToDatabase().selectData("select * from TAI_KHOAN");
			while (rs.next()) {
				String taiKhoan = rs.getString(1);
				String matKhau = rs.getString(2);
				String tenKhachHang = rs.getString(3);
				String gioiTinh = rs.getString(4);
				String soDienThoai = rs.getString(5);
				String email = rs.getString(6);
				String ngaySinh = rs.getString(7);
				String diaChi = rs.getString(8);
				String quyen = rs.getString(9);

				TaiKhoan user = new TaiKhoan(taiKhoan, matKhau, tenKhachHang, gioiTinh, soDienThoai, email, ngaySinh,
						diaChi, quyen);
				mapTemp.put(user.getTenTaiKhoan(), user);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapTemp;

	}

	public boolean checkLogin(String userName, String passWord) {
		TaiKhoan user = mapTaiKhoan.get(userName);
		if (user != null) {
			if (user.getMatKhau().equals(passWord)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean changePass(String userName, String newPass) {
		TaiKhoan user = mapTaiKhoan.get(userName);
		if (user != null) {
			user.setMatKhau(newPass);
			mapTaiKhoan.replace(user.getTenTaiKhoan(), user);
			edit(user.getTenTaiKhoan(), user);
			return true;
		} else {
			return false;
		}
	}

	public static boolean sendMail(String to, String subject, String text) {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("ntkien123@gmail.com", "hbskay123@");
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setHeader("Content-Type", "text/plain; charset=UTF-8");
			message.setFrom(new InternetAddress("shopphoneltw@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(text);
			Transport.send(message);
		} catch (MessagingException e) {
			e.getMessage();
			return false;
		}

		return true;
	}

	public boolean passRecorvery(String userName, String email) {

		TaiKhoan tk = mapTaiKhoan.get(userName);
		if (tk != null) {
			sendMail(email, "Cập nhật lại mật khẩu", tk.getMatKhau());
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		TaiKhoanDAO tkDao = new TaiKhoanDAO();
//		System.out.println(tkDao.mapTaiKhoan);
//		System.out.println(tkDao.checkLogin("anphan219", "phanan219"));
//		System.out.println(tkDao.checkLogin("anphan29", "phanan219"));
		System.out.println(tkDao.passRecorvery("anphan219", "phanthyan123@gmail.com"));
	}

	@Override
	public boolean add(Object obj) {
		TaiKhoan tk = (TaiKhoan) obj;
		mapTaiKhoan.put(tk.getTenTaiKhoan(), tk);
		String sql = "insert into TAI_KHOAN values(?,?,?,?,?,?,?,?,?)";

		try {
			Connection connect = new ConnectToDatabase().getConnection();
			PreparedStatement ppstm = connect.prepareStatement(sql);
			;
			ppstm.setString(1, tk.getTenTaiKhoan());
			ppstm.setString(2, tk.getMatKhau());
			ppstm.setString(3, tk.getTenKhachHang());
			ppstm.setString(4, tk.getGioiTinh());
			ppstm.setString(5, tk.getSoDienThoai());
			ppstm.setString(6, tk.getEmail());
			ppstm.setString(7, tk.getNgaySinh());
			ppstm.setString(8, tk.getDiaChi());
			ppstm.setString(9, tk.getQuyen());
			ppstm.executeUpdate();
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean edit(String id, Object obj) {
		TaiKhoan tk = (TaiKhoan) obj;
		mapTaiKhoan.replace(id, tk);
		try {
			String sql = "update TAI_KHOAN set MatKhau=?,TenKhachHang=?,Gioitinh=?,Sdt=?,Email=?,Ngaysinh=?,Diachi=?,Quyen=? where TenTaiKhoan=?";
			Connection connect = new ConnectToDatabase().getConnection();
			PreparedStatement ppstm = connect.prepareStatement(sql);
		
			ppstm.setString(1, tk.getMatKhau());
			ppstm.setString(2, tk.getTenKhachHang());
			ppstm.setString(3, tk.getGioiTinh());
			ppstm.setString(4, tk.getSoDienThoai());
			ppstm.setString(5, tk.getEmail());
			ppstm.setString(6, tk.getNgaySinh());
			ppstm.setString(7, tk.getDiaChi());
			ppstm.setString(8, tk.getQuyen());
			ppstm.setString(9, id);
			ppstm.executeUpdate();
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;

	}

	public List<TaiKhoan> searchByAttribute(int index, int size, String txtSearch) {
		try {
			Connection connect = new ConnectToDatabase().getConnection();
			ResultSet rs = null;
			PreparedStatement ppstm;
			List<TaiKhoan> list = new ArrayList<TaiKhoan>();
			String query = "";
			if (txtSearch == null) {
				query = "with x as (select ROW_NUMBER() over (order by TenTaiKhoan ASC ) as r,* from TAI_KHOAN)\r\n"
						+ "select * from x where r between ?*?-(?-1) and ?*?";
				ppstm = connect.prepareStatement(query);
				ppstm.setInt(1, index);
				ppstm.setInt(2, size);
				ppstm.setInt(3, size);
				ppstm.setInt(4, index);
				ppstm.setInt(5, size);
			} else {
				query = "with x as (select ROW_NUMBER() over (order by TenTaiKhoan ASC ) as r,* from TAI_KHOAN where TenTaiKhoan like ?)\r\n"
						+ "select * from x where r between ?*?-(?-1) and ?*?";
				ppstm = connect.prepareStatement(query);
				ppstm.setString(1, "%" + txtSearch + "%");
				ppstm.setInt(2, index);
				ppstm.setInt(3, size);
				ppstm.setInt(4, size);
				ppstm.setInt(5, index);
				ppstm.setInt(6, size);
			}
			rs = ppstm.executeQuery();
			while (rs.next()) {
				TaiKhoan dh = new TaiKhoan(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
				list.add(dh);
			}
			return list;

		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public boolean delete(String tenTaiKhoan) {
		mapTaiKhoan.remove(tenTaiKhoan);
		try {
			new ConnectToDatabase().excuteSql("delete from TAI_KHOAN where TenTaiKhoan='" + tenTaiKhoan + "'");
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

}
