package com.ust.payment_service.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ust.payment_service.Enums.PaymentStatus;
import com.ust.payment_service.Enums.PaymentType;
import com.ust.payment_service.Model.Payment;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String>{ 
	public List<Payment> findByVendorId(String vendorId); 
	public List<Payment> findByEventId(String eventId);  
	public List<Payment> findByPaymentStatus(PaymentStatus status); 
	public List<Payment> findByPaymentType(PaymentType type); 
	public List<Payment> findByPaymentDateBetween(Date startDateStr, Date endDateStr);
	
}
