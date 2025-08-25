package com.mc.oop.a_encapsulation.method;

/**
 * 캡슐화 예제 실행 클래스
 * 
 * 이 클래스는 다양한 콘서트 클래스를 실행하여 메소드 캡슐화와
 * 템플릿 메소드 패턴의 전조를 보여주는 예제입니다.
 */
public class Run {

	public static void main(String[] args) {
		// 각 계절별 콘서트 객체 생성 및 실행
		
		// 봄 콘서트 시작
		new SpringConcert().start();
		
		// 여름 콘서트 시작
		new SummerConcert().start();
		
		// 가을 콘서트 시작
		new AutumnConcert().start();
		
		/**
		 * 현재 구조의 문제점:
		 * 1. 세 콘서트 클래스가 거의 동일한 코드를 가지고 있어 중복이 발생
		 * 2. 새로운 계절 콘서트를 추가하려면 또 다른 클래스를 만들어야 함
		 * 
		 * 개선 방향:
		 * 1. Concert 추상 클래스를 만들어 공통 로직 구현
		 * 2. 각 계절별 콘서트는 Concert를 상속받아 필요한 부분만 오버라이드
		 * 3. 팩토리 패턴을 적용하여 콘서트 객체 생성 로직 분리 가능
		 */
	}
}