package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

@Builder
@Entity
@Table(name = "DETAI")
public class DeTai {
	

	// DETAI(MADETAI, TENDETAI, NAM, MOTADETAI, URLHINH, MAGV)
	@Id
	@Column(name = "MADETAI")
	@NotNull(message = "is required")
	@NotBlank(message = "is required")
	private String maDeTai;
	@Column(name = "TENDETAI", columnDefinition = "nvarchar(255)")
	@NotNull(message = "is required")
	@NotBlank(message = "is required")
	@Pattern(regexp = "^(?=.{1,100}$)([A-Z][a-z0-9]+\\s?)+$", message = "Each word must start with an uppercase letter, contain numbers but no special characters, and be up to 100 characters long")
	private String tenDeTai;
	@Column(name = "NAM")
	@NotNull(message = "is required")
	private int nam;
	@Column(name = "MOTADETAI", columnDefinition = "nvarchar(255)")
	private String moTaDeTai;
	@Column(name = "URLHINH")
	private String urlHinh;
	@ManyToOne()
	@JoinColumn(name = "MAGV")

	private GiangVien giangVien;

	public DeTai() {
		super();
	}

	public DeTai(String maDeTai, String tenDeTai, int nam, String moTaDeTai, String urlHinh, GiangVien giangVien) {
		super();
		this.maDeTai = maDeTai;
		this.tenDeTai = tenDeTai;
		this.nam = nam;
		this.moTaDeTai = moTaDeTai;
		this.urlHinh = urlHinh;
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

	public int getNam() {
		return nam;
	}

	public void setNam(int nam) {
		this.nam = nam;
	}

	public String getMoTaDeTai() {
		return moTaDeTai;
	}

	public void setMoTaDeTai(String moTaDeTai) {
		this.moTaDeTai = moTaDeTai;
	}

	public String getUrlHinh() {
		return urlHinh;
	}

	public void setUrlHinh(String urlHinh) {
		this.urlHinh = urlHinh;
	}

	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}

	@Override
	public String toString() {
		return "DeTai [maDeTai=" + maDeTai + ", tenDeTai=" + tenDeTai + ", nam=" + nam + ", moTaDeTai=" + moTaDeTai
				+ ", urlHinh=" + urlHinh + "]";
	}
}
