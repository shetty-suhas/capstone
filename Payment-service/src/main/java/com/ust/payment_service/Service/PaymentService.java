package com.ust.payment_service.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ust.payment_service.Exceptions.NoPaymentsFoundException;
import com.ust.payment_service.Model.Payment;
import com.ust.payment_service.Repository.PaymentRepository;

@Service
public class PaymentService {  
	
	@Autowired
	private PaymentRepository paymentRepository; 
	
	public ResponseEntity<List<Payment>> findPaymentsForVendor(String vendorId) throws NoPaymentsFoundException{ 
		Optional<List<Payment>> optional = paymentRepository.findPaymentByVendorId(vendorId); 
		if(optional.isEmpty()) throw new NoPaymentsFoundException("No payemnts"); 
		return ResponseEntity.ok(optional.get());
		
 	} 
	
	public ResponseEntity<List<Payment>> findPaymentsForEvent(String eventId) throws NoPaymentsFoundException{ 
		Optional<List<Payment>> optional = paymentRepository.findPaymentByEventId(eventId); 
		if(optional.isEmpty()) throw new NoPaymentsFoundException("No payemnts"); 
		return ResponseEntity.ok(optional.get()); 
	} 
	
	public ResponseEntity<Payment> addPayment(Payment payment){ 
		return ResponseEntity.ok(paymentRepository.save(payment));
	}
	
}