package com.Item.Tester;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.Item.Item;

public class Tester {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Item> items = new ArrayList<>();
		
		//Accpeting details min 5 items from user
		for(int i=0; i<1; i++) {
			System.out.println("Enter details for item"+(i+1)+ ":");
			
			System.out.println("item code:");
			String itemCode = sc.nextLine();
			System.out.println("Description:");
			String description = sc.nextLine();
			System.out.println("Price:");
			Double price = Double.parseDouble(sc.nextLine());
			System.out.println("Shipment date(dd-MM-yyyy):");
			String dateStr = sc.nextLine();
			Date shipmentDate =null;
			
			try {
				shipmentDate = new SimpleDateFormat("dd-MM-yyyy").parse(dateStr);
				
			}catch (ParseException e){
				System.out.println("Invalid date format. Please enter the date in dd-MM-yyyy format.");
				i++;//This line decrements the variable i by 1. This suggests that i is likely being used as a loop counter, and this statement might be inside a loop. Decrementing i in this context might indicate a mechanism to allow the user to re-enter the date in case of an invalid format.
				continue;
			}
			
			Item item = new Item(itemCode, description, price, shipmentDate) ;
			items.add(item);
		}
		
		//Sort by item code and serialize
		items.sort(Comparator.comparing(Item::getItemCode));
		serializeItems(items,"items_code.ser");
		
		//sort by price and serialize
		items.sort(Comparator.comparing(Item::getPrice));
		serializeItems(items, "items_price.ser");
		
		System.out.println("Items have been serialized to files");
	}

	private static void serializeItems(List<Item> items, String fileName) {
		try(ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(fileName))){
			oss.writeObject(items);
		
		} catch (IOException e) {
			System.err.println("Error serializing items:" + e.getMessage());
			
		} 
	}

}