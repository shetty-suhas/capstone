package com.ust.vendor_service.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ust.vendor_service.Model.Vendor;
import com.ust.vendor_service.Repository.VendorRepository;

@Service
public class VendorService { 
	@Autowired
	private VendorRepository vendorRepository;

    public ResponseEntity<Vendor> create(Vendor vendor) {
        Vendor savedVendor = vendorRepository.save(vendor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVendor);
    }

    public ResponseEntity<Vendor> getById(String id) {
        Optional<Vendor> vendorOpt = vendorRepository.findById(id);
        return vendorOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity<List<Vendor>> getAll() {
        List<Vendor> vendors = vendorRepository.findAll();
        return ResponseEntity.ok(vendors);
    }

    public ResponseEntity<Vendor> update(String id, Vendor vendor) {
        Optional<Vendor> existingVendorOpt = vendorRepository.findById(id);
        if (existingVendorOpt.isPresent()) {
            Vendor existingVendor = existingVendorOpt.get();
            existingVendor.setName(vendor.getName());
            existingVendor.setContactEmail(vendor.getContactEmail());
            existingVendor.setType(vendor.getType());
            existingVendor.setPayments(vendor.getPayments());
            existingVendor.setTotalAmount(vendor.getTotalAmount());
            existingVendor.setPendingAmount(vendor.getPendingAmount());
            existingVendor.setScheduleId(vendor.getScheduleId());

            Vendor updatedVendor = vendorRepository.save(existingVendor);
            return ResponseEntity.ok(updatedVendor);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<Void> delete(String id) {
        Optional<Vendor> vendorOpt = vendorRepository.findById(id);
        if (vendorOpt.isPresent()) {
            vendorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<List<Vendor>> findByScheduleId(String scheduleId) {
        List<Vendor> vendors = vendorRepository.findByScheduleId(scheduleId);
        if (vendors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(vendors);
    }
}
