package dao;

import java.util.List;

import entities.DanhMuc;

public interface DanhMucDao {
	public List<DanhMuc> getAll();
	public DanhMuc getById(String id);
	public void add(DanhMuc dm);
	public void update(DanhMuc dm);
	public void delete(int id);
}
