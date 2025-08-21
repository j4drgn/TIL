package com.mc.algorithm.d_datastructure.stack;

import java.util.EmptyStackException;

import com.mc.algorithm.d_datastructure.list.Node;

/**
 * 제네릭 타입을 지원하는 스택(Stack) 구현 클래스
 * 
 * 이 클래스는 LIFO(Last-In-First-Out) 방식으로 동작하는 스택 자료구조를 구현합니다.
 * 내부적으로 연결 리스트를 사용하여 요소를 저장합니다.
 * 
 * @param <E> 스택에 저장될 요소의 타입
 */
public class _Stack<E> {
	
	/** 스택의 최상단 노드 */
	private Node<E> top;
	
	/** 스택의 요소 개수 */
	private int size;
	
	/**
	 * 스택의 최상단에 요소를 추가합니다.
	 * 
	 * @param e 추가할 요소
	 * @return 추가된 요소
	 */
	public E push(E e) {
		// 새 노드 생성
		Node<E> newNode = new Node<>(e);
		
		// 스택이 비어있는 경우
		if(top == null) {
			top = newNode;
			size++;
			return e;
		}
		
		// 새 노드를 최상단에 연결
		newNode.next(top);
		top = newNode;
		size++;
		return e;
	}
	
	/**
	 * 스택의 최상단 요소를 제거하지 않고 반환합니다.
	 * 
	 * @return 스택의 최상단 요소
	 * @throws EmptyStackException 스택이 비어있는 경우
	 */
	public E peek() {
		if(size == 0) throw new EmptyStackException();
		return top.data();
	}
	
	/**
	 * 스택의 최상단 요소를 제거하고 반환합니다.
	 * 
	 * @return 제거된 요소
	 * @throws EmptyStackException 스택이 비어있는 경우
	 */
	public E pop() {
		if(size == 0) throw new EmptyStackException();
		E res = top.data();
		top = top.next();
		size--;
		return res;
	}
	
	/**
	 * 스택이 비어있는지 확인합니다.
	 * 
	 * @return 스택이 비어있으면 true, 그렇지 않으면 false
	 */
	public boolean isEmpty() {
		return size == 0;
	}
}
