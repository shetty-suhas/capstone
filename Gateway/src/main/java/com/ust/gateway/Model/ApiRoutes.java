package com.ust.gateway.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ApiRoutes")
public class ApiRoutes { 
	@Id
    private String id;
    private String routeIdentifier;
    private String uri;
    private String method;
    private String path;
}
