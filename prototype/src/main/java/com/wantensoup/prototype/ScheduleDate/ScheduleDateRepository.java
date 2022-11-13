package com.wantensoup.prototype.ScheduleDate;

/**
 * Last Updated: 11/10/2022
 * Class Purpose: Allows access to the data in the "Schedules" table in the 
 * database.
 * @author Kristin Cattell
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleDateRepository extends JpaRepository<ScheduleDate, Integer> {

    public ScheduleDate findByDate(String _date);
    
}
