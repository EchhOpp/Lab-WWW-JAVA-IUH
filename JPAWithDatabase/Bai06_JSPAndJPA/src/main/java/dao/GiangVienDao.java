package dao;

import java.util.List;

import entity.GiangVien;

public interface GiangVienDao {
	public List<GiangVien> getAll();

	public GiangVien getById(String id);

	public Boolean insert(GiangVien gv);

	public Boolean update(GiangVien gv);

	public Boolean delete(GiangVien gv);
}
