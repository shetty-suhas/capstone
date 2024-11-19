package com.example.event_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.event_service.Model.Event;
import com.example.event_service.service.EventService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/event")
public class EventController { 
	
	@Autowired  
	private EventService eventService; 
	
	@GetMapping("/test")
	public String test() {
		return "Hello";
	}

    @PostMapping
    public ResponseEntity<Event> create(@RequestBody Event event) {
        return eventService.create(event);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getById(@PathVariable String id) {
        return eventService.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAll() {
        return eventService.getAll();
    }  
    
    @GetMapping("/guests/{eventId}/{totalGuests}")
    public ResponseEntity<Event> updateEventGuests(
        @PathVariable String eventId,
        @PathVariable int totalGuests
    ) {
        return eventService.updateEventGuests(eventId, totalGuests);
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Event> update(@PathVariable String id, @RequestBody Event event) {
        return eventService.update(id, event);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return eventService.delete(id);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Event>> findByUserId(@PathVariable String userId) {
        return eventService.findByUserId(userId);
    } 
    
    @GetMapping("/tasks/{eventId}/{taskCompleted}/{totalTask}")
    public ResponseEntity<Event> updateTaskCounts(
        @PathVariable String eventId,
        @PathVariable int taskCompleted, 
        @PathVariable int totalTask
    ) {
        return eventService.updateTaskCounts(eventId, taskCompleted, totalTask);
    }
}