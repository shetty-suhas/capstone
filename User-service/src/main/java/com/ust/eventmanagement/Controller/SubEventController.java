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

import com.ust.eventmanagement.Model.SubEvent;
import com.ust.eventmanagement.Service.SubEventService;

@RestController
@RequestMapping("/subevent")
public class SubEventController { 
	
    @Autowired
    private SubEventService subEventService;

    @PostMapping
    public ResponseEntity<SubEvent> create(@RequestBody SubEvent subEvent) {
        return subEventService.create(subEvent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubEvent> getById(@PathVariable String id) {
        return subEventService.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<SubEvent>> getAll() {
        return subEventService.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubEvent> update(@PathVariable String id, @RequestBody SubEvent subEvent) {
        return subEventService.update(id, subEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return subEventService.delete(id);
    }

    @GetMapping("/schedule/{scheduleId}")
    public ResponseEntity<List<SubEvent>> findByScheduleId(@PathVariable String scheduleId) {
        return subEventService.findByScheduleId(scheduleId);
    }
}
