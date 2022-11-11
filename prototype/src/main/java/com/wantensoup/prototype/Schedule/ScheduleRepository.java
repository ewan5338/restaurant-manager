package com.wantensoup.prototype.Schedule;

/**
 * Last Updated: 11/10/2022
 * Class Purpose: Allows access to the data in the "Schedules" table in the 
 * database.
 * @author Kristin Cattell
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    public Schedule findByEmployeeName(String _employeeName);
    
}
