package com.ust.guest_service.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ust.guest_service.Model.GuestGroup;

@Repository
public interface GuestGroupRepository extends MongoRepository<GuestGroup, String>{ 
    Optional<GuestGroup> findGuestGroupByEventId(String eventId);
    List<GuestGroup> findByEventId(String eventId);
}
