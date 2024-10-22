package dao;

import java.util.List;

import entity.DanhMuc;

public interface DanhMucDao {
	public List<DanhMuc> getAllDanhMuc();
	public DanhMuc getDanhMuc(String maDM);
	public void addDanhMuc(DanhMuc dm);
	public void updateDanhMuc(DanhMuc dm);
	public void deleteDanhMuc(String maDM);
}
