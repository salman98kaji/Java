package com.app.employee;

import java.time.LocalDate;

public class FullTimeEmployee extends Employee{
	private double monthlySalary;
	
	public FullTimeEmployee(String name, LocalDate dateOfJoining, String phoneNumber, String aadhaarNumber, double monthlySalary) {
		super(name, dateOfJoining, phoneNumber, aadhaarNumber);
		this.monthlySalary = monthlySalary;
	}
	
	@Override
	public double getSalary() {
		return monthlySalary;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Monthly Salary=" + monthlySalary;
	}
}
