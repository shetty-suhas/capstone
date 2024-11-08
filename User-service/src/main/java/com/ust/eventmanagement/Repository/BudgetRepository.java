package com.ust.eventmanagement.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ust.eventmanagement.Model.Budget;

@Repository
public interface BudgetRepository extends MongoRepository<Budget, String>{ 
	public Optional<Budget> findBySubEventId(String eventId);
	
}
