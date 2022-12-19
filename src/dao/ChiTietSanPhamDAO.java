package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.ConnectToDatabase;
import model.SanPham;
import model.ChiTiet_SanPham;

public class ChiTietSanPhamDAO implements ObjectDAO {
	public static Map<String, ChiTiet_SanPham> mapChiTiet_SanPham = loadData();
	
	public ChiTietSanPhamDAO() {
		// TODO Auto-generated constructor stub
	}
	private static Map<String, ChiTiet_SanPham> loadData(){
		Map<String, ChiTiet_SanPham> mapTemp = new HashMap<String, ChiTiet_SanPham>();
		try {
			ResultSet rs = new ConnectToDatabase().selectData("select * from CHITIET_SANPHAM");
			while (rs.next()) {
				String 	maSP = rs.getString(1);
				String 	maNCC  = rs.getString(2);
				String  moTa  = rs.getString(3);
				String loaiSP  = rs.getString(4);
				String gioiTinh = rs.getString(5);
				String chatLieu  = rs.getString(6);
				String kieuDang = rs.getString(7);
				String xuatXu  = rs.getString(8);
				String SLSPConLai  = rs.getString(9);
				String phongCach  = rs.getString(10);
				String thBaoHanh = rs.getString(11);
			
				
				ChiTiet_SanPham ct_sp = new ChiTiet_SanPham(maSP, maNCC, moTa, loaiSP, gioiTinh,chatLieu,kieuDang, xuatXu, SLSPConLai, phongCach,thBaoHanh);
				mapTemp.put(ct_sp.getMaSP(), ct_sp);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapTemp;
		
	}
	public static void main(String[] args) {
//		System.out.println(ChiTietSanPhamDAO.mapChiTiet_SanPham);
		ChiTietSanPhamDAO c = new ChiTietSanPhamDAO();
		System.out.println(c.tongLoai("váy"));
	}
	@Override
	public boolean add(Object obj) {
		ChiTiet_SanPham ct_sp = (ChiTiet_SanPham) obj;
		mapChiTiet_SanPham.put(ct_sp.getMaSP(), ct_sp);
		String sql = "insert into CHITIET_SANPHAM values(?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			Connection connect = new ConnectToDatabase().getConnection();
			PreparedStatement ppstm = connect.prepareStatement(sql);
			ppstm.setString(1,ct_sp.getMaSP());
			ppstm.setString(2,ct_sp.getMaNCC());
			ppstm.setString(3,ct_sp.getMoTa());
			ppstm.setString(4,ct_sp.getLoaiSP());
			ppstm.setString(5,ct_sp.getGioiTinh());
			ppstm.setString(6,ct_sp.getChatLieu());
			ppstm.setString(7,ct_sp.getKieuDang());
			ppstm.setString(8,ct_sp.getXuatXu());
			ppstm.setString(9,ct_sp.getSoLuongSPConLai());
			ppstm.setString(10,ct_sp.getPhongCach());
			ppstm.setString(11,ct_sp.getTgBaoHanh());
		
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
		ChiTiet_SanPham ct_sp = (ChiTiet_SanPham) obj;
		mapChiTiet_SanPham.replace(id, ct_sp);
		try {	
			String sql = "update CHITIET_SANPHAM set MaNCC=?,MoTa=?,LoaiSP=?,GioiTinh=?,ChatLieu=?,KieuDang=?,XuatXu=?,SLSPConLai=?,PhongCach=?,TgianBaoHanh=? where MaSP=?";
				Connection connect = new ConnectToDatabase().getConnection();
				PreparedStatement ppstm = connect.prepareStatement(sql);
				ppstm.setString(1,ct_sp.getMaNCC());
				ppstm.setString(2,ct_sp.getMoTa());
				ppstm.setString(3,ct_sp.getLoaiSP());
				ppstm.setString(4,ct_sp.getGioiTinh());
				ppstm.setString(5,ct_sp.getChatLieu());
				ppstm.setString(6,ct_sp.getKieuDang());
				ppstm.setString(7,ct_sp.getXuatXu());
				ppstm.setString(8,ct_sp.getSoLuongSPConLai());
				ppstm.setString(9,ct_sp.getPhongCach());
				ppstm.setString(10,ct_sp.getTgBaoHanh());
				ppstm.setString(11,id);
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
		mapChiTiet_SanPham.remove(id);
		try {
			new ConnectToDatabase().excuteSql("delete from CHITIET_SANPHAM where MaSP='"+id+"'");
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	public int tongLoai(String loai) {
		try {
			String query = "select count(*) from CHITIET_SANPHAM where LoaiSP like ?";
			//mở kết nối tới db
			Connection connect = new ConnectToDatabase().getConnection();
			// truyền câu lệnh query vào sql
			PreparedStatement ppstm = connect.prepareStatement(query);
			ppstm.setString(1, "%"+loai+"%");
			//execute và nhận kết quả trả về
			ResultSet rs = null;
			rs =ppstm.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);		
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	public List<String> listLoaiSP(){
		try {
			String query = "select distinct LoaiSP from CHITIET_SANPHAM order by LoaiSP ASC";
			
			//mở kết nối tới db
			Connection connect = new ConnectToDatabase().getConnection();
			// truyền câu lệnh query vào sql
			PreparedStatement ppstm = connect.prepareStatement(query);
			//execute và nhận kết quả trả về
			ResultSet rs = null;
			rs =ppstm.executeQuery();
			List<String> list = new ArrayList<String>();
			while(rs.next()) {
				//trả về dữ liệu của chỉ mục cột được chỉ định
				list.add(rs.getString(1));			
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	

}
