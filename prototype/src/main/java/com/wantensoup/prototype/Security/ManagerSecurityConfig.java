package com.wantensoup.prototype.Security;

/**
 * Last Updated: 11/01/2022
 * Class Purpose: Configures default Spring Security rules to only allow 
 * managers to access "/manager/" pages.
 * @author Kristin Cattell
 */
import com.wantensoup.prototype.User.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Order(1)
public class ManagerSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain filterChain1(HttpSecurity _http) throws Exception {
        //Allows everyone to access the homepage.
        _http.authorizeRequests().antMatchers("/").permitAll();

        //Allows only those with the role "MANAGER" in the "users" table to access "/manager/" pages.
        _http.antMatcher("/manager/**")
                .authorizeRequests().anyRequest().hasAnyAuthority("MANAGER")
                .and()
                .formLogin()
                .loginPage("/manager/login")
                .usernameParameter("username")
                .loginProcessingUrl("/manager/login")
                .defaultSuccessUrl("/manager/home")
                .permitAll()
                .and()
                .logout().logoutUrl("/manager/logout")
                .logoutSuccessUrl("/");

        return _http.build();
    }
    
}
