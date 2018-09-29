package com.kodilla.patterns.prototype.library;

import java.time.LocalDate;

public final class Book {
	private final String title;
	private final String author;
	private final LocalDate publicationDate;
	
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