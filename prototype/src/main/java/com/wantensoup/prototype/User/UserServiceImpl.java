package com.wantensoup.prototype.User;

/**
 * Last Updated: 11/10/2022
 * Class Purpose: Implements the functionality of user objects.
 * @author Kristin Cattell
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User _user) {
        this.userRepository.save(_user);
    }

    @Override
    public User getUserById(Integer _id) {
        Optional<User> optional = userRepository.findById(_id);
        User user = null;

        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException("User not found for id: " + _id);
        }

        return user;
    }

    @Override
    public void deleteUserById(Integer _id) {
        this.userRepository.deleteById(_id);
    }
    
}