package com.wantensoup.prototype.GetDateAPI;

/**
 * Last Updated: 11/01/2022
 * Class Purpose: Used to parse out the "currentDateTime" from the API response 
 * body.
 * @author Kristin Cattell
 */
public class Time {

    private String datetime;
    
    //=================  GETTERS ===============
    public String getDatetime() {
        return datetime;
    }
    
    
    //=================  SETTERS ===============
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
    
}
