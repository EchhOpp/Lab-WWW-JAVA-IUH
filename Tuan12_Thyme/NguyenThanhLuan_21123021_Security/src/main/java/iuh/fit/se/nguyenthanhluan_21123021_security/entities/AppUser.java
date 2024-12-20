package iuh.fit.se.nguyenthanhluan_21123021_security.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "encrypted_password")
    private String encryptedPassword;
    @Column(name = "enabled")
    private boolean enabled;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public AppUser() {
    }

    public AppUser(String userName, String encryptedPassword, boolean enabled) {
        this.userName = userName;
        this.encryptedPassword = encryptedPassword;
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", encryptedPassword='" + encryptedPassword + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
