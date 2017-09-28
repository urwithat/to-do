package com.todo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.todo.model.Task;
import com.todo.repositories.AppRepository;

@RestController
@RequestMapping("/api")
public class TaskController {

	@RequestMapping(value = "/tasks/create", method = RequestMethod.POST)
	public List<Task> create(@RequestBody String payload) {
		if(payload != null) {
			if(payload.trim().length() != 0) {
				ObjectMapper objectMapper = new ObjectMapper();
				try {
					Task task = objectMapper.readValue(payload, Task.class);
					task.setId(generateId());
					AppRepository.getTaskRepository().save(task);
					return AppRepository.getTaskRepository().findAll(new Sort(Sort.Direction.ASC, "dateTime"));
				} catch (IOException e) {
					e.printStackTrace();
					return AppRepository.getTaskRepository().findAll(new Sort(Sort.Direction.ASC, "dateTime"));
				}
			} else {
				return AppRepository.getTaskRepository().findAll(new Sort(Sort.Direction.ASC, "dateTime"));
			}
		} else {
			return AppRepository.getTaskRepository().findAll(new Sort(Sort.Direction.ASC, "dateTime"));
		}
	}
	
	private String generateId() {
		String generateNewId = "TASK" + (int) (Math.floor(Math.random() * (Math.floor(99999999) - Math.ceil(11111111)) + Math.ceil(11111111)));
		Task checkIdExists = AppRepository.getTaskRepository().findById(generateNewId, new Sort(Sort.Direction.ASC, "dateTime"));
		if(checkIdExists != null) {
			return generateId();
		} else {
			return generateNewId;
		}
	}
	
	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public List<Task> readAll() {
		return AppRepository.getTaskRepository().findAll(new Sort(Sort.Direction.ASC, "dateTime"));
	}
	
	@RequestMapping(value = "/tasks/update", method = RequestMethod.PUT)
	public List<Task> update(@RequestBody String payload) {
		if(payload != null) {
			if(payload.trim().length() != 0) {
				ObjectMapper objectMapper = new ObjectMapper();
				try {
					Task taskModified = objectMapper.readValue(payload, Task.class);
					Task task = AppRepository.getTaskRepository().findById(taskModified.getId(), new Sort(Sort.Direction.ASC, "dateTime"));
					if(task != null) {
						task.setTitle(taskModified.getTitle());
						task.setDescription(taskModified.getDescription());
						task.setStatus(taskModified.getStatus());
						task.setDateTime(taskModified.getDateTime());
						AppRepository.getTaskRepository().save(task);
						return AppRepository.getTaskRepository().findAll(new Sort(Sort.Direction.ASC, "dateTime"));
					} else {
						//return Helper.EMP_ERROR_NO_DATA.value();
						return AppRepository.getTaskRepository().findAll(new Sort(Sort.Direction.ASC, "dateTime"));
					}
				} catch (IOException e) {
					e.printStackTrace();
					//return Helper.EMP_ERROR.value();
					return AppRepository.getTaskRepository().findAll(new Sort(Sort.Direction.ASC, "dateTime"));
				}
			} else {
				//return Helper.EMP_ERROR_PARAMETERS.value();
				return AppRepository.getTaskRepository().findAll(new Sort(Sort.Direction.ASC, "dateTime"));
			}
		} else {
			return AppRepository.getTaskRepository().findAll(new Sort(Sort.Direction.ASC, "dateTime"));
		}
	}
	
	@RequestMapping(value = "/tasks/delete/{id}", method = RequestMethod.GET)
	public List<Task> delete(@PathVariable("id") String id) {
		if(id != null) {
			if(id.trim().length() != 0) {
				Task task = AppRepository.getTaskRepository().findById(id, new Sort(Sort.Direction.ASC, "dateTime"));
				if(task != null) {
					AppRepository.getTaskRepository().delete(task);
					return AppRepository.getTaskRepository().findAll(new Sort(Sort.Direction.ASC, "dateTime"));
				} else {
					return AppRepository.getTaskRepository().findAll(new Sort(Sort.Direction.ASC, "dateTime"));
				}
			} else {
				return AppRepository.getTaskRepository().findAll(new Sort(Sort.Direction.ASC, "dateTime"));
			}
		} else {
			return AppRepository.getTaskRepository().findAll(new Sort(Sort.Direction.ASC, "dateTime"));
		}
	}
	
}
