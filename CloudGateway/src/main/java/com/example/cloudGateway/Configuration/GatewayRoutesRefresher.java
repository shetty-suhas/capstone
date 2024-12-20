package com.example.cloudGateway.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import com.example.cloudGateway.Handler.ApiRouteHandler;

@Component
public class GatewayRoutesRefresher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher; 
   
    
    private static final Logger logger = LoggerFactory.getLogger(GatewayRoutesRefresher.class);

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * Refresh the routes to load from data store
     */
    public void refreshRoutes() { 
    	logger.info("initiating");
        applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this)); 
    } 
}