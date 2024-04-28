package com.fruitbasket;

import java.util.Scanner;

public class Mainfruit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//read fruit basket size 
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter basket size n for fruits:");
		int size = scanner.nextInt();
		
		Fruit f[]=new Fruit[size];
		String name = null;
		String color = null;
		double weight = 0;
		boolean fresh = false;
		boolean exit = false; //status
		
		int count = 0;
		int index =0;
		int choice =0;
		
		while(!exit) {
			System.out.println("MENU");
			System.out.println("1. Add fruits");
			System.out.println("2. Display fruits");
			System.out.println("3. Check freshness of fruits");
			System.out.println("4. Change fresh status to flase if sour");
			System.out.println("0. Done shopping");
			
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch(choice) {
			case 1:
			for(int i=0;i<size;i++) {
				System.out.println("1. Add mango");
				System.out.println("2. Add orange");
				System.out.println("3. Add apple");
				
				System.out.println("enter your choice");
				int ch = scanner.nextInt();
				
				switch(ch) {
				case 1:
					if(count<size) {
						System.out.println("Add mango");
						System.out.println("name, color, weight, freshness");
						name = scanner.next();
						color = scanner.next();
						weight = scanner.nextDouble();
						fresh = scanner.nextBoolean();
					
						if(fresh) {
						f[count] = new Mango(name,color,weight,fresh);
						count++;
						}
						else {
						System.out.println("Stale fruit");
						f[count] = new Mango(name,color,weight,fresh);
						count++;
						index++;
						}
				}
					else {
						System.out.println("basket is full");
					}
					break;
				case 2:
				if(count<size) {
					System.out.println("Add orange");
					System.out.println("Enter name,color,weight,fresh");
					name = scanner.next();
					color = scanner.next();
					weight = scanner.nextDouble();
					fresh = scanner.nextBoolean();
					
					if (fresh) {
						f[count]= new Orange(name,color,weight,fresh);
						count++;
					}
					else {
						System.out.println("Stale fruit");
						f[count]= new Orange(name,color,weight,fresh);
						count++;
						index++;
					}				
				}
				else {
					System.out.println("basket is full");				
				}
				break;
				case 3:
					if(count<size) {
						System.out.println("Add apple");
						System.out.println("Enter name, color, weight, freshness");
						name = scanner.next();
						color = scanner.next();
						weight = scanner.nextDouble();
						fresh = scanner.nextBoolean();
						
						if (fresh) {
							f[count]= new Apple(name,color,weight,fresh);
							count++;
						}
						else {
							System.out.println("stale fruit");
							f[count]= new Apple(name,color,weight,fresh);
							count++;
							index++;
						}
					}
					else {
						System.out.println("basket is full");
					}
					break;
					
					default:
						System.out.println("Invalid choice please enter valid choice");
					continue;
			 }
				System.out.println("Do you want to enter more yes 'y' or no 'n'");
				String s= scanner.next();
				if(s=="y") {
					continue;
				}
				else {
					break;
				}
			}
			break;
			
			case 2:
				System.out.println("Display fruits");
				for(int i=0;i<count; i++) {
					if(f[i] instanceof Mango) {
						((Mango)f[i]).pulp();
					}
					if(f[i] instanceof Orange) {
						((Orange)f[i]).juice();
					}
					if(f[i] instanceof Apple) {
						((Apple)f[i]).jam();
					}
					
					System.out.println();
				}
				System.out.println("Total fruits = "+count);
				
				if(index>0) {
					System.out.println(count+ "Fruits in basket but");
					System.out.println(index+ "are stale ");
				}
			break;
				
			case 3:
				System.out.println("enter fruit no from list ");
				int n= scanner.nextInt();
				if(f[n].isFresh()) {
					System.out.println(f[n].getName()+" is fresh");
				}
				else {
					System.out.println(f[n].getName()+"is stale");
				}
			break;
			
			case 4:
				for(int i=0; i<count;i++) {
					if(f[i].taste()=="sour") {
						f[i].setFresh(false);
						System.out.println(f[i]);
					}
				}
			break;
			
			case 0:
				exit=true;
			break;
			
			default: 
				System.out.println("invalid choice please enter valid choice");
				continue;
			}
		    }
		}		

	}

