package com.kodilla.good.patterns.challenges.shop;

import java.util.Objects;

public class Wallet {
	private User user;
	private double accountBalance;
	
	public Wallet(User user, double accountBalance) {
		this.user = user;
		this.accountBalance = accountBalance;
	}
	
	public User getUser() {
		return user;
	}
	
	public double getAccountBalance() {
		return accountBalance;
	}
	
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null || getClass() != o.getClass())
			return false;
		Wallet wallet = (Wallet) o;
		return Double.compare(wallet.getAccountBalance(), getAccountBalance()) == 0 && Objects.equals(getUser(), wallet.getUser());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getUser(), getAccountBalance());
	}
}
