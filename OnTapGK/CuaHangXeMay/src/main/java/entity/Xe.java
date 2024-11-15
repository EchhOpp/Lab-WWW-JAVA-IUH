package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Xe")
public class Xe {
	@Id
	@Column(name = "MaXe")
	private String maXe;
	@Column(name = "TenXe")
	private String tenXe;
	@Column(name = "GiaXe")
	private String giaXe;
	@Column(name = "NamSanXuat")
	private String namSanXuat;
	
	@ManyToOne
	@JoinColumn(name = "MaHangXe")
	private HangXe hangXe;
	
	public Xe() {
		super();
	}

	public Xe(String maXe, String tenXe, String giaXe, String namSanXuat, String maHangXe) {
		super();
		this.maXe = maXe;
		this.tenXe = tenXe;
		this.giaXe = giaXe;
		this.namSanXuat = namSanXuat;
		this.maHangXe = maHangXe;
	}

	public Xe(String maXe) {
		super();
		this.maXe = maXe;
	}

	public String getMaXe() {
		return maXe;
	}

	public void setMaXe(String maXe) {
		this.maXe = maXe;
	}

	public String getTenXe() {
		return tenXe;
	}

	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}

	public String getGiaXe() {
		return giaXe;
	}

	public void setGiaXe(String giaXe) {
		this.giaXe = giaXe;
	}

	public String getNamSanXuat() {
		return namSanXuat;
	}

	public void setNamSanXuat(String namSanXuat) {
		this.namSanXuat = namSanXuat;
	}

	public String getMaHangXe() {
		return maHangXe;
	}

	public void setMaHangXe(String maHangXe) {
		this.maHangXe = maHangXe;
	}

	@Override
	public String toString() {
		return "Xe [maXe=" + maXe + ", tenXe=" + tenXe + ", giaXe=" + giaXe + ", namSanXuat=" + namSanXuat
				+ ", maHangXe=" + maHangXe + "]";
	}
	
	
}
