package com.kodilla.good.patterns.challenges.food2door;

import java.util.List;

public class Processor {
	
	public static boolean haveBeenProcessed(List<Order> listOfOrders) {
		boolean isDone = false;
		for(Order currentOrder : listOfOrders) {
			if(ExtraFoodShop.getInstance().getMapOfProducts().containsKey(currentOrder.getProductName())) {
				ExtraFoodShop.getInstance().process(currentOrder);
				isDone = true;
			} else if(GlutenFreeShop.getInstance().getMapOfProducts().containsKey(currentOrder.getProductName())) {
				GlutenFreeShop.getInstance().process(currentOrder);
				isDone = true;
			} else if(HealthyShop.getInstance().getMapOfProducts().containsKey(currentOrder.getProductName())) {
				HealthyShop.getInstance().process(currentOrder);
				isDone = true;
			} else {
				isDone = false;
			}
		}
		return isDone;
	}
}