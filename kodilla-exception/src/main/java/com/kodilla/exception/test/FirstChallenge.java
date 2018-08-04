package com.kodilla.exception.test;

public class FirstChallenge
{
	public double divide(double a, double b) throws ArithmeticException
	{
		try
		{
			if(b == 0)
			{
				throw new ArithmeticException();
			}
		}
		
		catch(ArithmeticException e)
		{
			System.out.println("One can never divide by zero when one feels an impulse to do so. " + "We have --- " + e +
					" --- here!!!");
		}
		
		finally
		{
			System.out.println("Just remember to never divide by zero.");
		}
		
		return a / b;
	}
	
	/**
	 * This main can throw an ArithmeticException!!!
	 * @param args
	 */
	
	public static void main(String[] args)
	{
		
		FirstChallenge firstChallenge = new FirstChallenge();
		
		double result = firstChallenge.divide(3, 0);
		
		System.out.println("BTW the result is: " + result);
		
	}
}