package com.example.VendorServicee.Model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class Payment {
	private String id;   
	private String vendorId;
	private String eventId;
	private Double amount; 

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "dd-mm-yyyy hh:mm")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-mm-yyyy hh:mm")
	Date paymentDate;  
	
	PaymentStatus paymentStatus; 
	PaymentType paymentType;
}
