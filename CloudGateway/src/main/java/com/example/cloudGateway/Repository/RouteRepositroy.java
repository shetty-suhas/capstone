package com.example.cloudGateway.Repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.cloudGateway.Entity.ApiRoute;

@Repository
public interface RouteRepositroy extends ReactiveCrudRepository<ApiRoute, String>{

}
