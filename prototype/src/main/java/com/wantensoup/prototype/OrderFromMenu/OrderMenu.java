package com.wantensoup.prototype.OrderFromMenu;

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
@Table(name = "table_carts")
public class OrderMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "item_id")
    private Integer itemId;
    
    @Column(name = "table_id")
    private Integer tableId;
    
    @Column(name = "table_name")
    private String tableName;
    
    @Column(name = "item_name")
    private String itemName;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "total")
    private float total;

    private Integer quantity;

    //=================  GETTERS ===============
    public Integer getId() {
        return id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public Integer getTableId() {
        return tableId;
    }

    public String getTableName() {
        return tableName;
    }

    public String getItemName() {
        return itemName;
    }

    public String getStatus() {
        return status;
    }

    public float getTotal() {
        return total;
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

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
