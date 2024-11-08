package com.ust.payment_service.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ust.payment_service.Model.Payment;
import com.ust.payment_service.Repository.PaymentRepository;

@Service
public class PaymentService {  
	
	@Autowired
	private PaymentRepository paymentRepository; 

    public ResponseEntity<Payment> create(Payment payment) {
        Payment savedPayment = paymentRepository.save(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPayment);
    }

    public ResponseEntity<Payment> getById(String id) {
        Optional<Payment> paymentOpt = paymentRepository.findById(id);
        return paymentOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity<List<Payment>> getAll() {
        List<Payment> payments = paymentRepository.findAll();
        return ResponseEntity.ok(payments);
    }

    public ResponseEntity<Payment> update(String id, Payment payment) {
        Optional<Payment> existingPaymentOpt = paymentRepository.findById(id);
        if (existingPaymentOpt.isPresent()) {
            Payment existingPayment = existingPaymentOpt.get();
            existingPayment.setVendorId(payment.getVendorId());
            existingPayment.setEventId(payment.getEventId());
            existingPayment.setAmount(payment.getAmount());
            existingPayment.setPaymentDate(payment.getPaymentDate());
            existingPayment.setPaymentStatus(payment.getPaymentStatus());
            existingPayment.setPaymentType(payment.getPaymentType());

            Payment updatedPayment = paymentRepository.save(existingPayment);
            return ResponseEntity.ok(updatedPayment);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<Void> delete(String id) {
        Optional<Payment> paymentOpt = paymentRepository.findById(id);
        if (paymentOpt.isPresent()) {
            paymentRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<List<Payment>> findByVendorId(String vendorId) {
        List<Payment> payments = paymentRepository.findByVendorId(vendorId);
        return payments.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.ok(payments);
    }

    // Get Payments by Event ID
    public ResponseEntity<List<Payment>> findByEventId(String eventId) {
        List<Payment> payments = paymentRepository.findByEventId(eventId);
        return payments.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.ok(payments);
    }
}
