package com.kodilla.good.patterns.challenges.food2door;

public class Product {
	private String name;
	private double quantity;
	private double pricePerUnit;
	
	public Product(String name, double quantity, double pricePerUnit) {
		this.name = name;
		this.quantity = quantity;
		this.pricePerUnit = pricePerUnit;
	}
	
	public String getName() {
		return name;
	}
	
	public double getQuantity() {
		return quantity;
	}
	
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
}