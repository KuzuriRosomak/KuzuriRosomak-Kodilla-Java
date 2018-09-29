package com.kodilla.patterns.prototype.library;

import java.time.LocalDate;

public final class Book {
	final String title;
	final String author;
	final LocalDate publicationDate;
	
	public Book(final String title, final String author, final int yearOfPublicationDate, final int monthOfPublicationDate,
	            final int dayOfPublicationDate) {
		this.title = title;
		this.author = author;
		this.publicationDate = LocalDate.of(yearOfPublicationDate, monthOfPublicationDate, dayOfPublicationDate);
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public LocalDate getPublicationDate() {
		return publicationDate;
	}
	
	@Override
	public String toString() {
		return author + " " + title + ", " + publicationDate + "\n";
	}
}