package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public final class World
{
	private final Set<Continent> world = new HashSet<>();
	
	public void addContinent(Continent continent)
	{
		world.add(continent);
	}
	
	public Set<Continent> getWorld()
	{
		return world;
	}
	
	public BigDecimal getPeopleQuantity()
	{
		BigDecimal quantityOfPeople = world.stream()
				.flatMap(continent -> continent.getContinentCountries().stream())
				.map(Country::getPeopleQuantity)
				.reduce(BigDecimal.ZERO, (sum, currentValue) -> sum = sum.add(currentValue));
		
		return quantityOfPeople;
	}
	
	@Override
	public int hashCode()
	{
		return world.hashCode();
	}
}