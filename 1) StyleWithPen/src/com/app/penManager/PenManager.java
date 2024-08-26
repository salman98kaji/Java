package com.app.penManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.app.pen.*;

public class PenManager {
	
	private List<Pen> pens = new ArrayList<>();
	
	// 1) Add new Pen
	public void addPen(Pen pen) {
		pens.add(pen);
		System.out.println("Pens added successfully");
	}
	
	// 2) Update stock of a Pen
	public void updateStock(int id, int newStock) {
		for(Pen pen : pens) {
			if (pen.getId() == id) {
				pen.setStock(newStock);
				System.out.println("Stock updated succesfully");
			}else {
				System.out.println("No pens found");
			}
		}
	}
	
	// 3) Set discount of 20% for all the pens which are not at all sold
	public void setDiscountForUnsoldPens() {
		LocalDate threeMonthsAgo = LocalDate.now().minusMonths(3);
		for(Pen pen:pens) {
			if(pen.getStockListingDate().isBefore(threeMonthsAgo)) {
				pen.setDiscount(20);
				
			} else {
				System.out.println("NO pens which are older than 3 months");
			}
		}
	}
	
	// 4) Remove Pens which are never sold once listed in 9 months 
	public void removeOldPens() { 
		LocalDate nineMonthsAgo = LocalDate.now().minusMonths(9);
		List<Pen> pensToRemove = pens.stream()
				.filter(pen -> pen.getStockListingDate().isBefore(nineMonthsAgo))
				.collect(Collectors.toList());
		pens.removeAll(pensToRemove);
	}
	
	//5) display all pens
	public void displayPens() {
		
		for(Pen pen : pens) {
			System.out.println(pen);
		}
	}
}
