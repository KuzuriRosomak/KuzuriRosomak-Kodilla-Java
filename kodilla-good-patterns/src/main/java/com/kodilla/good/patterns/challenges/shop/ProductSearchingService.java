package com.kodilla.good.patterns.challenges.shop;

import java.util.*;
import java.util.stream.Collectors;

public class ProductSearchingService {
	private ProductDatabase productDatabase;
	private User user;
	private UserProductMap userProductMap;
	private Product product;
	
	public Collection serviceSearchingMechanism(User user) {
		return user.getUserProductMap().getUsersProductMap().values();
	}
	
	public List serviceSearchingMechanism(String productName) {
		return ProductDatabase.getInstance().getShopsProductDataBase().values().stream()
				.filter(n -> n.getProductName().equals(productName))
				.collect(Collectors.toList());
	}
	
	public Product serviceSearchingMechanism(long productNumber) {
		return productDatabase.getShopsProductDataBase().get(productNumber);
	}
	
	public List serviceSearchingMechanism(double minProductPrice, double maxProductPrice) {
		return ProductDatabase.getInstance().getShopsProductDataBase().values().stream()
				.filter(n -> n.getProductPrice() >= minProductPrice && n.getProductPrice() <= maxProductPrice)
				.collect(Collectors.toList());
	}
}