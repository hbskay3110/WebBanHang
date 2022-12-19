package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import model.ConnectToDatabase;
import model.NhaCungCap;
import model.NhaCungCap;

public class NhaCungCapDAO implements ObjectDAO {
	public static Map<String, NhaCungCap> mapNhaCC = loadData();
	
	public NhaCungCapDAO() {
		// TODO Auto-generated constructor stub
	}
	private static Map<String, NhaCungCap> loadData(){
		Map<String, NhaCungCap> mapTemp = new HashMap<String, NhaCungCap>();
		try {
			ResultSet rs = new ConnectToDatabase().selectData("select * from NHACUNGCAP");
			while (rs.next()) {
				String maNCC = rs.getString(1);
				String tenNCC  = rs.getString(2);
				String diaChi  = rs.getString(3);
				String sdt  = rs.getString(4);

				NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, diaChi, sdt);
				mapTemp.put(ncc.getMaNCC(), ncc);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapTemp;
		
	}
	@Override
	public boolean add(Object obj) {
		NhaCungCap ncc = (NhaCungCap) obj;
		mapNhaCC.put(ncc.getMaNCC(), ncc);
		String sql = "insert into NHACUNGCAP values(?,?,?,?)";
		
		try {
			Connection connect = new ConnectToDatabase().getConnection();
			PreparedStatement ppstm = connect.prepareStatement(sql);
			ppstm.setString(1,ncc.getMaNCC());
			ppstm.setString(2,ncc.getTenNCC());
			ppstm.setString(3,ncc.getDiaChi());
			ppstm.setString(4,ncc.getSdt());
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
		NhaCungCap sp = (NhaCungCap) obj;
		mapNhaCC.replace(id, sp);
		try {	
			String sql = "update NHACUNGCAP set TenNCC=?,Diachi=?,Sdt=? where MaNCC=?";
				Connection connect = new ConnectToDatabase().getConnection();
				PreparedStatement ppstm = connect.prepareStatement(sql);
				ppstm.setString(1,sp.getTenNCC());
				ppstm.setString(2,sp.getDiaChi());
				ppstm.setString(3,sp.getSdt());
				ppstm.setString(4,id);
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
		mapNhaCC.remove(id);
		try {
			
			new ConnectToDatabase().excuteSql("delete from NHACUNGCAP where MaNCC='"+id+"'");
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

}
