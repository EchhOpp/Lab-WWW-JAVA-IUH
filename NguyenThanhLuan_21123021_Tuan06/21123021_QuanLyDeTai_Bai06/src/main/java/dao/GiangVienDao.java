package dao;

import java.util.List;

import entity.GiangVien;

public interface GiangVienDao {
	public List<GiangVien> getAllGiangVien();
	public GiangVien getGiangVien(String id);
	
	public boolean addGiangVien(GiangVien giangVien);
	public boolean updateGiangVien(GiangVien giangVien);
	public boolean deleteGiangVien(String id);
	
}
