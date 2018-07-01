package com.kodilla.testing.forum.statistics;

import java.lang.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatingStatistics
{
	private int numberOfUsers;
	private int numberOfPosts;
	private int numberOfComments;
	private double avgNumberOfPostPerUser;
	private double avgNumberOfCommentsPerUser;
	private double avgNumberOfCommentsPerPost;
	
	public int getNumberOfUsers()
	{
		return numberOfUsers;
	}
	
	public int getNumberOfPosts()
	{
		return numberOfPosts;
	}
	
	public int getNumberOfComments()
	{
		return numberOfComments;
	}
	
	public double getAvgNumberOfPostPerUser()
	{
		return avgNumberOfPostPerUser;
	}
	
	public double getAvgNumberOfCommentsPerUser()
	{
		return avgNumberOfCommentsPerUser;
	}
	
	public double getAvgNumberOfCommentsPerPost()
	{
		return avgNumberOfCommentsPerPost;
	}
	
	public void calculateAdvStatistics(Statistics statistics)
	{
		numberOfUsers = statistics.usersNames().size();
		numberOfPosts = statistics.postsCount();
		numberOfComments = statistics.commentsCount();
		
		double users = getNumberOfUsers();
		double posts = getNumberOfPosts();
		double comments = getNumberOfComments();
		
		if(numberOfUsers > 0)
		{
			avgNumberOfPostPerUser = posts / users;
			
			BigDecimal avgNumberOfPostsPerUserBigDecimal = new BigDecimal(avgNumberOfPostPerUser);
			avgNumberOfPostsPerUserBigDecimal = avgNumberOfPostsPerUserBigDecimal.setScale(3, RoundingMode.HALF_UP);
			avgNumberOfPostPerUser = avgNumberOfPostsPerUserBigDecimal.doubleValue();
		}
		
		else
		{
			System.out.println("avgNumberOfPostPerUser can't be counted");
		}
		
		if(numberOfUsers > 0)
		{
			avgNumberOfCommentsPerUser = comments / users;
			
			BigDecimal avgNumberOfCommentsPerUserBigDecimal = new BigDecimal(avgNumberOfCommentsPerUser);
			avgNumberOfCommentsPerUserBigDecimal = avgNumberOfCommentsPerUserBigDecimal.setScale(3, RoundingMode.HALF_UP);
			avgNumberOfCommentsPerUser = avgNumberOfCommentsPerUserBigDecimal.doubleValue();
		}
		
		else
		{
			System.out.println("avgNumberOfCommentsPerUser can't be counted");
		}
		
		if(numberOfPosts > 0)
		{
			avgNumberOfCommentsPerPost = comments / posts;
			
			BigDecimal avgNumberOfCommentsPerPostBigDecimal = new BigDecimal(avgNumberOfCommentsPerPost);
			avgNumberOfCommentsPerPostBigDecimal = avgNumberOfCommentsPerPostBigDecimal.setScale(3, RoundingMode.HALF_UP);
			avgNumberOfCommentsPerPost = avgNumberOfCommentsPerPostBigDecimal.doubleValue();
		}
		
		else
		{
			System.out.println("avgNumberOfCommentsPerPost can't be counted");
		}
	}
	
	public void showStatistics()
	{
		System.out.println("Forum currently has " + getNumberOfUsers() + " users.");
		System.out.println("They published " + getNumberOfPosts() + " posts.");
		System.out.println("Users commented " + getNumberOfComments() + " times.");
		System.out.println("Average number of posts per user is " + getAvgNumberOfPostPerUser() + ".");
		System.out.println("Average number of comments per user is " + getAvgNumberOfCommentsPerUser() + ".");
		System.out.println("Average number of comments per post is " + getAvgNumberOfCommentsPerPost() + ".");
	}
}
