package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.renderSP;
import model.ConnectToDatabase;
import model.DonHang;
import model.SanPham;


public class DonHangDAO implements ObjectDAO {
	public static Map<String, DonHang> mapDonHang = loadData();
	
	public DonHangDAO() {
		// TODO Auto-generated constructor stub
	}
	private static Map<String, DonHang> loadData(){
		Map<String, DonHang> mapTemp = new HashMap<String, DonHang>();
		try {
			ResultSet rs = new ConnectToDatabase().selectData("select * from DON_HANG");
			while (rs.next()) {
				String maDH = rs.getString(1);
				String tenTaiKhoan  = rs.getString(2);
				String ngayDatHang  = rs.getString(3);
				String tongTien  = rs.getString(4);
				String soDienThoai  = rs.getString(5);
				String tenNguoiNhan  = rs.getString(6);
				String diaChi  = rs.getString(7);
				String ghiChu  = rs.getString(8);
				String trangThai  = rs.getString(9);
				DonHang donHang = new DonHang(maDH, tenTaiKhoan, ngayDatHang, tongTien, soDienThoai, tenNguoiNhan, diaChi, ghiChu, trangThai);
				mapTemp.put(donHang.getMaDH(), donHang);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapTemp;
		
	}
	@Override
	public boolean add(Object obj) {
		DonHang sp = (DonHang) obj;
		mapDonHang.put(sp.getMaDH(), sp);
		String sql = "insert into DON_HANG values(?,?,?,?,?,?,?,?,?)";
		try {
			Connection connect = new ConnectToDatabase().getConnection();
			PreparedStatement ppstm = connect.prepareStatement(sql);
			ppstm.setString(1,sp.getMaDH());
			ppstm.setString(2,sp.getTenTaiKhoan());
			ppstm.setString(3,sp.getNgayDatHang());
			ppstm.setString(4,sp.getTongTien());
			ppstm.setString(5,sp.getSoDienThoai());
			ppstm.setString(6,sp.getTenNguoiNhan());
			ppstm.setString(7,sp.getDiaChi());
			ppstm.setString(8,sp.getGhiChu());
			ppstm.setString(9,sp.getTrangThai());
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
		DonHang donHang = (DonHang) obj;
		mapDonHang.replace(id, donHang);
		try {	
			String sql = "update DON_HANG set TenTaiKhoan=?,NgayDatHang=?,TongTien=?,SoDienThoai=?,TenNguoiNhan=?,DiaChi=?,GhiChu=?,TrangThai=? where MaDH=?";
				Connection connect = new ConnectToDatabase().getConnection();
				PreparedStatement ppstm = connect.prepareStatement(sql);
				ppstm.setString(1,donHang.getTenTaiKhoan());
				ppstm.setString(2,donHang.getNgayDatHang());
				ppstm.setString(3,donHang.getTongTien());
				ppstm.setString(4,donHang.getSoDienThoai());
				ppstm.setString(5,donHang.getTenNguoiNhan());
				ppstm.setString(6,donHang.getDiaChi());
				ppstm.setString(7,donHang.getGhiChu());
				ppstm.setString(8,donHang.getTrangThai());
				ppstm.setString(9,donHang.getMaDH());
				ppstm.executeUpdate();
				return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
			return false;
		
	}
	@Override
	public boolean delete(String id) {
		mapDonHang.remove(id);
		try {
			
			new ConnectToDatabase().excuteSql("delete from DON_HANG where MaDH='"+id+"'");
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	public List<DonHang> top5DonHang(String userName){
		try {
			String query = "with x as (select ROW_NUMBER() over (order by NgayDatHang DESC) as r,* from DON_HANG  where TenTaiKhoan = ? )\r\n"
					+ "	select * from x where r between 1 and 5";
			Connection connect = new ConnectToDatabase().getConnection();
			PreparedStatement ppstm = connect.prepareStatement(query);
			ppstm.setString(1, userName);
			ResultSet rs = null;
			rs =ppstm.executeQuery();
			List<DonHang> list = new ArrayList<DonHang>();
			while(rs.next()) {
				DonHang sp = new DonHang(rs.getString(2), 
						rs.getString(3),
						rs.getString(4), 
						rs.getString(5),
						rs.getString(6), 
						rs.getString(7),
						rs.getString(8), 
						rs.getString(9), 
						rs.getString(10)
						);
				list.add(sp);
			}
			return list;		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public List<DonHang> searchByAttribute(int index, int size, String txtSearch){
		try {
			Connection connect = new ConnectToDatabase().getConnection();
		ResultSet rs = null;
		PreparedStatement ppstm;
			List<DonHang> list = new ArrayList<DonHang>();
			String query="";
			if(txtSearch==null) {
				query = "with x as (select ROW_NUMBER() over (order by TenTaiKhoan ASC ) as r,* from DON_HANG)\r\n"
						+ "select * from x where r between ?*?-(?-1) and ?*?";
				ppstm = connect.prepareStatement(query);
				ppstm.setInt(1, index);
				ppstm.setInt(2, size);
				ppstm.setInt(3, size);
				ppstm.setInt(4, index);
				ppstm.setInt(5, size);
			}else {
				query = "with x as (select ROW_NUMBER() over (order by TenTaiKhoan ASC ) as r,* from DON_HANG where TenTaiKhoan like ?)\r\n"
						+ "select * from x where r between ?*?-(?-1) and ?*?";
				ppstm = connect.prepareStatement(query);
				ppstm.setString(1, "%"+txtSearch+"%");
				ppstm.setInt(2, index);
				ppstm.setInt(3, size);
				ppstm.setInt(4, size);
				ppstm.setInt(5, index);
				ppstm.setInt(6, size);		
			}
			rs= ppstm.executeQuery();
		while(rs.next()) {
			DonHang dh = new DonHang(rs.getString(2), 
					rs.getString(3),
					rs.getString(4), 
						rs.getString(5),
						rs.getString(6), 
				rs.getString(7),
					rs.getString(8), 
					rs.getString(9), 
						rs.getString(10));
			list.add(dh);
		}
		return list;
	} catch (Exception e) {
		// TODO: handle exception
	}
		return null;
		
	}
	public String maxMaDH() {
		try {
			String query = "select MAX(MaDH)  from DON_HANG";
			Connection connect = new ConnectToDatabase().getConnection();
			PreparedStatement ppstm = connect.prepareStatement(query);
			ResultSet rs = null;
			rs =ppstm.executeQuery();
			String max= "";
			while(rs.next()) {
				max = rs.getString(1);
			}
			return max;		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public static void main(String[] args) {
		DonHangDAO dh = new DonHangDAO();
//		System.out.println(dh.top5DonHang("anphan219"));
//		System.out.println(dh.maxMaDH());
		System.out.println(dh.searchByAttribute(1, 1, null));
	}

}
