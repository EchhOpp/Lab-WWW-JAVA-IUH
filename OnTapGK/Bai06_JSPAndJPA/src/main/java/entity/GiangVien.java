package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "GiangVien")
public class GiangVien {
	@Id
	@Column(name = "MaGV")
	private String maGV;
	@Column(name = "TenGV")
	private String tenGV;
	@Column(name = "LinhVucNghienCuu")
	private String linhVucNghienCuu;
	@Column(name = "SoDienThoai")
	private String soDienThoai;
}
