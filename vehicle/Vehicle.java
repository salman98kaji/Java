package com.vehicle;

import java.time.LocalDate;


public class Vehicle {
	private String chassisNo;
	private Color color;
	private double price;
	private LocalDate manufactureDate;
	private LocalDate insuranceExpDate;
	private double pollutionLevel;
	
	public Vehicle(String chassisNo, Color color, double price, LocalDate manufactureDate, LocalDate insuranceExpDate,
			double pollutionLevel) {
		super();
		this.chassisNo = chassisNo;
		this.color = color;
		this.price = price;
		this.manufactureDate = manufactureDate;
		this.insuranceExpDate = insuranceExpDate;
		this.pollutionLevel = pollutionLevel;
	}

	public String getChassisNo() {
		return chassisNo;
	}

	public void setChassisNo(String chassisNo) {
		this.chassisNo = chassisNo;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public LocalDate getInsuranceExpDate() {
		return insuranceExpDate;
	}

	public void setInsuranceExpDate(LocalDate insuranceExpDate) {
		this.insuranceExpDate = insuranceExpDate;
	}

	public double getPollutionLevel() {
		return pollutionLevel;
	}

	public void setPollutionLevel(double pollutionLevel) {
		this.pollutionLevel = pollutionLevel;
	}
	
	
	
}

