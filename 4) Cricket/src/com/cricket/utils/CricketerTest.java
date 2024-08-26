package com.cricket.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.cricket.Cricketer;

public class CricketerTest {
	
	private List<Cricketer> cricketers = new ArrayList<>();
	
//	public CricketerTest() {
//		cricketers = new ArrayList<>();
//	}
	
	// 1) Accept minimum 5 Cricketers in the collection.
	public void addCricketer(Cricketer cricketer) {
		cricketers.add(cricketer);
	}
	
	//2) Modify Cricketer's rating
	public void modifyRating(String name, int newRating) {
		for(Cricketer cricketer :cricketers) {
			if(cricketer.getName().equals(name)) {
				cricketer.setRating(newRating);
			}
		}
	}
	
	// 3) Search Cricketer by name
	public Cricketer searchCricketerByName(String name) {
		for(Cricketer cricketer : cricketers) {
			if(cricketer.getName().equals(name)) {
				return cricketer;
			}
		}
		return null;
	}
	
	// 4) Display all Cricketers added in collection.
	public void displayAllCrickters() {
		for(Cricketer cricketer : cricketers) {
			System.out.println(cricketer);
		}
	}
	
	//5) Display All Cricketers in sorted form by rating.
	public void displayAllCricketerSortedByRating() {
		//Method reference syntax --ClassName::methodName
		cricketers.sort(Comparator.comparing(Cricketer::getRating).reversed());
		displayAllCrickters();
	}

}
