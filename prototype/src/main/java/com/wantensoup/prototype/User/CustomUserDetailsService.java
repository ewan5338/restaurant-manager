package com.wantensoup.prototype.User;

/**
 * Last Updated: 10/17/2022 Class Purpose: Finds the username of an employee or
 * manager to use during the login process.
 * @author Kristin Cattell
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("No user found with the given username");
        }

        return new CustomUserDetails(user);
    }

}
