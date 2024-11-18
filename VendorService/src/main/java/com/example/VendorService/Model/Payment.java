package com.example.VendorService.Model;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.VendorService.Enums.PaymentStatus;
import com.example.VendorService.Enums.PaymentType;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	private String id;   
	private String vendorId;
	private Double amount;
	private String referenceNumber;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "dd-mm-yyyy")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-mm-yyyy")
	Date paymentDate;  
	
	PaymentStatus paymentStatus; 
	PaymentType paymentType;
}
