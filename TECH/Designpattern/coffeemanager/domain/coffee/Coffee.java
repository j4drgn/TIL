package com.mc.coffeemanager.domain.coffee;

import com.mc.coffeemanager.domain.purchase.Purchase;

public class Coffee {
	
	private String name;
	private int price;
	private int purchasePrice;
	private int stock;
	private int safetyStock;
	private int salesCnt;
	
	public Coffee(String name, int price, int purchasePrice, int stock, int safetyStock, int salesCnt) {
		this.name = name;
		this.price = price;
		this.purchasePrice = purchasePrice;
		this.stock = stock;
		this.safetyStock = safetyStock;
		this.salesCnt = salesCnt;
	}
	
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getPurchasePrice() {
		return purchasePrice;
	}
	public int getStock() {
		return stock;
	}
	public int getSafetyStock() {
		return safetyStock;
	}
	public int getSalesCnt() {
		return salesCnt;
	}
	
	public void provide(int cnt) {
		deductStock(cnt);
		addSalesCnt(cnt);
		checkSafetyStock();
	}
	
	private void checkSafetyStock() {
		if(stock <= safetyStock) {
			Purchase purchase = new Purchase(this, safetyStock * 2);
			
			if(purchase.proceed()) {
				System.out.println("system : 안전재고 확보에 성공했습니다.");
				return;
			};
			
			System.out.println("system : 안전재고 확보에 실패했습니다.");
		}
	}
	
	private void addSalesCnt(int cnt) {
		this.salesCnt += cnt;
	}
	
	private void deductStock(int cnt) {
		this.stock -= cnt;
	}
	
	public void addStock(int cnt) {
		this.stock += cnt;
	}
	
	

}
