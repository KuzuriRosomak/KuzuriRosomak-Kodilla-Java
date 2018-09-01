package com.kodilla.good.patterns.challenges.food2door;

public class Application {
	public static void main(String[] args) {
		
		OrderGenerator orderGenerator = new OrderGenerator();
		Processor extraFoodShopProcessor = new Processor(ExtraFoodShop.getInstance());
		Processor healthyShopProcessor = new Processor(HealthyShop.getInstance());
		Processor glutenFreeShopProcessor = new Processor(GlutenFreeShop.getInstance());
		
		extraFoodShopProcessor.haveBeenProcessed(orderGenerator.generate());
		healthyShopProcessor.haveBeenProcessed(orderGenerator.generate());
		glutenFreeShopProcessor.haveBeenProcessed(orderGenerator.generate());
	}
}