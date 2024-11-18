package com.example.VendorService.Repository;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.VendorService.Model.Payment;
import com.example.VendorService.Model.Vendor;

@Repository
public interface VendorRepository extends MongoRepository<Vendor, String>{ 
	public List<Vendor> findByEventId(String eventId); 
	public List<Payment> findPaymentsById(String id);
}

