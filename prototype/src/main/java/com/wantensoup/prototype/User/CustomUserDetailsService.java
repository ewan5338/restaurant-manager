/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wantensoup.prototype.User;

/**
 *
 * @author garca
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
 
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired private UserRepository repo;
 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found with the given username");
        }
         
        return new CustomUserDetails(user);
    }
    
}
