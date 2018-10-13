package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
	@Test
	public void testFactoryShoppingTask() {
		//Given
		TaskFactory factory = new TaskFactory();
		//When
		Task shoppingTask = factory.makeTask(TaskFactory.SHOPPING);
		shoppingTask.executeTask();
		//Then
		Assert.assertEquals("Groceries", shoppingTask.getTaskName());
		Assert.assertTrue(shoppingTask.isTaskExecuted());
	}
	
	@Test
	public void testFactoryPaintingTask() {
		//Given
		TaskFactory factory = new TaskFactory();
		//When
		Task paintingTask = factory.makeTask(TaskFactory.PAINTING);
		paintingTask.executeTask();
		//Then
		Assert.assertEquals("Fence painting", paintingTask.getTaskName());
		Assert.assertTrue(paintingTask.isTaskExecuted());
	}
	
	@Test
	public void testFactoryDrivingTask() {
		//Given
		TaskFactory factory = new TaskFactory();
		//When
		Task drivingTask = factory.makeTask(TaskFactory.DRIVING);
		drivingTask.executeTask();
		//Then
		Assert.assertEquals("Driving Warsaw", drivingTask.getTaskName());
		Assert.assertTrue(drivingTask.isTaskExecuted());
	}
}