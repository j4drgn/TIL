package com.mc.algorithm.d_datastructure.queue;

import com.mc.algorithm.d_datastructure.list.Node;

/**
 * 제네릭 타입을 지원하는 큐(Queue) 구현 클래스
 * 
 * 이 클래스는 FIFO(First-In-First-Out) 방식으로 동작하는 큐 자료구조를 구현합니다.
 * 내부적으로 연결 리스트를 사용하여 요소를 저장합니다.
 * 
 * @param <E> 큐에 저장될 요소의 타입
 */
public class _Queue<E> {
	
	/** 큐의 첫 번째 노드(헤드) */
	private Node<E> top;
	
	/** 큐의 요소 개수 */
	private int size;
	
	/**
	 * 큐의 요소 개수를 반환합니다.
	 * 
	 * @return 큐의 요소 개수
	 */
	public int size() {
		return size;
	}
	
	/**
	 * 큐가 비어있는지 확인합니다.
	 * 
	 * @return 큐가 비어있으면 true, 그렇지 않으면 false
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * 큐의 끝에 요소를 추가합니다.
	 * 
	 * @param e 추가할 요소
	 */
	public void enqueue(E e) {
		// 새 노드 생성
		Node<E> newNode = new Node<>(e);
		// 큐가 비어있는 경우
		if(size == 0) {
			top = newNode;
			size++;
			return;
		}
		
		// 큐의 마지막 노드를 찾아 새 노드를 연결
		Node<E> link = top;
		while(link.next() != null) {
			link = link.next();
		}
		
		link.next(newNode);
		size++;
	}
	
	/**
	 * 큐의 첫 번째 요소를 제거하고 반환합니다.
	 * 
	 * @return 제거된 요소, 큐가 비어있으면 null
	 */
	public E dequeue() {
		// 큐가 비어있는 경우
		if(top == null) return null;
		// 첫 번째 요소 저장
		E res = top.data();
		// 첫 번째 노드 제거
		top = top.next();
		size--;
		return res;
	}

	/**
	 * 큐의 문자열 표현을 반환합니다.
	 * 
	 * @return 큐의 내용을 포함한 문자열
	 */
	@Override
	public String toString() {
		Node<E> link = top;
		if(link == null) return "[]";

		// 문자열 조합을 위한 StringBuffer 사용
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		
		// 모든 노드를 순회하며 문자열에 추가
		while(link != null) {
			sb.append(link.data()).append(", ");
			link = link.next();
		}
		
		// 마지막 쉼표 제거 및 닫는 괄호 추가
		sb.deleteCharAt(sb.indexOf(","));
		sb.append("]");
		return sb.toString();
	}
}
