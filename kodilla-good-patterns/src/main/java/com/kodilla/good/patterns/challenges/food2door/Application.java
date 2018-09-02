package com.kodilla.good.patterns.challenges.food2door;

public class Application {
	public static void main(String[] args) {
		Processor.haveBeenProcessed(new OrderGenerator().generate());
	}
}