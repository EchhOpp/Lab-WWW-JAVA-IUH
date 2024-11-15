package dao;

import java.util.List;

import entities.TinTuc;

public interface TinTucDao {
	public List<TinTuc> getAll();
	public TinTuc getById(int id);
	public void add(TinTuc tt);
	public void update(TinTuc tt);
	public void delete(int id);
}
