package iuh.fit.se.nguyenthanhluan_21123021_security.service;

import iuh.fit.se.nguyenthanhluan_21123021_security.dao.AppRoleDao;
import iuh.fit.se.nguyenthanhluan_21123021_security.dao.AppUserDao;
import iuh.fit.se.nguyenthanhluan_21123021_security.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private AppRoleDao appRoleDao;
    @Autowired
    private AppUserDao appUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = this.appUserDao.findAccount(username);
        if (appUser == null) {
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        System.out.println("Found User: " + appUser);
        List<String> roleNames = this.appRoleDao.findListRole(username);

        System.out.println("Found Roles: " + roleNames);
        List<GrantedAuthority> granlist = new ArrayList<>();
        if(roleNames!=null){
            for (String role : roleNames) {
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                System.out.println("GrantedAuthority: " + authority);
                granlist.add(authority);
            }
        }
        UserDetails user = User.withUsername(appUser.getUserName())
                .password(appUser.getEncryptedPassword())
                .authorities(granlist)
                .build();
        System.out.println("UserDetails: " + user.getPassword());
        return user;
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

}

