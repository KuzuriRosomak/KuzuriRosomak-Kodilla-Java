package com.kodilla.good.patterns.challenges.shop;

public class ProductSendingService {
	private User user;
		
	public ProductSendingService(User user) {
		this.user = user;
	}
	
	public String sendPackage(User user) {
		String sendingEtiquette = user.getName() + " " + user.getLastName()
					+ "\n" + user.getLogin()
					+ "\n" + user.getAddressStreet() + " " + user.getAddressStreetNumber()
					+ "\n" + user.getAddressZipCode() + " " + user.getAddressCity()
					+ "\n" + user.getAddressCountry();
		return sendingEtiquette;
	}
	
	public String sendPackage(String name, String lastName, String streetName, String streetNumber, String zipCode,
	                          String city, String country) {
		String sendingEtiquette = name + " " + lastName
				+ "\n" + streetName + " " + streetNumber
				+ "\n" + zipCode + " " + city
				+ "\n" + country;
		return sendingEtiquette;
	}
}