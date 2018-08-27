package com.kodilla.good.patterns.challenges.food2door;

public class Application {
	public static void main(String[] args) {
		Product apple = new Product("Apple", 40, 2.5);
		Product carrot = new Product("Carrot", 150, 1.1);
		Product cucumber = new Product("Cucumber", 458, 1.7);
		Product strawberry = new Product("Strawberry", 2, 15);
		Product blueberry = new Product("Blueberry", 1.5, 25.7);
		Product banana = new Product("Banana", 245, 4.5);
		Product orange = new Product("Orange", 67, 5.7);
		Product tomato = new Product("Tomato", 25, 2.6);
		Product gorgonzola = new Product("Gorgonzola", 6.9, 98);
		Product flour = new Product("Flour", 232, 0.97);
		Product corn = new Product("Corn", 678, 3.5);
		
		ExtraFoodShop.getInstance().addToList(apple);
		ExtraFoodShop.getInstance().addToList(carrot);
		ExtraFoodShop.getInstance().addToList(cucumber);
		ExtraFoodShop.getInstance().addToList(strawberry);
		
		HealthyShop.getInstance().addToList(blueberry);
		HealthyShop.getInstance().addToList(banana);
		HealthyShop.getInstance().addToList(orange);
		HealthyShop.getInstance().addToList(tomato);
		
		GlutenFreeShop.getInstance().addToList(gorgonzola);
		GlutenFreeShop.getInstance().addToList(flour);
		GlutenFreeShop.getInstance().addToList(corn);
		
		Client client1 = new Client("Michael", "Butler", "Butty91", "ul. Sienkiewicza",
				"56", "15", "67-856", "Siemianowice",
				"Poland", 4500);
		Client client2 = new Client("Peter", "Bronko", "BronkoGod", "Roosevelta",
				"55", null, "24-545", "Chortra",
				"Poland", 340);
		Client client3 = new Client("Betty", "Draper", "BetsXX", "Wronowicza",
				"25", "25", "00-015", "Warszawa",
				"Poland", 560);
		Client client4 = new Client("Margaret", "Keys", "KeyChain44", null,
				null, "36", "54-018",
				"Traczki", "Poland", 12);
		
		Order order1 = new Order(client1, carrot, 5);
		Order order2 = new Order(client2, corn, 14);
		Order order3 = new Order(client3, gorgonzola, 4);
		Order order4 = new Order(client4, banana, 2);
		Order order5 = new Order(client2, gorgonzola, 5);
		
		Processor processor = new Processor(ExtraFoodShop.getInstance());
		processor.doIt();
	}
}