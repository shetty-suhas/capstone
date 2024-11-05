package com.ust.guest_service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ust.guest_service.Exceptions.NoGuestFoundException;
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
	
	public ResponseEntity<Guest> getGuestByEvent(String eventId) throws NoGuestFoundException{ 
		Optional<Guest> optional = guestRepository.findGuestByEventId(eventId); 
		if(optional.isEmpty()) throw new NoGuestFoundException("No guest found");  
		return ResponseEntity.ok(optional.get());
	} 
	
	public ResponseEntity<Guest> addGuest(Guest guest){ 
		Optional<GuestGroup> optional = guestGroupRepository.findGuestGroupByEventId(guest.getEventId()); 
		if(optional.isEmpty()) { 
			GuestGroup guestGroup = new GuestGroup(null, "group_" + guest.getEventId(), new ArrayList<>(), guest.getEventId()); 
			optional = Optional.of(guestGroup);
		}  
		GuestGroup guestGroup = optional.get(); 
		guestGroup.getGuests().add(guest); 
		guestGroupRepository.save(guestGroup);
		return ResponseEntity.ok(guestRepository.save(guest)); 
	}
}