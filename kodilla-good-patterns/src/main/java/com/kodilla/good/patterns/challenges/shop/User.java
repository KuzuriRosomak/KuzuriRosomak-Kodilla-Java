package com.kodilla.good.patterns.challenges.shop;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

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
	private LocalDateTime dateOfAccountCreation;
	private double accountBalance;
	private boolean isEighteen;
	private Map<String, Product> userProductMap;
	
	public User(String name, String lastName, String login, String addressStreet, String addressStreetNumber,
	            String addressApartmentNumber, String addressZipCode, String addressCity, String addressCountry,
	            int dayOfBirth, int monthOfBirth, int yearOfBirth, double accountBalance) {
		
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
		this.dateOfAccountCreation = LocalDateTime.now();
		this.accountBalance = accountBalance;
		this.isEighteen = (ChronoUnit.DAYS.between(LocalDate.now(), birthDate.plusYears(18)) <= 0);
		long uniqueIdRepository = (Long.parseLong(dateOfAccountCreation.toString().replaceAll("[-T:.]","")))
				+ (Long.parseLong(birthDate.toString().replaceAll("[-]","")));
		if(uniqueIdRepository <= 0) {
			uniqueIdRepository = (uniqueIdRepository * (-1));
		}
		this.uniqueId = uniqueIdRepository;
		this.userProductMap = new HashMap<>();
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
	
	public LocalDateTime getDateOfAccountCreation() {
		return dateOfAccountCreation;
	}
	
	public double getAccountBalance() {
		return accountBalance;
	}
	
	public boolean isEighteen() {
		return isEighteen;
	}
	
	public Map<String, Product> getUserProductMap() {
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
				birthDate + "\n" + "Your service wallet balance is: " + accountBalance + " PLN" + "\n" +
				"Your account have been created on: " + dateOfAccountCreation;
	}
}