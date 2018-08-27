package com.kodilla.good.patterns.challenges.food2door;

public class Order {
	private Product product;
	private Client client;
	private String name = product.getName();
	private double quantity;
	private double pricePerUnit = product.getPricePerUnit();
	
	public Order(Client client, Product product, double quantity) {
		this.client = client;
		this.product = product;
		this.quantity = quantity;
	}
	
	double finalPrice(Order order) {
		double priceToPay = order.getPricePerUnit() * order.getQuantity();
		return priceToPay;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public Client getClient() {
		return client;
	}
	
	public String getName() {
		return name;
	}
	
	public double getQuantity() {
		return quantity;
	}
	
	public double getPricePerUnit() {
		return pricePerUnit;
	}
}