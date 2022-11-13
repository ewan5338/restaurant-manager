package com.wantensoup.prototype.Schedule;

/**
 * Last Updated: 11/10/2022
 * Class Purpose: Defines the functionality of schedule objects.
 * @author Kristin Cattell
 */
import java.util.List;

public interface ScheduleService {

    List<Schedule> getAllSchedules();

    void saveSchedule(Schedule _schedule);

    Schedule getScheduleById(Integer _id);

    void deleteScheduleById(Integer _id);
    
}
