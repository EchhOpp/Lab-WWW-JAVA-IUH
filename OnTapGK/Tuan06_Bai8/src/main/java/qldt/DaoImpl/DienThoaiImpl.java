package qldt.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import qldt.Dao.DienThoaiDao;
import qldt.Entities.DienThoai;
import qldt.Entities.NhaCungCap;
import qldt.Utils.persistenceUtils;

public class DienThoaiImpl implements DienThoaiDao {

	private EntityManager em;

	public DienThoaiImpl(EntityManager entityManager) {
		this.em = entityManager;
	}

	@Override
	public List<DienThoai> getALLDT() {
		List<DienThoai> listDT = em.createQuery("select dt from DienThoai dt", DienThoai.class).getResultList();
		return listDT;
	}

	@Override
	public DienThoai getDTByID(int maDT) {
		DienThoai dt = em.find(DienThoai.class, maDT);
		return dt;
	}

	@Override
	public void addDT(DienThoai dt) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(dt);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

	}

	@Override
	public void updateDT(DienThoai dt) {
		EntityTransaction tx = em.getTransaction();
		DienThoai update = em.find(DienThoai.class, dt.getMaDT());
		if (update == null) {
			return;
		}
		try {
			tx.begin();
			em.merge(dt);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

	}

	@Override
	public void deleteDT(int maDT) {
		DienThoai dt = em.find(DienThoai.class, maDT);
		EntityTransaction tx = em.getTransaction();
		if (dt == null) {
			return;
		} else {
			try {
				tx.begin();
				em.remove(em.contains(dt) ? dt : em.merge(dt));
				tx.commit();

			} catch (Exception e) {
				e.printStackTrace();
				tx.rollback();
			}
		}

	}

	@Override
	public NhaCungCap getNCCByID(int maNCC) {
		NhaCungCap ncc = em.find(NhaCungCap.class, maNCC);
		return ncc;
	}

	@Override
	public List<DienThoai> getDTByNCC(int maNCC) {
		List<DienThoai> listDT = em
				.createQuery("select dt from DienThoai dt where dt.nhaCC.maNCC = :maNCC", DienThoai.class)
				.setParameter("maNCC", maNCC).getResultList();
		return listDT;
	}

	@Override
	public List<NhaCungCap> getALLNCC() {
		List<NhaCungCap> listNCC = em.createQuery("select ncc from NhaCungCap ncc", NhaCungCap.class).getResultList();
		return listNCC;
	}

	@Override
	public void addNCC(NhaCungCap ncc) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(ncc);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		
	}

}
