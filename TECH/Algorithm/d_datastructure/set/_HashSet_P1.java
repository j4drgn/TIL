package com.mc.algorithm.d_datastructure.set;

import java.util.Arrays;

/**
 * 기본적인 해시 집합(HashSet) 구현 클래스
 * 
 * 이 클래스는 해시 함수를 사용하여 요소를 저장하는 집합을 구현합니다.
 * 해시 충돌이 발생하면 단순히 추가를 거부하는 방식으로 처리합니다.
 * 제네릭 타입 E를 사용하여 다양한 타입의 요소를 저장할 수 있습니다.
 * 
 * @param <E> 집합에 저장될 요소의 타입
 */
@SuppressWarnings("unchecked")
public class _HashSet_P1<E> {
	
	/** 요소를 저장하는 내부 배열 */
	private Object[] table;
	
	/** 내부 배열의 크기 */
	private int arraySize = 6;
	
	/** 집합의 요소 개수 */
	private int size;
	
	/**
	 * 기본 생성자
	 * 기본 크기(6)의 빈 해시 집합을 생성합니다.
	 */
	public _HashSet_P1() {
		this.table = new Object[arraySize];
	}
	
	/**
	 * 지정된 초기 용량으로 해시 집합을 생성하는 생성자
	 * 
	 * @param initialCapacity 초기 용량
	 */
	public _HashSet_P1(int initialCapacity) {
		this.table = new Object[initialCapacity];
	}
	
	/**
	 * 집합이 비어있는지 확인합니다.
	 * 
	 * @return 집합이 비어있으면 true, 그렇지 않으면 false
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * 집합의 요소 개수를 반환합니다.
	 * 
	 * @return 집합의 요소 개수
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * 객체의 해시 코드를 계산하는 해시 함수
	 * 
	 * 해시 함수의 원칙:
	 * 1. 같은 값이 들어오면 언제나 같은 값을 반환
	 * 2. 다른 값이 들어오면 언제나 다른 값을 반환 (이상적인 경우)
	 * 
	 * 해시 충돌: 다른 값이 들어왔는데 해시 함수가 같은 해시값을 반환하는 경우
	 * 
	 * @param e 해시 코드를 계산할 객체
	 * @return 계산된 해시 코드(배열 인덱스)
	 */
	private int hash(Object e) {
		// 객체의 hashCode 메소드를 호출하고 절대값으로 변환
		int hashCode = Math.abs(e.hashCode());
		// 배열 크기로 모듈러 연산하여 배열 인덱스 범위 내의 값으로 변환
		return hashCode % arraySize;
	}
	
	/**
	 * 집합에 요소를 추가합니다.
	 * 
	 * 해시 충돌이 발생하면(같은 인덱스에 이미 요소가 있으면) 추가를 거부합니다.
	 * 배열이 가득 찬 경우, 배열 크기를 2배로 늘립니다.
	 * 
	 * @param e 추가할 요소
	 * @return 요소가 성공적으로 추가되면 true, 이미 존재하면 false
	 */
	public boolean add(E e) {
		// 배열이 가득 찬 경우, 크기 조정
		if(size == arraySize) {
			resize();
		}
		
		// 해시 함수를 사용하여 인덱스 계산
		int index = hash(e);
		// 해당 인덱스에 이미 요소가 있으면 추가 실패
		if(table[index] != null) return false;
		
		// 요소 추가 및 크기 증가
		table[index] = e;
		size++;
		return true;
	}
	
	/**
	 * 집합에서 요소를 제거합니다.
	 * 
	 * @param e 제거할 요소
	 * @return 요소가 성공적으로 제거되면 true, 존재하지 않으면 false
	 */
	public boolean remove(Object e) {
		// 해시 함수를 사용하여 인덱스 계산
		int index = hash(e);
		// 해당 인덱스에 요소가 없으면 제거 실패
		if(table[index] == null) return false;
		// 요소 제거 및 크기 감소
		table[index] = null;
		size--;
		return true;
	}

	/**
	 * 내부 배열의 크기를 2배로 늘리는 메소드
	 * 
	 * 기존 요소들을 새 배열에 재배치합니다.
	 * 배열 크기가 변경되면 해시 값도 변경되므로 모든 요소를 다시 해싱해야 합니다.
	 */
	private void resize() {
		// 배열 크기를 2배로 증가
		arraySize *= 2;
		// 새 배열 생성
		Object[] temp = new Object[arraySize];
		// 기존 요소들을 새 배열에 재배치
		for (int i = 0; i < table.length; i++) {
			if(table[i] == null) continue;
			// 새 배열 크기에 맞게 해시 값 재계산
			int index = hash((E)table[i]);
			temp[index] = table[i];
		}
		
		// 새 배열로 교체
		table = temp;
	}

	/**
	 * 집합의 문자열 표현을 반환합니다.
	 * 
	 * @return 집합의 내용을 포함한 문자열
	 */
	@Override
	public String toString() {
		return "_HashSet_P1 [table=" + Arrays.toString(table) + "]";
	}
}