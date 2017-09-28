package com.todo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Sort;
import java.util.List;
import com.todo.model.Task;
import com.todo.model.TaskStatus;

public interface TaskRepository extends MongoRepository<Task, String> {

	public List<Task> findAll(Sort sort);
	
	public Task findById(String id, Sort sort);
	
	public List<Task> findByStatus(TaskStatus.StatusType status, Sort sort);
	
}
