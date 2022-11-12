package com.wantensoup.prototype.ScheduleDate;

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
public class ScheduleDateServiceImpl implements ScheduleDateService {

    @Autowired
    private ScheduleDateRepository scheduleDateRepository;

    @Override
    public List<ScheduleDate> getAllScheduleDates() {
        return scheduleDateRepository.findAll();
    }

    @Override
    public void saveScheduleDate(ScheduleDate _schedule) {
        this.scheduleDateRepository.save(_schedule);
    }

    @Override
    public ScheduleDate getScheduleDateById(long _id) {
        Optional<ScheduleDate> optional = scheduleDateRepository.findById(_id);
        ScheduleDate schedule = null;

        if (optional.isPresent()) {
            schedule = optional.get();
        } else {
            throw new RuntimeException("Schedule date not found for id: " + _id);
        }

        return schedule;
    }

}