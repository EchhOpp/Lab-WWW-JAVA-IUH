package qldt.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "NhaCungCap")
public class NhaCungCap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MANCC")
	protected int maNCC;
	@Column(name = "TENNCC")
	private String tenNCC;
	@Column(name = "DIACHI")
	private String diaChi;
	@Column(name = "SODIENTHOAI")
	private String soDienThoai;

	@OneToMany(mappedBy = "nhaCC")
	private List<DienThoai> listDienThoai;
	
	public NhaCungCap() {
		super();
	}

	public NhaCungCap(int maNCC, String tenNCC, String diaChi, String soDienThoai) {
		super();
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

	public NhaCungCap(String tenNCC, String diaChi, String soDienThoai) {
		super();
		this.tenNCC = tenNCC;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

	public NhaCungCap(String tenNCC, String diaChi, String soDienThoai, List<DienThoai> listDienThoai) {
		super();
		this.tenNCC = tenNCC;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.listDienThoai = listDienThoai;
	}

	public int getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(int maNCC) {
		this.maNCC = maNCC;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public List<DienThoai> getListDienThoai() {
		return listDienThoai;
	}

	public void setListDienThoai(List<DienThoai> listDienThoai) {
		this.listDienThoai = listDienThoai;
	}
	
}
