package com.ust.eventmanagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.ust.eventmanagement.Model.Event;
import com.ust.eventmanagement.Repository.EventRepository;


@Service
public class EventService { 
	
	@Autowired
	private EventRepository eventRepository; 

    public ResponseEntity<Event> create(Event event) {
        Event savedEvent = eventRepository.save(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvent);
    }

    public ResponseEntity<Event> getById(String id) {
        Optional<Event> eventOpt = eventRepository.findById(id);
        return eventOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity<List<Event>> getAll() {
        List<Event> events = eventRepository.findAll();
        return ResponseEntity.ok(events);
    }

    public ResponseEntity<Event> update(String id, Event event) {
        Optional<Event> existingEventOpt = eventRepository.findById(id);
        if (existingEventOpt.isPresent()) {
            Event existingEvent = existingEventOpt.get();
            existingEvent.setUserId(event.getUserId());
            existingEvent.setName(event.getName());
            existingEvent.setLocation(event.getLocation());
            existingEvent.setStartDate(event.getStartDate());
            existingEvent.setEndDate(event.getEndDate());
            existingEvent.setType(event.getType());
            existingEvent.setStatus(event.getStatus());

            Event updatedEvent = eventRepository.save(existingEvent);
            return ResponseEntity.ok(updatedEvent);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<Void> delete(String id) {
        Optional<Event> eventOpt = eventRepository.findById(id);
        if (eventOpt.isPresent()) {
            eventRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<List<Event>> findByUserId(String userId) {
        List<Event> events = eventRepository.findByUserId(userId);
        if (events.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(events);
    }
}
