package com.ust.eventmanagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ust.eventmanagement.Model.Schedule;
import com.ust.eventmanagement.Repository.ScheduleRepository;

@Service
public class ScheduleService {  
	
	@Autowired
    private ScheduleRepository scheduleRepository;

    public ResponseEntity<Schedule> create(Schedule schedule) {
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSchedule);
    }

    public ResponseEntity<Schedule> getById(String id) {
        Optional<Schedule> scheduleOpt = scheduleRepository.findById(id);
        return scheduleOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity<List<Schedule>> getAll() {
        List<Schedule> schedules = scheduleRepository.findAll();
        return ResponseEntity.ok(schedules);
    }

    public ResponseEntity<Schedule> update(String id, Schedule schedule) {
        Optional<Schedule> existingScheduleOpt = scheduleRepository.findById(id);
        if (existingScheduleOpt.isPresent()) {
            Schedule existingSchedule = existingScheduleOpt.get();
            existingSchedule.setLastUpdated(schedule.getLastUpdated());
            existingSchedule.setEventId(schedule.getEventId());

            Schedule updatedSchedule = scheduleRepository.save(existingSchedule);
            return ResponseEntity.ok(updatedSchedule);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<Void> delete(String id) {
        Optional<Schedule> scheduleOpt = scheduleRepository.findById(id);
        if (scheduleOpt.isPresent()) {
            scheduleRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<List<Schedule>> findByEventId(String eventId) {
        List<Schedule> schedules = scheduleRepository.findByEventId(eventId);
        if (schedules.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(schedules);
    } 
	
}
