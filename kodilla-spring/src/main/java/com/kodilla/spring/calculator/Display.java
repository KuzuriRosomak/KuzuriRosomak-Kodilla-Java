package com.kodilla.spring.calculator;

import org.springframework.stereotype.Service;

@Service
public class Display {
	
	public void displayValue(double val) {
		System.out.println("The counted value is: " + val);
	}
}