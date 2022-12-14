package com.wantensoup.prototype.User;

/**
 * Last Updated: 11/10/2022
 * Class Purpose: Allows access to the data in the "users" table in the database.
 * @author Kristin Cattell
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUsername(String _username);
    
}
