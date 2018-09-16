package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
	
	@Test
	public void testCalculations() {
		//Given
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.kodilla.spring");
		Calculator calculator = context.getBean(Calculator.class);
		
		//When
		double addResult = calculator.add(2, 4);
		double subResult = calculator.sub(15, 6);
		double mulResult = calculator.mul(6, 6);
		double divResult = calculator.div(80, 10);
		
		//Then
		Assert.assertEquals(addResult, 6, 0);
		Assert.assertEquals(subResult, 9, 0);
		Assert.assertEquals(mulResult, 36, 0);
		Assert.assertEquals(divResult, 8, 0);
	}
}