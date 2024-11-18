package com.ust.eventmanagement.Model;

import java.util.Date;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ust.eventmanagement.Enums.EventStatus;
import com.ust.eventmanagement.Enums.EventType;

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

	@Temporal(TemporalType.TIME)
	@DateTimeFormat(style = "dd-mm-yyyy hh:mm")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-mm-yyyy hh:mm")
	private Date startDate, endDate; 
	
	private EventType type; 
	private EventStatus status;  
	int totalTask, taskCompleted, totalGuests; 
	Budget budget;
}
