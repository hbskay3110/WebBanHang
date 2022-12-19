package model;

public class BillProduct {
	private String maSP;
	private String tenSP;
	private String gia;
	private int soLuong;
	private double tong;
	private String hinhAnh;

	public BillProduct(String maSP, String tenSP, String gia, int soLuong, double tong, String hinhAnh) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.gia = gia;
		this.soLuong = soLuong;
		this.tong = tong;
		this.hinhAnh = hinhAnh;
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
	public String getGia() {
		return gia;
	}
	public void setGia(String gia) {
		this.gia = gia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getTong() {
		return tong;
	}
	public void setTong(double tong) {
		this.tong = tong;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	@Override
	public String toString() {
		return "BillProduct [maSP=" + maSP + ", tenSP=" + tenSP + ", gia=" + gia + ", soLuong=" + soLuong + ", tong="
				+ tong + ", hinhAnh=" + hinhAnh + "]";
	}
	
	
	

}
