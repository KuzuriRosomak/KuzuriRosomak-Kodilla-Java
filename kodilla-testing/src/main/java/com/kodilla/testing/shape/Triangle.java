package com.kodilla.testing.shape;

public class Triangle implements Shape
{
	private String shapeName;
	private double altitude;
	private double base;
	
	public Triangle(String shapeName, double altitude, double base)
	{
		this.shapeName = shapeName;
		this.altitude = altitude;
		this.base = base;
	}
	
	public String getShapeName()
	{
		return shapeName;
	}
	
	public double getField()
	{
		return (((base * altitude) / 2) * 1.0);
	}
	
	@Override
	public boolean equals(Object o)
	{
		Triangle shapeTriangle = (Triangle) o;
		return shapeName.equals(shapeTriangle.shapeName) && (altitude == shapeTriangle.altitude) && (base == shapeTriangle.base);
	}
	
	@Override
	public int hashCode()
	{
		int result = (31 * shapeName.hashCode()) * 31;
		return result;
	}
	
	@Override
	public String toString()
	{
		return "" + shapeName;
	}
}