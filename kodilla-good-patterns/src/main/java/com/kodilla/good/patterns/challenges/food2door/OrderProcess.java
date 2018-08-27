package com.kodilla.good.patterns.challenges.food2door;

interface OrderProcess {
	void addToList(Product product);
	boolean process(Order order);
}