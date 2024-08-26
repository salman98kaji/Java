package com.taskManager.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.taskManager.model.Task;

public class TaskService {
	private List<Task> taskList = new ArrayList<>(); 
	
	// 1)Add new task
	public void addTask(String taskName, String description, LocalDate taskDate) {
		Task newTask = new Task(taskName,description,taskDate);
		taskList.add(newTask);
	}
	
	// 2) Delete a task
	public void deleteTask(int taskId) {
		for(Task task:taskList) {
			if(task.getTaskId() == taskId) {
				task.setActive(false);
				break;
			}
		}		
	}
	
	// 3) Update task status
	public void updateTaskStatus(int taskId, String newStatus) {
		for(Task task : taskList) {
			if(task.getTaskId() == taskId) {
				task.setStatus(newStatus);
				break;
			}
		}
	}
	
	// 4) Display all pending tasks
	public List<Task> getAllPendingTasks(){
		return taskList.stream()
				.filter(task -> task.isActive() && task.getStatus().equals("PENDING"))
				.collect(Collectors.toList());
	}
	
	// 5) Display all pending tasks for today 
	public List<Task>getAllPendingTaskForToday(){
		LocalDate today = LocalDate.now();
		return taskList.stream()
				.filter(task -> task.isActive() && task.getStatus().equals("PENDING"))
				.collect(Collectors.toList());
		
	}
	
	// 6) Display all tasks sorted by taskDate
		public List<Task>getAllTasksSortedByDate(){
			return taskList.stream()
					.sorted((task1,task2) -> task1.getTaskDate().compareTo(task2.getTaskDate()))
							.collect(Collectors.toList());
			
		}
		
		public List<Task> getAllTask() {
			return taskList;
			
		}
	
	
}
