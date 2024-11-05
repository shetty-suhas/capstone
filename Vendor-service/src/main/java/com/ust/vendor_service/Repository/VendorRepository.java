package com.ust.vendor_service.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ust.vendor_service.Model.Vendor;

public interface VendorRepository extends MongoRepository<Vendor, String>{ 
	public List<Vendor> findByScheduleId(String vendorId);
}
