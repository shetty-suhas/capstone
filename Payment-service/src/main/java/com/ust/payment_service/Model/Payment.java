package com.ust.payment_service.Model;
import java.util.Date;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ust.payment_service.Enums.PaymentStatus;
import com.ust.payment_service.Enums.PaymentType;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class Payment { 
	@Id 
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
