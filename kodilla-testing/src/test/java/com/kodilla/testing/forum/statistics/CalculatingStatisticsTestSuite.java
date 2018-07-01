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
		for (int n=0; n<12436; n++)
		{
			namesOfUsersList.add(String.valueOf(theGenerator.nextInt(1000000)));
		}
		when(statisticsMock.usersNames()).thenReturn(namesOfUsersList);
		
		int posts = 0;
		when(statisticsMock.postsCount()).thenReturn(posts);
		
		int comments = 72464;
		when(statisticsMock.commentsCount()).thenReturn(comments);
		
		CalculatingStatistics statisticsCalculator = new CalculatingStatistics();
		
		//When
		statisticsCalculator.calculateAdvStatistics(statisticsMock);
		statisticsCalculator.showStatistics();
		double averagePostsUser = statisticsCalculator.getAvgNumberOfPostPerUser();
		double averageCommentsUser = statisticsCalculator.getAvgNumberOfCommentsPerUser();
		double averageCommentsPost = statisticsCalculator.getAvgNumberOfCommentsPerPost();
		
		//Then
		assertEquals(0, averagePostsUser, 0);
		assertEquals(5.827, averageCommentsUser, 0);
		assertEquals(0, averageCommentsPost, 0);
	}
	
	@Test
	public void testCalculateAdvStatisticsNumberOfPosts1000()
	{
		//Given
		Statistics statisticsMock = mock(Statistics.class);
		
		List<String> namesOfUsersList = new ArrayList<String>();
		Random theGenerator = new Random();
		for (int n=0; n<124; n++)
		{
			namesOfUsersList.add(String.valueOf(theGenerator.nextInt(1000000)));
		}
		when(statisticsMock.usersNames()).thenReturn(namesOfUsersList);
		
		int posts = 1000;
		when(statisticsMock.postsCount()).thenReturn(posts);
		
		int comments = 32543;
		when(statisticsMock.commentsCount()).thenReturn(comments);
		
		CalculatingStatistics statisticsCalculator = new CalculatingStatistics();
		
		//When
		statisticsCalculator.calculateAdvStatistics(statisticsMock);
		statisticsCalculator.showStatistics();
		double averagePostsUser = statisticsCalculator.getAvgNumberOfPostPerUser();
		double averageCommentsUser = statisticsCalculator.getAvgNumberOfCommentsPerUser();
		double averageCommentsPost = statisticsCalculator.getAvgNumberOfCommentsPerPost();
		
		//Then
		assertEquals(8.065, averagePostsUser, 0);
		assertEquals(262.444, averageCommentsUser, 0);
		assertEquals(32.543, averageCommentsPost, 0);
	}
	
	@Test
	public void testCalculateAdvStatisticsNumberOfComments0()
	{
		//Given
		Statistics statisticsMock = mock(Statistics.class);
		
		List<String> namesOfUsersList = new ArrayList<String>();
		Random theGenerator = new Random();
		for (int n=0; n<72654; n++)
		{
			namesOfUsersList.add(String.valueOf(theGenerator.nextInt(1000000)));
		}
		when(statisticsMock.usersNames()).thenReturn(namesOfUsersList);
		
		int posts = 6789642;
		when(statisticsMock.postsCount()).thenReturn(posts);
		
		int comments = 0;
		when(statisticsMock.commentsCount()).thenReturn(comments);
		
		CalculatingStatistics statisticsCalculator = new CalculatingStatistics();
		
		//When
		statisticsCalculator.calculateAdvStatistics(statisticsMock);
		statisticsCalculator.showStatistics();
		double averagePostsUser = statisticsCalculator.getAvgNumberOfPostPerUser();
		double averageCommentsUser = statisticsCalculator.getAvgNumberOfCommentsPerUser();
		double averageCommentsPost = statisticsCalculator.getAvgNumberOfCommentsPerPost();
		
		//Then
		assertEquals(93.452, averagePostsUser, 0);
		assertEquals(0, averageCommentsUser, 0);
		assertEquals(0, averageCommentsPost, 0);
	}
	
	@Test
	public void testCalculateAdvStatisticsNumberOfCommentsIsLowerThanNumberOfPosts()
	{
		//Given
		Statistics statisticsMock = mock(Statistics.class);
		
		List<String> namesOfUsersList = new ArrayList<String>();
		Random theGenerator = new Random();
		for (int n=0; n<7354; n++)
		{
			namesOfUsersList.add(String.valueOf(theGenerator.nextInt(1000000)));
		}
		when(statisticsMock.usersNames()).thenReturn(namesOfUsersList);
		
		int posts = 985432;
		when(statisticsMock.postsCount()).thenReturn(posts);
		
		int comments = 7658;
		when(statisticsMock.commentsCount()).thenReturn(comments);
		
		CalculatingStatistics statisticsCalculator = new CalculatingStatistics();
		
		//When
		statisticsCalculator.calculateAdvStatistics(statisticsMock);
		statisticsCalculator.showStatistics();
		double averagePostsUser = statisticsCalculator.getAvgNumberOfPostPerUser();
		double averageCommentsUser = statisticsCalculator.getAvgNumberOfCommentsPerUser();
		double averageCommentsPost = statisticsCalculator.getAvgNumberOfCommentsPerPost();
		
		//Then
		assertEquals(133.999, averagePostsUser, 0);
		assertEquals(1.041, averageCommentsUser, 0);
		assertEquals(0.008, averageCommentsPost, 0);
	}
	
	@Test
	public void testCalculateAdvStatisticsNumberOfCommentsIsBiggerThanNumberOfPosts()
	{
		//Given
		Statistics statisticsMock = mock(Statistics.class);
		
		List<String> namesOfUsersList = new ArrayList<String>();
		Random theGenerator = new Random();
		for (int n=0; n<8239098; n++)
		{
			namesOfUsersList.add(String.valueOf(theGenerator.nextInt(1000000)));
		}
		when(statisticsMock.usersNames()).thenReturn(namesOfUsersList);
		
		int posts = 32765769;
		when(statisticsMock.postsCount()).thenReturn(posts);
		
		int comments = 44872004;
		when(statisticsMock.commentsCount()).thenReturn(comments);
		
		CalculatingStatistics statisticsCalculator = new CalculatingStatistics();
		
		//When
		statisticsCalculator.calculateAdvStatistics(statisticsMock);
		statisticsCalculator.showStatistics();
		double averagePostsUser = statisticsCalculator.getAvgNumberOfPostPerUser();
		double averageCommentsUser = statisticsCalculator.getAvgNumberOfCommentsPerUser();
		double averageCommentsPost = statisticsCalculator.getAvgNumberOfCommentsPerPost();
		
		//Then
		assertEquals(3.977, averagePostsUser, 0);
		assertEquals(5.446, averageCommentsUser, 0);
		assertEquals(1.369, averageCommentsPost, 0);
	}
	
	@Test
	public void testCalculateAdvStatisticsNumberOfUsers0()
	{
		//Given
		Statistics statisticsMock = mock(Statistics.class);
		
		List<String> namesOfUsersList = new ArrayList<String>();
		
		when(statisticsMock.usersNames()).thenReturn(namesOfUsersList);
		
		int posts = 4567823;
		when(statisticsMock.postsCount()).thenReturn(posts);
		
		int comments = 9898765;
		when(statisticsMock.commentsCount()).thenReturn(comments);
		
		CalculatingStatistics statisticsCalculator = new CalculatingStatistics();
		
		//When
		statisticsCalculator.calculateAdvStatistics(statisticsMock);
		statisticsCalculator.showStatistics();
		double averagePostsUser = statisticsCalculator.getAvgNumberOfPostPerUser();
		double averageCommentsUser = statisticsCalculator.getAvgNumberOfCommentsPerUser();
		double averageCommentsPost = statisticsCalculator.getAvgNumberOfCommentsPerPost();
		
		//Then
		assertEquals(0, averagePostsUser, 0);
		assertEquals(0, averageCommentsUser, 0);
		assertEquals(2.167, averageCommentsPost, 0);
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
			namesOfUsersList.add(String.valueOf(theGenerator.nextInt(1000000)));
		}
		when(statisticsMock.usersNames()).thenReturn(namesOfUsersList);
		
		int posts = 87643;
		when(statisticsMock.postsCount()).thenReturn(posts);
		
		int comments = 245775;
		when(statisticsMock.commentsCount()).thenReturn(comments);
		
		CalculatingStatistics statisticsCalculator = new CalculatingStatistics();
		
		//When
		statisticsCalculator.calculateAdvStatistics(statisticsMock);
		statisticsCalculator.showStatistics();
		double averagePostsUser = statisticsCalculator.getAvgNumberOfPostPerUser();
		double averageCommentsUser = statisticsCalculator.getAvgNumberOfCommentsPerUser();
		double averageCommentsPost = statisticsCalculator.getAvgNumberOfCommentsPerPost();
		
		//Then
		assertEquals(876.43, averagePostsUser, 0);
		assertEquals(2457.75, averageCommentsUser, 0);
		assertEquals(2.804, averageCommentsPost, 0);
	}
}