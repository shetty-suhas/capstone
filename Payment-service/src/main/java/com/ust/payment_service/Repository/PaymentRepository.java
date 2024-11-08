package com.ust.payment_service.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ust.payment_service.Model.Payment;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String>{ 
	public List<Payment> findByVendorId(String vendorId); 
	public List<Payment> findByEventId(String eventId); 
}
