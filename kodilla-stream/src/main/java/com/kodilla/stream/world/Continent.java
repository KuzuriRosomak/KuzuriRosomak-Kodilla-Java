package com.kodilla.stream.world;

import java.util.HashSet;
import java.util.Set;

public final class Continent
{
	private final String continentName;
	private final Set<Country> continentCountries = new HashSet<>();
	
	public Continent(final String continentName)
	{
		this.continentName = continentName;
	}
	
	public void addCountry(Country country)
	{
		continentCountries.add(country);
	}
	
	public Set<Country> getContinentCountries()
	{
		return continentCountries;
	}
	
	@Override
	public int hashCode()
	{
		return continentName.hashCode();
	}
}