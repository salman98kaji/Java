package com.taskManager.model;

import java.time.LocalDate;

public class Task {
	private static int idCounter=0;
	private int taskId;
	private String taskName;
	private String description;
	private LocalDate taskDate;
	private String status;
	private boolean active;
	
	public Task(String taskName, String description, LocalDate taskDate) {
		super();
		this.taskId = ++idCounter;
		this.taskName = taskName;
		this.description = description;
		this.taskDate = taskDate;
		this.status = "PENDING";
		this.active = true;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(LocalDate taskDate) {
		this.taskDate = taskDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if(status.equals("PENDING") || status.equals("IN PROGRESS") || status.equals("COMPLETED")) {
		this.status = status;
		}
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Task [taskId =" + taskId + ", taskName =" + taskName + ", descriptio n=" + description + ", taskDate ="
				+ taskDate + ", status =" + status + ", active =" + active + "]";
	}
	
	
	
	
}
