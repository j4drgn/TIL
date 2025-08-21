package com.mc.algorithm.d_datastructure.list;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 제네릭 타입을 지원하는 ArrayList 구현 클래스
 * 
 * 이 클래스는 Java의 ArrayList와 유사한 기능을 제공하는 사용자 정의 구현입니다.
 * 내부적으로 배열을 사용하여 요소를 저장하며, 필요에 따라 배열 크기를 동적으로 조정합니다.
 * 
 * @param <E> 리스트에 저장될 요소의 타입
 */
public class _ArrayList<E> implements Iterable<E> {
	
	/** 요소를 저장하는 내부 배열 */
	private Object[] elementData;
	
	/** 리스트의 현재 요소 개수 */
	private int size;
	
	/** 내부 배열의 현재 크기 */
	private int arraySize = 10;
	
	/**
	 * 기본 생성자
	 * 기본 크기(10)의 빈 ArrayList를 생성합니다.
	 */
	public _ArrayList() {
		elementData = new Object[arraySize];
	}
	
	/**
	 * 지정된 초기 용량으로 ArrayList를 생성하는 생성자
	 * 
	 * @param initialCapacity 초기 용량
	 */
	public _ArrayList(int initialCapacity) {
		this.arraySize = initialCapacity;
		elementData = new Object[arraySize];
	}

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
	 * 내부 배열이 가득 찬 경우, 배열 크기를 2배로 늘립니다.
	 * 
	 * @param e 추가할 요소
	 * @return 요소가 성공적으로 추가되면 true
	 */
	public boolean add(E e) {
		// 현재 배열에 여유 공간이 있는 경우
		if(size < arraySize) {
			elementData[size] = e;
			size++;
			return true;
		}
		
		// 배열이 가득 찬 경우, 배열 크기를 2배로 늘림
		arraySize *= 2;
		elementData = Arrays.copyOf(elementData, arraySize);
		elementData[size] = e;
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
		return (E) elementData[index];
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
		E prevElement = (E) elementData[index];
		elementData[index] = element;
		return prevElement;
	}
	
	/**
	 * 지정된 인덱스의 요소를 제거합니다.
	 * 제거 후 해당 인덱스 이후의 모든 요소를 한 칸씩 앞으로 이동시킵니다.
	 * 
	 * @param index 제거할 요소의 인덱스
	 * @return 제거된 요소
	 * @throws IndexOutOfBoundsException 인덱스가 범위를 벗어난 경우
	 */
	@SuppressWarnings("unchecked")
	public E remove(int index) {
		// 인덱스 유효성 검사
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException("인덱스 범위를 벗어났습니다.");
		E prevElement = (E) elementData[index];
		
		// 제거된 요소 이후의 모든 요소를 한 칸씩 앞으로 이동
		for (int i = index; i < size - 1; i++) {
			elementData[i] = elementData[i+1];
		}
		
		// 마지막 요소 참조 제거 및 크기 감소
		elementData[size - 1] = null;
		size--;
		return prevElement;
	}

	/**
	 * 리스트의 문자열 표현을 반환합니다.
	 * 
	 * @return 리스트의 내용을 포함한 문자열
	 */
	@Override
	public String toString() {
		return "_ArrayList [elementData=" + Arrays.toString(elementData) + "]";
	}

	/**
	 * 리스트를 순회하는 Iterator를 반환합니다.
	 * 이 메소드를 통해 향상된 for문(for-each)에서 리스트를 사용할 수 있습니다.
	 * 
	 * @return 리스트의 요소를 순회할 수 있는 Iterator
	 */
	@Override
	@SuppressWarnings("unchecked")
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
				return pointer < size ? true : false;
			}

			/**
			 * 다음 요소를 반환하고 포인터를 증가시킵니다.
			 * 
			 * @return 다음 요소
			 */
			@Override
			public E next() {
				E res = (E) elementData[pointer];
				pointer++;
				return res;
			}
		};
	}
}