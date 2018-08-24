package com.kodilla.good.patterns.challenges.shop;

import java.util.HashMap;
import java.util.Map;

public class UserProductMap {
	private User user;
	private Product product;
	private ProductDatabase productDatabase;
	private Map<Long, Product> usersProductMap;
	
	public UserProductMap(User user) {
		this.user = user;
		this.usersProductMap = new HashMap<>();
	}
	
	public void addingToUsersProductMap(Product product) {
		usersProductMap.put(product.getProductNumber(), product);
		ProductDatabase.getInstance().addingToMapMechanism(product);
	}
	
	public void removingFromUsersProductMap(Product product) {
		usersProductMap.remove(product.getProductNumber());
		ProductDatabase.getInstance().removingFromMapMechanism(product);
	}
	
	public void changingQuantityInUsersProductMap(Product product, double quantity) {
		if((product.getQuantity() - quantity) <= 0) {
			removingFromUsersProductMap(product);
		} else {
			ProductDatabase.getInstance().changingQuantityInMapMechanism(product, quantity);
			usersProductMap.replace(product.getProductNumber(), product);
		}
	}
	
	public void changingUsersProductMap(Product product) {
		usersProductMap.replace(product.getProductNumber(), product);
		ProductDatabase.getInstance().changingMapMechanism(product);
	}
	
	public User getUser() {
		return user;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public ProductDatabase getProductDatabase() {
		return productDatabase;
	}
	
	public Map<Long, Product> getUsersProductMap() {
		return usersProductMap;
	}
}