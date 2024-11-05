package com.ust.guest_service.Model;

import java.util.List;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestGroup { 
	@Id
	private String id; 
	private String name; 
	List<Guest> guests;
	private String eventId;
}
