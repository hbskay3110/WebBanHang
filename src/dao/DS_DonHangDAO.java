package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.ConnectToDatabase;
import model.DS_DonHang;

public class DS_DonHangDAO implements ObjectDAO {
	public static List<DS_DonHang> mapDS_DonHang = loadData();
	
	public DS_DonHangDAO() {
		// TODO Auto-generated constructor stub
	}
	private static List<DS_DonHang> loadData(){
		List<DS_DonHang> mapTemp = new ArrayList<DS_DonHang>();
		try {
			ResultSet rs = new ConnectToDatabase().selectData("select * from DS_DONHANG");
			while (rs.next()) {
				String 	maDH = rs.getString("MaDH");
				String 	maSP  = rs.getString("MaSP");
				String  soLuongMua  = rs.getString("SoluongMua");
				String  gia  = rs.getString("Gia");
				int sl = Integer.parseInt(soLuongMua);
				double giaD = Double.parseDouble(gia);
				DS_DonHang ds_dh = new DS_DonHang(maDH, maSP, sl, giaD);
				mapTemp.add(ds_dh);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapTemp;
		
	}
	@Override
	public boolean add(Object obj) {
		DS_DonHang ds_dh = (DS_DonHang) obj;
		mapDS_DonHang.add(ds_dh);
		String sql = "insert into DS_DONHANG values(?,?,?,?)";
		
		try {
			Connection connect = new ConnectToDatabase().getConnection();
			PreparedStatement ppstm = connect.prepareStatement(sql);
			ppstm.setString(1,ds_dh.getMaDH());
			ppstm.setString(2,ds_dh.getMaSP());
			ppstm.setInt(3,ds_dh.getSlMua());
			ppstm.setDouble(4,ds_dh.getGia());
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
	public boolean delete(String id) {
		for (int i= 0; i<mapDS_DonHang.size();i++) {
			if(mapDS_DonHang.get(i).getMaDH().equals(id)) {
				mapDS_DonHang.remove(i);
			}
		}
		try {
			new ConnectToDatabase().excuteSql("delete from DS_DONHANG where MaDH='"+id+"'");
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	public List<DS_DonHang> dsDHByMaDH(String id) {
		List<DS_DonHang> rs = new ArrayList<DS_DonHang>();
		for (DS_DonHang ds_DonHang : mapDS_DonHang) {	
			if(ds_DonHang.getMaDH().equals(id)) {
				rs.add(ds_DonHang);		
			}
		}
		return rs;
	}
	public static void main(String[] args) {
		DS_DonHangDAO d= new DS_DonHangDAO();
		System.out.println(d.mapDS_DonHang);
		System.out.println(d.dsDHByMaDH("001"));
	}

}
