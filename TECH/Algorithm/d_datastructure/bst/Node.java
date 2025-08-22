package com.mc.algorithm.d_datastructure.bst;

public class Node<E> {
	
	private E data;
	private Node<E> left;
	private Node<E> right;
	
	public Node(E data) {
		super();
		this.data = data;
	}
	
	public E data(){
		return this.data;
	}
	
	public void data(E data) {
		this.data = data;
	}
	
	public Node<E> left(){
		return left;
	}
	
	public void left(Node<E> child) {
		this.left = child;
	}
	
	public Node<E> right(){
		return this.right;
	}
	
	public void right(Node<E> child) {
		this.right = child;
	}

	@Override
	public String toString() {
		return data.toString();
	}
	
	
	

}
