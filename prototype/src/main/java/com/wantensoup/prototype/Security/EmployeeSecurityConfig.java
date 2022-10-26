/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wantensoup.prototype.Security;

import com.wantensoup.prototype.User.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author garca
 */

@Configuration
@Order(2)
public class EmployeeSecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception {
        
        http.antMatcher("/employee/**")
                .authorizeRequests().anyRequest().hasAnyAuthority("EMPLOYEE")
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
        
        return http.build();
    }
}
