package daoimpl;

import java.util.List;

import dao.TinTucDao;
import entities.DanhMuc;
import entities.TinTuc;
import jakarta.persistence.Column;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class TinTucDaoImpl implements TinTucDao{
	
	private EntityManager entityManager;
	
	public TinTucDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
     }

	@Override
	public List<TinTuc> getAll() {
		String query = "SELECT tt FROM TinTuc tt";
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	public TinTuc getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(TinTuc tt) {
		// TODO Auto-generated method stub
//		@Id
//		@Column(name = "MaTT")
//		private String maTT;
//		@Column(name = "TieuDe")
//		private String tieuDe;
//		@Column(name = "NoiDungTT")
//		private String noiDungTT;
//		@Column(name = "LienKet")
//		private String lienKet;
//		
//		@ManyToOne
//		@JoinColumn(name = "MaDM")
//		private DanhMuc danhMuc;
		
		EntityTransaction tx = entityManager.getTransaction();
		try {
            tx.begin();
            entityManager.persist(tt);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
	}

	@Override
	public void update(TinTuc tt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
}
