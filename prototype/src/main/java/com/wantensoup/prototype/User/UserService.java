package com.wantensoup.prototype.User;

/**
 * Last Updated: 11/10/2022
 * Class Purpose: Defines the functionality of schedule objects.
 * @author Kristin Cattell
 */
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void saveUser(User _schedule);

    User getUserById(long _id);

    void deleteUserById(long _id);
    
}
