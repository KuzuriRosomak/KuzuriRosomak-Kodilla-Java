package com.kodilla.good.patterns.challenges.fly;

public class FlyApp {
	public static void main(String[] args){
		FlightFinder flightFinder = new FlightFinder();
		//flightFinder.search(DestinationsGenerator.generateDestinations(), "Warszawa");
		//flightFinder.search("Białystok", DestinationsGenerator.generateDestinations());
		System.out.println(flightFinder.search(DestinationsGenerator.generateDestinations(), "Gdańsk", "Warszawa"));
	}
}