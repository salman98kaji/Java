package com.vehicle;

import java.time.LocalDate;
import java.util.Scanner;

public class vehicleUtils {
	
	public static void addVehicle(Scanner sc) {
		System.out.println("----Enter vehicle details----");
		System.out.println("Chassis no :");
		String chassisNo = sc.next();
		System.out.println("Choose color (WHITE, SILVER, BLACK, RED, BLUE)");
		Color color= Color.valueOf(sc.next().toUpperCase());
		System.out.println("Price: ");
		double price = sc.nextDouble();
		System.out.println("Manufacture date (yyyy-mm-dd");
		LocalDate manufactureDate= LocalDate.parse(sc.next());
		System.out.println("Insurance expirry date (yyyy-mm-dd)");
		LocalDate insuranceExpDate= LocalDate.parse(sc.next());
		System.out.println("Pollution level");
		double pollutionLevel=sc.nextDouble();
		//sc.nextLine();
		
		try {
			Vehicle vehicle = new Vehicle(chassisNo,color,price,manufactureDate,insuranceExpDate,pollutionLevel);
			VehicleValidator.validateVehicle(vehicle);
			VehicleValidator.validatePollutionLevel(pollutionLevel);
		}
		catch (ColorNotSupportedException | PollutionLevelExceededException e) {
			System.out.println("Error: "+ e.getMessage());
		}
	}
	
	public static void driveVehicle(Scanner sc) {
		System.out.println("Enter kilometers driven:");
		int km=sc.nextInt();
		double calpollutionLevel = vehicleUtils.calculatePollutionLevel(km);
		
		if(calpollutionLevel >= 20) {
			try {
				throw new PollutionLevelExceededException("Pollution level exceeded 20%: " + calpollutionLevel);
			}
			catch(PollutionLevelExceededException e) {
				System.out.println("Error"+e.getMessage());
			}
		}
		else {
			System.out.println("Vehicle driven successfully");
		}
	}
	public static double calculatePollutionLevel(int km) {
		return km*0.01;
	}
}
