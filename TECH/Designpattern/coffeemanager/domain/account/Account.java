package com.mc.coffeemanager.domain.account;

public class Account {
	
	private int balance = 100000;
	private int sales;
	private int expences;
	private static Account instance;
	
	public static Account getInstance(int balance) {
		if(instance == null) {
			instance = new Account(balance);
		}
		
		return instance;
	}
	
	public static Account getInstance() {
		return getInstance(0);
	}
	
	private Account(int balance) {
		super();
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public int getSales() {
		return sales;
	}

	public int getExpences() {
		return expences;
	}
	
	public void registSales(int price) {
		this.balance += price;
		this.sales += price;
	}

	public boolean registExpenses(int price) {
		if(price > balance) {
			return false;
		}
		
		this.balance -= price;
		this.expences += price;
		return true;
	}
	
	

}
