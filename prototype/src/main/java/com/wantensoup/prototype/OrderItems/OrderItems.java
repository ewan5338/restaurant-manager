package com.wantensoup.prototype.OrderItems;

/**
 * Last Updated: 11/13/2022
 * Class Purpose: Creates the table "items_cart" and what attributes the table holds.
 * @author Kristin Cattell
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items_cart")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "item_id")
    private Integer itemId;
    
    @Column(name = "manager_id")
    private Integer managerId;
    
    @Column(name = "item_name")
    private String itemName;

    private Integer quantity;

    //=================  GETTERS ===============
    public Integer getId() {
        return id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public String getItemName() {
        return itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    //=================  SETTERS ===============
    public void setId(Integer _id) {
        this.id = _id;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
