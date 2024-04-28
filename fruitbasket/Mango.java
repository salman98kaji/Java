package com.fruitbasket;

public class Mango extends Fruit {
	
	public Mango(String color, String name,double weight,boolean fresh) {
		super(color, name, weight, fresh);
	}
//	@Override
//	public String toString() {
//		return super.toString();
//	}
	

	@Override
	public String toString() {
		return "Mango [getColor()=" + getColor() + ", getName()=" + getName() + ", getWeight()=" + getWeight()
				+ ", isFresh()=" + isFresh();
	}
	
	@Override 
	public String taste() {
		return super.getName()+" Sweet";
	}

	public void pulp() {
		System.out.println(getName()+" creating  pulp!");
	}

}
