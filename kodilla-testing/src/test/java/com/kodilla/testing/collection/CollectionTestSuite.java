package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.*;
import java.util.*;
import java.lang.*;


public class CollectionTestSuite
{
	@Before
	public void before()
	{
		System.out.println("Starting test case");
	}
	
	@After
	public void after()
	{
		System.out.println("Test case finished");
	}
	
	@Test
	public void testOddNumbersExterminatorEmptyList()
	{
		//Given
		OddNumbersExterminator exterminator = new OddNumbersExterminator();
		ArrayList<Integer> listOfNumbers1 = new ArrayList<Integer>();
		
		//When
		ArrayList<Integer> result1 = exterminator.exterminate(listOfNumbers1);
		System.out.println("Test 1 in progress");
		
		//Then
		Assert.assertEquals(listOfNumbers1, result1);
	}
	
	@Test
	public void testOddNumbersExterminatorNormalList()
	{
		//Given
		OddNumbersExterminator exterminator = new OddNumbersExterminator();
		ArrayList<Integer> listOfNumbers2 = new ArrayList<Integer>();
		listOfNumbers2.add(0);
		listOfNumbers2.add(1);
		listOfNumbers2.add(2);
		listOfNumbers2.add(3);
		listOfNumbers2.add(4);
		listOfNumbers2.add(5);
		listOfNumbers2.add(6);
		listOfNumbers2.add(7);
		listOfNumbers2.add(8);
		listOfNumbers2.add(9);
		
		//When
		ArrayList<Integer> result2 = exterminator.exterminate(listOfNumbers2);
		System.out.println("Test 2 in progress");
		
		//Then
		ArrayList<Integer> listOfNumbers3 = new ArrayList<Integer>();
		listOfNumbers3.add(0);
		listOfNumbers3.add(2);
		listOfNumbers3.add(4);
		listOfNumbers3.add(6);
		listOfNumbers3.add(8);
		Assert.assertEquals(listOfNumbers3, result2);
	}
}