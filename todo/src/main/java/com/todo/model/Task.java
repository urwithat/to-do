package com.todo.model;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.joda.ser.DateTimeSerializer;

public class Task {
	private String id;
	private String title;
	private String description;
	private TaskStatus.StatusType status;
	@JsonSerialize(using=DateTimeSerializer.class)
	private DateTime dateTime;
	
	public Task() {
        super();
    }
	
	public Task(String id, String title, String description, TaskStatus.StatusType status, DateTime dateTime) {
		this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.dateTime = dateTime;
    }
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public TaskStatus.StatusType getStatus() {
		return status;
	}
	public void setStatus(TaskStatus.StatusType status) {
		this.status = status;
	}
	
	public DateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}
	
}
