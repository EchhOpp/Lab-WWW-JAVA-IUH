package iuh.fit.se.nguyenthanhluan_21123021_security.dao;

import iuh.fit.se.nguyenthanhluan_21123021_security.entities.UserRole;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AppRoleDao {
    @Autowired
    private EntityManager entityManager;

    public List findListRole(String userName) {
        try {
            String sql = "select r.appRole.roleName from " + UserRole.class.getName() + " r where r.appUser.userName = :userName";
            Query query = entityManager.createQuery(sql, String.class);
            query.setParameter("userName", userName);
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
