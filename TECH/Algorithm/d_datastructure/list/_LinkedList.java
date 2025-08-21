package com.mc.algorithm.d_datastructure.list;

import java.util.Iterator;

/**
 * 제네릭 타입을 지원하는 단방향 연결 리스트(LinkedList) 구현 클래스
 * 
 * 이 클래스는 Java의 LinkedList와 유사한 기능을 제공하는 사용자 정의 구현입니다.
 * 내부적으로 Node 객체들을 연결하여 요소를 저장하며, 동적으로 크기가 조정됩니다.
 * 
 * @param <E> 리스트에 저장될 요소의 타입
 */
public class _LinkedList<E> implements Iterable<E>{
	
	/** 연결 리스트의 첫 번째 노드(헤드) */
	private Node<E> head;
	
	/** 리스트의 현재 요소 개수 */
	private int size;
	
	/**
	 * 리스트의 요소 개수를 반환합니다.
	 * 
	 * @return 리스트의 요소 개수
	 */
	public int size() {
		return size;
	}
	
	/**
	 * 리스트가 비어있는지 확인합니다.
	 * 
	 * @return 리스트가 비어있으면 true, 그렇지 않으면 false
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * 리스트의 끝에 요소를 추가합니다.
	 * 
	 * @param e 추가할 요소
	 * @return 요소가 성공적으로 추가되면 true
	 */
	public boolean add(E e) {
		// 새 노드 생성
		Node<E> node = new Node<>(e);
		
		// 리스트가 비어있는 경우, 새 노드를 헤드로 설정
		if(head == null) {
			head = node;
			size++;
			return true;
		}
		
		// 리스트의 마지막 노드를 찾아 새 노드를 연결
		Node<E> link = head;
		while(link.next() != null) {
			link = link.next();
		}
		
		link.next(node);
		size++;
		return true;
	}
	
	/**
	 * 지정된 인덱스의 요소를 반환합니다.
	 * 
	 * @param index 요소를 가져올 인덱스
	 * @return 지정된 인덱스의 요소
	 * @throws IndexOutOfBoundsException 인덱스가 범위를 벗어난 경우
	 */
	@SuppressWarnings("unchecked")
	public E get(int index) {
		// 인덱스 유효성 검사
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException("인덱스 범위를 벗어났습니다.");
		
		// 지정된 인덱스까지 노드를 순회
		Node<E> link = head;
		for (int i = 0; i < index; i++) {
			link = link.next();
		}
		
		return link.data();
	}
	
	/**
	 * 지정된 인덱스의 요소를 새 요소로 교체합니다.
	 * 
	 * @param index 교체할 요소의 인덱스
	 * @param element 새 요소
	 * @return 이전에 해당 인덱스에 있던 요소
	 * @throws IndexOutOfBoundsException 인덱스가 범위를 벗어난 경우
	 */
	@SuppressWarnings("unchecked")
	public E set(int index, E element) {
		// 인덱스 유효성 검사
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException("인덱스 범위를 벗어났습니다.");
		
		// 지정된 인덱스까지 노드를 순회
		Node<E> link = head;
		for (int i = 0; i < index; i++) {
			link = link.next();
		}
		
		// 기존 데이터 저장 후 새 데이터로 교체
		E removed = link.data();
		link.data(element);
		return removed;
	}
	
	/**
	 * 지정된 인덱스의 요소를 제거합니다.
	 * 
	 * @param index 제거할 요소의 인덱스
	 * @return 제거된 요소
	 * @throws IndexOutOfBoundsException 인덱스가 범위를 벗어난 경우
	 */
	@SuppressWarnings("unchecked")
	public E remove(int index) {
		// 인덱스 유효성 검사
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException("인덱스 범위를 벗어났습니다.");
		
		// 첫 번째 요소를 제거하는 경우
		if(index == 0) {
			E removed = head.data();
			head = head.next();
			size--;
			return removed;
		}
		
		// 이전 노드와 현재 노드를 추적하며 순회
		Node<E> prevNode = head;
		Node<E> link = head.next();
		
		// 제거할 노드 위치까지 이동
		for (int i = 1; i < index; i++) {
			prevNode = link;
			link = link.next();
		}
		
		// 이전 노드를 제거할 노드의 다음 노드와 연결
		prevNode.next(link.next());
		E removed = link.data();
		size--;
		return removed;
	}

	/**
	 * 리스트의 문자열 표현을 반환합니다.
	 * 
	 * @return 리스트의 내용을 포함한 문자열
	 */
	@Override
	public String toString() {
		// 문자열 조합을 위한 StringBuffer 사용
		StringBuffer sb = new StringBuffer("[");
		
		// 모든 요소를 순회하며 문자열에 추가
		for (int i = 0; i < size; i++) {
			sb.append(get(i));
			sb.append(", ");
		}
		
		// 마지막 쉼표 제거 및 닫는 괄호 추가
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append("]");
		return sb.toString();
	}
	
	/**
	 * 리스트에 지정된 객체가 포함되어 있는지 확인합니다.
	 * 
	 * @param e 확인할 객체
	 * @return 객체가 리스트에 포함되어 있으면 true, 그렇지 않으면 false
	 */
	public boolean contains(Object e) {
		Node<E> link = head;
		
		// 모든 노드를 순회하며 일치하는 데이터 검색
		while(link != null) {
			if(link.data().equals(e)) return true;
			link = link.next();
		}
		
		return false;
	}
	
	/**
	 * 지정된 객체가 리스트에서 처음 나타나는 인덱스를 반환합니다.
	 * 
	 * @param e 검색할 객체
	 * @return 객체의 인덱스, 리스트에 없으면 -1
	 */
	public int indexOf(Object e) {
		Node<E> link = head;

		// 모든 노드를 순회하며 일치하는 데이터의 인덱스 검색
		for (int i = 0; i < size; i++) {
			if(link.data().equals(e)) return i;
			link = link.next();
		}
		
		// 일치하는 요소가 없는 경우
		return -1;
	}

	/**
	 * 리스트를 순회하는 Iterator를 반환합니다.
	 * 이 메소드를 통해 향상된 for문(for-each)에서 리스트를 사용할 수 있습니다.
	 * 
	 * @return 리스트의 요소를 순회할 수 있는 Iterator
	 */
	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			// 현재 위치를 추적하는 포인터
			private int pointer = 0;

			/**
			 * 다음 요소가 있는지 확인합니다.
			 * 
			 * @return 다음 요소가 있으면 true, 없으면 false
			 */
			@Override
			public boolean hasNext() {
				return pointer < size;
			}

			/**
			 * 다음 요소를 반환하고 포인터를 증가시킵니다.
			 * 
			 * @return 다음 요소
			 */
			@Override
			public E next() {
				E e = get(pointer);
				pointer++;
				return e;
			}
		};
	}
}