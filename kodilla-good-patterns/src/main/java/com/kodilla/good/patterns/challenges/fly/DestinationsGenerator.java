package com.kodilla.good.patterns.challenges.fly;

import java.util.Arrays;
import java.util.List;

public class DestinationsGenerator {
	public static List<Destination> generateDestinations() {
		Destination gdanskKrakow = new Destination("Gdańsk", "Kraków");
		Destination gdanskSzczecin = new Destination("Gdańsk", "Szczecin");
		Destination gdanskLodz = new Destination("Gdańsk", "Łódź");
		Destination gdanskRzeszow = new Destination("Gdańsk", "Rzeszów");
		Destination krakowGdansk = new Destination("Kraków", "Gdańsk");
		Destination krakowLodz = new Destination("Kraków", "Łódź");
		Destination krakowWarszawa = new Destination("Kraków", "Warszawa");
		Destination krakowWroclaw = new Destination("Kraków", "Wrocław");
		Destination wroclawKrakow = new Destination("Wrocław", "Kraków");
		Destination wroclawBydgoszcz = new Destination("Wrocław", "Bydgoszcz");
		Destination warszawaKrakow = new Destination("Warszawa", "Kraków");
		Destination warszawaRzeszow = new Destination("Warszawa", "Rzeszów");
		Destination warszawaBydgoszcz = new Destination("Warszawa", "Bydgoszcz");
		Destination warszawaSzczecin = new Destination("Warszawa", "Szczecin");
		Destination warszawaPoznan = new Destination("Warszawa", "Poznań");
		Destination warszawaBialystok = new Destination("Warszawa", "Białystok");
		Destination szczecinGdansk = new Destination("Szczecin", "Gdańsk");
		Destination szczecinWarszawa = new Destination("Szczecin", "Warszawa");
		Destination poznanBialystok = new Destination("Poznań", "Białystok");
		Destination poznanWarszawa = new Destination("Poznań", "Warszawa");
		Destination bialystokPoznan = new Destination("Białystok", "Poznań");
		Destination bialystokWarszawa = new Destination("Białystok", "Warszawa");
		Destination rzeszowWarszawa = new Destination("Rzeszów", "Warszawa");
		Destination rzeszowGdansk = new Destination("Rzeszów", "Gdańsk");
		Destination bydgoszczWarszawa = new Destination("Bydgoszcz", "Warszawa");
		Destination bydgoszczWroclaw = new Destination("Bydgoszcz", "Wrocław");
		Destination lodzKrakow = new Destination("Łódź", "Kraków");
		Destination lodzGdansk = new Destination("Łódź", "Gdańsk");
		
		return Arrays.asList(gdanskKrakow, gdanskSzczecin, gdanskLodz, gdanskRzeszow, krakowGdansk, krakowLodz,
				krakowWarszawa, krakowWroclaw, wroclawKrakow, wroclawBydgoszcz, warszawaKrakow, warszawaRzeszow,
				warszawaBydgoszcz, warszawaBialystok, warszawaSzczecin, warszawaPoznan, szczecinGdansk, szczecinWarszawa,
				poznanBialystok, poznanWarszawa, bialystokPoznan, bialystokWarszawa, rzeszowWarszawa, rzeszowGdansk,
				bydgoszczWarszawa, bydgoszczWroclaw, lodzKrakow, lodzGdansk);
	}
}