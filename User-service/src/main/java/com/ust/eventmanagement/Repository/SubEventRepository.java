package com.ust.eventmanagement.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ust.eventmanagement.Model.SubEvent;

@Repository
public interface SubEventRepository extends MongoRepository<SubEvent, String>{ 
	public List<SubEvent> findByScheduleId(String scheduleId);
}
