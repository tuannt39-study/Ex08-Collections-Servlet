package vn.its.ex07.model;

import java.util.Date;

public class BaiViet {
	private int maBV;
	private String tieuDe;
	private String danhMuc;
	private String chiTiet;
	private Date lichDang;
	private String trangThai;
	private String nhan;

	public BaiViet() {
		super();
	}

	public int getMaBV() {
		return maBV;
	}

	public void setMaBV(int maBV) {
		this.maBV = maBV;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getDanhMuc() {
		return danhMuc;
	}

	public void setDanhMuc(String danhMuc) {
		this.danhMuc = danhMuc;
	}

	public String getChiTiet() {
		return chiTiet;
	}

	public void setChiTiet(String chiTiet) {
		this.chiTiet = chiTiet;
	}

	public Date getLichDang() {
		return lichDang;
	}

	public void setLichDang(Date lichDang) {
		this.lichDang = lichDang;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getNhan() {
		return nhan;
	}

	public void setNhan(String nhan) {
		this.nhan = nhan;
	}
}
