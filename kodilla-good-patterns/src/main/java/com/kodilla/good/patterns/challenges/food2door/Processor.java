package com.kodilla.good.patterns.challenges.food2door;

public class Processor {
	private OrderProcess orderProcess;
	
	public Processor(OrderProcess orderProcess) {
		this.orderProcess = orderProcess;
	}
	
	public void doIt(Order order) {
		orderProcess.process(order);
	}
}