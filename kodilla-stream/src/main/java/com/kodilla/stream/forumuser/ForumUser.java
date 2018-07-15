package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser
{
	private final int forumUserNumber;
	private final String forumUserName;
	private final char sex;
	private final LocalDate dateOfBirth;
	private final int postCount;
	
	public ForumUser(final int forumUserNumber, final String forumUserName, final char sex, final int yearOfBirth,
	                 final int monthOfBirth, final int dayOfBirth, final int postCount)
	{
		this.forumUserNumber = forumUserNumber;
		this.forumUserName = forumUserName;
		this.sex = sex;
		this.dateOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
		this.postCount = postCount;
	}
	
	public int getForumUserNumber()
	{
		return forumUserNumber;
	}
	
	public String getForumUserName()
	{
		return forumUserName;
	}
	
	public char getSex()
	{
		return sex;
	}
	
	public LocalDate getDateOfBirth()
	{
		return dateOfBirth;
	}
	
	public int getPostCount()
	{
		return postCount;
	}
	
	@Override
	public String toString()
	{
		return "Forum User number: " + forumUserNumber + " User name: " + forumUserName + " User sex: " + sex +
				" User birth date: " + dateOfBirth + " Number of posts posted by User: " + postCount;
	}
}