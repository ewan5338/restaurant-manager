package com.wantensoup.prototype.Security;

/**
 * Last Updated: 11/13/2022
 * Class Purpose: Configures default Spring Security rules to only allow 
 * managers to access "/addNewOrder/" pages.
 * @author Kristin Cattell
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Order(4)
public class AddOrderConfig {

    @Bean
    public SecurityFilterChain filterChain4(HttpSecurity _http) throws Exception {
        //Allows only those with the role "MANAGER" in the "users" table to access "/addNewOrder/" pages.
        _http.antMatcher("/addNewOrder/**")
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
