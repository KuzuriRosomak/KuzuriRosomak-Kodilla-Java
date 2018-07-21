package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite
{
	@Test
	public void testGetAverage()
	{
		//Given
		//When
		int[] arrayExample = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 32, 52, 62, 138, 197, 531, 1021, 1837, 1999, 2018};
		
		//Then
		double averageToCheck = ArrayOperations.getAverage(arrayExample);
		
		Assert.assertEquals(397.1, averageToCheck, 0);
	}
}