package com.kodilla.good.patterns.challenges.food2door;

import java.util.HashMap;
import java.util.Map;

public class ExtraFoodShop implements OrderProcess {
	private String name;
	private Map<String, Product> mapOfProducts;
	
	private static ExtraFoodShop instance;
	
	private ExtraFoodShop(String name) {
		this.name = name;
		this.mapOfProducts = new HashMap<>();
		mapOfProducts.put("Apple", new Product("Apple", 40, 2.5));
		mapOfProducts.put("Carrot", new Product("Carrot", 150, 1.1));
		mapOfProducts.put("Cucumber", new Product("Cucumber", 458, 1.7));
		mapOfProducts.put("Strawberry", new Product("Strawberry", 2, 15));
	}
	
	public static ExtraFoodShop getInstance() {
		if(instance == null) {
			synchronized(ExtraFoodShop.class) {
				if(instance == null) {
					instance = new ExtraFoodShop("ExtraFoodShop");
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
		System.out.println("Starting processing order " + order.getClient().getLogin());
		if(!(mapOfProducts.containsKey(order.getProductName()))) {
			System.out.println(order.getClient().getLogin() + " we don't have: "
					+ order.getProductName() + " in our stock." + " Please feel free to " +
					"check out our other products.");
			return false;
		} else {
			if(!(mapOfProducts.get(order.getProductName()).getQuantity() >= order.getQuantity())) {
				System.out.println(order.getClient().getLogin() + " we don't have enough amount of: "
						+ order.getProductName() + ". Please lower the required " +
						"amount of: " + order.getQuantity() + " to: "
						+ mapOfProducts.get(order.getProductName()).getQuantity()
						+ " or less, or check out our other products.");
				return false;
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
					return false;
				} else {
					System.out.println(order.getClient().getLogin() + " your order have been processed. You will get your: "
							+ order.getQuantity() + " "
							+ order.getProductName() + " soon.");
					return true;
				}
			}
		}
	}
}