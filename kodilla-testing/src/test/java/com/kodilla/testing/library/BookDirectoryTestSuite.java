package com.kodilla.testing.library;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class BookDirectoryTestSuite
{
	private List<Book> generateListOfNBooks(int booksQuantity)
	{
		List<Book> resultList = new ArrayList<Book>();
		for(int n = 1; n <= booksQuantity; n++)
		{
			Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
			resultList.add(theBook);
		}
		return resultList;
	}
	
	@Test
	public void testListBooksWithConditionsReturnList()
	{
		// Given
		LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
		BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
		List<Book> resultListOfBooks = new ArrayList<Book>();
		Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
		Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
		Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
		Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
		resultListOfBooks.add(book1);
		resultListOfBooks.add(book2);
		resultListOfBooks.add(book3);
		resultListOfBooks.add(book4);
		when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);
		
		// When
		List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");
		
		// Then
		assertEquals(4, theListOfBooks.size());
	}
	
	@Test
	public void testListBooksWithConditionMoreThan20()
	{
		// Given
		LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
		BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
		List<Book> resultListOf0Books = new ArrayList<Book>();
		List<Book> resultListOf15Books = generateListOfNBooks(15);
		List<Book> resultListOf40Books = generateListOfNBooks(40);
		when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
		when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
		when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);
		
		// When
		List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
		List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
		List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
		
		// Then
		assertEquals(0, theListOfBooks0.size());
		assertEquals(15, theListOfBooks15.size());
		assertEquals(0, theListOfBooks40.size());
	}
	
	@Test
	public void testListBooksWithConditionFragmentShorterThan3()
	{
		// Given
		LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
		BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
		List<Book> resultListOf10Books = generateListOfNBooks(10);
		when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf10Books);
		
		// When
		List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");
		
		// Then
		assertEquals(0, theListOfBooks10.size());
		verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
	}
	
	@Test
	public void testListBooksInHands()
	{
		// Given
		LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
		BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
		LibraryUser user1 = new LibraryUser("Michael", "Butler", "99679876545");
		LibraryUser user2 = new LibraryUser("John", "Smith", "99679876546");
		LibraryUser user3 = new LibraryUser("Frederick", "Baker", "99679876547");
		List<Book> listBooksInHand0 = new ArrayList<Book>();
		List<Book> listBooksInHand1 = generateListOfNBooks(1);
		List<Book> listBooksInHand5 = generateListOfNBooks(5);
		when(libraryDatabaseMock.listBooksInHandsOf(user1)).thenReturn(listBooksInHand0);
		when(libraryDatabaseMock.listBooksInHandsOf(user2)).thenReturn(listBooksInHand1);
		when(libraryDatabaseMock.listBooksInHandsOf(user3)).thenReturn(listBooksInHand5);
		
		// When
		List<Book> usersBooks0 = bookLibrary.listBooksInHandsOf(user1);
		List<Book> usersBooks1 = bookLibrary.listBooksInHandsOf(user2);
		List<Book> usersBooks5 = bookLibrary.listBooksInHandsOf(user3);
		
		// Then
		assertEquals(0, usersBooks0.size());
		assertEquals(1, usersBooks1.size());
		assertEquals(5, usersBooks5.size());
	}
	
	@Test
	public void testRentABook()
	{
		// Given
		LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
		BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
		LibraryUser user1 = new LibraryUser("Michael", "Butler", "99679876545");
		LibraryUser user2 = new LibraryUser("John", "Smith", "99679876546");
		LibraryUser user3 = new LibraryUser("Frederick", "Baker", "99679876547");
		List<Book> libraryBooks = new ArrayList<Book>();
		Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
		Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
		Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
		Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
		Book book5 = new Book("XYZ", "John Hoop", 2002);
		Book book6 = new Book("ABCD", "Robert Ian", 1856);
		Book book7 = new Book("1234", "Twit Witt", 2018);
		Book book8 = new Book("Barbie", "Michael Jordan", 1956);
		Book book9 = new Book("Australia", "Brian \"Aussie\" Piotrovic", 1956);
		libraryBooks.add(book1);
		libraryBooks.add(book2);
		libraryBooks.add(book3);
		libraryBooks.add(book4);
		libraryBooks.add(book5);
		libraryBooks.add(book6);
		libraryBooks.add(book7);
		libraryBooks.add(book8);
		boolean isTrue = true;
		boolean isFalse = false;
		when(libraryDatabaseMock.rentABook(user1, book5)).thenReturn(isTrue);
		when(libraryDatabaseMock.rentABook(user2, book7)).thenReturn(isTrue);
		when(libraryDatabaseMock.rentABook(user3, book9)).thenReturn(isFalse);
		
		// When
		boolean bookRent1 = bookLibrary.rentABook(user1, book5);
		boolean bookRent2 = bookLibrary.rentABook(user2, book7);
		boolean bookRent3 = bookLibrary.rentABook(user3, book9);
		
		// Then
		assertTrue(bookRent1);
		assertTrue(bookRent2);
		assertFalse(bookRent3);
	}
	
	@Test
	public void testReturnBooks()
	{
		// Given
		LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
		BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
		LibraryUser user1 = new LibraryUser("Michael", "Butler", "99679876545");
		LibraryUser user2 = new LibraryUser("John", "Smith", "99679876546");
		LibraryUser user3 = new LibraryUser("Frederick", "Baker", "99679876547");
		List<Book> listBooksInHand0 = new ArrayList<Book>();
		List<Book> listBooksInHand3 = generateListOfNBooks(3);
		List<Book> listBooksInHand5 = generateListOfNBooks(5);
		when(libraryDatabaseMock.returnBooks(user1)).thenReturn(listBooksInHand0.size());
		when(libraryDatabaseMock.returnBooks(user2)).thenReturn(listBooksInHand3.size());
		when(libraryDatabaseMock.returnBooks(user3)).thenReturn(listBooksInHand5.size());
		
		
		// When
		int returnedBooksByUser1 = bookLibrary.returnBooks(user1);
		int returnedBooksByUser2 = bookLibrary.returnBooks(user2);
		int returnedBooksByUser3 = bookLibrary.returnBooks(user3);
		
		// Then
		assertEquals(0, returnedBooksByUser1);
		assertEquals(3, returnedBooksByUser2);
		assertEquals(5, returnedBooksByUser3);
	}
}