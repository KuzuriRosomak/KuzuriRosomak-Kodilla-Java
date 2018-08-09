package com.kodilla.exception.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightSearchEngine
{
	public boolean findFlight(Flight flight) throws RouteNotFoundException
	{
		Boolean canFly;
		
		Map<String, Boolean> database = new HashMap<>();
		database.put("Melbourne", true);
		database.put("Warsaw", true);
		database.put("Berlin", true);
		database.put("Buenos Aires", true);
		database.put("Montreal", true);
		database.put("Wellington", true);
		database.put("Beijing", true);
		database.put("Moscow", false);
		
		if(!database.containsKey(flight.getArrivalAirport()) || database.get(flight.getArrivalAirport()) == false)
		{
			throw new RouteNotFoundException();
		}
		
		else
		{
			canFly = database.get(flight.getArrivalAirport());
			System.out.println("The chosen route is available: " + flight + "\n");
			
			return canFly;
		}
	}
}