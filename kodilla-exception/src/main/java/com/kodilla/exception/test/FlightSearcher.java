package com.kodilla.exception.test;

public class FlightSearcher
{
	public static void main(String[] args)
	{
		FlightSearchEngine flightSearchEngine = new FlightSearchEngine();
		Flight flight1 = new Flight("Melbourne", "Warsaw");
		Flight flight2 = new Flight("Berlin", "Buenos Aires");
		Flight flight3 = new Flight("Montreal", "Wellington");
		Flight flight4 = new Flight("Beijing", "Moscow");
		Flight flight5 = new Flight("Wroclaw", "Paris");
		
		try
		{
			flightSearchEngine.findFlight(flight1);
			flightSearchEngine.findFlight(flight2);
			flightSearchEngine.findFlight(flight3);
			flightSearchEngine.findFlight(flight4);
			flightSearchEngine.findFlight(flight5);
		}
		
		catch(RouteNotFoundException e)
		{
			System.out.println("\n" + "The route you looking for is not existing because departure airport is closed. " +
					"Change input data and don't use diacritical signs.");
		}
	}
}