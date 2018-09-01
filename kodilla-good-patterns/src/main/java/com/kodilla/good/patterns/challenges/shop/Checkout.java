package com.kodilla.good.patterns.challenges.shop;

import java.time.LocalDateTime;
import java.util.List;

public class Checkout {
	
	public boolean checkingOut(Shopping shopping) {
		boolean isDone = false;
		for(List<ShopCart> userList : shopping.shoppingProcess()) {
			for(ShopCart currentUsersElementFromShopCart : userList) {
				System.out.println("Starting processing your order " + currentUsersElementFromShopCart
						.getThisUserIsBuying().getLogin());
				if(!(currentUsersElementFromShopCart.getThisUserIsBuying().isEighteen())) {
					System.out.println(currentUsersElementFromShopCart.getThisUserIsBuying().getLogin()
							+ " your age is under 18. You can't buy anything hear. Please come back later.");
					isDone = false;
				} else {
					if(!(currentUsersElementFromShopCart.getThisUserIsSelling().getUserProductMap()
							.containsKey(currentUsersElementFromShopCart.getProduct().getProductName()))) {
						isDone = false;
						System.out.println(currentUsersElementFromShopCart.getThisUserIsBuying().getLogin() + " we don't have "
								+ currentUsersElementFromShopCart.getProduct().getProductName()
								+ " in our stock.");
					}
					else {
						if(!((currentUsersElementFromShopCart.getProduct().getQuantity()) >= (currentUsersElementFromShopCart
								.getProductQuantity()))) {
							isDone = false;
							System.out.println(currentUsersElementFromShopCart.getThisUserIsBuying().getLogin() +
									" we don't have " + currentUsersElementFromShopCart.getProductQuantity()
									+ " " + currentUsersElementFromShopCart.getProduct().
									getProductName() + " in our stock." + " Please lower amount to "
									+ currentUsersElementFromShopCart.getProduct().getQuantity() + ".");
						} else {
							if(!(((currentUsersElementFromShopCart.getProduct().getPricePerUnit())
									* (currentUsersElementFromShopCart.getProductQuantity()))
									<= (currentUsersElementFromShopCart.getThisUserIsBuying().getAccountBalance()))) {
								isDone = false;
								System.out.println(currentUsersElementFromShopCart.getThisUserIsBuying().getLogin()
										+ " you have insufficient funds." + "You have " + currentUsersElementFromShopCart
										.getThisUserIsBuying().getAccountBalance() + " and total price for "
										+ currentUsersElementFromShopCart.getProductQuantity() + " "
										+ currentUsersElementFromShopCart.getProduct().getProductName() + " is "
										+ ((currentUsersElementFromShopCart.getProductQuantity())
										* currentUsersElementFromShopCart.getProduct().getPricePerUnit()) + "."
										+ " Please lower amount of product or increase the amount of your account balance");
							} else {
								isDone = true;
								System.out.println("Your order of: " + currentUsersElementFromShopCart.getProductQuantity()
										+ " " + currentUsersElementFromShopCart.getProduct().getProductName() + " have been" +
										" processed successfully. Your order soon will be in the way.");
								ProductDatabase.getInstance().changingQuantityInMapMechanism(currentUsersElementFromShopCart
										.getProduct(), currentUsersElementFromShopCart.getProductQuantity());
								currentUsersElementFromShopCart.setTimeOfOrder(LocalDateTime.now());
								ArchiveService.getInstance().addingToOrderArchive(currentUsersElementFromShopCart);
							}
						}
					}
				}
			}
		}
		return isDone;
	}
}