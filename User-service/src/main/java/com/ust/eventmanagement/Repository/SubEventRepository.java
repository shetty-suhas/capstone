package com.ust.eventmanagement.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ust.eventmanagement.Model.SubEvent;

@Repository
public interface SubEventRepository extends MongoRepository<SubEvent, String>{

}
