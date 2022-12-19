package model;

public class SanPham {
	private String maSP;
	private String tenSP;
	private String giaBanSP;
	private String giaGiam;
	private String sPMoi;
	private String soLuongNhap;
	private String soLuongBan;
	private String hinhAnh;
	private String sale;
	private String yeuThich;
	public SanPham(String maSP, String tenSP, String giaBanSP, String giaGiam, String sPMoi, String soLuongNhap,
			String soLuongBan, String hinhAnh, String sale, String yeuThich) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.giaBanSP = giaBanSP;
		this.giaGiam = giaGiam;
		this.sPMoi = sPMoi;
		this.soLuongNhap = soLuongNhap;
		this.soLuongBan = soLuongBan;
		this.hinhAnh = hinhAnh;
		this.sale = sale;
		this.yeuThich = yeuThich;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public String getGiaBanSP() {
		return giaBanSP;
	}
	public void setGiaBanSP(String giaBanSP) {
		this.giaBanSP = giaBanSP;
	}
	public String getGiaGiam() {
		return giaGiam;
	}
	public void setGiaGiam(String giaGiam) {
		this.giaGiam = giaGiam;
	}
	public String getsPMoi() {
		return sPMoi;
	}
	public void setsPMoi(String sPMoi) {
		this.sPMoi = sPMoi;
	}
	public String getSoLuongNhap() {
		return soLuongNhap;
	}
	public void setSoLuongNhap(String soLuongNhap) {
		this.soLuongNhap = soLuongNhap;
	}
	public String getSoLuongBan() {
		return soLuongBan;
	}
	public void setSoLuongBan(String soLuongBan) {
		this.soLuongBan = soLuongBan;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getSale() {
		return sale;
	}
	public void setSale(String sale) {
		this.sale = sale;
	}
	public String getYeuThich() {
		return yeuThich;
	}
	public void setYeuThich(String yeuThich) {
		this.yeuThich = yeuThich;
	}
	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", giaBanSP=" + giaBanSP + ", giaGiam=" + giaGiam
				+ ", sPMoi=" + sPMoi + ", soLuongNhap=" + soLuongNhap + ", soLuongBan=" + soLuongBan + ", hinhAnh="
				+ hinhAnh + ", sale=" + sale + ", yeuThich=" + yeuThich + "]";
	}
	
	
	

}
