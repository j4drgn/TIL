package com.mc.algorithm.d_datastructure.queue;

/**
 * 큐 구현체의 기능을 테스트하는 실행 클래스
 * 
 * 이 클래스는 사용자 정의 큐(_Queue) 구현체의 기능을 테스트합니다.
 * 요소 추가(enqueue)와 제거(dequeue) 기능을 시연합니다.
 */
public class Run {

	/**
	 * 메인 메소드 - 큐의 기능 테스트
	 * 
	 * @param args 명령행 인자
	 */
	public static void main(String[] args) {
		// 정수를 저장하는 큐 생성
		_Queue<Integer> queue = new _Queue<Integer>();
		
		// 0부터 9까지의 정수를 큐에 추가
		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);
		}
		
		// 큐에서 요소를 하나씩 제거하며 출력
		// FIFO 방식으로 0부터 9까지 순서대로 제거됨
		for (int i = 0; i < 10; i++) {
			// 제거된 요소 출력
			System.out.println(queue.dequeue());
			// 제거 후 큐의 상태 출력
			System.out.println(queue);
		}
	}
}
