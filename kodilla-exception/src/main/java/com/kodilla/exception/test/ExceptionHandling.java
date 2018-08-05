package com.kodilla.exception.test;

public class ExceptionHandling
{
	public static void main(String args[])
	{
		SecondChallenge secondChallenge = new SecondChallenge();
		
		try
		{
			secondChallenge.probablyIWillThrowException(1, 1.5);
		}
		
		catch(Exception e)
		{
			System.out.println("The exception: --- " + e + " --- has been thrown!");
		}
		
		finally
		{
			System.out.println("It was obvious that exception will occurred or it wasn't.");
		}
	}
}