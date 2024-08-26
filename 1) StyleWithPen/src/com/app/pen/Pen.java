package com.app.pen;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pen {
	private static int idCounter = 0;
	
	private int id;
	private String brand;
	private String color;
	private String inkColor;
	private String material;
	private int stock;
	private LocalDate stockUpdateDate;
	private LocalDate stockListingDate;
	private double price;
	private double discount;
	
	public Pen(String brand, String color, String inkColor, String material, int stock, 
			double price, LocalDate stockListingDate) {
		super();
		this.id = ++idCounter;
		this.brand = brand;
		this.color = color;
		this.inkColor = inkColor;
		this.material = material;
		this.stock = stock;
		this.stockUpdateDate = LocalDate.now();
		this.stockListingDate = stockListingDate;
		this.price = price;
		this.discount = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getInkColor() {
		return inkColor;
	}

	public void setInkColor(String inkColor) {
		this.inkColor = inkColor;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
		this.stockUpdateDate = LocalDate.now();
	}

	public LocalDate getStockUpdateDate() {
		return stockUpdateDate;
	}

	public void setStockUpdateDate(LocalDate stockUpdateDate) {
		this.stockUpdateDate = stockUpdateDate;
	}

	public LocalDate getStockListingDate() {
		return stockListingDate;
	}

	public void setStockListingDate(LocalDate stockListingDate) {
		this.stockListingDate = stockListingDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Pen [id=" + id + ", brand=" + brand + ", color=" + color + ", inkColor=" + inkColor + ", material="
				+ material + ", stock=" + stock + ", stockUpdateDate=" + stockUpdateDate.format(formatter) + ", stockListingDate="
				+ stockListingDate.format(formatter) + ", price=" + price + ", discount=" + discount + "]";
	}
	
	
	
}
