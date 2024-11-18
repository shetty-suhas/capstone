package com.example.VendorServicee.Model;


import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;


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
	private String scheduleId;
}
