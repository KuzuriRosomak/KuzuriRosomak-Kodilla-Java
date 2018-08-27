package com.kodilla.good.patterns.challenges.food2door;

import java.util.LinkedList;
import java.util.List;

public class HealthyShop implements OrderProcess {
	private String name;
	private List listOfProducts;
	
	private static HealthyShop instance;
	
	private HealthyShop(String name) {
		this.name = name;
		this.listOfProducts = new LinkedList();
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
	
	public List getListOfProducts() {
		return listOfProducts;
	}
	
	@Override
	public void addToList(Product product) {
	}
	
	@Override
	public boolean process(Order order) {
		boolean itsOk;
		System.out.println("Starting processing order...");
		if(!(HealthyShop.getInstance().getListOfProducts().contains(order.getProduct()))) {
			System.out.println("We don't have the product. Please feel free to check out our other products.");
			itsOk = false;
		} else {
			if(!(order.getProduct().getQuantity() >= order.getQuantity())) {
				System.out.println("We don't have enough amount of product. Please lower the required " +
						"amount or check our other products.");
				itsOk = false;
			} else {
				if(!((order.finalPrice(order)) <= (order.getClient().getAccountBalance()))) {
					System.out.println("You don't have enough funds to processed your order.");
					itsOk = false;
				} else {
					System.out.println("Your order have been processed.");
					itsOk = true;
				}
			}
		}
	return itsOk;
	}
}