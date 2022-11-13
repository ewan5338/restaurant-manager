package com.wantensoup.prototype.Table;

/**
 * Last Updated: 10/31/2022
 * Class Purpose: Creates the table "items" and what attributes the table holds.
 * @author Atsoupe Bessou
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tables")
public class RestTables {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Table_Name")
    private String tableName;

    @Column(name = "Table_Status")
    private String tableStatus;

    //=================  GETTERS ===============
    public Integer getId() {
        return id;
    }

    public String getTableName() {
        return tableName;
    }

    public String getTableStatus() {
        return tableStatus;
    }

    //=================  SETTERS ===============
    public void setId(Integer _id) {
        this.id = _id;
    }

    public void setTableName(String _tableName) {
        this.tableName = _tableName;
    }

    public void setTableStatus(String _tableStatus) {
        this.tableStatus = _tableStatus;
    }
    
}
