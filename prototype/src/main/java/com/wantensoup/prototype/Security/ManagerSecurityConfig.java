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
    public SecurityFilterChain filterChain1(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll();
        
        http.antMatcher("/manager/**")
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
        
        return http.build();
    }
}
