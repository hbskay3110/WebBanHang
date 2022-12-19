package model;
public class DonHang {
	private String maDH;
	private String TenTaiKhoan;
	private String ngayDatHang;
	private String tongTien;
	private String soDienThoai;
	private String tenNguoiNhan;
	private String diaChi;
	private String ghiChu;
	private String trangThai;
	public DonHang(String maDH, String tenTaiKhoan, String ngayDatHang, String tongTien, String soDienThoai,
			String tenNguoiNhan, String diaChi, String ghiChu, String trangThai) {
		super();
		this.maDH = maDH;
		TenTaiKhoan = tenTaiKhoan;
		this.ngayDatHang = ngayDatHang;
		this.tongTien = tongTien;
		this.soDienThoai = soDienThoai;
		this.tenNguoiNhan = tenNguoiNhan;
		this.diaChi = diaChi;
		this.ghiChu = ghiChu;
		this.trangThai = trangThai;
	}
	public String getMaDH() {
		return maDH;
	}
	public void setMaDH(String maDH) {
		this.maDH = maDH;
	}
	public String getTenTaiKhoan() {
		return TenTaiKhoan;
	}
	public void setTenTaiKhoan(String tenTaiKhoan) {
		TenTaiKhoan = tenTaiKhoan;
	}
	public String getNgayDatHang() {
		return ngayDatHang;
	}
	public void setNgayDatHang(String ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}
	public String getTongTien() {
		return tongTien;
	}
	public void setTongTien(String tongTien) {
		this.tongTien = tongTien;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getTenNguoiNhan() {
		return tenNguoiNhan;
	}
	public void setTenNguoiNhan(String tenNguoiNhan) {
		this.tenNguoiNhan = tenNguoiNhan;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public String toString() {
		return "DonHang [maDH=" + maDH + ", TenTaiKhoan=" + TenTaiKhoan + ", ngayDatHang=" + ngayDatHang + ", tongTien="
				+ tongTien + ", soDienThoai=" + soDienThoai + ", tenNguoiNhan=" + tenNguoiNhan + ", diaChi=" + diaChi
				+ ", ghiChu=" + ghiChu + ", trangThai=" + trangThai + "]";
	}
	
	
	
	

}
