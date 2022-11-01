package com.wantensoup.prototype.GetDateAPI;

/**
 * Last Updated: 10/31/2022 Class Purpose: Used to parse out the
 * "currentDateTime" from the API response body.
 * @author Kristin Cattell
 */
public class Time {

    private String currentDateTime;
    
    //=================  GETTERS ===============
    public String getCurrentDateTime() {
        return currentDateTime;
    }
    
    //=================  SETTERS ===============
    public void setCurrentDateTime(String currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

}
