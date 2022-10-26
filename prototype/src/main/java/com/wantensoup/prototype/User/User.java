/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wantensoup.prototype.User;

import javax.persistence.*;
 
@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
    @Column(nullable = false, unique = true, length = 40)  
    private String username;
     
    @Column(nullable = false, unique = true, length = 10)
    private String password;
     
    @Enumerated(EnumType.STRING)
    private Role role;
 
    public User() {}
     
    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    
}
