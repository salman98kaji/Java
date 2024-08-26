package com.cricket.main;

import com.cricket.Cricketer;
import com.cricket.utils.CricketerTest;

public class CricketerMain {

	public static void main(String[] args) {
		CricketerTest cricketerTest = new CricketerTest();
		
		//Add 5 cricketers
		cricketerTest.addCricketer(new Cricketer("Sachin", 47, "sachin@gmail.com","123456789" , 95));
		cricketerTest.addCricketer(new Cricketer("Virat", 35, "Virat@gmail.com", "234567891", 97));
		cricketerTest.addCricketer(new Cricketer("Dhoni", 42, "dhoni@gmail.com", "8974860421", 85));
		cricketerTest.addCricketer(new Cricketer("Siraj", 26, "siraj@gmail.com", "8974868563", 90));
		cricketerTest.addCricketer(new Cricketer("Shami", 32, "shami@gmail.com", "8974860456", 89));
	
		//modify a cricketer rating
		cricketerTest.modifyRating("Virat", 100);
		
		//search a cricketer by name
		Cricketer searchedCricketer= cricketerTest.searchCricketerByName("Shami");
		System.out.println(searchedCricketer);
		
		//display all cricketers
		System.out.println("\nAll crickters are :");
		cricketerTest.displayAllCrickters();
		
		//display cricketer sorted by rating 
		System.out.println("\nCrickters sorted by rating");
		cricketerTest.displayAllCricketerSortedByRating();
		
	}

}
