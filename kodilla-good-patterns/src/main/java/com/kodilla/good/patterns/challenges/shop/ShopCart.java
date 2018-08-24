package com.kodilla.good.patterns.challenges.shop;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;

public class ShopCart {
	private User user;
	private User user2;
	private Product product;
	private UserProductMap userProductMap;
	private ProductDatabase productDatabase;
	private double productQuantity;
	private double finalPrice;
	private Map<Product, Double> shopCartMap;
	
	public ShopCart(User user) {
		this.user = user;
		this.shopCartMap = new HashMap<>();
	}
	
	public void addingToShopCartMap(Product product, double quantity) {
		shopCartMap.put(product, quantity);
		productQuantity = shopCartMap.size();
	}
	
	public void removingFromShopCartMap(Product product) {
		shopCartMap.remove(product);
		productQuantity = shopCartMap.size();
	}
	
	public void removingAllItemsFromShopCartMap(Map shopCartMap) {
		shopCartMap.clear();
		productQuantity = shopCartMap.size();
	}
	
	public void changingShopCartMap(Product product, double quantity) {
		shopCartMap.replace(product, quantity);
		productQuantity = shopCartMap.size();
	}
	
	public Map<Product, Double> getShopCartMap() {
		return shopCartMap;
	}
	
	public double getProductQuantity() {
		return productQuantity;
	}
	
	public double finalPriceCounter() {
		
		finalPrice = getShopCartMap().entrySet().stream()
				.mapToDouble(n -> n.getKey().getProductPrice())
				.sum();
		
		return finalPrice * getProductQuantity();
	}
}