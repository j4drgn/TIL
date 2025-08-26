package com.mc.coffeemanager.domain.purchase;

import com.mc.coffeemanager.domain.account.Account;
import com.mc.coffeemanager.domain.coffee.Coffee;

public class Purchase {
	
	private Coffee coffee;
	private int purchaseCnt;
	private int purchasePrice;
	
	public Purchase(Coffee coffee, int cnt) {
		this.coffee = coffee; 
		this.purchaseCnt = cnt;
		this.purchasePrice = coffee.getPurchasePrice() * cnt;
	}
	
	public Coffee getCoffee() {
		return coffee;
	}
	public int getPurchaseCnt() {
		return purchaseCnt;
	}
	public int getPurchasePrice() {
		return purchasePrice;
	}

	public boolean proceed() {
		Account account = Account.getInstance();
		if(account.registExpenses(purchasePrice)) {
			System.out.println("system : " + coffee.getName() + "[" + purchaseCnt + "잔] 매입" );
			coffee.addStock(purchaseCnt);
			return true;
		}
		
		System.out.println("system : 매입에 실패했습니다.");
		return false;
	}
	
	

}
