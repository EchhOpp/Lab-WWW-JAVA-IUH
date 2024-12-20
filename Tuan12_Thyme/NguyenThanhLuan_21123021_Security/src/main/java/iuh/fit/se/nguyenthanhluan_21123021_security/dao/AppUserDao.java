package iuh.fit.se.nguyenthanhluan_21123021_security.dao;

import iuh.fit.se.nguyenthanhluan_21123021_security.entities.AppUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public class AppUserDao {
    @Autowired
    private EntityManager entityManager;

    public AppUser findAccount(String userName) {
        try {
            String sql = "select e from " + AppUser.class.getName() + " e where e.userName = :userName";
            Query query = entityManager.createQuery(sql, AppUser.class);
            query.setParameter("userName", userName);
            return (AppUser) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
