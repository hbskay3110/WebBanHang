package model;



public class TaiKhoan {
	
	private String tenTaiKhoan;
	private String matKhau;
	private String tenKhachHang;
	private String gioiTinh;
	private String soDienThoai;
	private String email;
	private String ngaySinh;
	private String diaChi;
	private String quyen;
	public TaiKhoan( String tenTaiKhoan, String matKhau, String tenKhachHang, String gioiTinh, String soDienThoai,
			String email, String ngaySinh, String diaChi, String quyen) {
		super();
		
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.tenKhachHang = tenKhachHang;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.quyen = quyen;
	}
	public String getQuyen() {
		return quyen;
	}
	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}
	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	@Override
	public String toString() {
		return "TaiKhoan [ tenTaiKhoan=" + tenTaiKhoan + ", matKhau=" + matKhau
				+ ", tenKhachHang=" + tenKhachHang + ", gioiTinh=" + gioiTinh + ", soDienThoai=" + soDienThoai
				+ ", email=" + email + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", quyen=" + quyen + "]";
	}


	
	

}
