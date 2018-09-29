package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

public class LibraryTestSuite {
	@Test
	public void testGetBooks() {
		//given
		Book book1 = new Book("Title 1", "Author 1",1997, 6,
				25);
		Book book2 = new Book("Title 2", "Author 2",2018, 2,
				12);
		Book book3 = new Book("Title 3", "Author 3",1952, 11,
				17);
		Book book4 = new Book("Title 4", "Author 4",1978, 4,
				5);
		
		Library library = new Library("Library number 1");
		library.getBooks().add(book1);
		library.getBooks().add(book2);
		library.getBooks().add(book3);
		library.getBooks().add(book4);
		
		Library clonedLibrary = null;
		try {
			clonedLibrary = library.shallowCopy();
			clonedLibrary.setName("Library number 2");
		} catch (CloneNotSupportedException e) {
			System.out.println(e);
		}
		
		Library deepClonedLibrary = null;
		try {
			deepClonedLibrary = library.deepCopy();
			deepClonedLibrary.setName("Library number 3");
		} catch (CloneNotSupportedException e) {
			System.out.println(e);
		}
		
		//When
		library.getBooks().remove(book2);
		
		//Then
		System.out.println(library);
		System.out.println(clonedLibrary);
		System.out.println(deepClonedLibrary);
		Assert.assertEquals(3, library.getBooks().size());
		Assert.assertEquals(3, clonedLibrary.getBooks().size());
		Assert.assertEquals(4, deepClonedLibrary.getBooks().size());
		Assert.assertEquals(clonedLibrary.getBooks(), library.getBooks());
		Assert.assertNotEquals(deepClonedLibrary.getBooks(), library.getBooks());
	}
}