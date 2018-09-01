package com.kodilla.good.patterns.challenges.shop;

public class OrderServiceApp {
	public static void main(String[] args) {
		
		Shopping shopping = new Shopping();
		Checkout checkout = new Checkout();
		checkout.checkingOut(shopping);
	}
}