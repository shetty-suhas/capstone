package com.example.event_service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.event_service.Model.Event;


@Repository
public interface EventRepository extends MongoRepository<Event, String>{ 
	public List<Event> findByUserId(String eventUserId);
}
