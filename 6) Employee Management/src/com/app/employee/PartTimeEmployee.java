package com.app.employee;

import java.time.LocalDate;

public class PartTimeEmployee extends Employee {
	private double hourlyPayment;

	public PartTimeEmployee(String name, LocalDate dateOfJoining, String phoneNumber, String aadhaarNumber,double hourlyPayment) {
		super(name, dateOfJoining, phoneNumber, aadhaarNumber);
		this.hourlyPayment = hourlyPayment;
	}

	@Override
	public double getSalary() {		
		return hourlyPayment;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", hourly payment=" + hourlyPayment;
	}

}
