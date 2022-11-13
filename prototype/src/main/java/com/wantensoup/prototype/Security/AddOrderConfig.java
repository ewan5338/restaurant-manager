package com.wantensoup.prototype.Security;

/**
 * Last Updated: 11/01/2022
 * Class Purpose: Configures default Spring Security rules to only allow 
 * employees to access "/employee/" pages.
 * @author Kristin Cattell
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Order(3)
public class AddOrderConfig {

    @Bean
    public SecurityFilterChain filterChain3(HttpSecurity _http) throws Exception {
        //Allows only those with the role "EMPLOYEE" in the "users" table to access "/employee/" pages.
        _http.antMatcher("/addNewOrder/**")
                .authorizeRequests().anyRequest().hasAnyAuthority("MANAGER")
                .and()
                .formLogin()
                .loginPage("/employee/login")
                .usernameParameter("username")
                .loginProcessingUrl("/employee/login")
                .defaultSuccessUrl("/employee/home")
                .permitAll()
                .and()
                .logout().logoutUrl("/employee/logout")
                .logoutSuccessUrl("/");

        return _http.build();
    }
    
}
