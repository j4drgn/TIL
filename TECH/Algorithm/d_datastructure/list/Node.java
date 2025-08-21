package com.mc.algorithm.d_datastructure.list;

/**
 * 연결 리스트에서 사용되는 노드 클래스
 * 
 * 이 클래스는 연결 리스트의 기본 구성 요소로, 데이터와 다음 노드에 대한 참조를 저장합니다.
 * 제네릭 타입을 지원하여 다양한 타입의 데이터를 저장할 수 있습니다.
 * 
 * @param <E> 노드에 저장될 데이터의 타입
 */
public class Node<E> {
	
	/** 다음 노드에 대한 참조 */
	private Node<E> next;
	
	/** 노드에 저장된 데이터 */
	private E data;

	/**
	 * 기본 생성자
	 * 데이터와 다음 노드 참조가 null인 빈 노드를 생성합니다.
	 */
	public Node() {
	}
	
	/**
	 * 지정된 데이터로 노드를 생성하는 생성자
	 * 
	 * @param data 노드에 저장할 데이터
	 */
	public Node(E data) {
		super();
		this.data = data;
	}

	/**
	 * 다음 노드를 반환하는 getter 메소드
	 * 
	 * @return 다음 노드에 대한 참조
	 */
	public Node<E> next(){
		return next;
	}
	
	/**
	 * 다음 노드를 설정하는 setter 메소드
	 * 
	 * @param next 설정할 다음 노드
	 */
	public void next(Node<E> next) {
		this.next = next;
	}

	/**
	 * 노드의 데이터를 설정하는 setter 메소드
	 * 
	 * @param data 설정할 데이터
	 */
	public void data(E data) {
		this.data = data;
	}
	
	/**
	 * 노드의 데이터를 반환하는 getter 메소드
	 * 
	 * @return 노드에 저장된 데이터
	 */
	public E data() {
		return this.data;
	}

	/**
	 * 노드의 문자열 표현을 반환하는 메소드
	 * 
	 * @return 노드의 데이터를 문자열로 변환한 값
	 */
	@Override
	public String toString() {
		return data.toString();
	}
}