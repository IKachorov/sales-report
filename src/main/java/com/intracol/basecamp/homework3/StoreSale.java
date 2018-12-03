package com.intracol.basecamp.homework3;

import java.math.BigDecimal;

public class StoreSale {
	
	private String store;
	private int numberOfPurchases;
	private BigDecimal totalAmount;
	private BigDecimal avgAmount;

	public StoreSale(String store, int numberOfPurchases, BigDecimal totalAmount) {
		this.store = store;
		this.numberOfPurchases = numberOfPurchases;
		this.totalAmount = totalAmount;
		avgAmount = totalAmount.divide(new BigDecimal(numberOfPurchases), java.math.MathContext.DECIMAL64);
	}

	
	public String getStore() {
		return store;
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
