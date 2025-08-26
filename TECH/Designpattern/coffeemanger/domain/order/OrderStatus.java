package com.mc.coffeemanager.domain.order;

/**
 * 주문 상태를 나타내는 열거형(Enum) 클래스
 * 주문의 다양한 상태와 관련된 정보를 포함
 * HTTP 상태 코드와 유사한 코드 체계 사용
 */
public enum OrderStatus {

	// 주문 상태 정의
	OK(200, "주문 생성 성공"),                           // 성공 상태
	FAIL_SOLD_OUT(500, "재고 확보 실패로 인한 주문 취소"),   // 재고 부족으로 인한 실패
	FAIL_FORCE(400, "판매자의 강제 주문 취소");           // 판매자에 의한 강제 취소
	
	// 상태 속성
	private int code;      // 상태 코드
	private String desc;   // 상태 설명
	
	/**
	 * OrderStatus 생성자
	 * 
	 * @param code 상태 코드
	 * @param desc 상태 설명
	 */
	OrderStatus(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	/**
	 * 주문 성공 여부 확인
	 * 
	 * @return 성공 여부 (코드가 200인 경우 true)
	 */
	public boolean isOk() {
		return code == 200;
	}
	
	/**
	 * 주문 실패 여부 확인
	 * 
	 * @return 실패 여부 (코드가 200이 아닌 경우 true)
	 */
	public boolean isFail() {
		return code != 200;
	}
	
	/**
	 * 상태 설명 반환
	 * 
	 * @return 상태 설명 문자열
	 */
	public String desc() {
		return desc;
	}
	
	/**
	 * 상태 코드 반환
	 * 
	 * @return 상태 코드
	 */
	public int code() {
		return code;
	}
}
