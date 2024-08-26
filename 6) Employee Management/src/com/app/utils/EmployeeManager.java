package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.app.employee.Employee;
import com.app.employee.FullTimeEmployee;
import com.app.employee.PartTimeEmployee;

public class EmployeeManager {
	private List<Employee> employees = new ArrayList<>();
	
	//Add full time employee
	public void addFullTimeEmployee(String name, LocalDate dateOfJoining, String phoneNumber, String aadhaarNumber, double monthlySalary ) {
		if(isValidPhoneNo(phoneNumber) && isValidAadharNo(aadhaarNumber) && !existsAadhar(aadhaarNumber)) {
			Employee employee = new FullTimeEmployee(name, dateOfJoining, phoneNumber, aadhaarNumber, monthlySalary);
			employees.add(employee);
			System.out.println("Full time employee added successfully");
		} else {
			System.out.println("Invalid input or Aadhaar number already exists.");
		}
	}

	private boolean isValidPhoneNo(String phoneNumber) {
		
		return phoneNumber.matches("^[0-9]{10}$");
	}

	private boolean isValidAadharNo(String aadhaarNumber) {
		//Contains exactly 12 non-whitespace characters in a row (\\S{12}).
		return aadhaarNumber.matches("^\\S{12}$");
	}

	private boolean existsAadhar(String aadhaarNumber) {
		for(Employee employee : employees) {
			if (employee.getAadhaarNumber().equals(aadhaarNumber)) {
				return true;
			}
		}
		return false;
	}
	
	//Add part time employee
	public void addPartTimeEmployee(String name, LocalDate dateOfJoining, String phoneNumber, String aadhaarNumber,double hourlyPayment) {
		if (isValidPhoneNo(phoneNumber) && (isValidAadharNo(aadhaarNumber) && (!existsAadhar(aadhaarNumber)))) {
			Employee employee = new PartTimeEmployee(name, dateOfJoining, phoneNumber, aadhaarNumber, hourlyPayment);
			employees.add(employee);
			System.out.println("Part-Time Employee added successfully!");
		} else {
			System.out.println("Invalid input or Aadhaar number already exists.");
		}
	}

	//Delete an employee by Emp Id
	public void deleteEmployee(int empId) {
		for (Employee employee : employees) {
			if(employee.getEmployeeId() == empId) {
			employees.remove(employee);
			System.out.println("Employee removed succesfully");
		} else {
			System.out.println("Employee not found");
		}
	}
		
	}
	
	//Search employee details by Aadhaar number
	public void searchEmployeeByAadhar(String aadharNo) {
		for (Employee employee : employees) {
			if (employee.getAadhaarNumber().equals(aadharNo)) {
				System.out.println(employee);
				return;
			}
		}
		System.out.println("Employee not found");
	}
	
	//Display all employee details
	public void displayAllEmployees() {
		for(Employee employee : employees) {
			System.out.println(employee);
		}
	}
	
	//Display all employee details sorted by date of joining
	public void displayAllEmployeesSortedByDate() {
		Collections.sort(employees,Comparator.comparing(Employee :: getDateOfJoining));//This method reference is shorthand for (Employee e) -> e.getDateOfJoining().
		displayAllEmployees();
	}
	
	
	
}
