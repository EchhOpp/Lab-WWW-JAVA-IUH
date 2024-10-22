package dao;

import java.util.List;

import entity.DeTai;

public interface DeTaiDao {
	public List<DeTai> getAll();
	public DeTai getById(String id);
	public Boolean insert(DeTai dt);
	public Boolean update(DeTai dt);
	public Boolean delete(DeTai dt);
}
