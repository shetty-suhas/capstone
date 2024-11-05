package com.ust.eventmanagement.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ust.eventmanagement.Model.Schedule;

@Repository
public interface ScheduleRepository extends MongoRepository<Schedule, String>{

}
