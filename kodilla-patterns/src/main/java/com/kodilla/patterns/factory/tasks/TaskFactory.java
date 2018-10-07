package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
	public static final String SHOPPING = "SHOPPING";
	public static final String PAINTING = "PAINTING";
	public static final String DRIVING = "DRIVING";
	
	public final Task makeTask(final String taskClass) {
		switch (taskClass) {
			case SHOPPING:
				return new ShoppingTask("Groceries", "apples", 1.5);
			case PAINTING:
				return new PaintingTask("Fence painting", "red", "fence");
			case DRIVING:
				return new DrivingTask("Driving Warsaw", "Warsaw", "car");
			default:
				return null;
		}
	}
}