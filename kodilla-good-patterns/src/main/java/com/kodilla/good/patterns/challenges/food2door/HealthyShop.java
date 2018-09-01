package com.kodilla.good.patterns.challenges.food2door;

import java.util.HashMap;
import java.util.Map;

public class HealthyShop implements OrderProcess {
	private String name;
	private Map<String, Product> mapOfProducts;
	
	private static HealthyShop instance;
	
	private HealthyShop(String name) {
		this.name = name;
		this.mapOfProducts = new HashMap<>();
		mapOfProducts.put("Blueberry", new Product("Blueberry", 1.5, 25.7));
		mapOfProducts.put("Banana", new Product("Banana", 245, 4.5));
		mapOfProducts.put("Orange", new Product("Orange", 67, 5.7));
		mapOfProducts.put("Tomato", new Product("Tomato", 25, 2.6));
	}
	
	public static HealthyShop getInstance() {
		if(instance == null) {
			synchronized(HealthyShop.class) {
				if(instance == null) {
					instance = new HealthyShop("HealthyShop");
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
		boolean itsOk;
		System.out.println("Starting processing order...");
		if(!(mapOfProducts.containsKey(order.getProductName()))) {
			System.out.println("We don't have: " + order.getProductName() + " in our stock." + " Please feel free to " +
					"check out our other products.");
			itsOk = false;
		} else {
			if(!(mapOfProducts.get(order.getProductName()).getQuantity() >= order.getQuantity())) {
				System.out.println("We don't have enough amount of: " + order.getProductName() + ". Please lower the required " +
						"amount of: " + order.getQuantity() + " to: "
						+ mapOfProducts.get(order.getProductName()).getQuantity() + " or less, or check out our other products.");
				itsOk = false;
			} else {
				if(!(((order.getQuantity()) * (mapOfProducts.get(order.getProductName()).getPricePerUnit()))
						<= (order.getClient().getAccountBalance()))) {
					System.out.println("You don't have enough funds to processed your order.\nYour account balance is: "
							+ order.getClient().getAccountBalance() + ".\n" + "Required amount is: "
							+ ((order.getQuantity()) * (mapOfProducts.get(order.getProductName()).getPricePerUnit()))
							+ ".\nPlease deposit missing: "
							+ (((order.getQuantity()) * (mapOfProducts.get(order.getProductName()).getPricePerUnit()))
							- (order.getClient().getAccountBalance())) + ".");
					itsOk = false;
				} else {
					System.out.println("Your order have been processed. You will get your: " + order.getQuantity() + " "
							+ order.getProductName() + " soon.");
					itsOk = true;
				}
			}
		}
		return itsOk;
	}
}