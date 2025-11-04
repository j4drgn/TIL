package com.mc.algorithm.d_datastructure.list;

import java.util.Arrays;
import java.util.Iterator;


public class _ArrayList<E> implements Iterable<E> {
	
	private Object[] elementData;
	private int size;
	private int arraySize = 10;
	
	public _ArrayList() {
		elementData = new Object[arraySize];
	}
	
	public _ArrayList(int initialCapacity) {
		this.arraySize = initialCapacity;
		elementData = new Object[arraySize];
	}

	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean add(E e) {
		
		if(size < arraySize) {
			elementData[size] = e;
			size++;
			return true;
		}
		
		arraySize *= 2;
		elementData = Arrays.copyOf(elementData, arraySize);
		elementData[size] = e;
		size++;
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public E get(int index) {
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException("인덱스 범위를 벗어났습니다.");
		return (E) elementData[index];
	}
	
	@SuppressWarnings("unchecked")
	public E set(int index, E element) {
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException("인덱스 범위를 벗어났습니다.");
		E prevElement = (E) elementData[index];
		elementData[index] = element;
		return prevElement;
	}
	
	@SuppressWarnings("unchecked")
	public E remove(int index) {
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException("인덱스 범위를 벗어났습니다.");
		E prevElement = (E) elementData[index];
		
		for (int i = index; i < size - 1; i++) {
			elementData[i] = elementData[i+1];
		}
		
		elementData[size - 1] = null;
		size--;
		return prevElement;
	}

	@Override
	public String toString() {
		return "_ArrayList [elementData=" + Arrays.toString(elementData) + "]";
	}

	@Override
	@SuppressWarnings("unchecked")
	public Iterator<E> iterator() {
		return new Iterator<E>() {

			private int pointer = 0;
			
			@Override
			public boolean hasNext() {
				return pointer < size ? true : false;
			}

			@Override
			public E next() {
				E res = (E) elementData[pointer];
				pointer++;
				return res;
			}
		};
	}
	
}