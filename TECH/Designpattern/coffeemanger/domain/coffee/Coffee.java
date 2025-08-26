package com.mc.coffeemanager.domain.coffee;

import com.mc.coffeemanager.domain.purchase.Purchase;

/**
 * 커피 객체를 표현하는 도메인 클래스
 * 커피의 기본 정보와 재고 관리 기능을 제공합니다.
 * 도메인 주도 설계(DDD) 개념에 따라 비즈니스 로직을 포함하고 있습니다.
 */
public class Coffee {
	
	// 커피 기본 속성
	private String name;          // 커피 이름
	private int price;            // 판매 가격
	private int purchasePrice;    // 매입 원가
	private int stock;            // 현재 재고량
	private int safetyStock;      // 안전 재고량 (이 수준 이하로 떨어지면 추가 매입 필요)
	private int salesCnt;         // 판매량
	
	/**
	 * 커피 객체 생성자
	 * 
	 * @param name 커피 이름
	 * @param price 판매 가격
	 * @param purchasePrice 매입 원가
	 * @param stock 초기 재고량
	 * @param safetyStock 안전 재고량
	 * @param salesCnt 초기 판매량
	 */
	public Coffee(String name, int price, int purchasePrice, int stock, int safetyStock, int salesCnt) {
		this.name = name;
		this.price = price;
		this.purchasePrice = purchasePrice;
		this.stock = stock;
		this.safetyStock = safetyStock;
		this.salesCnt = salesCnt;
	}
	
	/**
	 * 커피 이름 반환
	 * @return 커피 이름
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 판매 가격 반환
	 * @return 판매 가격
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * 매입 원가 반환
	 * @return 매입 원가
	 */
	public int getPurchasePrice() {
		return purchasePrice;
	}
	
	/**
	 * 현재 재고량 반환
	 * @return 현재 재고량
	 */
	public int getStock() {
		return stock;
	}
	
	/**
	 * 안전 재고량 반환
	 * @return 안전 재고량
	 */
	public int getSafetyStock() {
		return safetyStock;
	}
	
	/**
	 * 현재 판매량 반환
	 * @return 현재 판매량
	 */
	public int getSalesCnt() {
		return salesCnt;
	}
	
	/**
	 * 커피 제공 메소드 - 판매 시 호출됨
	 * 재고 차감, 판매량 증가, 안전재고 확인 작업을 순차적으로 수행
	 * 
	 * @param cnt 제공할 커피 수량
	 */
	public void provide(int cnt) {
		deductStock(cnt);
		addSalesCnt(cnt);
		checkSafetyStock();
	}
	
	/**
	 * 안전재고 확인 및 확보 메소드
	 * 재고가 안전재고 이하로 떨어지면 자동으로 매입을 시도함
	 */
	private void checkSafetyStock() {
		if(stock <= safetyStock) {
			// 안전재고의 2배 수량을 매입 시도
			Purchase purchase = new Purchase(this, safetyStock * 2);
			
			if(purchase.proceed()) {
				System.out.println("system : 안전재고 확보에 성공했습니다.");
				return;
			};
			
			System.out.println("system : 안전재고 확보에 실패했습니다.");
		}
	}
	
	/**
	 * 판매량 증가 메소드
	 * @param cnt 증가시킬 판매량
	 */
	private void addSalesCnt(int cnt) {
		this.salesCnt += cnt;
	}
	
	/**
	 * 재고 차감 메소드
	 * @param cnt 차감할 수량
	 */
	private void deductStock(int cnt) {
		this.stock -= cnt;
	}
	
	/**
	 * 재고 추가 메소드 - 매입 시 호출됨
	 * @param cnt 추가할 수량
	 */
	public void addStock(int cnt) {
		this.stock += cnt;
	}
}
