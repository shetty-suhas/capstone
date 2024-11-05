package com.ust.eventmanagement.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ust.eventmanagement.Model.Event;

@Repository
public interface EventRepository extends MongoRepository<Event, String>{ 
	public List<Event> findByUserId(String eventUserId);
}
