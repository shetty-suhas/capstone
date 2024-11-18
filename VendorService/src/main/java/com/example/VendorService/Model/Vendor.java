package com.example.VendorService.Model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.VendorService.Enums.VendorType;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Vendor { 
	@Id
	private String id; 
	private String name, contactEmail; 
	private VendorType type; 
	private List<Payment> payments; 
	private Double totalAmount, pendingAmount;	
	private String eventId;
}

