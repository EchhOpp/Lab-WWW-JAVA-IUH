package dao;

import java.util.List;

import entity.DeTai;

public interface DeTaiDao {
	public List<DeTai> getAllDeTai();
	public DeTai getDeTai(String id);
	
	public boolean addDeTai(DeTai deTai);
	public boolean updateDeTai(DeTai deTai);
	public boolean deleteDeTai(String id);
}
