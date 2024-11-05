package com.ust.eventmanagement.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ust.eventmanagement.Model.EventUser;

@Repository
public interface UserRepository extends MongoRepository<EventUser, String> {

}
