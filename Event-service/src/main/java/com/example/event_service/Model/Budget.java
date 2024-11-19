package com.example.event_service.Model;

import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;



import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Budget { 
	@Id
	private String id;
	private Double allocatedAmount, spentAmount; 
	private Map<String, Double> categoryAllocations;  
}
