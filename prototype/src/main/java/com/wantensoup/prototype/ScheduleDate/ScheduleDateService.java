package com.wantensoup.prototype.ScheduleDate;

/**
 * Last Updated: 11/10/2022
 * Class Purpose: Defines the functionality of ScheduleDate objects.
 * @author Kristin Cattell
 */
import java.util.List;

public interface ScheduleDateService {

    List<ScheduleDate> getAllScheduleDates();

    void saveScheduleDate(ScheduleDate _schedule);

    ScheduleDate getScheduleDateById(Integer _id);
 
}
