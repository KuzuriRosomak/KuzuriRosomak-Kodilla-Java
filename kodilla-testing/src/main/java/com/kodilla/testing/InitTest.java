package com.kodilla.testing;

public class InitTest
{
	public InitTest()
	{
		s1 = print("1");
	}
	
	static String s1 = print("a");
	
	String s3 = print("2");
	{
		s1 = print("3");
	}
	
	static
	
	{
		s1 = print("b");
	}
	
	static String s2 = print("c");
	
	String s4 = print("4");
	
	public static void main(String args[])
	{
		InitTest it = new InitTest();
	}
	private static String print(String s)
	{
		System.out.println(s);  return s;
	}
}
