package entity;

public class DeTai {
	private String maDeTai;
	private String tenDeTai;
	private String namDK;
	private String moTa;
	private GiangVien giangVien;
	
	public DeTai() {
		super();
	}
	
	public DeTai(String maDeTai, String tenDeTai, String namDK, String moTa, GiangVien giangVien) {
		super();
		this.maDeTai = maDeTai;
		this.tenDeTai = tenDeTai;
		this.namDK = namDK;
		this.moTa = moTa;
		this.giangVien = giangVien;
	}

	public String getMaDeTai() {
		return maDeTai;
	}

	public void setMaDeTai(String maDeTai) {
		this.maDeTai = maDeTai;
	}

	public String getTenDeTai() {
		return tenDeTai;
	}

	public void setTenDeTai(String tenDeTai) {
		this.tenDeTai = tenDeTai;
	}

	public String getNamDK() {
		return namDK;
	}

	public void setNamDK(String namDK) {
		this.namDK = namDK;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}

	@Override
	public String toString() {
		return "DeTai [maDeTai=" + maDeTai + ", tenDeTai=" + tenDeTai + ", namDK=" + namDK + ", moTa=" + moTa
				+ ", giangVien=" + giangVien + "]";
	}
	
}
