package model;

public class DS_DonHang {
	private String maDH;
	private String maSP;
	private int slMua;
	private double gia;
	public DS_DonHang(String maDH, String maSP, int slMua, double gia) {
		super();
		this.maDH = maDH;
		this.maSP = maSP;
		this.slMua = slMua;
		this.gia = gia;
	}
	public String getMaDH() {
		return maDH;
	}
	public void setMaDH(String maDH) {
		this.maDH = maDH;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public int getSlMua() {
		return slMua;
	}
	public void setSlMua(int slMua) {
		this.slMua = slMua;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	@Override
	public String toString() {
		return "DS_DonHang [maDH=" + maDH + ", maSP=" + maSP + ", slMua=" + slMua + ", gia=" + gia + "]";
	}
	
	
}

	

	
