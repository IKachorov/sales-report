package com.intracol.basecamp.homework3;

import java.math.BigDecimal;

public class CitySale {
	
	
	private String city;
	private int numberOfPurchases;
	private BigDecimal totalAmount;
	private BigDecimal avgAmount; //= totalAmount.divide(new BigDecimal(numberOfPurchases), java.math.MathContext.DECIMAL64);

	public CitySale(String city, int numberOfPurchases, BigDecimal totalAmount) {
		this.city = city;
		this.numberOfPurchases = numberOfPurchases;
		this.totalAmount = totalAmount;
		avgAmount = totalAmount.divide(new BigDecimal(numberOfPurchases), java.math.MathContext.DECIMAL64);
	}

	
	public String getCity() {
		return city;
	}

	public int getNumberOfPurchases() {
		return numberOfPurchases;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	
	public BigDecimal getAvgAmount() {
		return avgAmount;
	}


}
