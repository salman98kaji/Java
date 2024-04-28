package com.fruitbasket;

public abstract class Fruit {
	private String color;
	private String name;
	private double weight;
	private boolean fresh;
	
	public Fruit(String color, String name, double weight,boolean fresh) {
		super();
		this.color=color;
		this.name=name;
		this.weight=weight;
		this.fresh=fresh;
	}
	

	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public boolean isFresh() {
		return fresh;
	}


	public void setFresh(boolean fresh) {
		this.fresh = fresh;
	}


	@Override
	public String toString() {
		return "Fruit [color=" + color + ", name=" + name + ", weight=" + weight + ", fresh=" + fresh + "]";
	}
	
	public abstract String taste();
}
