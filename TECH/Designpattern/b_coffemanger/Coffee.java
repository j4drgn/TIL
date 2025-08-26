
package com.mc.oop.b_coffemanger;

/**
 * 커피 객체를 표현하는 클래스
 * 커피의 기본 정보와 재고 관리 기능을 제공합니다.
 */
public class Coffee {

  // 커피 기본 속성
  private String name;      // 커피 이름
  private int price;        // 판매 가격
  private int cost;         // 매입 원가
  private int stock;        // 현재 재고량
  private int safetyStock;  // 안전 재고량 (이 수준 이하로 떨어지면 추가 매입 필요)
  private int salesAmount;  // 판매량

  /**
   * 커피 객체 생성자
   * 
   * @param name 커피 이름
   * @param price 판매 가격
   * @param cost 매입 원가
   * @param stock 초기 재고량
   * @param safetyStock 안전 재고량
   * @param salesAmount 초기 판매량
   */
  public Coffee(String name, int price, int cost, int stock, int safetyStock, int salesAmount) {
    super();
    this.name = name;
    this.price = price;
    this.cost = cost;
    this.stock = stock;
    this.safetyStock = safetyStock;
    this.salesAmount = salesAmount;
  }

  /**
   * 현재 재고량 반환
   * @return 현재 재고량
   */
  public int getStock() {
    return stock;
  }

  /**
   * 재고량 설정
   * @param stock 설정할 재고량
   */
  public void setStock(int stock) {
    this.stock = stock;
  }

  /**
   * 현재 판매량 반환
   * @return 현재 판매량
   */
  public int getSalesAmount() {
    return salesAmount;
  }

  /**
   * 판매량 설정
   * @param salesAmount 설정할 판매량
   */
  public void setSalesAmount(int salesAmount) {
    this.salesAmount = salesAmount;
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
  public int getCost() {
    return cost;
  }

  /**
   * 안전 재고량 반환
   * @return 안전 재고량
   */
  public int getSafetyStock() {
    return safetyStock;
  }

  /**
   * 재고 차감 메소드
   * @param cnt 차감할 수량
   */
  public void deductStock(int cnt) {
    this.stock -= cnt;
  }

  /**
   * 재고 추가 메소드
   * @param cnt 추가할 수량
   */
  public void addStock(int cnt) {
    this.stock += cnt;
  }

}
