package com.intracol.basecamp.homework3;

import java.math.BigDecimal;

public class Sale {

	

	private String city;
	private String store;
	private int id;
	private BigDecimal amount;

	public Sale(int id, String city, String store, BigDecimal amount) {
		this.city = city;
		this.store = store;
		this.id = id;
		this.amount = amount;
	}

	
	public String getCity() {
		return city;
	}

	
	public void setCity(String city) {
		this.city = city;
	}

	
	public String getStore() {
		return store;
	}

	
	public void setStore(String store) {
		this.store = store;
	}

	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	
	public BigDecimal getAmount() {
		return amount;
	}

	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
}
