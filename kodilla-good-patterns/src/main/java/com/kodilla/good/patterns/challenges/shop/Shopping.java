package com.kodilla.good.patterns.challenges.shop;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Shopping {
	
	public List<List<ShopCart>> shoppingProcess() {
		User user1 = new User("Michael", "Butler", "Butty91", "ul. Sienkiewicza",
				"56", "15", "67-856", "Siemianowice",
				"Poland", 15, 4, 1994, 5000);
		User user2 = new User("Peter", "Bronko", "BronkoGod", "Roosevelta",
				"55", null, "24-545", "Chortra",
				"Poland", 3, 2, 1967, 18900);
		User user3 = new User("Betty", "Draper", "BetsXX", "Wronowicza",
				"25", "25", "00-015", "Warszawa",
				"Poland", 25, 12, 2005, 3000);
		User user4 = new User("Margaret", "Keys", "KeyChain44", null,
				null, "36", "54-018",
				"Traczki", "Poland", 18, 12, 1975, 25);
		
		ProductDatabase.getInstance().addingToMapMechanism(new Product(user2, "Laptop HP 1987", 2549,
				1));
		ProductDatabase.getInstance().addingToMapMechanism(new Product(user2, "Slippers", 25.99,
				36));
		ProductDatabase.getInstance().addingToMapMechanism(new Product(user2, "Wine Porto 2005", 45,
				36));
		
		List<ShopCart> user1ShopCartList = new LinkedList<>();
		user1ShopCartList.add(new ShopCart(user1, user2, "Laptop HP 1987", 1));
		user1ShopCartList.add(new ShopCart(user1, user2, "Slippers", 2));
		
		List<ShopCart> user3ShopCartList = new LinkedList<>();
		user3ShopCartList.add(new ShopCart(user3, user2, "Laptop HP 1987", 1));
		user3ShopCartList.add(new ShopCart(user3, user2, "Wine Porto 2005", 3));
		
		List<ShopCart> user4ShopCartList = new LinkedList<>();
		user4ShopCartList.add(new ShopCart(user4, user2, "Slippers", 1));
		
		return Arrays.asList(user1ShopCartList, user3ShopCartList, user4ShopCartList);
	}
}