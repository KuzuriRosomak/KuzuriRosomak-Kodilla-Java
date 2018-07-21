package com.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations
{
	static double getAverage(int[] numbers)
	{
		IntStream.range(0, numbers.length)
				.map(n -> numbers[n])
				.forEach(s -> System.out.println(s));
		
		OptionalDouble average = IntStream.range(0, numbers.length)
				.map(n -> numbers[n])
				.average();
		
		return average.getAsDouble();
	}
}