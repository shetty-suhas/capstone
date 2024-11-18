package com.example.VendorServicee.Controller;

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


import com.example.VendorServicee.Service.VendorService;


@RestController
@RequestMapping("/vendor")
public class VendorController {
	
	@Autowired
	private VendorService vendorService;  
	
	@GetMapping("/test") 
	public String hello() { 
		return "Hello";
	}
	
    @PostMapping
    public ResponseEntity<Vendor> create(@RequestBody Vendor vendor) {
        return vendorService.create(vendor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendor> getById(@PathVariable String id) {
        return vendorService.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<Vendor>> getAll() {
        return vendorService.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendor> update(@PathVariable String id, @RequestBody Vendor vendor) {
        return vendorService.update(id, vendor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return vendorService.delete(id);
    }

    @GetMapping("/schedule/{scheduleId}")
    public ResponseEntity<List<Vendor>> findByScheduleId(@PathVariable String scheduleId) {
        return vendorService.findByScheduleId(scheduleId);
    }
}

