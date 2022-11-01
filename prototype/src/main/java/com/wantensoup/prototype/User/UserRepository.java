package com.wantensoup.prototype.User;

/**
 * Last Updated: 11/01/2022
 * Class Purpose: Allows access to the data in the "users" table in the database.
 * @author Kristin Cattell
 */
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByUsername(String _username);
    
}
