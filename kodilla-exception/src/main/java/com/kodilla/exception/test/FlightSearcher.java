package com.kodilla.exception.test;

public class FlightSearcher
{
	public static void main(String[] args)
	{
		FlightSearchEngine flightSearchEngine = new FlightSearchEngine();
		Flight flight1 = new Flight("Melbourne, Australia - MEL", "Warsaw, Poland - WAW");
		Flight flight2 = new Flight("Berlin, Germany - BER", "Buenos Aires, Argentina - AEP");
		Flight flight3 = new Flight("Montreal, Canada - YUL", "Wellington, New Zealand - WLG");
		Flight flight4 = new Flight("Beijing, China - PEK", "Moscow, Russia - SVO");
		Flight flight5 = new Flight("Wroclaw, Poland - WRO", "Paris, France - CDG");
		
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
			System.out.println("\n" + "The route you looking for is not existing. Change input data");
		}
	}
}