package com.kodilla.good.patterns.challenges.shop;

import java.util.List;

public class Shopping {
	private User user;
	private UserProductMap userProductMap;
	private Wallet wallet;
	private ProductSearchingService productSearchingService;
	
	public void shoppingProcess() {
		User user1 = new User("Michael", "Butler", "Butty91", "ul. Sienkiewicza",
				"56", "15", "67-856", "Siemianowice",
				"Poland", 1994, 4, 17);
		Wallet user1Wallet = new Wallet(user1, 5000);
		
		User user2 = new User("Peter", "Bronko", "BronkoGod", "Roosevelta",
				"55", null, "24-545", "Chortra",
				"Poland", 1967, 2, 12);
		UserProductMap user2ProductMap = new UserProductMap(user2);
		Product laptop = new Product(user2, "Laptop HP 1987", 2549, 5);
		Product slippers = new Product(user2, "Slippers", 25.99, 36);
		Product wino = new Product(user2, "Wino Porto 2005", 45, 15);
		user2ProductMap.addingToUsersProductMap(laptop);
		user2ProductMap.addingToUsersProductMap(slippers);
		user2ProductMap.addingToUsersProductMap(wino);
		Wallet user2Wallet = new Wallet(user2, 18900);
		
		User user3 = new User("Betty", "Draper", "BetsXX", "Wronowicza",
				"25", "25", "00-015", "Warszawa",
				"Poland", 2005, 12, 25);
		Wallet user3Wallet = new Wallet(user3, 3000);
		
		User user4 = new User("Margaret", "Keys", "KeyChain44", null,
				null, "36", "54-018",
				"Traczki", "Poland", 18, 12, 1975);
		Wallet user4Wallet = new Wallet(user4, 25);
		
		ProductSearchingService user1Search = new ProductSearchingService();
		Product foundProduct1 = user1Search.serviceSearchingMechanism(laptop.getProductNumber());
		ProductSearchingService user3Search = new ProductSearchingService();
		Product foundProduct2 = user3Search.serviceSearchingMechanism(slippers.getProductNumber());
		ProductSearchingService user4Search = new ProductSearchingService();
		Product foundProduct3 = user4Search.serviceSearchingMechanism(wino.getProductNumber());
		
		ShopCart user1ShopCart = new ShopCart(user1);
		user1ShopCart.addingToShopCartMap(foundProduct1, 2);
		ShopCart user3ShopCart = new ShopCart(user3);
		user3ShopCart.addingToShopCartMap(foundProduct2, 3);
		ShopCart user4ShopCart = new ShopCart(user4);
		user4ShopCart.addingToShopCartMap(foundProduct3, 1);
		
		Checkout user1checkout = new Checkout(user1);
		Checkout user2checkout = new Checkout(user3);
		Checkout user3checkout = new Checkout(user4);
		
		user1checkout.checkingOut(user1ShopCart, user1Wallet);
		user2checkout
		user3checkout
	}
}