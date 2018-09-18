package com.kodilla.spring.portfolio;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public final class TaskList {
	private final List<String> tasks;
	
	public TaskList() {
		this.tasks = new ArrayList<>();
	}
	
	public List<String> getTasks() {
		return tasks;
	}
}