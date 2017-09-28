package com.todo.repositories;

import org.springframework.beans.factory.annotation.Autowired;

public class AppRepository {
	
	@Autowired
	private static TaskRepository taskRepository;
	
	public static TaskRepository getTaskRepository() {
        return taskRepository;
    }

    public static void setTaskRepository(TaskRepository taskRepository) {
    	AppRepository.taskRepository = taskRepository;
    }
}
