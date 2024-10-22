package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TinTuc")
public class TinTuc {
	@Id
	@Column(name = "MaTT")
	private String maTT;
	@Column(name = "TieuDe")
	private String tieuDe;
	@Column(name = "NoiDungTT")
	private String noiDungTT;
	@Column(name = "LienKet")
	private String lienKet;
	
	@ManyToOne
	@JoinColumn(name = "MaDM")
	private DanhMuc danhMuc;

	public TinTuc(String maTT, String tieuDe, String noiDungTT, String lienKet, DanhMuc danhMuc) {
		super();
		this.maTT = maTT;
		this.tieuDe = tieuDe;
		this.noiDungTT = noiDungTT;
		this.lienKet = lienKet;
		this.danhMuc = danhMuc;
	}

	public TinTuc() {
		super();
	}

	public String getMaTT() {
		return maTT;
	}

	public void setMaTT(String maTT) {
		this.maTT = maTT;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getNoiDungTT() {
		return noiDungTT;
	}

	public void setNoiDungTT(String noiDungTT) {
		this.noiDungTT = noiDungTT;
	}

	public String getLienKet() {
		return lienKet;
	}

	public void setLienKet(String lienKet) {
		this.lienKet = lienKet;
	}

	public DanhMuc getDanhMuc() {
		return danhMuc;
	}

	public void setDanhMuc(DanhMuc danhMuc) {
		this.danhMuc = danhMuc;
	}

	@Override
	public String toString() {
		return "TinTuc [maTT=" + maTT + ", tieuDe=" + tieuDe + ", noiDungTT=" + noiDungTT + ", lienKet=" + lienKet
				+ ", danhMuc=" + danhMuc + "]";
	}
	
	
}
