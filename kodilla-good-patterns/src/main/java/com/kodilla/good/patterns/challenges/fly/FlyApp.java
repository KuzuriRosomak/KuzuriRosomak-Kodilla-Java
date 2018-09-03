package com.kodilla.good.patterns.challenges.fly;

public class FlyApp {
	public static void main(String[] args){
		FlightFinder flightFinder = new FlightFinder();
		flightFinder.search(DestinationsGenerator.generateDestinations(), "Warszawa");
		flightFinder.search("Białystok", DestinationsGenerator.generateDestinations());
		flightFinder.search(DestinationsGenerator.generateDestinations(), "Gdańsk",
				"Warszawa", "Kraków");
	}
}
