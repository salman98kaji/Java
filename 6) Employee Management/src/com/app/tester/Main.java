package com.app.tester;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.app.utils.EmployeeManager;

public class Main {

	public static void main(String[] args) {
		EmployeeManager employeeManager = new EmployeeManager();
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		
		while (!exit) {
			try {
				
				System.out.println("\n--- Employee Management System ---");
	            System.out.println("1. Add Full-Time Employee");
	            System.out.println("2. Add Part-Time Employee");
	            System.out.println("3. Delete an Employee by ID");
	            System.out.println("4. Search Employee by Aadhaar Number");
	            System.out.println("5. Display All Employee Details");
	            System.out.println("6. Display All Employee Details Sorted by Date of Joining");
	            System.out.println("7. Exit");
	            System.out.print("Enter your choice: ");
	            int choice;
	            choice=sc.nextInt();
	            sc.nextLine();
            
            switch(choice) {
            	case 1:
            		System.out.println("Enter name:");
            		String name = sc.nextLine();
            		System.out.println("Enter Date of joining(yyyy-MM-dd):");
            		String doj = sc.next();
            		LocalDate date = LocalDate.parse(doj);
            		
            		System.out.println("Enter phone no:");
            		String phnNo = sc.next();
            		
            		System.out.println("Enter aadhar no:");
            		String adhrNo = sc.next();
            		
            		System.out.println("Enter monthly salary");
            		double monthlySalary = sc.nextDouble();
            		sc.nextLine();
            		employeeManager.addFullTimeEmployee(name, date, phnNo, adhrNo, monthlySalary);
            		break;
            		
            	case 2:
            		System.out.println("Enter name:");
            		String name2 = sc.nextLine();
            		System.out.println("Enter Date of joining(yyyy-MM-dd):");
            		String doj2 = sc.next();
            		LocalDate date2 = LocalDate.parse(doj2);
            		
            		System.out.println("Enter phone no:");
            		String phnNo2 = sc.next();
            		
            		System.out.println("Enter aadhar no:");
            		String adhrNo2 = sc.next();
            		
            		System.out.println("Enter hourly Payment");
            		double hourlyPayment = sc.nextDouble();
            		sc.nextLine();
            		employeeManager.addPartTimeEmployee(name2, date2, phnNo2, adhrNo2, hourlyPayment);
            		break;
            		
            	case 3:
            		System.out.println("Enter employee id:");
            		int empId = sc.nextInt();
            		sc.nextLine();
            		employeeManager.deleteEmployee(empId);
            		break;
            		
            	case 4:
            		System.out.println("Enter aadhar no :");
            		String aadhrNo = sc.nextLine();
            		employeeManager.searchEmployeeByAadhar(aadhrNo);
            		break;
            		
            	case 5:
            		employeeManager.displayAllEmployees();
            		break;
            		
            	case 6:
            		employeeManager.displayAllEmployeesSortedByDate();
            		break;
            		
            	case 7:
            		System.out.println("Exiting the system.");
            		exit = true;
            		break;
            		
            	default:
            		System.out.println("Invalid choice. Please try again.");
            	}
            }catch (InputMismatchException e) {
            	System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
            }
		}

	}

}
