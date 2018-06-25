package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector
{
	private List<Shape> shapes = new ArrayList<Shape>();
	
	public ShapeCollector()
	{
	}
	
	public List<Shape> getShapes()
	{
		return shapes;
	}
	
	public void addFigure(Shape shape)
	{
		shapes.add(shape);
	}
	
	public boolean removeFigure(Shape shape)
	{
		boolean result = false;
		if(shapes.contains(shape))
		{
			shapes.remove(shape);
			result = true;
		}
		
		return result;
	}
	
	public Shape getFigure(int figureNumber)
	{
		Shape shape = null;
		if (figureNumber >= 0 && figureNumber < shapes.size())
		{
			shape = shapes.get(figureNumber);
		}
		return shape;
	}
	
	public String showFigures()
	{
		String nameOfTheShape = "";
		for(Shape shapeLoop: shapes)
		{
			nameOfTheShape += shapeLoop.getShapeName();
		}
		
		return nameOfTheShape;
	}
}