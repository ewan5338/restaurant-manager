package com.wantensoup.prototype.ScheduleDate;

/**
 * Last Updated: 11/10/2022
 * Class Purpose: Creates the table "schedules_date" and what attributes the table holds.
 * @author Kristin Cattell
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "schedules_date")
public class ScheduleDate {

    @Id
    private Integer id;

    @Column(name = "date")
    private String date;

    //=================  GETTERS ===============
    public Integer getId() {
        return id;
    }

    public String getDate() {
        return date;
    }
    
    //=================  SETTERS ===============
    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
