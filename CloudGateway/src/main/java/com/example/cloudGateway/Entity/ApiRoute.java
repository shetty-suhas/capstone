package com.example.cloudGateway.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class ApiRoute { 
	@Id
	private String id; 
    private String routeIdentifier;
    private String uri;
    private String method;
    private String path;
}
