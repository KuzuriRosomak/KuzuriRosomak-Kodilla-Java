package com.kodilla.good.patterns.challenges;

import java.util.stream.Collectors;

public class MovieStoreApp
{
	public static void main(String[] args) {
		
		MovieStore movieStore = new MovieStore();
		
		String resultString = movieStore.getMovies().values().stream()
				.flatMap(n -> n.stream())
				.collect(Collectors.joining("!"));
		
		System.out.println(resultString);
	}
}