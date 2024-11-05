package com.ust.gateway.Config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ust.gateway.Service.ApiRouteLocatorImple;
import com.ust.gateway.Service.RouteService;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteService routeService, RouteLocatorBuilder routeLocationBuilder) {
        return new ApiRouteLocatorImple(routeLocationBuilder, routeService);
    }
}
