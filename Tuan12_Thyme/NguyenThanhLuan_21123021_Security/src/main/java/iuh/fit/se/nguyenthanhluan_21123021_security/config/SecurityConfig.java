package iuh.fit.se.nguyenthanhluan_21123021_security.config;

import iuh.fit.se.nguyenthanhluan_21123021_security.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {
    @Autowired
    private UserDetailServiceImpl userDetailService;
    
    @Autowired
    private DataSource dataSource;
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder auth = http.getSharedObject(AuthenticationManagerBuilder.class);
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
        return auth.build();
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/", "/login", "/logout").permitAll()
                .requestMatchers("/userInfo").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .requestMatchers("/admin").hasAnyAuthority("ROLE_ADMIN")
                .anyRequest().authenticated()
        );
        
        http.formLogin(formLogin -> formLogin
                .loginPage("/login")
                .loginProcessingUrl("/j_spring_security_check")
                .defaultSuccessUrl("/userInfo", true)
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
        );
        
        http.logout(logout -> logout
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .logoutSuccessUrl("/logoutSuccessful")
                .permitAll()
        );
        
        http.rememberMe(rememberMe -> rememberMe
                .tokenRepository(this.persistentTokenRepository())
                .tokenValiditySeconds(86400)
        );
        http.exceptionHandling(handle -> handle.accessDeniedPage("/403"));
        return http.build();
    }
    
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }
}
