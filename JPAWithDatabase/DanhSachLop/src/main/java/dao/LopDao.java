package dao;

import java.util.List;

import entity.LopHoc;
import entity.SinhVien;

public interface LopDao {
	public List<LopHoc> getAllLop();
	
	public List<SinhVien> getSinhVienByLop(String maLop);
	
	public Boolean addSinhVien(SinhVien sv);
	
}
