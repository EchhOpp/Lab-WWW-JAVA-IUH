package entity;

public class GiangVien {
	private String maGiangVien;
	private String tenGiangVien;
	private String linhVucNghienCuu;
	private String soDienThoai;
	
	public GiangVien() {
		super();
	}

	public GiangVien(String maGiangVien, String tenGiangVien, String linhVucNghienCuu, String soDienThoai) {
		super();
		this.maGiangVien = maGiangVien;
		this.tenGiangVien = tenGiangVien;
		this.linhVucNghienCuu = linhVucNghienCuu;
		this.soDienThoai = soDienThoai;
	}

	public String getMaGiangVien() {
		return maGiangVien;
	}

	public void setMaGiangVien(String maGiangVien) {
		this.maGiangVien = maGiangVien;
	}

	public String getTenGiangVien() {
		return tenGiangVien;
	}

	public void setTenGiangVien(String tenGiangVien) {
		this.tenGiangVien = tenGiangVien;
	}

	public String getLinhVucNghienCuu() {
		return linhVucNghienCuu;
	}

	public void setLinhVucNghienCuu(String linhVucNghienCuu) {
		this.linhVucNghienCuu = linhVucNghienCuu;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	@Override
	public String toString() {
		return "GiangVien [maGiangVien=" + maGiangVien + ", tenGiangVien=" + tenGiangVien + ", linhVucNghienCuu="
				+ linhVucNghienCuu + ", soDienThoai=" + soDienThoai + "]";
	}
	
}
