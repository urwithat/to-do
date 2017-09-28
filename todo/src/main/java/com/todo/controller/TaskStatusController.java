package com.todo.controller;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todo.model.Task;
import com.todo.model.TaskStatus;
import com.todo.repositories.AppRepository;

@RestController
@RequestMapping("/api")
public class TaskStatusController {

	@RequestMapping(value = "/tasks/status/{status}", method = RequestMethod.GET)
	public List<Task> readAll(@PathVariable("status") String status) {
		try {
			TaskStatus.StatusType a = TaskStatus.StatusType.valueOf(status.toUpperCase());
			return AppRepository.getTaskRepository().findByStatus(a, new Sort(Sort.Direction.ASC, "dateTime"));
		} catch (Exception e) {
			return null;
		}
	}
	
}
