package com.vehicle;

import java.util.Scanner;

public class test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Options");
			System.out.println("1. Add new vehicle");
			System.out.println("2. Drive a vehicle");
			System.out.println("3. Exit");
			System.out.println("Enter your choice");
			
			int choice = sc.nextInt();
			sc.nextLine(); //consume newline
			
			switch(choice) {
			
			case 1:
				vehicleUtils.addVehicle(sc);
				break;
				
			case 2: 
				vehicleUtils.driveVehicle(sc);
				break;
				
			case 3:
				System.out.println("Exitting");
				System.exit(0);
				
			default:
				System.out.println("Invalid option please try again");
					
			}
		}
	}

}
