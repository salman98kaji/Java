package com.fruitbasket;

public class Apple extends Fruit{
	
	public Apple(String color, String name,Double weight,boolean fresh) {
		super(color,name,weight,fresh);
	}
//
//	@Override
//	public String toString() {
//		return ;
//	}
	
	
	@Override
	public String taste() {
		return super.getName()+"Sweet and sour";
	}
	@Override
	public String toString() {
		return "Apple [getColor()=" + getColor() + ", getName()=" + getName() + ", getWeight()=" + getWeight()
				+ ", isFresh()=" + isFresh();
	}
	


	public void jam() {
		System.out.println(super.getName()+" creating pulp");
		
	}

}
