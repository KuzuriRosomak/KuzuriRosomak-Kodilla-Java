package com.kodilla.testing.shape;

import com.kodilla.testing.shape.ShapeCollector;
import org.junit.rules.TestName;
import org.junit.*;
import static org.junit.Assert.*;

public class ShapeCollectorTestSuite
{
	private static int testCounter = 0;
	
	@Rule
	public TestName nameOfTheTest = new TestName();
	
	@BeforeClass
	public static void beforeTestSuite()
	{
		System.out.println("Starting Test Suite for ShapeCollector Class.");
	}
	
	@AfterClass
	public static void afterTestSuite()
	{
		System.out.println("Test Suite for ShapeCollector Class is finished.");
	}
	
	@Before
	public void beforeTests()
	{
		testCounter++;
		System.out.println("Starting test number: " + testCounter + " named: " + nameOfTheTest.getMethodName());
	}
	
	@After
	public void afterTests()
	{
		System.out.println("Finishing test number: " + testCounter + " named: " + nameOfTheTest.getMethodName());
	}
	
	@Test
	public void testAddFigure()
	{
		//Given
		Square squareShape = new Square("Square", 5);
		ShapeCollector shapeCollectorObject = new ShapeCollector();
		
		//When
		shapeCollectorObject.addFigure(squareShape);
		
		//Then
		assertEquals(1, shapeCollectorObject.getShapes().size());
	}
	
	@Test
	public void testRemoveFigureNotExisting()
	{
		//Given
		Square squareShape = new Square("Square", 5);
		ShapeCollector shapeCollectorObject = new ShapeCollector();
		
		//When
		boolean result = shapeCollectorObject.removeFigure(squareShape);
		
		//Then
		assertFalse(result);
	}
	
	@Test
	public void testRemoveFigure()
	{
		//Given
		Square squareShape = new Square("Square", 5);
		ShapeCollector shapeCollectorObject = new ShapeCollector();
		shapeCollectorObject.addFigure(squareShape);
		
		//When
		boolean result = shapeCollectorObject.removeFigure(squareShape);
		
		//Then
		assertTrue(result);
		assertEquals(0, shapeCollectorObject.getShapes().size());
	}
	
	@Test
	public void testGetFigure()
	{
		//Given
		Square squareShape = new Square("Square", 5);
		ShapeCollector shapeCollectorObject = new ShapeCollector();
		shapeCollectorObject.addFigure(squareShape);
		
		//When
		Shape retrievedShape;
		retrievedShape = shapeCollectorObject.getFigure(0);
		
		//Then
		assertEquals(squareShape, retrievedShape);
	}
	
	@Test
	public void testShowFigures()
	{
		Square squareShape = new Square("Square", 5);
		Circle circleShape = new Circle("Circle", 7);
		Triangle triangleShape = new Triangle("Triangle", 4, 6);
		ShapeCollector shapeCollectorObject = new ShapeCollector();
		shapeCollectorObject.addFigure(squareShape);
		shapeCollectorObject.addFigure(circleShape);
		shapeCollectorObject.addFigure(triangleShape);
		
		//When
		String retrievedShapes;
		retrievedShapes = shapeCollectorObject.showFigures();
		
		//Then
		assertEquals("SquareCircleTriangle", retrievedShapes);
	}
}