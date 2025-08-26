package com.mc.coffeemanager.domain.account;

/**
 * 계정 관리를 담당하는 싱글톤 클래스
 * 시스템 내에서 단일 계정만 존재하도록 싱글톤 패턴을 적용함
 * 판매 및 지출 관리 기능을 제공
 */
public class Account {
	
	// 계정 속성
	private int balance = 100000;  // 잔고
	private int sales;             // 총 매출액
	private int expences;          // 총 지출액
	
	// 싱글톤 인스턴스
	private static Account instance;
	
	/**
	 * 계정 인스턴스 반환 (초기 잔고 설정 가능)
	 * 싱글톤 패턴 구현 - 최초 호출 시 인스턴스 생성, 이후에는 기존 인스턴스 반환
	 * 
	 * @param balance 초기 잔고
	 * @return 계정 인스턴스
	 */
	public static Account getInstance(int balance) {
		if(instance == null) {
			instance = new Account(balance);
		}
		
		return instance;
	}
	
	/**
	 * 계정 인스턴스 반환 (기본 잔고 사용)
	 * 
	 * @return 계정 인스턴스
	 */
	public static Account getInstance() {
		return getInstance(0);
	}
	
	/**
	 * 계정 생성자 - private으로 외부에서 직접 생성 불가
	 * 싱글톤 패턴을 위해 생성자를 private으로 제한
	 * 
	 * @param balance 초기 잔고
	 */
	private Account(int balance) {
		super();
		this.balance = balance;
	}

	/**
	 * 현재 잔고 반환
	 * @return 현재 잔고
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * 총 매출액 반환
	 * @return 총 매출액
	 */
	public int getSales() {
		return sales;
	}

	/**
	 * 총 지출액 반환
	 * @return 총 지출액
	 */
	public int getExpences() {
		return expences;
	}
	
	/**
	 * 매출 등록 메소드
	 * 잔고와 총 매출액을 증가시킴
	 * 
	 * @param price 매출 금액
	 */
	public void registSales(int price) {
		this.balance += price;
		this.sales += price;
	}

	/**
	 * 지출 등록 메소드
	 * 잔고가 충분한 경우에만 지출을 등록하고 true를 반환
	 * 잔고가 부족한 경우 false를 반환
	 * 
	 * @param price 지출 금액
	 * @return 지출 등록 성공 여부
	 */
	public boolean registExpenses(int price) {
		if(price > balance) {
			return false;
		}
		
		this.balance -= price;
		this.expences += price;
		return true;
	}
}
