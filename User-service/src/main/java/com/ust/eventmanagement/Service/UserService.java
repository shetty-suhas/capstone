package com.ust.eventmanagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ust.eventmanagement.Model.EventUser;
import com.ust.eventmanagement.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired 
	private UserRepository userRepository;  

    public ResponseEntity<EventUser> create(EventUser eventUser) {
        EventUser savedEventUser = userRepository.save(eventUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEventUser);
    }
    public ResponseEntity<EventUser> getById(String id) {
        Optional<EventUser> eventUserOpt = userRepository.findById(id);
        return eventUserOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity<List<EventUser>> getAll() {
        List<EventUser> eventUsers = userRepository.findAll();
        return ResponseEntity.ok(eventUsers);
    }

    public ResponseEntity<EventUser> update(String id, EventUser eventUser) {
        Optional<EventUser> existingEventUserOpt = userRepository.findById(id);
        if (existingEventUserOpt.isPresent()) {
            EventUser existingEventUser = existingEventUserOpt.get();
            existingEventUser.setName(eventUser.getName());
            existingEventUser.setEventList(eventUser.getEventList());

            EventUser updatedEventUser = userRepository.save(existingEventUser);
            return ResponseEntity.ok(updatedEventUser);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<Void> delete(String id) {
        Optional<EventUser> eventUserOpt = userRepository.findById(id);
        if (eventUserOpt.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
