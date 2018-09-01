package com.kodilla.good.patterns.challenges.food2door;

import java.util.Arrays;
import java.util.List;

public class OrderGenerator {
	public List<Order> generate() {
		Client client1 = new Client("Michael", "Butler", "Butty91", "ul. Sienkiewicza",
				"56", "15", "67-856", "Siemianowice",
				"Poland", 4500);
		Client client2 = new Client("Peter", "Bronko", "BronkoGod", "ul. Roosevelta",
				"55", null, "24-545", "Chortra",
				"Poland", 340);
		Client client3 = new Client("Betty", "Draper", "BetsXX", "ul. Wronowicza",
				"25", "25", "00-015", "Warszawa",
				"Poland", 560);
		Client client4 = new Client("Margaret", "Keys", "KeyChain44", null,
				null, "36", "54-018",
				"Traczki", "Poland", 12);
		
		Order order1 = new Order(client1, 5, "Carrot");
		Order order2 = new Order(client2, 14, "Corn");
		Order order3 = new Order(client3, 4, "Gorgonzola");
		Order order4 = new Order(client4, 2, "Banana");
		Order order5 = new Order(client2, 5, "Gorgonzola");
		
		return Arrays.asList(order1, order2, order3, order4, order5);
	}
}