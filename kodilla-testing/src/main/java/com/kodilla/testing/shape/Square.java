package com.kodilla.testing.shape;

import java.lang.Math;

public class Square implements Shape
{
	private String shapeName;
	private double side;
	
	public Square(String shapeName, double side)
	{
		this.shapeName = shapeName;
		this.side = side;
	}
	
	public String getShapeName()
	{
		return shapeName;
	}
	
	public double getField()
	{
		return (Math.pow(side, 2) * 1.0);
	}
	
	@Override
	public boolean equals(Object o)
	{
		Square shapeSquare = (Square) o;
		return shapeName.equals(shapeSquare.shapeName) && (side == shapeSquare.side);
	}
	
	@Override
	public int hashCode()
	{
		int result = (31 * shapeName.hashCode()) * 31;
		return result;
	}
}