package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain
{
	public static void main(String[] args)
	{
		Forum theForum = new Forum();
		
		Map<Integer, ForumUser> mapOfForumUsers = theForum.getUserList().stream()
				.filter(theForumUser -> theForumUser.getSex() == 'M')
				.filter(theForumUser -> ((LocalDate.now().getYear()) - (theForumUser.getDateOfBirth().getYear())) >= 20)
				.filter(theForumUser -> theForumUser.getPostCount() >= 1)
				.collect(Collectors.toMap(ForumUser::getForumUserNumber, theForumUser -> theForumUser));
		
		mapOfForumUsers.entrySet().stream()
			.map(entry -> entry.getValue())
			.forEach(System.out::println);
	}
}