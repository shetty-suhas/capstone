package com.example.tasks.Model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.tasks.Enums.TaskStatus;
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
public class Task { 
	
	@Id
	private String id; 
	private String name; 
	private String description; 
	TaskStatus status;

	@Temporal(TemporalType.TIME)
	@DateTimeFormat(style = "yyyy-mm-dd hh:mm")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-mm-dd hh:mm") 
	private Date startDateTime, endDateTime;
	
	private String eventId; 
}