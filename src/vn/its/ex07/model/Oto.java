package vn.its.ex07.model;

import java.util.Date;

public class Oto {

	public enum HangSanXuat {
		BMW, TOYOTA, HUYNDAI;
	}

	public enum BaoHiem {
		NO, A, B, C;
	}

	private int maXe;
	private int bienKiemSoat;
	private String tenXe;
	private Date namSanXuat;
	private HangSanXuat hangSanXuat;
	private BaoHiem baoHiem;
	private String ghiChu;

	public Oto() {
		super();
	}

	public Oto(int maXe, int bienKiemSoat, String tenXe, Date namSanXuat, HangSanXuat hangSanXuat, BaoHiem baoHiem,
			String ghiChu) {
		super();
		this.maXe = maXe;
		this.bienKiemSoat = bienKiemSoat;
		this.tenXe = tenXe;
		this.namSanXuat = namSanXuat;
		this.hangSanXuat = hangSanXuat;
		this.baoHiem = baoHiem;
		this.ghiChu = ghiChu;
	}

	public int getMaXe() {
		return maXe;
	}

	public void setMaXe(int maXe) {
		this.maXe = maXe;
	}

	public int getBienKiemSoat() {
		return bienKiemSoat;
	}

	public void setBienKiemSoat(int bienKiemSoat) {
		this.bienKiemSoat = bienKiemSoat;
	}

	public String getTenXe() {
		return tenXe;
	}

	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}

	public Date getNamSanXuat() {
		return namSanXuat;
	}

	public void setNamSanXuat(Date namSanXuat) {
		this.namSanXuat = namSanXuat;
	}

	public HangSanXuat getHangSanXuat() {
		return hangSanXuat;
	}

	public void setHangSanXuat(HangSanXuat hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}

	public BaoHiem getBaoHiem() {
		return baoHiem;
	}

	public void setBaoHiem(BaoHiem baoHiem) {
		this.baoHiem = baoHiem;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
}
