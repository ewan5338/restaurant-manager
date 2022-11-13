package com.wantensoup.prototype.Schedule;

/**
 * Last Updated: 11/10/2022
 * Class Purpose: Creates the table "schedules" and what attributes the table holds.
 * @author Kristin Cattell
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    private Integer id;

    @Column(name = "employee_name")
    private String employeeName;
    
    @Column(name = "monday")
    private String monday;
    
    @Column(name = "tuesday")
    private String tuesday;
    
    @Column(name = "wednesday")
    private String wednesday;
    
    @Column(name = "thursday")
    private String thursday;
    
    @Column(name = "friday")
    private String friday;
    
    @Column(name = "saturday")
    private String saturday;

    //=================  GETTERS ===============
    public Integer getId() {
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getMonday() {
        return monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public String getFriday() {
        return friday;
    }

    public String getSaturday() {
        return saturday;
    }
    
    //=================  SETTERS ===============
    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }
        
}
