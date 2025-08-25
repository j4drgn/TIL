package com.mc.oop.a_encapsulation.method;

/**
 * 봄 콘서트 클래스
 * 
 * 이 클래스는 템플릿 메소드 패턴의 전조가 보이는 구조입니다.
 * AutumnConcert, SummerConcert와 동일한 구조를 가지고 있어
 * 향후 상속과 추상화를 통해 템플릿 메소드 패턴으로 리팩토링할 수 있습니다.
 * 
 * 현재 구조의 문제점:
 * - 세 콘서트 클래스가 거의 동일한 코드를 가지고 있어 중복이 발생
 * - 콘서트 종류만 다르고 나머지 로직은 동일함
 * 
 * 개선 방향:
 * - 공통 부분을 추상 클래스로 추출하여 중복 제거
 * - 변경되는 부분만 하위 클래스에서 구현하도록 설계
 */
public class SpringConcert {

	/**
	 * 콘서트를 시작하는 메소드
	 * 콘서트 시작 메시지를 출력하고, 연주자를 생성한 후 연주를 시작합니다.
	 */
	public void start() {
		// 콘서트 시작 메시지 출력
		System.out.println("Spring concert 시작합니다. ^^ ******");
		
		// 바이올린 연주자 생성
		Player player = new Player("바이올린");
		
		// 연주 시작 - Player 클래스의 캡슐화된 메소드 호출
		player.play();
		
		// 콘서트 종료 구분선 출력
		System.out.println("=====================================");
	}
}