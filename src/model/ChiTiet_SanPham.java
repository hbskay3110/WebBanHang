package model;

public class ChiTiet_SanPham {
	private String maSP;
	private String maNCC;
	private String moTa;
	private String loaiSP;
	private String gioiTinh;
	private String chatLieu;
	private String kieuDang;
	private String xuatXu;
	private String soLuongSPConLai;
	private String phongCach;
	private String tgBaoHanh;
	

	public ChiTiet_SanPham(String maSP, String maNCC, String moTa, String loaiSP, String gioiTinh, String chatLieu,
			String kieuDang, String xuatXu, String soLuongSPConLai, String phongCach, String tgBaoHanh) {
		super();
		this.maSP = maSP;
		this.maNCC = maNCC;
		this.moTa = moTa;
		this.loaiSP = loaiSP;
		this.gioiTinh = gioiTinh;
		this.chatLieu = chatLieu;
		this.kieuDang = kieuDang;
		this.xuatXu = xuatXu;
		this.soLuongSPConLai = soLuongSPConLai;
		this.phongCach = phongCach;
		this.tgBaoHanh = tgBaoHanh;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getKieuDang() {
		return kieuDang;
	}
	public void setKieuDang(String kieuDang) {
		this.kieuDang = kieuDang;
	}
	public String getMaNCC() {
		return maNCC;
	}
	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getLoaiSP() {
		return loaiSP;
	}
	public void setLoaiSP(String loaiSP) {
		this.loaiSP = loaiSP;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getChatLieu() {
		return chatLieu;
	}
	public void setChatLieu(String chatLieu) {
		this.chatLieu = chatLieu;
	}
	public String getXuatXu() {
		return xuatXu;
	}
	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}
	public String getSoLuongSPConLai() {
		return soLuongSPConLai;
	}
	public void setSoLuongSPConLai(String soLuongSPConLai) {
		this.soLuongSPConLai = soLuongSPConLai;
	}
	public String getPhongCach() {
		return phongCach;
	}
	public void setPhongCach(String phongCach) {
		this.phongCach = phongCach;
	}
	public String getTgBaoHanh() {
		return tgBaoHanh;
	}
	public void setTgBaoHanh(String tgBaoHanh) {
		this.tgBaoHanh = tgBaoHanh;
	}
	@Override
	public String toString() {
		return "ChiTiet_SanPham [maSP=" + maSP + ", maNCC=" + maNCC + ", moTa=" + moTa + ", loaiSP=" + loaiSP
				+ ", gioiTinh=" + gioiTinh + ", chatLieu=" + chatLieu + ", kieuDang=" + kieuDang + ", xuatXu=" + xuatXu
				+ ", soLuongSPConLai=" + soLuongSPConLai + ", phongCach=" + phongCach + ", tgBaoHanh=" + tgBaoHanh
				+ "]";
	}
	
	
	
	

}
