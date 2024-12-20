package com.ust.guest_service.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.ust.guest_service.Enums.DietaryPreference;
import com.ust.guest_service.Enums.RSVPStatus;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Document("guest")
public class Guest { 
	@Id
	private String id; 
	private String name, contactEmail; 
	private DietaryPreference dietaryPreference; 
	private RSVPStatus rsvpStatus; 
	private String eventId; 
}
