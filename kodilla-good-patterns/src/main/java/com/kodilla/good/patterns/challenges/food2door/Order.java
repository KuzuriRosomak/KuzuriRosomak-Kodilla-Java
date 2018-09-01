package com.kodilla.good.patterns.challenges.food2door;

public class Order {
	private Client client;
	private double quantity;
	private String productName;
	
	public Order(Client client, double quantity, String productName) {
		this.client = client;
		this.quantity = quantity;
		this.productName = productName;
	}
	
	public Client getClient() {
		return client;
	}
	
	public double getQuantity() {
		return quantity;
	}
	
	public String getProductName() {
		return productName;
	}
}