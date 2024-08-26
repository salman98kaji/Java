package com.app.employee;

import java.time.LocalDate;

public abstract class Employee {
	private static int idCounter = 1;
	private int employeeId;
	private String name;
	private LocalDate dateOfJoining;
	private String phoneNumber;
	private String aadhaarNumber;
	
	public Employee(String name, LocalDate dateOfJoining, String phoneNumber, String aadhaarNumber) {
		super();
		this.employeeId = idCounter++;
		this.name = name;
		this.dateOfJoining = dateOfJoining;
		this.phoneNumber = phoneNumber;
		this.aadhaarNumber = aadhaarNumber;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", dateOfJoining=" + dateOfJoining
				+ ", phoneNumber=" + phoneNumber + ", aadhaarNumber=" + aadhaarNumber + "]";
	}

	public abstract double getSalary(); 
		
	
	
	
}
