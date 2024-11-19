package com.example.VendorService.Controller;

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

import com.example.VendorService.Model.Payment;
import com.example.VendorService.Model.Vendor;
import com.example.VendorService.Service.VendorService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Vendor>> findByEventId(@PathVariable String eventId) {
        return vendorService.findByEventId(eventId);
    } 
    
    @GetMapping("/payment/{id}")
    public ResponseEntity<List<Payment>> getPaymentsById(@PathVariable String id) {
        return vendorService.getPaymentsById(id);
    } 
    
    @PostMapping("/newpayment/{id}")
    public ResponseEntity<Vendor> addPaymentToVendor(@PathVariable String id, @RequestBody Payment payment){  
    	return vendorService.addPaymentToVendor(id, payment);
    } 
    
    @DeleteMapping("/deletepayment/{vendorId}/{paymentId}")
    public ResponseEntity<Vendor> deletePayment(
            @PathVariable String vendorId,
            @PathVariable String paymentId) {
        
            return vendorService.deletePayment(vendorId, paymentId); 
    }
    @PutMapping("/updatepayment/{vendorId}/{paymentId}")
    public ResponseEntity<Payment> updatePayment(
            @PathVariable String vendorId,
            @PathVariable String paymentId,
            @RequestBody Payment updatedPayment) {
            Payment payment = vendorService.updatePayment(vendorId, paymentId, updatedPayment);
            return ResponseEntity.ok(payment);

    }
 
  
}
