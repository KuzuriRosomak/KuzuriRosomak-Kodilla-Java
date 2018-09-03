package com.kodilla.good.patterns.challenges.fly;

import java.util.*;
import java.util.stream.Collectors;

public class FlightFinder {
	
	public List<Destination> search(List<Destination> listOfDestinations, String departureCity) {
		List<Destination> listOfFlightsFromSpecifiedCity = listOfDestinations.stream()
				.filter(a -> a.getDepartureCity().equals(departureCity))
				.collect(Collectors.toList());
		return listOfFlightsFromSpecifiedCity;
	}
	
	public List<Destination> search(String arrivalCity, List<Destination> listOfDestinations) {
		List<Destination> listOfFlightsToSpecifiedCity = listOfDestinations.stream()
				.filter(a -> a.getArrivalCity().equals(arrivalCity))
				.collect(Collectors.toList());
		return listOfFlightsToSpecifiedCity;
	}
	
	public List<Destination> search(List<Destination> listOfDestinations, String departureCity, String arrivalCity) {
		List<Destination> listOfFlightsThroughSpecifiedCity = new ArrayList<>();
		
		List<Destination> tempList = search(listOfDestinations, departureCity);
		List<Destination> tempList2 = search(arrivalCity, listOfDestinations);
		for(Destination departure : tempList) {
			for(Destination arrival : tempList2) {
				if(departure.getArrivalCity().equals(arrival.getDepartureCity())) {
					listOfFlightsThroughSpecifiedCity.add(departure);
					listOfFlightsThroughSpecifiedCity.add(arrival);
				}
			}
		}
		return listOfFlightsThroughSpecifiedCity;
	}
}