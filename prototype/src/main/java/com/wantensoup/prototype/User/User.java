package com.wantensoup.prototype.User;

/**
 * Last Updated: 10/17/2022 
 * Class Purpose: Creates the table "users" and what attributes the table holds.
 * @author Kristin Cattell
 */
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    private Integer id;

    @Column(nullable = false, unique = true, length = 40)
    private String username;

    @Column(nullable = false, unique = true, length = 40)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {
    }

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    //=================  GETTERS ===============
    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    //=================  SETTERS ===============
    public void setId(Integer _id) {
        this.id = _id;
    }

    public void setUsername(String _username) {
        this.username = _username;
    }

    public void setPassword(String _password) {
        this.password = _password;
    }

    public void setRole(Role _role) {
        this.role = _role;
    }
    
}
