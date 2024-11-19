package com.ust.eventmanagement.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ust.eventmanagement.Model.EventUser;

@Repository
public interface UserRepository extends MongoRepository<EventUser, String> {
    Optional<EventUser> findByName(String username);
}
