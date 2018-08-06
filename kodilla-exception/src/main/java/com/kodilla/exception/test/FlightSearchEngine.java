package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearchEngine
{
	public boolean findFlight(Flight flight) throws RouteNotFoundException
	{
		Boolean canFly;
		
		Map<String, Boolean> database = new HashMap<>();
		database.put("Melbourne, Australia - MEL", true);
		database.put("Warsaw, Poland - WAW", true);
		database.put("Berlin, Germany - BER", true);
		database.put("Buenos Aires, Argentina - AEP", true);
		database.put("Montreal, Canada - YUL", true);
		database.put("Wellington, New Zealand - WLG", true);
		database.put("Beijing, China - PEK", true);
		database.put("Moscow, Russia - SVO", true);
		
		Map<String, String> catcher = new HashMap<>();
		
		if(!database.containsKey(flight.getDepartureAirport()) && !database.containsKey(flight.getArrivalAirport()))
		{
			catcher.put(flight.getDepartureAirport(), flight.getArrivalAirport());
			System.out.println(catcher.entrySet());
			throw new RouteNotFoundException();
		}
		
		else
		{
			canFly = database.get(flight.getDepartureAirport());
			System.out.println("The chosen route is available: " + flight + "\n");
			
			return canFly;
		}
	}
}