package com.kodilla.testing.forum.statistics;

import org.junit.rules.TestName;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculatingStatisticsTestSuite
{
	private static int testCounter = 0;
	
	@Rule
	public TestName nameOfTheTest = new TestName();
	
	@BeforeClass
	public static void beforeTestSuite()
	{
		System.out.println("Starting Test Suite for CalculatingStatistics Class.");
	}
	
	@AfterClass
	public static void afterTestSuite()
	{
		System.out.println("Test Suite for CalculatingStatistics Class is finished.");
	}
	
	@Before
	public void beforeTests()
	{
		testCounter++;
		System.out.println("Starting test number: " + testCounter + " named: " + nameOfTheTest.getMethodName());
	}
	
	@After
	public void afterTests()
	{
		System.out.println("Finishing test number: " + testCounter + " named: " + nameOfTheTest.getMethodName());
	}
	
	@Test
	public void testCalculateAdvStatisticsNumberOfPosts0()
	{
		//Given
		Statistics statisticsMock = mock(Statistics.class);
		
		List<String> namesOfUsersList = new ArrayList<String>();
		Random theGenerator = new Random();
		for (int n=0; n<56742; n++)
		{
			namesOfUsersList.add(String.valueOf(theGenerator.nextInt(999999999)));
		}
		when(statisticsMock.usersNames()).thenReturn(namesOfUsersList);
		
		int posts = 0;
		when(statisticsMock.postsCount()).thenReturn(posts);
		
		int comments = 65472;
		when(statisticsMock.commentsCount()).thenReturn(comments);
		
		CalculatingStatistics statisticsCalculator = new CalculatingStatistics();
		
		//When
		statisticsCalculator.calculateAdvStatistics(statisticsMock);
		statisticsCalculator.showStatistics();
		int postsNumber = statisticsCalculator.getNumberOfPosts();
		
		//Then
		assertEquals(posts, postsNumber);
	}
	
	@Test
	public void testCalculateAdvStatisticsNumberOfPosts1000()
	{
		//Given
		Statistics statisticsMock = mock(Statistics.class);
		
		List<String> namesOfUsersList = new ArrayList<String>();
		Random theGenerator = new Random();
		for (int n=0; n<56742; n++)
		{
			namesOfUsersList.add(String.valueOf(theGenerator.nextInt(999999999)));
		}
		when(statisticsMock.usersNames()).thenReturn(namesOfUsersList);
		
		int posts = 1000;
		when(statisticsMock.postsCount()).thenReturn(posts);
		
		int comments = 65472;
		when(statisticsMock.commentsCount()).thenReturn(comments);
		
		CalculatingStatistics statisticsCalculator = new CalculatingStatistics();
		
		//When
		statisticsCalculator.showStatistics();
		statisticsCalculator.calculateAdvStatistics(statisticsMock);
		int postsNumber = statisticsCalculator.getNumberOfPosts();
		
		//Then
		assertEquals(posts, postsNumber);
	}
	
	@Test
	public void testCalculateAdvStatisticsNumberOfComments0()
	{
		//Given
		Statistics statisticsMock = mock(Statistics.class);
		
		List<String> namesOfUsersList = new ArrayList<String>();
		Random theGenerator = new Random();
		for (int n=0; n<56742; n++)
		{
			namesOfUsersList.add(String.valueOf(theGenerator.nextInt(999999999)));
		}
		when(statisticsMock.usersNames()).thenReturn(namesOfUsersList);
		
		int posts = 12455;
		when(statisticsMock.postsCount()).thenReturn(posts);
		
		int comments = 0;
		when(statisticsMock.commentsCount()).thenReturn(comments);
		
		CalculatingStatistics statisticsCalculator = new CalculatingStatistics();
		
		//When
		statisticsCalculator.calculateAdvStatistics(statisticsMock);
		statisticsCalculator.showStatistics();
		int commentsNumber = statisticsCalculator.getNumberOfComments();
		
		//Then
		assertEquals(comments, commentsNumber);
	}
	
	@Test
	public void testCalculateAdvStatisticsNumberOfCommentsIsLowerThanNumberOfPosts()
	{
		//Given
		Statistics statisticsMock = mock(Statistics.class);
		
		List<String> namesOfUsersList = new ArrayList<String>();
		Random theGenerator = new Random();
		for (int n=0; n<56742; n++)
		{
			namesOfUsersList.add(String.valueOf(theGenerator.nextInt(999999999)));
		}
		when(statisticsMock.usersNames()).thenReturn(namesOfUsersList);
		
		int posts = 12455;
		when(statisticsMock.postsCount()).thenReturn(posts);
		
		int comments = 50;
		when(statisticsMock.commentsCount()).thenReturn(comments);
		
		CalculatingStatistics statisticsCalculator = new CalculatingStatistics();
		
		//When
		statisticsCalculator.calculateAdvStatistics(statisticsMock);
		statisticsCalculator.showStatistics();
		int commentsNumber = statisticsCalculator.getNumberOfComments();
		
		//Then
		assertEquals(comments, commentsNumber);
	}
	
	@Test
	public void testCalculateAdvStatisticsNumberOfCommentsIsBiggerThanNumberOfPosts()
	{
		//Given
		Statistics statisticsMock = mock(Statistics.class);
		
		List<String> namesOfUsersList = new ArrayList<String>();
		Random theGenerator = new Random();
		for (int n=0; n<56742; n++)
		{
			namesOfUsersList.add(String.valueOf(theGenerator.nextInt(999999999)));
		}
		when(statisticsMock.usersNames()).thenReturn(namesOfUsersList);
		
		int posts = 50;
		when(statisticsMock.postsCount()).thenReturn(posts);
		
		int comments = 12456;
		when(statisticsMock.commentsCount()).thenReturn(comments);
		
		CalculatingStatistics statisticsCalculator = new CalculatingStatistics();
		
		//When
		statisticsCalculator.calculateAdvStatistics(statisticsMock);
		statisticsCalculator.showStatistics();
		int commentsNumber = statisticsCalculator.getNumberOfComments();
		
		//Then
		assertEquals(comments, commentsNumber);
	}
	
	@Test
	public void testCalculateAdvStatisticsNumberOfUsers0()
	{
		//Given
		Statistics statisticsMock = mock(Statistics.class);
		
		List<String> namesOfUsersList = new ArrayList<String>();
		
		int posts = 50;
		when(statisticsMock.postsCount()).thenReturn(posts);
		
		int comments = 12456;
		when(statisticsMock.commentsCount()).thenReturn(comments);
		
		CalculatingStatistics statisticsCalculator = new CalculatingStatistics();
		
		//When
		statisticsCalculator.calculateAdvStatistics(statisticsMock);
		statisticsCalculator.showStatistics();
		int usersNumber = statisticsCalculator.getNumberOfUsers();
		
		//Then
		assertEquals(namesOfUsersList.size(), usersNumber);
	}
	
	@Test
	public void testCalculateAdvStatisticsNumberOfUsers100()
	{
		//Given
		Statistics statisticsMock = mock(Statistics.class);
		
		List<String> namesOfUsersList = new ArrayList<String>();
		Random theGenerator = new Random();
		for (int n=0; n<100; n++)
		{
			namesOfUsersList.add(String.valueOf(theGenerator.nextInt(999999999)));
		}
		when(statisticsMock.usersNames()).thenReturn(namesOfUsersList);
		
		int posts = 50;
		when(statisticsMock.postsCount()).thenReturn(posts);
		
		int comments = 12456;
		when(statisticsMock.commentsCount()).thenReturn(comments);
		
		CalculatingStatistics statisticsCalculator = new CalculatingStatistics();
		
		//When
		statisticsCalculator.calculateAdvStatistics(statisticsMock);
		statisticsCalculator.showStatistics();
		int usersNumber = statisticsCalculator.getNumberOfUsers();
		
		//Then
		assertEquals(namesOfUsersList.size(), usersNumber);
	}
}