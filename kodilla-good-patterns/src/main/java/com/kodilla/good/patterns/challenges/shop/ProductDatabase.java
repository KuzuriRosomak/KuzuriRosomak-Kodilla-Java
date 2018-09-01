package com.kodilla.good.patterns.challenges.shop;

import java.util.HashMap;
import java.util.Map;

public class ProductDatabase {
	private static ProductDatabase instance;
	private Map<Long, Product> shopsProductDataBase;
	
	private ProductDatabase() {
		this.shopsProductDataBase = new HashMap<>();
	}
	
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
		product.getUser().getUserProductMap().put(product.getProductName(), product);
	}
	
	public void removingFromMapMechanism(Product product) {
		ArchiveService.getInstance().addingToProductArchive(product);
		shopsProductDataBase.remove(product.getProductNumber());
		product.getUser().getUserProductMap().remove(product.getProductName());
	}
	
	public void changingQuantityInMapMechanism(Product product, double quantity) {
		double tempDouble = ((product.getQuantity()) - (quantity));
		if(tempDouble <= 0) {
			removingFromMapMechanism(product);
		}
		else {
			product.setQuantity(tempDouble);
			shopsProductDataBase.replace(product.getProductNumber(), product);
			product.getUser().getUserProductMap().replace(product.getProductName(), product);
		}
	}
	
	public Map<Long, Product> getShopsProductDataBase() {
		return shopsProductDataBase;
	}
}