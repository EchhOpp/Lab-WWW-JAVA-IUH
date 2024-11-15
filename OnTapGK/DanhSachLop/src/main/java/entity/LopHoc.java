package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LopHoc")
public class LopHoc {
	@Id
	@Column(name = "MaLop")
	private int id;
	@Column(name = "TenLop")
	private String tenLop;
}
