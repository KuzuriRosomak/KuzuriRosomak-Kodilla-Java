package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public final class Board {
	@Autowired
	@Qualifier("toDoList")
	private TaskList toDoList;
	
	@Autowired
	@Qualifier("inProgressList")
	private TaskList inProgressList;
	
	@Autowired
	@Qualifier("doneList")
	private TaskList doneList;
	
	public void taskAdderToToDoList() {
		toDoList.getTasks().add("Something to do 1");
	}
	
	public void taskAdderToInProgressList() {
		inProgressList.getTasks().add("Something to do 2");
	}
	
	public void taskAdderToDoneList() {
		doneList.getTasks().add("Something to do 3");
	}
	
	public TaskList getToDoList() {
		return toDoList;
	}
	
	public TaskList getInProgressList() {
		return inProgressList;
	}
	
	public TaskList getDoneList() {
		return doneList;
	}
}