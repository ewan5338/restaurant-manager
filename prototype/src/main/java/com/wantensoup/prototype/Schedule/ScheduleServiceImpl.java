package com.wantensoup.prototype.Schedule;

/**
 * Last Updated: 11/10/2022
 * Class Purpose: Implements the functionality of schedule objects.
 * @author Kristin Cattell
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public void saveSchedule(Schedule _schedule) {
        this.scheduleRepository.save(_schedule);
    }

    @Override
    public Schedule getScheduleById(Integer _id) {
        Optional<Schedule> optional = scheduleRepository.findById(_id);
        Schedule schedule = null;

        if (optional.isPresent()) {
            schedule = optional.get();
        } else {
            throw new RuntimeException("Schedule not found for id: " + _id);
        }

        return schedule;
    }

    @Override
    public void deleteScheduleById(Integer _id) {
        this.scheduleRepository.deleteById(_id);
    }
}