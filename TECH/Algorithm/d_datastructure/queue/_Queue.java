package com.mc.algorithm.d_datastructure.queue;

import com.mc.algorithm.d_datastructure.list.Node;

public class _Queue<E> {
	
	private Node<E> top;
	private int size;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void enqueue(E e) {
		Node<E> newNode = new Node<>(e);
		if(size == 0) {
			top = newNode;
			size++;
			return;
		}
		
		Node<E> link = top;
		while(link.next() != null) {
			link = link.next();
		}
		
		link.next(newNode);
		size++;
	}
	
	public E dequeue() {
		if(top == null) return null;
		E res = top.data();
		top = top.next();
		size--;
		return res;
	}

	@Override
	public String toString() {
		Node<E> link = top;
		if(link == null) return "[]";

		StringBuffer sb = new StringBuffer();
		sb.append("[");
		
		while(link != null) {
			sb.append(link.data()).append(", ");
			link = link.next();
		}
		
		sb.deleteCharAt(sb.indexOf(","));
		sb.append("]");
		return sb.toString();
	}
	
	
	
	
	
	

}
