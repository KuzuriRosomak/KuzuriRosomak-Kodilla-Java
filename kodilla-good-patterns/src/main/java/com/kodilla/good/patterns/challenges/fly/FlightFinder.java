package com.kodilla.good.patterns.challenges.fly;

import java.util.List;
import java.util.stream.Collectors;

public class FlightFinder {
	
	public List<Destination> search(List<Destination> listOfDestinations, String departureCity) {
		List<Destination> listOfFlightsFromSpecifiedCity =
				listOfDestinations.stream()
				.filter(a -> a.getDepartureCity() == departureCity)
				.collect(Collectors.toList());
		System.out.println(listOfFlightsFromSpecifiedCity);
		return listOfFlightsFromSpecifiedCity;
	}
	
	public List<Destination> search(String arrivalCity, List<Destination> listOfDestinations) {
		List<Destination> listOfFlightsToSpecifiedCity =
		listOfDestinations.stream()
				.filter(a -> a.getArrivalCity() == arrivalCity)
				.collect(Collectors.toList());
		System.out.println(listOfFlightsToSpecifiedCity);
		return listOfFlightsToSpecifiedCity;
	}
	
	public List<Destination> search(List<Destination> listOfDestinations, String departureCity,
	                                String arrivalCity, String stopoverCity) {
		List<Destination> listOfFlightsThroughSpecifiedCity =
				listOfDestinations.stream()
						.filter(a -> a.getDepartureCity() == departureCity || a.getDepartureCity() == stopoverCity)
						.filter(b -> b.getArrivalCity() == stopoverCity || b.getArrivalCity() == arrivalCity)
						.collect(Collectors.toList());
		System.out.println(listOfFlightsThroughSpecifiedCity);
		return listOfFlightsThroughSpecifiedCity;
	}
}