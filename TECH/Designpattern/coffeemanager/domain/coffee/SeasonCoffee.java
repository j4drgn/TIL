package com.mc.coffeemanager.domain.coffee;

import java.time.LocalDate;
import java.time.Month;

public class SeasonCoffee extends Coffee{
	
	private Month[] seasons;

	public SeasonCoffee(String name, int price, int purchasePrice, int stock, int safetyStock, int salesCnt,
			Month[] seasons) {
		super(name, price, purchasePrice, stock, safetyStock, salesCnt);
		this.seasons = seasons;
	}
	
	
	public boolean isSeason() {
		Month now = LocalDate.now().getMonth();
		
		for (Month month : seasons) {
			if(month.equals(now)) return true;
		}
		
		return false;
	}
	
	
	
	
	

}
