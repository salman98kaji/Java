package com.fruitbasket;

public class Orange extends Fruit {
	
	public Orange(String color,String name,double weight, boolean fresh) {
		super(color,name,weight,fresh);
	}
//	@Override
//	public String toString() {
//		return super.toString();
//	}
	
	
	
	@Override
	public String toString() {
		return "Orange [getColor()=" + getColor() + ", getName()=" + getName() + ", getWeight()=" + getWeight()
				+ ", isFresh()=" + isFresh();
	}

	@Override
	public String taste() {
		return super.getName()+"Sour";
	}
	public void juice() {
		System.out.println(super.getName()+"extracting juice!");
	}
	
}
