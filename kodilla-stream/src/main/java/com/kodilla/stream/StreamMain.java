package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain
{
	public static void main(String[] args)
	{
		ExpressionExecutor expressionExecutor = new ExpressionExecutor();
		
		System.out.println("Calculating expressions with lambdas");
		expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
		expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
		expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
		expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
		
		System.out.println("Calculating expressions with method references");
		expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
		expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
		expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
		expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);
		
		System.out.println("\nBeautifying text");
		PoemBeautifier poemBeautifier = new PoemBeautifier();
		poemBeautifier.beautify("Bowna", (text) -> "ABC" + text + "XYZ");
		poemBeautifier.beautify("London", (text) -> text.toUpperCase());
		poemBeautifier.beautify("Poland", (text) -> new StringBuffer(text).reverse().toString());
		poemBeautifier.beautify("RAGNAR", (text) -> text.toLowerCase());
		poemBeautifier.beautify("trader", (text) -> text.replaceFirst("der", "itor"));
		
		System.out.println("\nUsing Stream to generate even numbers from 1 to 20");
		NumbersGenerator.generateEven(20);
	}
}