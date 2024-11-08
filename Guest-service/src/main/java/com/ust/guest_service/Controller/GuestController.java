package com.ust.guest_service.Controller;

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

import com.ust.guest_service.Model.Guest;
import com.ust.guest_service.Service.GuestService;

@RestController
@RequestMapping("/guest")
public class GuestController { 
	
	@Autowired
	private GuestService guestService; 

    @PostMapping
    public ResponseEntity<Guest> create(@RequestBody Guest guest) {
        return guestService.create(guest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getById(@PathVariable String id) {
        return guestService.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<Guest>> getAll() {
        return guestService.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guest> update(@PathVariable String id, @RequestBody Guest guest) {
        return guestService.update(id, guest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return guestService.delete(id);
    }
    
    
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Guest>> findByEventId(@PathVariable String eventId) {
        return guestService.findByEventId(eventId);
    }
}
