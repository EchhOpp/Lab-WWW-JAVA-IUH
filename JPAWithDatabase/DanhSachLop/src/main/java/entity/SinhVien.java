package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "SinhVien")
public class SinhVien {
	@Id
	@Column(name = "MaSV")
	private int id;
	@Column(name = "TenSV")
	private String tenSV;
	@Column(name = "Email")
	private String email;
	@Column(name = "DiaChi")
	private String diaChi;
	@Column(name = "DienThoai")
	private String dienThoai;
	@Column(name = "HinhAnh")
	private String hinhAnh;
	
	@ManyToOne
	@JoinColumn(name = "MaLop")
	private LopHoc lopHoc;
}
