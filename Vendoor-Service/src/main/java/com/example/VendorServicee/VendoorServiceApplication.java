package com.example.VendorServicee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class VendoorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendoorServiceApplication.class, args);
	}

}
