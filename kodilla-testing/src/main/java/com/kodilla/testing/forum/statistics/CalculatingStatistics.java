package com.kodilla.testing.forum.statistics;

import java.lang.*;

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
	
	public void calculateAdvStatistics(Statistics statistics)
	{
		numberOfUsers = statistics.usersNames().size();
		numberOfPosts = statistics.postsCount();
		numberOfComments = statistics.commentsCount();
		if(numberOfUsers > 0)
		{
			avgNumberOfPostPerUser = numberOfPosts / numberOfUsers;
		}
		
		else
		{
			System.out.println("avgNumberOfPostPerUser can't be counted");
		}
		
		if(numberOfUsers > 0)
		{
			avgNumberOfCommentsPerUser = numberOfComments / numberOfUsers;
		}
		
		else
		{
			System.out.println("avgNumberOfCommentsPerUser can't be counted");
		}
		
		if(numberOfPosts > 0)
		{
			avgNumberOfCommentsPerPost = numberOfComments / numberOfPosts;
		}
		
		else
		{
			System.out.println("avgNumberOfCommentsPerPost can't be counted");
		}
	}
	
	public void showStatistics()
	{
		System.out.println("Forum currently has " + numberOfUsers + " users.");
		System.out.println("They published " + numberOfPosts + " posts.");
		System.out.println("Users commented " + numberOfComments + " times");
		System.out.println("Average number of posts per user is " + avgNumberOfPostPerUser);
		System.out.println("Average number of comments per user is " + avgNumberOfCommentsPerUser);
		System.out.println("Average number of comments per post is " + avgNumberOfCommentsPerPost);
	}
}
