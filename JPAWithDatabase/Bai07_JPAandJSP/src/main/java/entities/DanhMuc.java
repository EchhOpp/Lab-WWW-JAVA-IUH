package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity	
@Table(name = "DanhMuc")
public class DanhMuc {
	@Id
	@Column(name = "MaDM")
	private String maDM;
	@Column(name = "TenDanhMuc")
	private String tenDM;
	@Column(name = "NguoiQuanLy")
	private String nguoiQuanLy;
	@Column(name = "GhiChu")
	private String ghiChu;
	
	public DanhMuc() {
		super();
	}

	public String getMaDM() {
		return maDM;
	}

	public void setMaDM(String maDM) {
		this.maDM = maDM;
	}

	public String getTenDM() {
		return tenDM;
	}

	public void setTenDM(String tenDM) {
		this.tenDM = tenDM;
	}

	public String getNguoiQuanLy() {
		return nguoiQuanLy;
	}

	public void setNguoiQuanLy(String nguoiQuanLy) {
		this.nguoiQuanLy = nguoiQuanLy;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public DanhMuc(String maDM, String tenDM, String nguoiQuanLy, String ghiChu) {
		super();
		this.maDM = maDM;
		this.tenDM = tenDM;
		this.nguoiQuanLy = nguoiQuanLy;
		this.ghiChu = ghiChu;
	}

	public DanhMuc(String maDM) {
		super();
		this.maDM = maDM;
	}

	@Override
	public String toString() {
		return "DanhMuc [maDM=" + maDM + ", tenDM=" + tenDM + ", nguoiQuanLy=" + nguoiQuanLy + ", ghiChu=" + ghiChu
				+ "]";
	}
	
}
