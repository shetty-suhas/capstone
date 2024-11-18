package com.example.VendorServicee.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface VendorRepository extends MongoRepository<Vendor, String>{ 
	public List<Vendor> findByScheduleId(String vendorId);
}
