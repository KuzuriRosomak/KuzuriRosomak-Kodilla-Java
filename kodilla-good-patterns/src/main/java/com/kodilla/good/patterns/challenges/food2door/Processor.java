package com.kodilla.good.patterns.challenges.food2door;

import java.util.List;

public class Processor {
	private OrderProcess orderProcess;
	
	public Processor(OrderProcess orderProcess) {
		this.orderProcess = orderProcess;
	}
	
	public boolean haveBeenProcessed(List<Order> listOfOrders) {
		boolean isDone = false;
		for(Order currentOrder : listOfOrders) {
			if(orderProcess.process(currentOrder)) {
				isDone = true;
			} else {
				isDone = false;
			}
		}
		return isDone;
	}
}