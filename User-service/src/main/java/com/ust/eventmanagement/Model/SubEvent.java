package com.ust.eventmanagement.Model;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

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
public class SubEvent {
	@Id
	private String id; 
	private String name, location;  
	
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(style = "dd-mm-yyyy hh:mm")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-mm-yyyy hh:mm")
	private Date startTime, endTime;  
	
	private List<Vendor> requiredVendors; 
	private List<GuestGroup> involvedGroups;  
	private String scheduleId;
}
