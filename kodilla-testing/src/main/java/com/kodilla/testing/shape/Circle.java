package com.kodilla.testing.shape;

import java.lang.Math;

public class Circle implements Shape
{
	private String shapeName;
	private double radius;
	
	public Circle(String shapeName, double radius)
	{
		this.shapeName = shapeName;
		this.radius = radius;
	}
	
	public String getShapeName()
	{
		return shapeName;
	}
	
	public double getField()
	{
		return ((Math.PI*(Math.pow(radius, 2))) * 1.0);
	}
	
	@Override
	public boolean equals(Object o)
	{
		Circle shapeCircle = (Circle) o;
		return shapeName.equals(shapeCircle.shapeName) && (radius == shapeCircle.radius);
	}
	
	@Override
	public int hashCode()
	{
		int result = (31 * shapeName.hashCode()) * 31;
		return result;
	}
}