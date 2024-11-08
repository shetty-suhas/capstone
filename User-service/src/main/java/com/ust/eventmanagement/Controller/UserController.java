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

import com.ust.eventmanagement.Model.EventUser;
import com.ust.eventmanagement.Service.UserService;

@RestController 
@RequestMapping(value="/user")
public class UserController {  
	
	@Autowired 
	private UserService userService; 
	@PostMapping
    public ResponseEntity<EventUser> create(@RequestBody EventUser eventUser) {
        return userService.create(eventUser);
    }

    // Get an EventUser by ID
    @GetMapping("/{id}")
    public ResponseEntity<EventUser> getById(@PathVariable String id) {
        return userService.getById(id);
    }

    // Get all EventUsers
    @GetMapping
    public ResponseEntity<List<EventUser>> getAll() {
        return userService.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventUser> update(@PathVariable String id, @RequestBody EventUser eventUser) {
        return userService.update(id, eventUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return userService.delete(id);
    }
}
