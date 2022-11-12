/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wantensoup.prototype.Menu;
import com.wantensoup.prototype.Customer.*;
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
@Table(name = "menu_items")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "item")
    private String menuItem;

    @Column(name = "price")
    private double price;
    
    @Column(name = "item_type")
    private String itemType;

    //=================  GETTERS ===============
    public long getId() {
        return id;
    }

    public String getMenuItem() {
        return menuItem;
    }

    public double getPrice() {
        return price;
    }

    public String getItemType() {
        return itemType;
    }
    
    //=================  SETTERS ===============
    public void setId(long id) {
        this.id = id;
    }

    public void setMenuItem(String menuItem) {
        this.menuItem = menuItem;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
    
}
