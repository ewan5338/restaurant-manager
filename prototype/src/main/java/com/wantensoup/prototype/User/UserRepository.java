/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.wantensoup.prototype.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByUsername(String username); 
}
