package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype {
	String name;
	Set<Book> books = new HashSet<>();
	
	public Library(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Set<Book> getBooks() {
		return books;
	}
	
	public Library shallowCopy() throws CloneNotSupportedException {
		return (Library)super.clone();
	}
	
	public Library deepCopy() throws CloneNotSupportedException {
		Library clonedLibrary = (Library)super.clone();
		clonedLibrary.books = new HashSet<>();
		for(Book theBook : books) {
			clonedLibrary.getBooks().add(theBook);
		}
		return clonedLibrary;
	}
	
	@Override
	public String toString() {
		return name + ":\n" +
				books.toString();
	}
}

//deepCopy()

/**public Board deepCopy() throws CloneNotSupportedException {
 Board clonedBoard = (Board)super.clone();
 clonedBoard.lists = new HashSet<>();
 for(TasksList theList : lists) {
 TasksList clonedList = new TasksList(theList.getName());
 for(Task task : theList.getTasks()) {
 clonedList.getTasks().add(task);
 }
 clonedBoard.getLists().add(clonedList);
 }
 return clonedBoard;
 }*/