package com.ust.gateway.Repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.ust.gateway.Model.ApiRoutes;

@Repository
public interface RouteRepository extends ReactiveCrudRepository<ApiRoutes, String>{

}
