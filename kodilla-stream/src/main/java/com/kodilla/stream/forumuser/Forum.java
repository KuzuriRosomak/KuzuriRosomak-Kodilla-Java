package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum
{
	private final List<ForumUser> userList = new ArrayList<>();
	
	public Forum()
	{
		userList.add(new ForumUser(1, "Michael Butler", 'M',
				1954, 6, 1, 2));
		userList.add(new ForumUser(2, "Michel Obama", 'F',
				1975, 12, 13, 0));
		userList.add(new ForumUser(3, "Anna Michaels", 'F',
				2001, 1, 31, 156));
		userList.add(new ForumUser(4, "Terry Newmack", 'M',
				1965, 3, 29, 315));
		userList.add(new ForumUser(5, "Bart McCoy", 'M',
				1989, 4, 15, 0));
		userList.add(new ForumUser(6, "Troy Vitky", 'M',
				2004, 7, 15, 67));
		userList.add(new ForumUser(7, "Suzanne Tripod", 'F',
				1985, 11, 13, 89));
		userList.add(new ForumUser(8, "Tracy Bactrian", 'F',
				1993, 12, 14, 24));
		userList.add(new ForumUser(9, "Loretta Nigs", 'F',
				2002, 1, 22, 75));
		userList.add(new ForumUser(10, "Michael Tarkovsky", 'M',
				2002, 4, 9, 198));
	}
	
	public List<ForumUser> getUserList()
	{
		return new ArrayList<>(userList);
	}
}