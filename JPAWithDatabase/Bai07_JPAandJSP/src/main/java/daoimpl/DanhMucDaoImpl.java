package daoimpl;

import java.util.List;

import dao.DanhMucDao;
import entities.DanhMuc;
import jakarta.persistence.EntityManager;

public class DanhMucDaoImpl implements DanhMucDao{
	
	private EntityManager entityManager;
	
	public DanhMucDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<DanhMuc> getAll() {
		// TODO Auto-generated method stub
		String query = "SELECT dm FROM DanhMuc dm";
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	public DanhMuc getById(String id) {
		// TODO Auto-generated method stub
		String query = "SELECT dm FROM DanhMuc dm WHERE dm.maDM = :maDM";
		return (DanhMuc) entityManager.createQuery(query).setParameter("maDM", id).getSingleResult();

	}

	@Override
	public void add(DanhMuc dm) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(DanhMuc dm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
