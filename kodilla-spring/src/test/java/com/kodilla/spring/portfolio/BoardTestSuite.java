package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class BoardTestSuite {
	@Test
	public void testTaskAdd() {
		//Given
		ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
		Board board = context.getBean(Board.class);
		board.taskAdderToToDoList();
		board.taskAdderToInProgressList();
		board.taskAdderToDoneList();
		
		//When
		List<String> toDoListTasks = board.getToDoList().getTasks();
		List<String> inProgressListTasks = board.getInProgressList().getTasks();
		List<String> doneListTasks = board.getDoneList().getTasks();
		
		//Then
		Assert.assertEquals(toDoListTasks, Arrays.asList("Something to do 1"));
		Assert.assertEquals(inProgressListTasks, Arrays.asList("Something to do 2"));
		Assert.assertEquals(doneListTasks, Arrays.asList("Something to do 3"));
	}
}