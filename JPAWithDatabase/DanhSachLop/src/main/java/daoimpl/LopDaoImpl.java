package daoimpl;

import java.util.List;

import dao.LopDao;
import entity.LopHoc;
import entity.SinhVien;
import jakarta.persistence.EntityManager;

public class LopDaoImpl implements LopDao{
	
	private EntityManager em;
	
	public LopDaoImpl(EntityManager em) {
        this.em = em;
        }

	@Override
	public List<LopHoc> getAllLop() {
		// TODO Auto-generated method stub
		return em.createQuery("from LopHoc", LopHoc.class).getResultList();
	}

	@Override
	public List<SinhVien> getSinhVienByLop(String maLop) {
		// TODO Auto-generated method stub
		return em.createQuery("from SinhVien where MaLop = :maLop", SinhVien.class).setParameter("maLop", maLop).getResultList();
	}

	@Override
	public Boolean addSinhVien(SinhVien sv) {
		// TODO Auto-generated method stub
		try {
            em.getTransaction().begin();
            em.persist(sv);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
			e.printStackTrace();
			return false;
        }
	}

}
