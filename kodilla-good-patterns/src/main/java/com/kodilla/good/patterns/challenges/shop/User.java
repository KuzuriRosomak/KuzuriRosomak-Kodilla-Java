package com.kodilla.good.patterns.challenges.shop;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class User {
	private String name;
	private String lastName;
	private String login;
	private long uniqueId;
	private String addressStreet;
	private String addressStreetNumber;
	private String addressApartmentNumber;
	private String addressZipCode;
	private String addressCity;
	private String addressCountry;
	private LocalDate birthDate;
	private boolean isEighteen;
	private LocalDateTime dateOfAccountCreation;
	private UserProductMap userProductMap;
	private Wallet wallet;
	
	public User(String name, String lastName, String login, String addressStreet, String addressStreetNumber,
	            String addressApartmentNumber, String addressZipCode, String addressCity, String addressCountry,
	            int yearOfBirth, int monthOfBirth, int dayOfBirth) {
		this.name = name;
		this.lastName = lastName;
		this.login = login;
		this.addressStreet = addressStreet;
		this.addressStreetNumber = addressStreetNumber;
		this.addressApartmentNumber = addressApartmentNumber;
		this.addressZipCode = addressZipCode;
		this.addressCity = addressCity;
		this.addressCountry = addressCountry;
		this.birthDate = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
		this.isEighteen = (ChronoUnit.DAYS.between(LocalDate.now(), birthDate.plusYears(18)) <= 0);
		this.dateOfAccountCreation = LocalDateTime.now();
		this.uniqueId = (Long.parseLong(dateOfAccountCreation.toString().replaceAll("[-T:.]","")))
				+ (Long.parseLong(birthDate.toString().replaceAll("[-]","")));
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
	
	public long getUniqueId() {
		return uniqueId;
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
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public boolean isEighteen() {
		return isEighteen;
	}
	
	public LocalDateTime getDateOfAccountCreation() {
		return dateOfAccountCreation;
	}
	
	public UserProductMap getUserProductMap() {
		return userProductMap;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof User))
			return false;
		User user = (User) o;
		return user.equals(user.uniqueId);
	}
	
	@Override
	public int hashCode() {
		String hashCodeTempString = (String.valueOf((Long.parseLong(dateOfAccountCreation.toString().
				replaceAll("[-T:.]", ""))) + (Long.parseLong(birthDate.toString()
				.replaceAll("[-]", "")))));
		String hashCodeTempString2 = hashCodeTempString.substring((hashCodeTempString.length()) - 8);
		int hashCodeTemp1 = (Integer.parseInt(hashCodeTempString2));
		if(hashCodeTemp1 <= 0) {
			hashCodeTemp1 = (hashCodeTemp1 * (-1));
		}
		return hashCodeTemp1;
	}
	
	@Override
	public String toString() {
		return "User account: \n" + "Your login is: " + login + "\n" + "Your name and last name are: " + name + " "
				+ lastName + "\n" + "Your address is:\n" + addressStreet + " " + addressStreetNumber + "\n"
				+ addressZipCode + " " + addressCity + "\n" + addressCountry + "\n" + "Your date of birth is: " +
				birthDate + "\n" + "Your service wallet balance is: " + wallet + " PLN" + "\n" +
				"Your account havebeen created on: " + dateOfAccountCreation;
	}
}