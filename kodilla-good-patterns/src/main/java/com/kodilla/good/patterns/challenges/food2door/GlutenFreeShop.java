package com.kodilla.good.patterns.challenges.food2door;

import java.util.HashMap;
import java.util.Map;

public class GlutenFreeShop implements OrderProcess {
	private String name;
	private Map<String, Product> mapOfProducts;
	
	private static GlutenFreeShop instance;
	
	private GlutenFreeShop(String name) {
		this.name = name;
		this.mapOfProducts = new HashMap<>();
		mapOfProducts.put("Gorgonzola", new Product("Gorgonzola", 6.9, 98));
		mapOfProducts.put("Flour", new Product("Flour", 232, 0.97));
		mapOfProducts.put("Corn", new Product("Corn", 678, 3.5));
	}
	
	public static GlutenFreeShop getInstance() {
		if(instance == null) {
			synchronized(GlutenFreeShop.class) {
				if(instance == null) {
					instance = new GlutenFreeShop("GlutenFreeShop");
				}
			}
		}
		return instance;
	}
	
	public String getName() {
		return name;
	}
	
	public Map<String, Product> getMapOfProducts() {
		return mapOfProducts;
	}
	
	@Override
	public void addToMap(Product product) {
		mapOfProducts.put(product.getName(), product);
	}
	
	@Override
	public boolean process(Order order) {
		boolean canBeProcessed = false;
		System.out.println("Starting processing order " + order.getClient().getLogin());
		if(!(mapOfProducts.containsKey(order.getProductName()))) {
			System.out.println(order.getClient().getLogin() + " we don't have: "
					+ order.getProductName() + " in our stock." + " Please feel free to " +
					"check out our other products.");
		} else {
			if(!(mapOfProducts.get(order.getProductName()).getQuantity() >= order.getQuantity())) {
				System.out.println(order.getClient().getLogin() + " we don't have enough amount of: "
						+ order.getProductName() + ". Please lower the required " +
						"amount of: " + order.getQuantity() + " to: "
						+ mapOfProducts.get(order.getProductName()).getQuantity()
						+ " or less, or check out our other products.");
			} else {
				if(!(((order.getQuantity()) * (mapOfProducts.get(order.getProductName()).getPricePerUnit()))
						<= (order.getClient().getAccountBalance()))) {
					System.out.println(order.getClient().getLogin() + " you don't have enough funds to processed your " +
							"order.\nYour account balance is: "
							+ order.getClient().getAccountBalance() + ".\n" + "Required amount is: "
							+ ((order.getQuantity()) * (mapOfProducts.get(order.getProductName()).getPricePerUnit()))
							+ ".\nPlease deposit missing: "
							+ (((order.getQuantity()) * (mapOfProducts.get(order.getProductName()).getPricePerUnit()))
							- (order.getClient().getAccountBalance())) + ".");
				} else {
					System.out.println(order.getClient().getLogin() + " your order have been processed. You will get your: "
							+ order.getQuantity() + " "
							+ order.getProductName() + " soon.");
					canBeProcessed = true;
				}
			}
		}
		return canBeProcessed;
	}
}