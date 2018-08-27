package com.kodilla.good.patterns.challenges.food2door;

public class Client {
	private String name;
	private String lastName;
	private String login;
	private String addressStreet;
	private String addressStreetNumber;
	private String addressApartmentNumber;
	private String addressZipCode;
	private String addressCity;
	private String addressCountry;
	private double accountBalance;
	
	public Client(String name, String lastName, String login, String addressStreet, String addressStreetNumber,
	              String addressApartmentNumber, String addressZipCode, String addressCity, String addressCountry,
	              double accountBalance) {
		this.name = name;
		this.lastName = lastName;
		this.login = login;
		this.addressStreet = addressStreet;
		this.addressStreetNumber = addressStreetNumber;
		this.addressApartmentNumber = addressApartmentNumber;
		this.addressZipCode = addressZipCode;
		this.addressCity = addressCity;
		this.addressCountry = addressCountry;
		this.accountBalance = accountBalance;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getAddressStreet() {
		return addressStreet;
	}
	
	public String getAddressStreetNumber() {
		return addressStreetNumber;
	}
	
	public String getAddressApartmentNumber() {
		return addressApartmentNumber;
	}
	
	public String getAddressZipCode() {
		return addressZipCode;
	}
	
	public String getAddressCity() {
		return addressCity;
	}
	
	public String getAddressCountry() {
		return addressCountry;
	}
	
	public double getAccountBalance() {
		return accountBalance;
	}
}