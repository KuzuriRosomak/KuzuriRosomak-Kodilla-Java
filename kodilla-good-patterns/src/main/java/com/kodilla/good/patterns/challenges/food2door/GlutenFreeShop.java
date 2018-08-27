package com.kodilla.good.patterns.challenges.food2door;

import java.util.LinkedList;
import java.util.List;

public class GlutenFreeShop implements OrderProcess {
	private String name;
	private List listOfProducts;
	
	private static GlutenFreeShop instance;
	
	private GlutenFreeShop(String name) {
		this.name = name;
		this.listOfProducts = new LinkedList();
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
	
	public List getListOfProducts() {
		return listOfProducts;
	}
	
	@Override
	public void addToList(Product product) {
	}
	
	@Override
	public boolean process(Order order) {
		boolean canBeProcessed = false;
		System.out.println("Starting processing order...");
		if(!(GlutenFreeShop.getInstance().getListOfProducts().contains(order.getProduct()))) {
			System.out.println("We don't have the product. Please feel free to check out our other products.");
		} else {
			if(!(order.getProduct().getQuantity() >= order.getQuantity())) {
				System.out.println("We don't have enough amount of product. Please lower the required " +
						"amount or check our other products.");
			} else {
				if(!((order.finalPrice(order)) <= (order.getClient().getAccountBalance()))) {
					System.out.println("You don't have enough funds to processed your order.");
				} else {
					System.out.println("Your order have been processed.");
					canBeProcessed = true;
				}
			}
		}
	return canBeProcessed;
	}
}