package dao;

import java.util.List;

import entity.Xe;

public interface XeDao {
	public List<Xe> getAllXe();
	public Xe getXe(String maXe);
	public Boolean addXe(Xe xe);
	
	public List<Xe> getXebByTenXe(String tenXe);
	public List<Xe> getXeByGiaXe(String giaXe);
	
	public List<Xe> getByTenOrGia(String param);
}
