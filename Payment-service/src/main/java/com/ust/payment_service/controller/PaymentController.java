package com.ust.payment_service.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ust.payment_service.Enums.PaymentStatus;
import com.ust.payment_service.Enums.PaymentType;
import com.ust.payment_service.Model.Payment;
import com.ust.payment_service.Service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController { 
	
	@Autowired 
	private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> create(@RequestBody Payment payment) {
        return paymentService.create(payment);
    } 
    
	@GetMapping("/test") 
	public String hello() { 
		return "Hello";
	}
	

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getById(@PathVariable String id) {
        return paymentService.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAll() {
        return paymentService.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> update(@PathVariable String id, @RequestBody Payment payment) {
        return paymentService.update(id, payment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return paymentService.delete(id);
    }

    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<List<Payment>> findByVendorId(@PathVariable String vendorId) {
        return paymentService.findByVendorId(vendorId);
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Payment>> findByEventId(@PathVariable String eventId) {
        return paymentService.findByEventId(eventId);
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Payment>> findByPaymentStatus(@PathVariable PaymentStatus status) {
        return paymentService.findByPaymentStatus(status);
    }

    // Get all payments of a specific payment type
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Payment>> findByPaymentType(@PathVariable PaymentType type) {
        return paymentService.findByPaymentType(type);
    }

    // Get all payments made within a specific date range
    @GetMapping("/date-range")
    public ResponseEntity<List<Payment>> findByPaymentDateRange(
        @RequestParam("startDate") String startDate, 
        @RequestParam("endDate") String endDate) {
        return paymentService.findByPaymentDateRange(startDate, endDate);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Payment> updatePaymentStatus(
        @PathVariable String id, 
        @RequestParam PaymentStatus status) {
        return paymentService.updatePaymentStatus(id, status);
    }
}
