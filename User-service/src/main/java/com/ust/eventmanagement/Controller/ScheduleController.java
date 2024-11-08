package com.ust.eventmanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.eventmanagement.Model.Schedule;
import com.ust.eventmanagement.Service.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController { 

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<Schedule> create(@RequestBody Schedule schedule) {
        return scheduleService.create(schedule);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getById(@PathVariable String id) {
        return scheduleService.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<Schedule>> getAll() {
        return scheduleService.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> update(@PathVariable String id, @RequestBody Schedule schedule) {
        return scheduleService.update(id, schedule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return scheduleService.delete(id);
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Schedule>> findByEventId(@PathVariable String eventId) {
        return scheduleService.findByEventId(eventId);
    }
}
