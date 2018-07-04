package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary
{
	LibraryDatabase libraryDatabase;
	
	public BookLibrary(LibraryDatabase libraryDatabase)
	{
		this.libraryDatabase = libraryDatabase;
	}
	
	public List<Book> listBooksWithCondition(String titleFragment)
	{
		List<Book> bookList = new ArrayList<Book>();
		if (titleFragment.length() < 3) return bookList;
		List<Book> resultList = libraryDatabase.listBooksWithCondition(titleFragment);
		if (resultList.size() > 20) return bookList;
		bookList = resultList;
		return bookList;
	}
	
	public List<Book> listBooksInHandsOf(LibraryUser libraryUser)
	{
		List<Book> booksInHand = libraryDatabase.listBooksInHandsOf(libraryUser);
		return booksInHand;
	}
	
	boolean rentABook(LibraryUser libraryUser, Book book)
	{
		if(!libraryDatabase.rentABook(libraryUser, book))
		{
			return false;
		}
		
		if(listBooksInHandsOf(libraryUser).contains(book))
		{
			return false;
		}
		
		if(listBooksInHandsOf(libraryUser).size() >= 5)
		{
			return false;
		}
		
		return true;
	}
	
	int returnBooks(LibraryUser libraryUser)
	{
		int numberOfReturnedBooks = libraryDatabase.returnBooks(libraryUser);
		return numberOfReturnedBooks;
	}
}