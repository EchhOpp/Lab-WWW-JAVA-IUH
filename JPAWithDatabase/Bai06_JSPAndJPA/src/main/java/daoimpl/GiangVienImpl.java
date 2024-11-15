package daoimpl;

import java.util.List;

import dao.GiangVienDao;
import entity.GiangVien;
import jakarta.persistence.EntityManager;

public class GiangVienImpl implements GiangVienDao{
	
	private EntityManager em;
	
	public GiangVienImpl(EntityManager entityManager) {
		this.em = entityManager;
	}
	
	@Override
	public List<GiangVien> getAll() {
		List<GiangVien> listGV = em.createQuery("select gv from GiangVien gv", GiangVien.class).getResultList();
		return listGV;
	}

	@Override
	public GiangVien getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean insert(GiangVien gv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(GiangVien gv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(GiangVien gv) {
		// TODO Auto-generated method stub
		return null;
	}
}	
