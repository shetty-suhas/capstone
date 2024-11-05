package com.ust.eventmanagement.Model;

import java.util.List;

import com.ust.eventmanagement.Enums.VendorType;


public class Vendor {
	private String id; 
	private String name, contactEmail; 
	private VendorType type; 
	private List<Payment> payments; 
	private Double totalAmount, pendingAmount;	
}
