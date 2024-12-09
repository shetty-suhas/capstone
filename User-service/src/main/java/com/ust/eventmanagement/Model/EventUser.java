package com.ust.eventmanagement.Model;

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
public class EventUser { 
	@Id 
	private String id; 
	private String name;  
	private String password;

}
