package com.kodilla.good.patterns.challenges.shop;

public class OrderServiceApp {
	public static void main(String[] args) {
	
	ProductOrderService productOrderService = new ProductOrderService(new ProductSearchingService, new ShopCart,
			new ProductSendingService, new Checkout, new ArchiveService);
	productOrderService.process();
	}
}