package com.taskManager;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.taskManager.model.Task;
import com.taskManager.service.*;

public class TaskManager {

	public void displayMenu() {
		Scanner sc = new Scanner(System.in);
		TaskService taskService = new TaskService();
		boolean exit = false;
		
		while(!exit) {
			System.out.println("\nTask manager Menu");
			System.out.println("1. Add new task");
			System.out.println("2. Delete a task");
			System.out.println("3. Update a task");
			System.out.println("4. Display All Pending Tasks");
			System.out.println("5. Display All Pending Tasks for Today");
	        System.out.println("6. Display All Tasks Sorted by Date");
	        System.out.println("7. Display all task");
	        System.out.println("8. Exit");
	        System.out.print("Enter your choice: ");
	        
	        int choice = sc.nextInt();
	        sc.nextLine();
	        
	        switch(choice) {
	        case 1:
	        	System.out.println("Enter task name");
	        	String taskName = sc.nextLine();
	        	System.out.println("Enter task description");
	        	String description = sc.nextLine();
	        	System.out.println("Enter task date(yyyy-mm-dd)");
	        	LocalDate taskDate = LocalDate.parse(sc.nextLine());
	        	taskService.addTask(taskName,description,taskDate);
	        	System.out.println("Task added successfully.");
	        	break;
	        	
	        case 2:
	        	System.out.println("Enter task ID to delete task");
	        	int taskId = sc.nextInt();
	        	taskService.deleteTask(taskId);
	        	System.out.println("Task deleted succesfully");
	        	break;
	        	
	        case 3:
	        	System.out.println("Enter taskId to update status");
	        	int taskId2 = sc.nextInt();
	        	sc.nextLine();
	        	System.out.println("Enter new status (PENDING, IN PROGRESS, COMPLETED):");
	        	String newStatus = sc.nextLine().toUpperCase();
	        	taskService.updateTaskStatus(taskId2, newStatus);
	        	System.out.println("Task status updated succesfully");
	        	break;
	        	
	        case 4:
	        	System.out.println("Pending tasks");
	        	taskService.getAllPendingTasks().forEach(System.out::println);
	        	break;
	        
	        case 5:
	        	System.out.println("Pending task for today");
	        	taskService.getAllPendingTaskForToday().forEach(System.out::println);
	        	break;
	        	
	        case 6:
	        	System.out.println("All tasks sorted by date");
	        	taskService.getAllTasksSortedByDate().forEach(System.out::println);
	        	break;
	        	
	        case 7:
	        	List<Task> tasks = taskService.getAllTask(); 
	        	tasks.forEach(System.out::println);
	        	break;
	        	
	        case 8:
	        	exit = true;
	        	System.out.println("program is over aniket Jawale Iacsd Dac 23.45 cr package");
	        	break;
	        	
	        }
		}
	}
}
