/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wantensoup.prototype.Customer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ewan
 */
@Entity
@Table(name = "Menu")

public class CustMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Menu_Name")
    private String menuName;

    @Column(name = "Price")
    private double price;

    public long getId() {
        return id;
    }

    public String getMenuName() {
        return menuName;
    }

    public double getPrice() {
        return price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMenuName(String mealName) {
        this.menuName = menuName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
