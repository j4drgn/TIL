package com.mc.oop.a_encapsulation;

/**
 * 캡슐화(Encapsulation) 예제 - 속성 캡슐화
 * 
 * 캡슐화는 객체의 속성(데이터)과 행위(메소드)를 하나로 묶고,
 * 실제 구현 내용 일부를 외부에 감추어 객체의 자율성과 응집도를 높이는 기법입니다.
 * 
 * 이 클래스는 커피 정보를 표현하며, 속성 캡슐화의 기본적인 예를 보여줍니다.
 * - 모든 필드는 private으로 선언되어 직접 접근이 제한됩니다.
 * - getter/setter 메소드를 통해 제어된 접근을 제공합니다.
 */
public class Coffee {
	
	// 커피 속성 - 모두 private으로 선언하여 외부 직접 접근 차단
	private String name;   // 커피 이름
	private int price;     // 커피 가격
	private int stock;     // 재고 수량
	
	/**
	 * 속성 접근 제어 방식:
	 * - 읽기, 수정 필요: getter/setter 모두 제공
	 * - 읽기만 필요: getter만 제공
	 * - 접근 불필요: 아무 메소드도 제공하지 않음
	 */
	
	/**
	 * 커피 이름을 반환합니다.
	 * @return 커피 이름
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 커피 이름을 설정합니다.
	 * @param name 설정할 커피 이름
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 커피 가격을 반환합니다.
	 * @return 커피 가격
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * 커피 가격을 설정합니다.
	 * @param price 설정할 커피 가격
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * 커피 재고 수량을 반환합니다.
	 * @return 재고 수량
	 */
	public int getStock() {
		return stock;
	}
	
	/**
	 * 커피 재고 수량을 설정합니다.
	 * @param stock 설정할 재고 수량
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}
}