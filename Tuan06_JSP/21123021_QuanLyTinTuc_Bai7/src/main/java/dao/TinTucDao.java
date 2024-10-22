package dao;

import java.util.List;

import entity.TinTuc;

public interface TinTucDao {
	public List<TinTuc> getAllTinTuc();
	public TinTuc getTinTuc(String maTT);
	public boolean addTinTuc(TinTuc tt);
	public boolean updateTinTuc(TinTuc tt);
	public boolean deleteTinTuc(String maTT);
}
