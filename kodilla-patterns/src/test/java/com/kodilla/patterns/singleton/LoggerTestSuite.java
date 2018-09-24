package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {
	
	@Test
	public void testGetLastLog1() {
		//Given
		String log1 = "Last login: 29-10-2006 16:45";
		Logger.getInstance().log(log1);
		
		//When
		String result1 = Logger.getInstance().getLastLog();
		
		//Then
		Assert.assertEquals("Last login: 29-10-2006 16:45", result1);
	}
	
	@Test
	public void testGetLastLog2() {
		//Given
		String log2 = "Last login: 29-10-2006 16:55";
		Logger.getInstance().log(log2);
		
		//When
		String result2 = Logger.getInstance().getLastLog();
		
		//Then
		Assert.assertEquals("Last login: 29-10-2006 16:55", result2);
	}
	
	@Test
	public void testGetLastLog3() {
		//Given
		String log3 = "Last login: 29-10-2006 16:59";
		Logger.getInstance().log(log3);
		
		//When
		String result3 = Logger.getInstance().getLastLog();
		
		//Then
		Assert.assertEquals("Last login: 29-10-2006 16:59", result3);
	}
	
	@Test
	public void testGetLastLog4() {
		//Given
		String log4 = "Last login: 29-10-2006 17:12";
		Logger.getInstance().log(log4);
		
		//When
		String result4 = Logger.getInstance().getLastLog();
		
		//Then
		Assert.assertEquals("Last login: 29-10-2006 17:12", result4);
	}
}