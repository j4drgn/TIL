package com.mc.oop.a_encapsulation.method;

/**
 * 캡슐화(Encapsulation) 예제 - 메소드 캡슐화
 * 
 * 객체의 자율성을 보장하는 메소드 캡슐화의 예시입니다.
 * 객체가 어떤 작업을 할 때 그 작업에 대한 책임을 객체에게 주어야 합니다.
 * 
 * 이 클래스는 악기 연주자를 표현하며:
 * - 외부에서는 단순히 play() 메소드만 호출합니다.
 * - 실제 연주 과정의 세부 단계는 내부에 캡슐화되어 있습니다.
 * - 모든 세부 단계는 private 메소드로 구현되어 외부에서 접근할 수 없습니다.
 */
public class Player {
	
	// 연주할 악기 종류
	private String instrument;

	/**
	 * Player 객체 생성자
	 * @param instrument 연주할 악기 이름
	 */
	public Player(String instrument) {
		super();
		this.instrument = instrument;
	}
	
	/**
	 * 연주를 시작하는 공개 인터페이스
	 * 이 메소드만 외부에 노출되며, 실제 연주 과정의 모든 단계를 순차적으로 실행합니다.
	 * 
	 * 메소드 캡슐화의 장점:
	 * 1. 사용자는 복잡한 내부 로직을 알 필요 없이 단순히 play()만 호출하면 됩니다.
	 * 2. 내부 구현이 변경되어도 외부 인터페이스는 유지됩니다.
	 * 3. 각 단계가 올바른 순서로 실행되도록 보장합니다.
	 */
	public void play() {
		prepare();    // 1. 연주 준비
		playing();    // 2. 연주 시작
		stop();       // 3. 연주 중단
		leave();      // 4. 무대 퇴장
		curtainCall(); // 5. 커튼콜
	}
	
	/**
	 * 연주 준비 단계
	 * 악기를 준비하고 연주 자세를 취합니다.
	 */
	private void prepare() {
		System.out.println(instrument + " 연주를 준비합니다.");
	}
	
	/**
	 * 실제 연주를 시작하는 단계
	 * 악기 연주를 시작합니다.
	 */
	private void playing() {
		System.out.println(instrument + " 연주를 시작합니다.");
	}
	
	/**
	 * 연주를 중단하는 단계
	 * 연주를 마무리합니다.
	 */
	private void stop() {
		System.out.println("연주를 중단합니다.");
	}
	
	/**
	 * 무대에서 퇴장하는 단계
	 * 연주가 끝난 후 무대를 떠납니다.
	 */
	private void leave() {
		System.out.println("공연장을 떠납니다.");
	}
	
	/**
	 * 커튼콜 단계
	 * 관객의 호응에 응답하는 마지막 인사를 합니다.
	 */
	private void curtainCall(){
		System.out.println("커튼콜을 진행합니다.");
	}
}