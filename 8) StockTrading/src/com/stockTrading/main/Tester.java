package com.stockTrading.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.stockTrading.collectionUtils.CollectionUtils;
import com.stockTrading.customExceptions.StockTradingException;
import com.stockTrading.service.StockTradingService;

public class Tester {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StockTradingService service = new StockTradingService();
		CollectionUtils.addSampleStocks();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		while(true) {
			System.out.println("1. Addnew stock");
			System.out.println("2. View avaialble stocks by comapany");
			System.out.println("3. Purchase stock");
			System.out.println("4. Sell stock");
			System.out.println("5. SAve and exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			sc.nextLine();
			
			try {
				switch(choice) {
					case 1:
						System.out.println("Enter stock id");
						String stockId = sc.nextLine();
						System.out.println("Enter Stock name");
						String stockName = sc.nextLine();
						System.out.println("Enter comapny name");
						String companyName = sc.nextLine();
						System.out.println("Enter price");
						Double price = sc.nextDouble();
						System.out.println("Enter closing date(yyyy-MM-dd");
						String closingDateStr = sc.next();
						LocalDate closingDate = LocalDate.parse(closingDateStr, formatter);
						System.out.println("Enter quantity");
						int quantity = sc.nextInt();
						sc.nextLine();
						service.addNewStock(stockId, stockName, companyName,price, closingDate, quantity);
						break;
						
					case 2:
						System.out.println("Enter company name");
						String company = sc.nextLine();
						service.viewStocksByCOmpany(company);
						break;
					
					case 3:
						System.out.println("Enter stockId");
						String purchaseId = sc.nextLine();
						System.out.println("Enter qunatity");
						int purchaseQuantity = sc.nextInt();
						sc.nextLine();
						service.purchaseStock(purchaseId, purchaseQuantity);
						break;
						
					case 4:
						System.out.println("enter stock Id");
						String sellId = sc.nextLine();
						System.out.println("Enter quantity");
						int sellQty = sc.nextInt();
						sc.nextLine();
						service.sellStock(sellId, sellQty);
						break;
						
					case 5:
						service.saveAndExit();
						return;
						
					default:
						System.out.println("Invalid choice. Please try again");	
				}
					
			} catch (StockTradingException e) {
				System.out.println("Error" +e.getMessage());
			}
		}

	}

}
