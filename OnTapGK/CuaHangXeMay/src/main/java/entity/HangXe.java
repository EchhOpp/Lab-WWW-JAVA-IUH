package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "HangXe")
public class HangXe {
	@Id
	@Column(name = "MaHangXe")
	private String maHangXe;
	@Column(name = "TenHang")
	private String tenHang;
	@Column(name = "QuocGia")
	private String quocGia;
	@Column(name = "MoTa")
	private String moTa;
	public HangXe() {
		super();
	}
	public HangXe(String maHangXe) {
		super();
		this.maHangXe = maHangXe;
	}
	public HangXe(String maHangXe, String tenHang, String quocGia, String moTa) {
		super();
		this.maHangXe = maHangXe;
		this.tenHang = tenHang;
		this.quocGia = quocGia;
		this.moTa = moTa;
	}
	public String getMaHangXe() {
		return maHangXe;
	}
	public void setMaHangXe(String maHangXe) {
		this.maHangXe = maHangXe;
	}
	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}
	public String getQuocGia() {
		return quocGia;
	}
	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	@Override
	public String toString() {
		return "HangXe [maHangXe=" + maHangXe + ", tenHang=" + tenHang + ", quocGia=" + quocGia + ", moTa=" + moTa
				+ "]";
	}

}
