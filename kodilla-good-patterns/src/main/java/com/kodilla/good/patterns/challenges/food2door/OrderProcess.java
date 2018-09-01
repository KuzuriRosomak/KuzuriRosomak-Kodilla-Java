package com.kodilla.good.patterns.challenges.food2door;

interface OrderProcess {
	void addToMap(Product product);
	boolean process(Order order);
}