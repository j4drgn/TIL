
package com.mc.oop.b_coffeemanager;

public class Coffee {
	
	private String name;
	private int price;
	private int cost;
	private int stock;
	private int safetyStock;
	private int salesAmount;
	
	public Coffee(String name, int price, int cost, int stock, int safetyStock, int salesAmount) {
		super();
		this.name = name;
		this.price = price;
		this.cost = cost;
		this.stock = stock;
		this.safetyStock = safetyStock;
		this.salesAmount = salesAmount;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(int salesAmount) {
		this.salesAmount = salesAmount;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getCost() {
		return cost;
	}

	public int getSafetyStock() {
		return safetyStock;
	}

	public void deductStock(int cnt) {
		this.stock -= cnt;
	}

	public void addStock(int cnt) {
		this.stock += cnt;
	}

}
