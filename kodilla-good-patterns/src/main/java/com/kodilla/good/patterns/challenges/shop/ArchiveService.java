package com.kodilla.good.patterns.challenges.shop;

import java.util.HashMap;
import java.util.Map;

public class ArchiveService {
	private static ArchiveService instance;
	private Map<Long, ShopCart> orderArchive;
	private Map<Long, Product> productArchive;
	
	private ArchiveService() {
		this.orderArchive = new HashMap<>();
		this.productArchive = new HashMap<>();
	}
	
	public static ArchiveService getInstance() {
		if(instance == null) {
			synchronized(ArchiveService.class) {
				if(instance == null) {
					instance = new ArchiveService();
				}
			}
		}
		return instance;
	}
	
	public void addingToOrderArchive(ShopCart shopCart) {
		orderArchive.put(shopCart.getProduct().getProductNumber(), shopCart);
	}
	
	public void addingToProductArchive(Product product) {
		productArchive.put(product.getProductNumber(), product);
	}
	
	public Map<Long, ShopCart> getOrderArchive() {
		return orderArchive;
	}
	
	public Map<Long, Product> getProductArchive() {
		return productArchive;
	}
}