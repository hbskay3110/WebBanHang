package model;

public class NhaCungCap {
	private String MaNCC;
	private String tenNCC;
	private String diaChi;
	private String sdt;
	public NhaCungCap(String maNCC, String tenNCC, String diaChi, String sdt) {
		super();
		MaNCC = maNCC;
		this.tenNCC = tenNCC;
		this.diaChi = diaChi;
		this.sdt = sdt;
	}
	public String getMaNCC() {
		return MaNCC;
	}
	public void setMaNCC(String maNCC) {
		MaNCC = maNCC;
	}
	public String getTenNCC() {
		return tenNCC;
	}
	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	@Override
	public String toString() {
		return "NhaCungCap [MaNCC=" + MaNCC + ", tenNCC=" + tenNCC + ", diaChi=" + diaChi + ", sdt=" + sdt + "]";
	}
	

}
