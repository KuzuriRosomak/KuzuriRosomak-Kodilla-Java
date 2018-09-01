package com.kodilla.good.patterns.challenges.shop;

import java.util.Random;

public class Product {
	private User user;
	private String productName;
	private long productNumber;
	private double pricePerUnit;
	private double quantity;
	private Random productNumberGenerator = new Random();
	
	public Product(User user, String productName, double pricePerUnit, double quantity) {
		this.user = user;
		this.productName = productName;
		this.pricePerUnit = pricePerUnit;
		this.quantity = quantity;
		this.productNumber = productNumberGeneratorMethod();
	}
	
	private long productNumberGeneratorMethod() {
		long temporaryFirstLong = ((productNumberGenerator.nextInt(999999999)) + 100000000);
		if(temporaryFirstLong <= 0) {
			temporaryFirstLong = ((temporaryFirstLong) * (-1));
		}
		String temporaryLongString = String.valueOf(temporaryFirstLong);
		
		long temporaryFirstLong2 = ((productNumberGenerator.nextInt(999999999)) + 100000000);
		if(temporaryFirstLong2 <= 0) {
			temporaryFirstLong2 = ((temporaryFirstLong2) * (-1));
		}
		String temporaryLongString2 = String.valueOf(temporaryFirstLong2);
		
		long temporaryFirstLong3 = ((productNumberGenerator.nextInt(999999999)) + 100000000);
		if(temporaryFirstLong3 <= 0) {
			temporaryFirstLong3 = ((temporaryFirstLong3) * (-1));
		}
		String temporaryLongString3 = String.valueOf(temporaryFirstLong3);
		
		long temporaryFirstLong4 = ((productNumberGenerator.nextInt(999999999)) + 100000000);
		if(temporaryFirstLong4 <= 0) {
			temporaryFirstLong4 = ((temporaryFirstLong4) * (-1));
		}
		String temporaryLongString4 = String.valueOf(temporaryFirstLong4);
		
		long temporaryFirstLong5 = ((productNumberGenerator.nextInt(999999999)) + 100000000);
		
		if(temporaryFirstLong5 <= 0) {
			temporaryFirstLong5 = ((temporaryFirstLong5) * (-1));
		}
		String temporaryLongString5 = String.valueOf(temporaryFirstLong5);
		
		String concatString = temporaryLongString.concat(temporaryLongString2).concat(temporaryLongString3)
				.concat(temporaryLongString4).concat(temporaryLongString5);
		String trimTemporaryLongString = concatString.substring((concatString.length()) - 15);
		long temporaryLong = Long.parseLong(trimTemporaryLongString);
		long longToCompare = 100000000000L;
		if(temporaryLong <= longToCompare) {
			productNumberGeneratorMethod();
		} else {
			if ((ProductDatabase.getInstance().getShopsProductDataBase().containsKey(temporaryLong)) == true) {
				productNumberGeneratorMethod();
			}
		}
		return temporaryLong;
	}
	
	public User getUser() {
		return user;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public long getProductNumber() {
		return productNumber;
	}
	
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	
	public double getQuantity() {
		return quantity;
	}
	
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof Product))
			return false;
		Product product = (Product) o;
		return product.equals(product.productNumber);
	}
	
	@Override
	public int hashCode() {
		int hashCodeTemp1 = (Integer.parseInt((String.valueOf(productNumber)).substring(((String.valueOf
				(productNumber)).length()) - 8)));
		if(hashCodeTemp1 <= 0) {
			hashCodeTemp1 = (hashCodeTemp1 * (-1));
		}
		return hashCodeTemp1;
	}
}