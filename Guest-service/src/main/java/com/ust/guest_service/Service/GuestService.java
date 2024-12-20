package com.ust.guest_service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ust.guest_service.Enums.RSVPStatus;
import com.ust.guest_service.Model.Guest;
import com.ust.guest_service.Model.GuestGroup;
import com.ust.guest_service.Repository.GuestGroupRepository;
import com.ust.guest_service.Repository.GuestRepository;

@Service
public class GuestService { 
	
	@Autowired
	private GuestRepository guestRepository;  
	
	@Autowired 
	private GuestGroupRepository guestGroupRepository;

    public ResponseEntity<Guest> create(Guest guest) { 
		Optional<GuestGroup> optional = guestGroupRepository.findGuestGroupByEventId(guest.getEventId()); 
		if(optional.isEmpty()) { 
			GuestGroup guestGroup = new GuestGroup(null, "group_" + guest.getEventId(), new ArrayList<>(), guest.getEventId()); 
			optional = Optional.of(guestGroup);
		}  
		GuestGroup guestGroup = optional.get(); 
		guestGroup.getGuests().add(guest); 
		guestGroupRepository.save(guestGroup);
        Guest savedGuest = guestRepository.save(guest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGuest);
    }


    public ResponseEntity<Guest> getById(String id) {
        Optional<Guest> guestOpt = guestRepository.findById(id);
        return guestOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity<List<Guest>> getAll() {
        List<Guest> guests = guestRepository.findAll();
        return ResponseEntity.ok(guests);
    }

    public ResponseEntity<Guest> update(String id, Guest guest) {
        Optional<Guest> existingGuestOpt = guestRepository.findById(id);
        if (existingGuestOpt.isPresent()) {
            Guest existingGuest = existingGuestOpt.get();
            existingGuest.setName(guest.getName());
            existingGuest.setContactEmail(guest.getContactEmail());
            existingGuest.setDietaryPreference(guest.getDietaryPreference());
            existingGuest.setRsvpStatus(guest.getRsvpStatus());
            existingGuest.setEventId(guest.getEventId());

            Guest updatedGuest = guestRepository.save(existingGuest);
            return ResponseEntity.ok(updatedGuest);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<Void> delete(String id) {
        Optional<Guest> guestOpt = guestRepository.findById(id);
        if (guestOpt.isPresent()) {
            guestRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    } 
    
    public ResponseEntity<Guest> findGuestByEventId(String eventId) {
        Optional<Guest> guest = guestRepository.findGuestByEventId(eventId);
        return guest.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.ok(guest.get());
    }

    public ResponseEntity<List<Guest>> findByEventId(String eventId) {
        List<Guest> guests = guestRepository.findByEventId(eventId);
        return ResponseEntity.ok(guests);
    } 
    
    public ResponseEntity<List<Guest>> findGuestsByDietaryPreference(String dietaryPreference) {
        List<Guest> guests = guestRepository.findByDietaryPreference(dietaryPreference);
        return ResponseEntity.ok(guests);
    }

//    public ResponseEntity<List<Guest>> findGuestsByRSVPStatus(RSVPStatus rsvpStatus) {
//        List<Guest> guests = guestRepository.findByRSVPStatus(rsvpStatus);
//        return ResponseEntity.ok(guests);
//    }

    // GuestGroup Methods

    public ResponseEntity<GuestGroup> createGuestGroup(GuestGroup guestGroup) {
        GuestGroup savedGroup = guestGroupRepository.save(guestGroup);
        return ResponseEntity.ok(savedGroup);
    }

    public ResponseEntity<GuestGroup> getGuestGroupById(String id) {
        Optional<GuestGroup> guestGroup = guestGroupRepository.findById(id);
        return guestGroup.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<GuestGroup>> getAllGuestGroups() {
        List<GuestGroup> guestGroups = guestGroupRepository.findAll();
        return ResponseEntity.ok(guestGroups);
    }

    public ResponseEntity<GuestGroup> updateGuestGroup(String id, GuestGroup guestGroup) {
        guestGroup.setId(id);
        GuestGroup updatedGroup = guestGroupRepository.save(guestGroup);
        return ResponseEntity.ok(updatedGroup);
    }

    public ResponseEntity<Void> deleteGuestGroup(String id) {
        guestGroupRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<List<GuestGroup>> findGuestGroupsByEventId(String eventId) {
        List<GuestGroup> guestGroups = guestGroupRepository.findByEventId(eventId);
        return ResponseEntity.ok(guestGroups);
    }
}

