package daoimpl;

import java.util.List;

import dao.XeDao;
import entity.Xe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import utils.ConnectDB;

public class XeDaoImpl implements XeDao{
	private EntityManager em;
	
	public XeDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public List<Xe> getAllXe() {
		// TODO Auto-generated method stub
		String query = "SELECT x FROM Xe x";
		List<Xe> list = em.createQuery(query, Xe.class).getResultList();
		return list;
	}

	@Override
	public Xe getXe(String maXe) {
		return em.find(Xe.class, maXe);
	}

	@Override
	public Boolean addXe(Xe xe) {
		// TODO Auto-generated method stub
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(xe);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Xe> getXebByTenXe(String tenXe) {
		// TODO Auto-generated method stub
		String query = "SELECT x FROM Xe x WHERE x.tenXe LIKE :tenXe";
		List<Xe> list = em.createQuery(query, Xe.class).setParameter("tenXe", "%" + tenXe + "%").getResultList();
		return list;
	}

	@Override
	public List<Xe> getXeByGiaXe(String giaXe) {
		// TODO Auto-generated method stub
		String query = "SELECT x FROM Xe x WHERE x.giaXe LIKE :giaXe";
		List<Xe> list = em.createQuery(query, Xe.class).setParameter("giaXe", "%" + giaXe + "%").getResultList();
		return list;
	}

	@Override
	public List<Xe> getByTenOrGia(String param) {
		// TODO Auto-generated method stub
		String query = "SELECT x FROM Xe x WHERE x.tenXe LIKE :param OR x.giaXe LIKE :param";
		List<Xe> list = em.createQuery(query, Xe.class).setParameter("param", "%" + param + "%").getResultList();
		return list;
	}
}
