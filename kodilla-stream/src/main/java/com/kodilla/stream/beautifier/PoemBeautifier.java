package com.kodilla.stream.beautifier;

public class PoemBeautifier
{
	public void beautify(String text, PoemDecorator poemDecorator)
	{
		String beautified = poemDecorator.decorate(text);
		System.out.println("Text before: " + text + "\n" + "Beautified text: " + beautified);
	}
}