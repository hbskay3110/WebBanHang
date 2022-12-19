package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.productDetail;
import model.ConnectToDatabase;
import model.DS_DonHang;
import model.SanPham;

public class SanPhamDAO implements ObjectDAO {
	public static Map<String, SanPham> mapSanPham = loadData();
	
	public SanPhamDAO() {
		// TODO Auto-generated constructor stub
	}
	private static Map<String, SanPham> loadData(){
		Map<String, SanPham> mapTemp = new HashMap<String, SanPham>();
		try {
			ResultSet rs = new ConnectToDatabase().selectData("select * from SANPHAM");
			while (rs.next()) {
				String maSP = rs.getString(1);
				String tenSP  = rs.getString(2);
				String giaBanSP  = rs.getString(3);
				String giaDaGiam  = rs.getString(4);
				String sPMoi  = rs.getString(5);
				String soLuongNhap  = rs.getString(6);
				String soLuongBan  = rs.getString(7);
				String hinhanh  = rs.getString(8);
				String sale  = rs.getString(9);
				String yeuThich  = rs.getString(10);
			
				
				SanPham sanPham = new SanPham(maSP, tenSP, giaBanSP, giaDaGiam, sPMoi, soLuongNhap, soLuongBan, hinhanh, sale,yeuThich);
				mapTemp.put(sanPham.getMaSP(), sanPham);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapTemp;
		
	}
	public int countSP(String txtSearch) {
		try {
			String query = "select count(*) from SANPHAM where TenSP like ?";
			//mở kết nối tới db
			Connection connect = new ConnectToDatabase().getConnection();
			// truyền câu lệnh query vào sql
			PreparedStatement ppstm = connect.prepareStatement(query);
			ppstm.setString(1, "%"+txtSearch+"%");
			//execute và nhận kết quả trả về
			ResultSet rs = null;
			rs =ppstm.executeQuery();
			while(rs.next()) {
				//trả về dữ liệu của chỉ mục cột được chỉ định
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	public List<SanPham> search(String txtSearch,int index, int size){
		try {
			String query = "with x as (select ROW_NUMBER() over (order by TenSP desc ) as r,* from SANPHAM where TenSP like ?)\r\n"
					+ "select * from x where r between ?*?-(?-1) and ?*?";
			Connection connect = new ConnectToDatabase().getConnection();
			PreparedStatement ppstm = connect.prepareStatement(query);
			ppstm.setString(1, "%"+txtSearch+"%");
			ppstm.setInt(2, index);
			ppstm.setInt(3, size);
			ppstm.setInt(4, size);
			ppstm.setInt(5, index);
			ppstm.setInt(6, size);
			ResultSet rs = null;
			rs =ppstm.executeQuery();
			List<SanPham> list = new ArrayList<SanPham>();
			while(rs.next()) {
				SanPham sp = new SanPham(rs.getString(2), 
						rs.getString(3),
						rs.getString(4), 
						rs.getString(5),
						rs.getString(6), 
						rs.getString(7),
						rs.getString(8), 
						rs.getString(9), 
						rs.getString(10),"0");
				list.add(sp);
			}
			return list;
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public List<SanPham> searchByAttribute(int index, int size, String proviso,String attribute,String txtSearch,String loaiSP){
		try {
			String query;
			Connection connect = new ConnectToDatabase().getConnection();
			ResultSet rs = null;
			PreparedStatement ppstm;
			if((txtSearch==null|| txtSearch.equals("")) && (loaiSP==null || loaiSP.equals(""))) {
				 query = "with x as (select ROW_NUMBER() over (order by "+attribute+" "+proviso+ ") as r,* from SANPHAM)\r\n"
						+ "select * from x where r between ?*?-(?-1) and ?*?";	
					ppstm = connect.prepareStatement(query);
					ppstm.setInt(1, index);
					ppstm.setInt(2, size);
					ppstm.setInt(3, size);
					ppstm.setInt(4, index);
					ppstm.setInt(5, size);				
					rs =ppstm.executeQuery();
			}else if((loaiSP==null || loaiSP.equals("")) && (txtSearch!=null)) {
			 query = "with x as (select ROW_NUMBER() over (order by "+attribute+" "+proviso+ ") as r,* from SANPHAM where TenSP like ?)\r\n"
					+ "select * from x where r between ?*?-(?-1) and ?*?";
				ppstm = connect.prepareStatement(query);
				ppstm.setString(1, "%"+txtSearch+"%");
				ppstm.setInt(2, index);
				ppstm.setInt(3, size);
				ppstm.setInt(4, size);
				ppstm.setInt(5, index);
				ppstm.setInt(6, size);
				rs =ppstm.executeQuery();
			}else if(loaiSP!=null && (txtSearch==null|| txtSearch.equals(""))){
				 query = "with x as (select ROW_NUMBER() over (order by "+attribute+" "+proviso+ ") as r,sp.* from SANPHAM sp join CHITIET_SANPHAM ct on sp.MaSP = ct.MaSP where LoaiSP in(?))\r\n"
							+ "select * from x where r between ?*?-(?-1) and ?*?";
						ppstm = connect.prepareStatement(query);
						ppstm.setString(1, loaiSP);
						ppstm.setInt(2, index);
						ppstm.setInt(3, size);
						ppstm.setInt(4, size);
						ppstm.setInt(5, index);
						ppstm.setInt(6, size);
						rs =ppstm.executeQuery();
			}else {
				 query = "with x as (select ROW_NUMBER() over (order by "+attribute+" "+proviso+ ") as r,sp.* from SANPHAM sp join CHITIET_SANPHAM ct on sp.MaSP = ct.MaSP where LoaiSP in(?) and TenSP like ?)\r\n"
							+ "select * from x where r between ?*?-(?-1) and ?*?";
				 	ppstm = connect.prepareStatement(query);
					ppstm.setString(1, loaiSP);
					ppstm.setString(2, txtSearch);
					ppstm.setInt(3, index);
					ppstm.setInt(4, size);
					ppstm.setInt(5, size);
					ppstm.setInt(6, index);
					ppstm.setInt(7, size);
					rs =ppstm.executeQuery();
			}
			List<SanPham> list = new ArrayList<SanPham>();
			while(rs.next()) {
				SanPham sp = new SanPham(rs.getString(2), 
						rs.getString(3),
						rs.getString(4), 
						rs.getString(5),
						rs.getString(6), 
						rs.getString(7),
						rs.getString(8), 
						rs.getString(9), 
						rs.getString(10),rs.getString(11));
				list.add(sp);
			}
			return list;
			
			
			
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	public List<SanPham> render(int index, int size){
		try {
			String query = "with x as (select ROW_NUMBER() over (order by TenSP desc ) as r,* from SANPHAM)\r\n"
					+ "select * from x where r between ?*?-(?-1) and ?*?";
			Connection connect = new ConnectToDatabase().getConnection();
			PreparedStatement ppstm = connect.prepareStatement(query);
			ppstm.setInt(1, index);
			ppstm.setInt(2, size);
			ppstm.setInt(3, size);
			ppstm.setInt(4, index);
			ppstm.setInt(5, size);
			ResultSet rs = null;
			rs =ppstm.executeQuery();
			List<SanPham> list = new ArrayList<SanPham>();
			while(rs.next()) {
				SanPham sp = new SanPham(rs.getString(2), 
						rs.getString(3),
						rs.getString(4), 
						rs.getString(5),
						rs.getString(6), 
						rs.getString(7),
						rs.getString(8), 
						rs.getString(9), 
						rs.getString(10),
						rs.getString(11)
						);
				list.add(sp);
			}
			return list;
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	@Override
	public boolean add(Object obj) {
		SanPham sp = (SanPham) obj;
		mapSanPham.put(sp.getMaSP(), sp);
		String sql = "insert into SANPHAM values(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			Connection connect = new ConnectToDatabase().getConnection();
			PreparedStatement ppstm = connect.prepareStatement(sql);
			ppstm.setString(1,sp.getMaSP());
			ppstm.setString(2,sp.getTenSP());
			ppstm.setString(3,sp.getGiaBanSP());
			ppstm.setString(4,sp.getGiaGiam());
			ppstm.setString(5,sp.getsPMoi());
			ppstm.setString(6,sp.getSoLuongNhap());
			ppstm.setString(7,sp.getSoLuongBan());
			ppstm.setString(8,sp.getHinhAnh());
			ppstm.setString(9,sp.getSale());
			ppstm.setString(10,sp.getYeuThich());
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
		SanPham sp = (SanPham) obj;
		mapSanPham.replace(id, sp);
		try {	
			String sql = "update SANPHAM set TenSP=?,GiaBanSP=?,GiaDaGiam=?,SPMoi=?,SoLuongNhap=?,SoLuongBan=?,HinhAnh=?,Sale=?,YeuThich=?  where MaSP=?";
				Connection connect = new ConnectToDatabase().getConnection();
				PreparedStatement ppstm = connect.prepareStatement(sql);
				ppstm.setString(1,sp.getTenSP());
				ppstm.setString(2,sp.getGiaBanSP());
				ppstm.setString(3,sp.getGiaGiam());
				ppstm.setString(4,sp.getsPMoi());
				ppstm.setString(5,sp.getSoLuongNhap());
				ppstm.setString(6,sp.getSoLuongBan());
				ppstm.setString(7,sp.getHinhAnh());
				ppstm.setString(8,sp.getSale());
				ppstm.setString(9,sp.getYeuThich());
				ppstm.setString(10, id);
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
		mapSanPham.remove(id);
		try {								
			new ConnectToDatabase().excuteSql("delete from SANPHAM where MaSP='"+id+"'");
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	public List<SanPham> getSanPhamByDH(List<DS_DonHang> list){
		List<SanPham> rs = new ArrayList<SanPham>();
		for (DS_DonHang sanPham : list) {
			SanPham sp = mapSanPham.get(sanPham.getMaSP());
			rs.add(sp);
		}
		return rs;
	}
	public static void main(String[] args) {
		SanPhamDAO sp = new SanPhamDAO();
//		int count = sp.countSP("Á");
//		System.out.println(count);
		List<SanPham> list = sp.searchByAttribute(1, 3, "ASC", "LoaiSP", null,"Áo thun");
		System.out.println(list);
		for (SanPham sanPham : list) {
			System.out.println(sanPham +"\n");
		}
	}

}
