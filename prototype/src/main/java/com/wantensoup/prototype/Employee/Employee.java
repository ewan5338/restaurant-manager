package com.wantensoup.prototype.Employee;

/**
 * Last Updated: 11/01/2022
 * Class Purpose: Creates the table "Employees" and what attributes the table 
 * holds.
 * @author Atsoupe Bessou Kpeglo
 */
import com.wantensoup.prototype.User.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(nullable = false, unique = true, length = 40)
    private String username;

    @Column(nullable = false, unique = true, length = 40)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    //=================  GETTERS ===============
    public Integer getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
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

    public void setFullName(String _fullName) {
        this.fullName = _fullName;
    }

    public void setAddress(String _address) {
        this.address = _address;
    }

    public void setEmail(String _email) {
        this.email = _email;
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
