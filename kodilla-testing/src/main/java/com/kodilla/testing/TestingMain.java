package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain
{
	public static void main(String[] args)
	{
		Calculator calculatingMachine = new Calculator();
		
		int result1 = calculatingMachine.add(30, 25);
		
		if(result1 == 55)
		{
			System.out.println("Test 1 - adding - result: Positive");
		}
		
		else
		{
			System.out.println("Test 1 - adding - result: Negative");
		}
		
		
		int result2 = calculatingMachine.subtract(100, 40);
		
		if(result2 == 60)
		{
			System.out.println("Test 2 - subtracting - result: Positive");
		}
		
		else
		{
			System.out.println("Test 2 - subtracting - result: Negative");
		}
	}
}