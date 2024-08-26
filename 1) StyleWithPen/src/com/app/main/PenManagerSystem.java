package com.app.main;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

import com.app.pen.*;
import com.app.penManager.PenManager;

public class PenManagerSystem {

	public static void main(String[] args) throws ParseException {
		PenManager penManager = new PenManager();
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		
		while (!exit) {
			try {
				System.out.println("\n---Pen Management Menu---");
				System.out.println("1. Add new pen");
				System.out.println("2. Update stock of a pen");
				System.out.println("3. Set discount for unsold pen");
				System.out.println("4. Remove old pens");
				System.out.println("5. Display all pens");
				System.out.println("6. Exit");
				System.out.println("Enter your choice");
				
				int choice = sc.nextInt();
				sc.nextLine();//consume new line
				
				switch (choice) {
				
				case 1:
					System.out.println("Enter brand:");
					String brand = sc.next();
					System.out.println("Enter color:");
					String color = sc.next();
					System.out.println("Enter Ink Color:");
					String inkColor = sc.next();
					System.out.println("Enter material:");
					String material = sc.next();
					System.out.println("Enter Stock");
					int stock = sc.nextInt();
					System.out.println("Enter price");
					double price = sc.nextDouble();
					sc.nextLine();
					System.out.println("Enter stock listing date (dd/MM/yyyy):");
					String dateStr = sc.nextLine();
					if (dateStr.isEmpty()) {
						System.out.println("Error: Date cannot be empty. Please enter a valid date.");
						break;
					}
					LocalDate stockListingDate;
					try {
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						stockListingDate = LocalDate.parse(dateStr, formatter);
						if (brand.isEmpty() || color.isEmpty() || inkColor.isEmpty() || material.isEmpty() || stock<0 || price <0) {
							System.out.println("Error: Invalid input. Please enter valid details.");
						} else {
							Pen newPen = new Pen(brand, color, inkColor, material, stock, price, stockListingDate);
							penManager.addPen(newPen);
						}
					} catch (DateTimeParseException e){
						System.out.println("Error: Invalid date format. Please enter the date in dd/MM/yyyy format.");
					}
					break;
					
				case 2:
					System.out.println("Enter pen id ");
					int id = sc.nextInt();
					System.out.println("Enter new stock");
					int newStock = sc.nextInt();
					penManager.updateStock(id, newStock);
					break;
					
				case 3:
					penManager.setDiscountForUnsoldPens();
					System.out.println("20% discount set for unsold pens");
					break;
					
				case 4:
					penManager.removeOldPens();
					break;
					
				case 5:
					penManager.displayPens();
					break;
					
				case 6:
					System.out.println("Exiting the system.");
					exit = true;
					break;
					
				default:
            		System.out.println("Invalid choice. Please try again.");				
				}
			
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				sc.nextLine();
			}
		}

	}

}
