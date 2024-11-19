package com.example.event_service.Model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.event_service.enums.EventStatus;
import com.example.event_service.enums.EventType;
import com.fasterxml.jackson.annotation.JsonFormat;


import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Event { 
	@Id
	private String id;  
	private String userId; 
	private String name, location; 
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "dd-MM-yyyy hh:mm")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm")
	private Date startDate, endDate; 
	
	private EventType type; 
	private EventStatus status;  
	int totalTask, taskCompleted, totalGuests; 
	Budget budget;
}
