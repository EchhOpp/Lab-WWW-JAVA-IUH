package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "GIANGVIEN")
public class GiangVien {
//	GIANGVIEN(MAGV, TENGV, LINHVUCNGHIENCUU, DIENTHOAI, EMAIL) 
	@Id
	@Column(name = "MAGV")
	@NotNull(message = "is required")
	@NotBlank(message = "is required")
	private String maGV;
	@Column(name = "TENGV")
	@NotNull(message = "is required")
    @NotBlank(message = "is required")
	private String tenGV;
	@Column(name = "LINHVUCNGHIENCUU")
	private String linhVucNghienCuu;
	@Column(name = "DIENTHOAI")
	@NotNull(message = "is required")
	@Pattern(regexp = "^\\d{9,11}$", message = "Phone number must be 9 to 11 digits long")
	private String dienThoai;
	@Column(name = "EMAIL")
	@NotNull(message = "is required")
	@Pattern(regexp = "^([a-zA-z]+)@([\\w]+).((com|org|net).vn)", message = "yourname@yourcompany.com|org|net.vn")
	private String email;
	@OneToMany(mappedBy = "giangVien", fetch = FetchType.LAZY)
	private List<DeTai> dsDeTai;

	public List<DeTai> getDsDeTai() {
		return dsDeTai;
	}

	public void setDsDeTai(List<DeTai> dsDeTai) {
		this.dsDeTai = dsDeTai;
	}

	public GiangVien() {
		super();
	}

	public GiangVien(String maGV, String tenGV, String linhVucNghienCuu, String dienThoai, String email) {
		super();
		this.maGV = maGV;
		this.tenGV = tenGV;
		this.linhVucNghienCuu = linhVucNghienCuu;
		this.dienThoai = dienThoai;
		this.email = email;
	}

	public String getMaGV() {
		return maGV;
	}

	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}

	public String getTenGV() {
		return tenGV;
	}

	public void setTenGV(String tenGV) {
		this.tenGV = tenGV;
	}

	public String getLinhVucNghienCuu() {
		return linhVucNghienCuu;
	}

	public void setLinhVucNghienCuu(String linhVucNghienCuu) {
		this.linhVucNghienCuu = linhVucNghienCuu;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
    public String toString() {
        return "GiangVien [maGV=" + maGV + ", tenGV=" + tenGV + ", linhVuc=" + linhVucNghienCuu + ", dienThoai=" + dienThoai + ", email=" + email + "]";
    }
}
