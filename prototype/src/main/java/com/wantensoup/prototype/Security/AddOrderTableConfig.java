package com.wantensoup.prototype.Security;

/**
 * Last Updated: 11/13/2022
 * Class Purpose: Configures default Spring Security rules to only allow 
 * customers to access "/addNewOrderFromMenu/" pages.
 * @author Kristin Cattell
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Order(5)
public class AddOrderTableConfig {

    @Bean
    public SecurityFilterChain filterChain5(HttpSecurity _http) throws Exception {
        //Allows only those with the role "TABLE" in the "users" table to access "/addNewOrderFromMenu/" pages.
        _http.antMatcher("/addNewOrderFromMenu/**")
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
