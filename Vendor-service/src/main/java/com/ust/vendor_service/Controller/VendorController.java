package com.ust.vendor_service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.vendor_service.Exceptions.NoVendorFoundException;
import com.ust.vendor_service.Model.Vendor;
import com.ust.vendor_service.Service.VendorService;

@RestController
@RequestMapping("/vendor")
public class VendorController {
	
	@Autowired
	private VendorService vendorService; 
	
	@GetMapping("/getById/{id}") 
	public ResponseEntity<Vendor> getVendorById(@PathVariable String id){  
		try { 
			return vendorService.getVendorById(id); 
		} 
		catch(NoVendorFoundException e) { 
			return ResponseEntity.noContent().build();
		}
	}
}
