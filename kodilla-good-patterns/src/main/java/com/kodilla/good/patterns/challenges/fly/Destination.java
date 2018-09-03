package com.kodilla.good.patterns.challenges.fly;

public class Destination {
	
	private String departureCity;
	private String arrivalCity;
	
	public Destination(String departureCity, String arrivalCity) {
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
	}
	
	public String getDepartureCity() {
		return departureCity;
	}
	
	public String getArrivalCity() {
		return arrivalCity;
	}
	
	@Override
	public String toString() {
		return "\nFlight: " + departureCity + " - " + arrivalCity;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof Destination)) return false;
		Destination destination = (Destination) o;
		return arrivalCity.equals(destination.arrivalCity) && departureCity.equals(destination.departureCity);
	}
	
	@Override
	public int hashCode() {
		return arrivalCity.hashCode() * departureCity.hashCode();
	}
}