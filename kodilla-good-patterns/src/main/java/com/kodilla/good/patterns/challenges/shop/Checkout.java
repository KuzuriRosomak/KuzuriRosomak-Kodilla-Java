package com.kodilla.good.patterns.challenges.shop;

import java.util.HashMap;
import java.util.Map;

public class Checkout {
	private User user;
	private UserProductMap userProductMap;
	private ShopCart shopCart;
	private ProductDatabase productDatabase;
	private Wallet wallet;
	private Map<Product, Double> checkoutMap;
	private boolean paid = false;
	
	
	public Checkout(User user) {
		this.user = user;
		this.checkoutMap = new HashMap<>();
	}
	
	public boolean checkingOut(ShopCart shopCart, Wallet wallet, UserProductMap userProductMap) {
		if((user.isEighteen() && shopCart.finalPriceCounter() <= wallet.getAccountBalance())) {
			checkoutMap.putAll(shopCart.getShopCartMap());
			//
			//
			//
			//in progress
			//for(Map currentProduct : shopCart.getShopCartMap().entrySet()) {
			userProductMap.changingQuantityInUsersProductMap(currentProduct, (userProductMap.
					getProduct().getQuantity() - shopCart.getShopCartMap().get(currentProduct)));
			
			shopCart.removingAllItemsFromShopCartMap(shopCart.getShopCartMap());
			paid = true;
		} else if(!(user.isEighteen())) {
			System.out.println("Your age is under 18. You can't buy anything hear. Please come back later.");
		} else if((shopCart.finalPriceCounter()>wallet.getAccountBalance())) {
			System.out.println("You have insufficient funds.");
		}
		
		return paid;
	}
	
	public void removingFromMapMechanism(Product product) {
		shopsProductDataBase.remove(product.getProductNumber());
	}
	
	public void changingQuantityInMapMechanism(Product product, double quantity) {
		product.setQuantity(quantity);
		shopsProductDataBase.replace(product.getProductNumber(), product);
	}
	
	public void changingMapMechanism(Product product) {
		shopsProductDataBase.replace(product.getProductNumber(), product);
	}
	
	public Map<Long, Product> getShopsProductDataBase() {
		return shopsProductDataBase;
	}
}