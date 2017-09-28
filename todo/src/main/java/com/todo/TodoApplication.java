package com.todo;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.todo.model.Task;
import com.todo.model.TaskStatus.StatusType;
import com.todo.repositories.AppRepository;
import com.todo.repositories.TaskRepository;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

	@Autowired
	private TaskRepository taskRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		
		AppRepository.setTaskRepository(taskRepository);
		
		AppRepository.getTaskRepository().save(new Task("TASK56221935", "Work 1", "This is my work", StatusType.COMPLETED, new DateTime()));
		AppRepository.getTaskRepository().save(new Task("TASK56221936", "Work 2", "This is my work", StatusType.ONHOLD, new DateTime()));
		AppRepository.getTaskRepository().save(new Task("TASK56221937", "Work 3", "This is my work", StatusType.INPROGRESS, new DateTime()));
		AppRepository.getTaskRepository().save(new Task("TASK56221938", "Work 4", "This is my work", StatusType.COMPLETED, new DateTime()));
		AppRepository.getTaskRepository().save(new Task("TASK56221939", "Work 5", "This is my work", StatusType.INPROGRESS, new DateTime()));
		AppRepository.getTaskRepository().save(new Task("TASK56221915", "Work 6", "This is my work", StatusType.ONHOLD, new DateTime()));
		AppRepository.getTaskRepository().save(new Task("TASK56221925", "Work 7", "This is my work", StatusType.INPROGRESS, new DateTime()));
		AppRepository.getTaskRepository().save(new Task("TASK56221235", "Work 8", "This is my work", StatusType.PENDING, new DateTime()));
		AppRepository.getTaskRepository().save(new Task("TASK56221945", "Work 9", "This is my work", StatusType.PENDING, new DateTime()));
		AppRepository.getTaskRepository().save(new Task("TASK56221955", "Work 10", "This is my work", StatusType.PENDING, new DateTime()));
		
	}
}
