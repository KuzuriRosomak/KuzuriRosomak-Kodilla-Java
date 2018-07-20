package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite
{
	@Test
	public void testGetPeopleQuantity()
	{
		//Given
		Country germany = new Country("Germany", new BigDecimal("82740900"));
		Country france = new Country("France", new BigDecimal("67247000"));
		Country unitedKingdom = new Country( "United Kingdom", new BigDecimal("66040229"));
		Country italy = new Country("Italy", new BigDecimal("60483973"));
		
		Country china = new Country("China", new BigDecimal("1393040000"));
		Country india = new Country("India", new BigDecimal("1334570000"));
		Country indonesia = new Country("Indonesia", new BigDecimal("265015300"));
		Country pakistan = new Country("Pakistan", new BigDecimal("212302000"));
		
		Country nigeria = new Country("Nigeria", new BigDecimal("193392517"));
		Country ethiopia = new Country("Ethiopia", new BigDecimal("107534882"));
		Country egypt = new Country("Egypt", new BigDecimal("97323300"));
		Country dRCongo = new Country("Democratic Republic of the Congo", new BigDecimal("84004989"));
		
		Country australiaCountry = new Country("Australia", new BigDecimal("25003100"));
		Country papuaNewGuinea = new Country("Papua New Guinea", new BigDecimal("8558800"));

		
		Country uSA = new Country("USA", new BigDecimal("327510000"));
		Country mexico = new Country("Mexico", new BigDecimal("124737789"));
		Country canada = new Country("Canada", new BigDecimal("37169700"));
		Country guatemala = new Country("Guatemala", new BigDecimal("17245346"));
		
		Country brazil = new Country("Brazil", new BigDecimal("209337000"));
		Country colombia = new Country("Colombia", new BigDecimal("49862100"));
		Country argentina = new Country("Argentina", new BigDecimal("44494502"));
		Country venezuela = new Country("Venezuela", new BigDecimal("31828110"));
		
		Continent europe = new Continent("Europe");
		Continent asia = new Continent("Asia");
		Continent africa = new Continent("Africa");
		Continent australia = new Continent("Australia");
		Continent northAmerica = new Continent("North America");
		Continent southAmerica = new Continent("South America");
		
		World worldObject = new World();
		
		//When
		europe.addCountry(germany);
		europe.addCountry(france);
		europe.addCountry(unitedKingdom);
		europe.addCountry(italy);
		
		asia.addCountry(china);
		asia.addCountry(india);
		asia.addCountry(indonesia);
		asia.addCountry(pakistan);
		
		africa.addCountry(nigeria);
		africa.addCountry(ethiopia);
		africa.addCountry(egypt);
		africa.addCountry(dRCongo);
		
		australia.addCountry(australiaCountry);
		australia.addCountry(papuaNewGuinea);
		
		northAmerica.addCountry(uSA);
		northAmerica.addCountry(mexico);
		northAmerica.addCountry(canada);
		northAmerica.addCountry(guatemala);
		
		southAmerica.addCountry(brazil);
		southAmerica.addCountry(colombia);
		southAmerica.addCountry(argentina);
		southAmerica.addCountry(venezuela);
		
		worldObject.addContinent(europe);
		worldObject.addContinent(asia);
		worldObject.addContinent(africa);
		worldObject.addContinent(australia);
		worldObject.addContinent(northAmerica);
		worldObject.addContinent(southAmerica);
		
		//Then
		Assert.assertEquals(4, europe.getContinentCountries().size());
		Assert.assertEquals(4, asia.getContinentCountries().size());
		Assert.assertEquals(4, africa.getContinentCountries().size());
		Assert.assertEquals(2, australia.getContinentCountries().size());
		Assert.assertEquals(4, northAmerica.getContinentCountries().size());
		Assert.assertEquals(4, southAmerica.getContinentCountries().size());
		Assert.assertEquals(6, worldObject.getWorld().size());
		
		BigDecimal expectedNumberOfPPLInTheWorld = new BigDecimal("4839441537");
		Assert.assertEquals(expectedNumberOfPPLInTheWorld, worldObject.getPeopleQuantity());
	}
}