package com.Item;

import java.io.Serializable;
import java.util.Date;

public class Item implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String itemCode;
	private String description;
	private double price;
	private Date shipment;
	
	public Item(String itemCode, String description, double price, Date shipment) {
		super();
		this.itemCode = itemCode;
		this.description = description;
		this.price = price;
		this.shipment = shipment;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getShipment() {
		return shipment;
	}

	public void setShipment(Date shipment) {
		this.shipment = shipment;
	}

	@Override
	public String toString() {
		return "Item [itemCode=" + itemCode + ", description=" + description + ", price=" + price + ", shipment="
				+ shipment + "]";
	}
	
	
	
}
