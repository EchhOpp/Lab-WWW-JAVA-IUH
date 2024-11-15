package qldt.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DIENTHOAI")
public class DienThoai {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MADT")
	protected int maDT;
	@Column(name = "TENDT")
	private String tenDT;
	@Column(name = "NAMSX")
	private int namSX;
	@Column(name = "CAUHINH")
	private String cauHinh;

	@ManyToOne
	@JoinColumn(name = "MANCC")
	private NhaCungCap nhaCC;

	public DienThoai(int maDT, String tenDT, int namSX, String cauHinh, NhaCungCap nhaCC) {
		super();
		this.maDT = maDT;
		this.tenDT = tenDT;
		this.namSX = namSX;
		this.cauHinh = cauHinh;
		this.nhaCC = nhaCC;
	}

	public DienThoai() {
		super();
	}

	public DienThoai(String tenDT, int namSX, String cauHinh, NhaCungCap nhaCC) {
		super();
		this.tenDT = tenDT;
		this.namSX = namSX;
		this.cauHinh = cauHinh;
		this.nhaCC = nhaCC;
	}

	public int getMaDT() {
		return maDT;
	}

	public void setMaDT(int maDT) {
		this.maDT = maDT;
	}

	public String getTenDT() {
		return tenDT;
	}

	public void setTenDT(String tenDT) {
		this.tenDT = tenDT;
	}

	public int getNamSX() {
		return namSX;
	}

	public void setNamSX(int namSX) {
		this.namSX = namSX;
	}

	public String getCauHinh() {
		return cauHinh;
	}

	public void setCauHinh(String cauHinh) {
		this.cauHinh = cauHinh;
	}

	public NhaCungCap getNhaCC() {
		return nhaCC;
	}

	public void setNhaCC(NhaCungCap nhaCC) {
		this.nhaCC = nhaCC;
	}
	
}
