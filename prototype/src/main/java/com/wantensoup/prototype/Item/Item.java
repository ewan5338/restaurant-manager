package com.wantensoup.prototype.Item;

/**
 * Last Updated: 10/31/2022
 * Class Purpose: Creates the table "items" and what attributes the table holds.
 * @author Kristin Cattell
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Item")
    private String itemName;

    @Column(name = "Amount")
    private long itemQuantity;

    //=================  GETTERS ===============
    public long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public long getItemQuantity() {
        return itemQuantity;
    }

    //=================  SETTERS ===============
    public void setId(long _id) {
        this.id = _id;
    }

    public void setItemName(String _itemName) {
        this.itemName = _itemName;
    }

    public void setItemQuantity(long _itemQuantity) {
        this.itemQuantity = _itemQuantity;
    }
    
}
