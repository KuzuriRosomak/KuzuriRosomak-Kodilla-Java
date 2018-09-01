package com.kodilla.good.patterns.challenges.shop;

import java.time.LocalDateTime;

public class ShopCart {
	private User thisUserIsBuying;
	private User thisUserIsSelling;
	private Product product;
	private double productQuantity;
	private LocalDateTime timeOfOrder;
	
	public ShopCart(User thisUserIsBuying, User thisUserIsSelling, String productName, double productQuantity) {
		this.thisUserIsBuying = thisUserIsBuying;
		this.thisUserIsSelling = thisUserIsSelling;
		this.product = thisUserIsSelling.getUserProductMap().get(productName);
		this.productQuantity = productQuantity;
		this.timeOfOrder = LocalDateTime.now();
	}
	
	public User getThisUserIsBuying() {
		return thisUserIsBuying;
	}
	
	public User getThisUserIsSelling() {
		return thisUserIsSelling;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public double getProductQuantity() {
		return productQuantity;
	}
	
	public LocalDateTime getTimeOfOrder() {
		return timeOfOrder;
	}
	
	public void setTimeOfOrder(LocalDateTime timeOfOrder) {
		this.timeOfOrder = timeOfOrder;
	}
}