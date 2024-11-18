package com.example.eventgateway.Config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration 
public class GatewayConfig { 
	
	private AuthenticationFilter authenticationFilter;
	
	@Bean 
	RouteLocator gatewayRoute(RouteLocatorBuilder builder) { 
		return builder
				.routes()
				.route("VENDORSERVICE", r -> r.path("/vendor/**") 
					.filters(f -> f.addResponseHeader("X-Response-Header", "World")
							.filter(authenticationFilter)) 
					.uri("lb://VENDORSERVICE".replaceAll("\\s+", "")))
				.route("USER-SERVICE", r -> r.path("/user/**") 
						.filters(f -> f.addResponseHeader("X-Response-Header", "World")
								.filter(authenticationFilter)) 
						.uri("lb://USER-SERVICE"))
				.route("PAYMENT-SERVICE", r -> r.path("/payment/**") 
						.filters(f -> f.addResponseHeader("X-Response-Header", "World")
								.filter(authenticationFilter)) 
						.uri("lb://PAYMENT-SERVICE"))
				.route("GUEST-SERVICE", r -> r.path("/guest/**") 
						.filters(f -> f.addResponseHeader("X-Response-Header", "World")
								.filter(authenticationFilter)) 
						.uri("lb://GUEST-SERVICE"))
				.route("TASKS", r -> r.path("/task/**")
						.filters(f -> f.addResponseHeader("X-response-header", "HELLO")
								.filter(authenticationFilter))
						.uri("lb://TASKS")) 
				.build();
	} 
}