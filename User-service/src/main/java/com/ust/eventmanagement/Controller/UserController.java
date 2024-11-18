package com.ust.eventmanagement.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import com.ust.eventmanagement.Model.EventUser;
import com.ust.eventmanagement.Service.UserService;
import com.ust.eventmanagement.dto.EventUserRequest;

@RestController 
@RequestMapping(value="/user")
public class UserController {  
	
	@Autowired 
	private UserService userService;  

	
    @Autowired
    private AuthenticationManager authenticationManager;
    
    
	@PostMapping("/auth/create")
    public ResponseEntity<EventUser> create(@RequestBody EventUser eventUser) {
        return userService.create(eventUser);
    }
	
	@PostMapping("/auth/login") 
	public ResponseEntity<String> login(@RequestBody EventUserRequest authRequest){ 
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return ResponseEntity.ok(userService.generateToken(authRequest.getUsername()));
        } else {
            throw new RuntimeException("invalid access");
        }
	}

    @GetMapping("/{id}")
    public ResponseEntity<EventUser> getById(@PathVariable String id) {
        return userService.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<EventUser>> getAll() {
        return userService.getAll();
    } 
    
    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        userService.validateToken(token);
        return "Token is valid";
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventUser> update(@PathVariable String id, @RequestBody EventUser eventUser) {
        return userService.update(id, eventUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return userService.delete(id);
    } 
    @GetMapping("/byName/{name}")
    public ResponseEntity<EventUser> getByName(@PathVariable String name) {
        return userService.getByName(name);
    }

    @GetMapping("/search")
    public ResponseEntity<List<EventUser>> searchByEvent(@RequestParam String event) {
        return userService.searchByEvent(event);
    }


}

