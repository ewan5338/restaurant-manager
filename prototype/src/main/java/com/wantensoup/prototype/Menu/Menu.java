package com.wantensoup.prototype.Menu;

/**
 * Last Updated: 11/14/2022
 * Class Purpose: Creates the table "menu_items" and what attributes the table holds.
 * @author Kristin Cattell
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu_items")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "item")
    private String menuItem;

    @Column(name = "price")
    private double price;
    
    @Column(name = "item_type")
    private String itemType;

    //=================  GETTERS ===============
    public Integer getId() {
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
    public void setId(Integer id) {
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
