package entity;

public class TinTuc {
	private String maTT;
	private String tieuDe;
	private String noiDungTT;
	private String lienKet;
	private String maDM;
	
	public TinTuc() {
	}
	
	public TinTuc(String maTT, String tieuDe, String noiDungTT, String lienKet, String maDM) {
		this.maTT = maTT;
		this.tieuDe = tieuDe;
		this.noiDungTT = noiDungTT;
		this.lienKet = lienKet;
		this.maDM = maDM;
	}

	public TinTuc(String maTT) {
		super();
		this.maTT = maTT;
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

	public String getMaDM() {
		return maDM;
	}

	public void setMaDM(String maDM) {
		this.maDM = maDM;
	}

	@Override
	public String toString() {
		return "TinTuc [maTT=" + maTT + ", tieuDe=" + tieuDe + ", noiDungTT=" + noiDungTT + ", lienKet=" + lienKet
				+ ", maDM=" + maDM + "]";
	}
}	
