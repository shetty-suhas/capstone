package com.ust.eventmanagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ust.eventmanagement.Model.SubEvent;
import com.ust.eventmanagement.Repository.SubEventRepository;

@Service
public class SubEventService { 
	
	@Autowired
	private SubEventRepository subEventRepository; 


    public ResponseEntity<SubEvent> create(SubEvent subEvent) {
        SubEvent savedSubEvent = subEventRepository.save(subEvent);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSubEvent);
    }

    public ResponseEntity<SubEvent> getById(String id) {
        Optional<SubEvent> subEventOpt = subEventRepository.findById(id);
        return subEventOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity<List<SubEvent>> getAll() {
        List<SubEvent> subEvents = subEventRepository.findAll();
        return ResponseEntity.ok(subEvents);
    }

    public ResponseEntity<SubEvent> update(String id, SubEvent subEvent) {
        Optional<SubEvent> existingSubEventOpt = subEventRepository.findById(id);
        if (existingSubEventOpt.isPresent()) {
            SubEvent existingSubEvent = existingSubEventOpt.get();
            existingSubEvent.setName(subEvent.getName());
            existingSubEvent.setLocation(subEvent.getLocation());
            existingSubEvent.setStartTime(subEvent.getStartTime());
            existingSubEvent.setEndTime(subEvent.getEndTime());
            existingSubEvent.setRequiredVendors(subEvent.getRequiredVendors());
            existingSubEvent.setInvolvedGroups(subEvent.getInvolvedGroups());
            existingSubEvent.setScheduleId(subEvent.getScheduleId());

            SubEvent updatedSubEvent = subEventRepository.save(existingSubEvent);
            return ResponseEntity.ok(updatedSubEvent);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<Void> delete(String id) {
        Optional<SubEvent> subEventOpt = subEventRepository.findById(id);
        if (subEventOpt.isPresent()) {
            subEventRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<List<SubEvent>> findByScheduleId(String scheduleId) {
        List<SubEvent> subEvents = subEventRepository.findByScheduleId(scheduleId);
        if (subEvents.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(subEvents);
    }
}

