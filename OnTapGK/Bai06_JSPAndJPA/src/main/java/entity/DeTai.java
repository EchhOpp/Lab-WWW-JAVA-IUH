package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DeTai")
public class DeTai {
	@Id
	@Column(name = "MaDeTai")
	private String maDeTai;
	@Column(name = "TenDeTai")
	private String tenDeTai;
	@Column(name = "NamDangKy")
	private String namDangKy;
	@Column(name = "MoTaDeTai")
	private String moTaDeTai;
	@Column(name = "MaGV")
	private String maGV;
}
