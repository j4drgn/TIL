package com.mc.coffeemanager.domain.order;

import java.time.OffsetDateTime;

import com.mc.coffeemanager.domain.coffee.Coffee;
import com.mc.coffeemanager.domain.purchase.Purchase;

/**
 * 주문을 표현하는 도메인 클래스
 * 주문 정보를 관리하고 주문 생성 및 처리 기능을 제공
 * 팩토리 메소드 패턴을 활용하여 주문 객체 생성
 */
public class Order {
	
	// 주문 속성
	private String name;                  // 주문명 (커피명[수량])
	private Coffee coffee;                // 주문한 커피 객체
	private int orderCnt;                 // 주문 수량
	private int orderPrice;               // 주문 금액
	private OffsetDateTime orderTime;     // 주문 시간
	private OrderStatus status;           // 주문 상태
	
	/**
	 * 주문 생성 팩토리 메소드
	 * 주문 객체를 생성하고 재고 확인 및 필요시 매입 처리를 수행
	 * 
	 * @param coffee 주문할 커피 객체
	 * @param orderCnt 주문 수량
	 * @return 생성된 주문 객체
	 */
	public static Order createOrder(Coffee coffee, int orderCnt) {
		
		Order order = new Order(coffee, orderCnt);
		
		// 주문 수량이 재고보다 많은 경우 매입 시도
		if(orderCnt > coffee.getStock()) {
			Purchase purchase = new Purchase(coffee, orderCnt);
			if(!purchase.proceed()) {
				// 매입 실패 시 주문 상태를 FAIL_SOLD_OUT으로 설정
				order.status = OrderStatus.FAIL_SOLD_OUT;
				return order;
			}
		}
		
		// 재고가 충분하거나 매입 성공 시 주문 상태를 OK로 설정
		order.status = OrderStatus.OK;
		return order;
	}
	
	/**
	 * 주문 생성자 - private으로 외부에서 직접 생성 불가
	 * 팩토리 메소드 패턴을 위해 생성자를 private으로 제한
	 * 
	 * @param coffee 주문할 커피 객체
	 * @param orderCnt 주문 수량
	 */
	private Order(Coffee coffee, int orderCnt) {
		this.name = coffee.getName() + "[" + orderCnt + "]";
		this.coffee = coffee;
		this.orderCnt = orderCnt;
		this.orderPrice = coffee.getPrice() * orderCnt;
		this.orderTime = OffsetDateTime.now();
	}
	
	/**
	 * 주문 상태 반환
	 * @return 주문 상태
	 */
	public OrderStatus getStatus() {
		return status;
	}
	
	/**
	 * 주문명 반환
	 * @return 주문명
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 주문한 커피 객체 반환
	 * @return 커피 객체
	 */
	public Coffee getCoffee() {
		return coffee;
	}
	
	/**
	 * 주문 수량 반환
	 * @return 주문 수량
	 */
	public int getOrderCnt() {
		return orderCnt;
	}
	
	/**
	 * 주문 금액 반환
	 * @return 주문 금액
	 */
	public int getOrderPrice() {
		return orderPrice;
	}
	
	/**
	 * 주문 시간 반환
	 * @return 주문 시간
	 */
	public OffsetDateTime getOrderTime() {
		return orderTime;
	}

	/**
	 * 주문 처리 메소드
	 * 커피 객체의 provide 메소드를 호출하여 재고 차감 및 판매량 증가 처리
	 */
	public void proceed() {
		coffee.provide(orderCnt);
	}
}
