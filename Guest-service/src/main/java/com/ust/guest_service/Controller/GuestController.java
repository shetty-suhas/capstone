package com.ust.guest_service.Controller;

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

import com.ust.guest_service.Enums.RSVPStatus;
import com.ust.guest_service.Model.Guest;
import com.ust.guest_service.Model.GuestGroup;
import com.ust.guest_service.Service.GuestService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/guest")
public class GuestController { 
	
	@Autowired
	private GuestService guestService; 
	
	@GetMapping("/test") 
	public String test() { 
		return "Guest Service";
	}

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
    
    @GetMapping("/diet/{dietaryPreference}")
    public ResponseEntity<List<Guest>> findGuestsByDietaryPreference(@PathVariable String dietaryPreference) {
        return guestService.findGuestsByDietaryPreference(dietaryPreference);
    }

//    @GetMapping("/rsvp/{rsvpStatus}")
//    public ResponseEntity<List<Guest>> findGuestsByRSVPStatus(@PathVariable RSVPStatus rsvpStatus) {
//        return guestService.findGuestsByRSVPStatus(rsvpStatus);
//    }

    // GuestGroup Endpoints
    @PostMapping("/group")
    public ResponseEntity<GuestGroup> createGuestGroup(@RequestBody GuestGroup guestGroup) {
        return guestService.createGuestGroup(guestGroup);
    }

    @GetMapping("/group/{id}")
    public ResponseEntity<GuestGroup> getGuestGroupById(@PathVariable String id) {
        return guestService.getGuestGroupById(id);
    }

    @GetMapping("/groups")
    public ResponseEntity<List<GuestGroup>> getAllGuestGroups() {
        return guestService.getAllGuestGroups();
    }

    @PutMapping("/group/{id}")
    public ResponseEntity<GuestGroup> updateGuestGroup(@PathVariable String id, @RequestBody GuestGroup guestGroup) {
        return guestService.updateGuestGroup(id, guestGroup);
    }

    @DeleteMapping("/group/{id}")
    public ResponseEntity<Void> deleteGuestGroup(@PathVariable String id) {
        return guestService.deleteGuestGroup(id);
    }

    @GetMapping("/group/event/{eventId}")
    public ResponseEntity<List<GuestGroup>> findGuestGroupsByEventId(@PathVariable String eventId) {
        return guestService.findGuestGroupsByEventId(eventId);
    }
}

