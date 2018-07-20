package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country
{
	private final String countryName;
	private final BigDecimal peopleQuantity;
	
	public Country(final String countryName, final BigDecimal peopleQuantity)
	{
		this.countryName = countryName;
		this.peopleQuantity = peopleQuantity;
	}
	
	public BigDecimal getPeopleQuantity()
	{
		return peopleQuantity;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Country)) return false;
		Country country = (Country) o;
		return country.equals(country.countryName);
	}
}