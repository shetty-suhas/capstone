package com.example.tasks.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.tasks.Enums.TaskStatus;
import com.example.tasks.Model.Task;



@Repository
public interface TaskRepository extends MongoRepository<Task, String>{ 
    List<Task> findByStatus(TaskStatus status);

    List<Task> findByEventId(String eventId);
}
