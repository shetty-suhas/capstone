package com.ust.eventmanagement.Model;

import com.ust.eventmanagement.Enums.DietaryPreference;
import com.ust.eventmanagement.Enums.RSVPStatus;

public class Guest {
	private String id; 
	private String name, contactEmail; 
	private DietaryPreference dietaryPreference; 
	private RSVPStatus rsvpStatus; 
	private String eventId;
}
