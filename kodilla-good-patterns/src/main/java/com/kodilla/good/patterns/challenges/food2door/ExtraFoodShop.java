package com.kodilla.good.patterns.challenges.food2door;

import java.util.LinkedList;
import java.util.List;

public class ExtraFoodShop implements OrderProcess {
	private String name;
	private List listOfProducts;
	
	private static ExtraFoodShop instance;
	
	private ExtraFoodShop(String name) {
		this.name = name;
		this.listOfProducts = new LinkedList();
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
	
	public List getListOfProducts() {
		return listOfProducts;
	}
	
	@Override
	public void addToList(Product product) {
	}
	
	@Override
	public boolean process(Order order) {
		System.out.println("Starting processing order...");
		if(!(ExtraFoodShop.getInstance().getListOfProducts().contains(order.getProduct()))) {
			System.out.println("We don't have the product. Please feel free to check out our other products.");
			return false;
		} else {
			if(!(order.getProduct().getQuantity() >= order.getQuantity())) {
				System.out.println("We don't have enough amount of product. Please lower the required " +
						"amount or check our other products.");
				return false;
			} else {
				if(!((order.finalPrice(order)) <= (order.getClient().getAccountBalance()))) {
					System.out.println("You don't have enough funds to processed your order.");
					return false;
				} else {
					System.out.println("Your order have been processed.");
					return true;
				}
			}
		}
	}
}