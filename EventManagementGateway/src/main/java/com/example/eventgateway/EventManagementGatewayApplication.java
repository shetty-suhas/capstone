package com.example.eventgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EventManagementGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventManagementGatewayApplication.class, args);
	}

}
