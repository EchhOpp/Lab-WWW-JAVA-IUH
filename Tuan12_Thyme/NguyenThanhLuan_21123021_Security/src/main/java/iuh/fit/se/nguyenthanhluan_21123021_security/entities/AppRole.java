package iuh.fit.se.nguyenthanhluan_21123021_security.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "app_role")
public class AppRole {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;
    @Column(name = "role_name")
    private String roleName;

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public AppRole() {
    }

    public AppRole(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "AppRole{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
