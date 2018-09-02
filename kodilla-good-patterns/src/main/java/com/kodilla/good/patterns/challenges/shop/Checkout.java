package com.kodilla.good.patterns.challenges.shop;

import java.time.LocalDateTime;
import java.util.List;

public class Checkout {
	
	public boolean ageValidator(User buyer) {
		boolean validAge = false;
		if(!(buyer.isEighteen())) {
			System.out.println(buyer.getLogin() + " your age is under 18. You can't buy anything hear. " + "Please come back later.");
		} else {
			validAge = true;
		}
		return validAge;
	}
	
	public boolean hasProductValidator(User seller, Product product, User buyer) {
		boolean hasProduct = false;
		if(!(seller.getUserProductMap().containsKey(product.getProductName()))) {
			System.out.println(buyer.getLogin() + " we don't have " + product.getProductName() + " in our stock.");
		} else {
			hasProduct = true;
		}
		return hasProduct;
	}
	
	public boolean hasEnoughProduct(User buyer, Product product, ShopCart orderedProduct) {
		boolean hasEnoughProduct = false;
		if(!((product.getQuantity()) >= (orderedProduct.getProductQuantity()))) {
			System.out.println(buyer.getLogin() + " we don't have " + orderedProduct.getProductQuantity() + " " + product.getProductName() + " in our stock." + " Please lower amount to " + product.getQuantity() + ".");
		} else {
			hasEnoughProduct = true;
		}
		return hasEnoughProduct;
	}
	
	public boolean hasEnoughFunds(User buyer, Product product, ShopCart orderedProduct) {
		boolean hasEnoughFunds = false;
		if(!(((product.getPricePerUnit()) * (orderedProduct.getProductQuantity())) <= (buyer.getAccountBalance()))) {
			System.out.println(buyer.getLogin() + " you have insufficient funds." + "You have " + buyer.getAccountBalance() + " and total price for " + orderedProduct.getProductQuantity() + " " + product.getProductName() + " is " + ((orderedProduct.getProductQuantity()) * product.getPricePerUnit()) + "." + " Please lower amount of product or increase the amount of your account balance");
		} else {
			hasEnoughFunds = true;
		}
		return hasEnoughFunds;
	}
	
	public boolean checkingOut(Shopping shopping) {
		boolean isDone = false;
		for(List<ShopCart> userList : shopping.shoppingProcess()) {
			for(ShopCart currentUsersElementFromShopCart : userList) {
				System.out.println("Starting processing your order " + currentUsersElementFromShopCart
						.getThisUserIsBuying().getLogin());
				if((ageValidator(currentUsersElementFromShopCart.getThisUserIsBuying()))
						&& (hasProductValidator(currentUsersElementFromShopCart.getThisUserIsSelling(),
						currentUsersElementFromShopCart.getProduct(), currentUsersElementFromShopCart
								.getThisUserIsBuying()))
						&& (hasEnoughProduct(currentUsersElementFromShopCart.getThisUserIsBuying(),
						currentUsersElementFromShopCart.getProduct(), currentUsersElementFromShopCart))
						&& (hasEnoughFunds(currentUsersElementFromShopCart.getThisUserIsBuying(),
						currentUsersElementFromShopCart.getProduct(), currentUsersElementFromShopCart))) {
					isDone = true;
					System.out.println("Your order of: " + currentUsersElementFromShopCart.getProductQuantity() + " " + currentUsersElementFromShopCart.getProduct().getProductName() + " have been" + " processed successfully. Your order soon will be in the way.");
					ProductDatabase.getInstance().changingQuantityInMapMechanism(currentUsersElementFromShopCart.getProduct(), currentUsersElementFromShopCart.getProductQuantity());
					currentUsersElementFromShopCart.setTimeOfOrder(LocalDateTime.now());
					ArchiveService.getInstance().addingToOrderArchive(currentUsersElementFromShopCart);
				} else {
					isDone = false;
				}
			}
		}
		return isDone;
	}
}