package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {
	private final String taskName;
	private final String color;
	private final String whatToPaint;
	private boolean taskExecuted = false;
	
	PaintingTask(String taskName, String color, String whatToPaint) {
		this.taskName = taskName;
		this.color = color;
		this.whatToPaint = whatToPaint;
	}
	
	@Override
	public void executeTask() {
		System.out.println(taskName + " has been executed.\nYou painted " + whatToPaint + " " + color + ".");
		taskExecuted = true;
	}
	
	@Override
	public String getTaskName() {
		return this.taskName;
	}
	
	@Override
	public boolean isTaskExecuted() {
		return taskExecuted;
	}
}