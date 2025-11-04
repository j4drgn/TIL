package com.mc.algorithm.d_datastructure.set;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class _HashSet_P1<E> {
	
	private Object[] table;
	private int arraySize = 6;
	private int size;
	
	public _HashSet_P1() {
		this.table = new Object[arraySize];
	}
	
	public _HashSet_P1(int initialCapacity) {
		this.table = new Object[initialCapacity];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return this.size;
	}
	
	// 해시함수의 원칙 
	//	같은 값이 들어오면 언제나 같은 값을 반환
	//  다른 값이 들어오면 언제나 다른 값을 반환
	// 해시충돌 : 다른 값이 들어왔는데 해시함수가 같은 해시값을 반환하는 경우
	private int hash(Object e) {
		int hashCode = Math.abs(e.hashCode());
		return hashCode % arraySize;
	}
	
	public boolean add(E e) {
		if(size == arraySize) {
			resize();
		}
		
		int index = hash(e);
		if(table[index] != null) return false;
		
		table[index] = e;
		size++;
		return true;
	}
	
	public boolean remove(Object e) {
		int index = hash(e);
		if(table[index] == null) return false;
		table[index] = null;
		size--;
		return true;
	}

	private void resize() {
		arraySize *= 2;
		Object[] temp = new Object[arraySize];
		for (int i = 0; i < table.length; i++) {
			if(table[i] == null) continue;
			int index = hash((E)table[i]);
			temp[index] = table[i];
		}
		
		table = temp;
	}

	@Override
	public String toString() {
		return "_HashSet_P1 [table=" + Arrays.toString(table) + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
