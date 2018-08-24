package com.kodilla.good.patterns.challenges.shop;

import java.util.HashMap;
import java.util.Map;

public class ProductDatabase {
	private static ProductDatabase instance;
	private Product product;
	private Map<Long, Product> shopsProductDataBase = new HashMap<>();
	
	private ProductDatabase() {}
	
	public static ProductDatabase getInstance() {
		if(instance == null) {
			synchronized(ProductDatabase.class) {
				if(instance == null) {
					instance = new ProductDatabase();
				}
			}
		}
		return instance;
	}
	
	public void addingToMapMechanism(Product product) {
		shopsProductDataBase.put(product.getProductNumber(), product);
	}
	
	public void removingFromMapMechanism(Product product) {
		shopsProductDataBase.remove(product.getProductNumber());
	}
	
	public void changingQuantityInMapMechanism(Product product, double quantity) {
		product.setQuantity(quantity);
		shopsProductDataBase.replace(product.getProductNumber(), product);
	}
	
	public void changingMapMechanism(Product product) {
		shopsProductDataBase.replace(product.getProductNumber(), product);
	}
	
	public Map<Long, Product> getShopsProductDataBase() {
		return shopsProductDataBase;
	}
}