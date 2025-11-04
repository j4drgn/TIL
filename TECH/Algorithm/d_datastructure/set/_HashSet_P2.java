package com.mc.algorithm.d_datastructure.set;

import java.util.Arrays;
import java.util.Iterator;

import com.mc.algorithm.d_datastructure.list.Node;

@SuppressWarnings("unchecked")
public class _HashSet_P2<E> implements Iterable<E> {
	
	private int arraySize = 2;
	private Object[] table;
	private int size = 0;
	
	public _HashSet_P2() {
		this.table = new Object[arraySize];
	}
	
	public _HashSet_P2(int initialCapacity) {
		this.table = new Object[initialCapacity];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return this.size;
	}
	
	private int hash(Object e) {
		int hashCode = Math.abs(e.hashCode());
		return hashCode % arraySize;
	}
	
	public boolean add(E e) {
		if(size == arraySize) {
			resize();
		}
		
		if(!addNode(e)) return false;
		size++;
		return true;
	}

	private boolean addNode(E e) {
		int index = hash(e);
		Node<E> node = new Node<E>(e);
		Node<E> head = (Node<E>) table[index];
		
		if(head == null) {
			table[index] = node;
			return true;
		}
		
		Node<E> link = head;
		while(link.next() != null) {
			if(link.data().equals(e)) return false;
			link = link.next();
		}
		
		if(link.data().equals(e)) return false;
		link.next(node);
		return true;
	}
	
	public boolean remove(E data) {
		int index = hash(data);
		Node<E> head = (Node<E>) table[index];
		
		if(head == null) return false;
		if(head.data().equals(data)) {
			table[index] = head.next();
			size--;
			return true;
		}
		
		Node<E> link = head.next();
		Node<E> prev = head;
		
		while(link != null) {
			if(link.data().equals(data)) {
				prev.next(link.next());
				size--;
				return true;
			}
			
			prev = link;
			link = link.next();
		}
		
		return false;
	}

	private void resize() {
		Object[] temp = Arrays.copyOf(table, arraySize);
		arraySize *= 2;
		table = new Object[arraySize];
		
		for (int i = 0; i < temp.length; i++) {
			if(temp[i] == null) continue;
			Node<E> link = (Node<E>) temp[i];
			
			while(link != null) {
				addNode(link.data());
				link = link.next();
			}
		}
	}
	
	@Override
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		
		for (int i = 0; i < table.length; i++) {
			if(table[i] == null) continue;
			Node<E> link = (Node<E>) table[i];
			while(link != null) {
				sb.append(link.data()).append(", ");
				link = link.next();
			}
		}
		
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append("]");
		return sb.toString();
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {

			private int cnt = 0;
			private int rowPointer = -1;
			private Node<E> prev = new Node<E>(null);
			
			@Override
			public boolean hasNext() {
				return cnt < size;
			}

			@Override
			public E next() {
				if(prev.next() != null) {
					E data = prev.data();
					prev = prev.next();
					cnt++;
					return data;
				}
				
				do {
					rowPointer++;
				}while(table[rowPointer] == null);
				
				prev = (Node<E>) table[rowPointer];
				E data = prev.data(); 
				cnt++;
				return data;
			}
		};
	}
}
