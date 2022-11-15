package com.wantensoup.prototype.Security;

/**
 * Last Updated: 11/13/2022
 * Class Purpose: Configures default Spring Security rules to only allow 
 * customers to access "/customer/" pages.
 * @author Kristin Cattell
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Order(3)
public class CustomerSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain3(HttpSecurity _http) throws Exception {
        //Allows only those with the role "TABLE" in the "users" table to access "/customer/" pages.
        _http.antMatcher("/customer/**")
                .authorizeRequests().anyRequest().hasAnyAuthority("TABLE")
                .and()
                .formLogin()
                .loginPage("/customer/login")
                .usernameParameter("username")
                .loginProcessingUrl("/customer/login")
                .defaultSuccessUrl("/customer/home")
                .permitAll()
                .and()
                .logout().logoutUrl("/customer/logout")
                .logoutSuccessUrl("/");

        return _http.build();
    }
    
}
