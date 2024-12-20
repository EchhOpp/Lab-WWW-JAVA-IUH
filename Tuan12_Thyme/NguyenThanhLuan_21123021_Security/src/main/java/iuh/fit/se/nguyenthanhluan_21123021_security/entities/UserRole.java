package iuh.fit.se.nguyenthanhluan_21123021_security.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private AppUser appUser;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private AppRole appRole;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserRole(AppUser appUser, AppRole appRole) {
        this.appUser = appUser;
        this.appRole = appRole;
    }

    public UserRole() {
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", appUser=" + appUser +
                ", appRole=" + appRole +
                '}';
    }
}
