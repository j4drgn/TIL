package com.mc.algorithm.d_datastructure.bst;

import java.util.ArrayList;
import java.util.List;

import com.mc.algorithm.d_datastructure.list._LinkedList;
import com.mc.algorithm.d_datastructure.queue._Queue;
import com.mc.algorithm.d_datastructure.stack._Stack;

public class BinarySearchTree<E extends Comparable<E>> {
	
	private Node<E> root;
	private int size;
	
	public int size() {
		return this.size;
	}
	
	public void insert(E element) {
		Node<E> newNode = new Node<>(element);
		
		if(size == 0) {
			root = newNode;
			size++;
			return;
		}
		
		Node<E> link = root;
		
		while(true) {
			if(element.compareTo(link.data()) < 0) {
				if(link.left() == null) {
					link.left(newNode);
					break;
				}
				
				link = link.left();
			}else {
				if(link.right() == null) {
					link.right(newNode);
					break;
				}
				
				link = link.right();
			}
		}
		
		size++;
	}
	
	
	
	public void delete(E target) {
		
		Node<E> parent = null;
		Node<E> link = root;
		
		while(link != null && target.compareTo(link.data()) != 0) {
			parent = link;
			if(target.compareTo(link.data()) < 0) {
				link = link.left();
			}else {
				link = link.right();
			}
		}
		
		// 노드를 찾지 못한 경우
		if(link == null) return;
		
		// 삭제할 노드가 leaf 노드인 경우
		if(link.left() == null && link.right() == null) {
			deleteNode(parent, link, null);
			size--;
			return;
		}
		
		// 자식 노드가 둘인 경우
		if(link.left() != null && link.right() != null) {
			
			// 오른쪽 서브트리에서 가장 작은 노드(후계자) 찾기
			Node<E> successorParent = link;
			Node<E> successor = link.right();
			
			while(successor.left() != null) {
				successorParent = successor;
				successor = successor.left();
			}
			
			link.data(successor.data());
			
			// 후계자 노드가 리프노드인 경우
			if(successor.right() == null) {
				deleteNode(successorParent, successor, null);
				return;
			}
			
			// 후계자 노드의 자식노드가 1개만(오른쪽 자식 노드만 존재) 존재하는 경우
			deleteNode(successorParent, successor, successor.right());
			return;
		}
		
		// 자식 노드가 1개인 경우
		Node<E> child = link.left() != null ? link.left() : link.right();
		deleteNode(parent, link, child);
	}

	private void deleteNode(Node<E> parent, Node<E> current, Node<E> child) {
		// 노드가 root 인 경우
		if(parent == null) {
			root = child;
			return;
		}
		
		if(parent.left() != null && parent.left().equals(current)) {
			parent.left(child);
			return;
		}
		
		if(parent.right() == null) return;
		parent.right(child);
	}
	
	// bfs : 너비우선탐색
	// 현재 노드와 인접한 모든 노드를 탐색한 후, 그 다음 레벨의 노드를 탐색하는 방식
	// DB 인덱스를 사용해 데이터를 탐색
	public _LinkedList<E> bfs(){
		_Queue<Node<E>> queue = new _Queue<Node<E>>();
		_LinkedList<E> result = new _LinkedList<E>();
		
		queue.enqueue(root);
		int level = 1;
		
		while(!queue.isEmpty()) {
			System.out.print("level " + level + ": ");
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				Node<E> node = queue.dequeue();
				System.out.print(node.data() + " ");
				result.add(node.data());
				
				if(node.left() != null) {
					queue.enqueue(node.left());
				}
				
				if(node.right() != null) {
					queue.enqueue(node.right());
				}
			}
			
			level++;
			System.out.println();
		}
		
		return result;
	}
	

	public List<E> preOrderRecursive(){
		List<E> result = new ArrayList<E>();
		preOrderHelper(root, result);
		return result;
	}

	private void preOrderHelper(Node<E> node, List<E> result) {
		if(node == null) return;
		result.add(node.data()); // 현재노드 추가
		preOrderHelper(node.left(), result);
		preOrderHelper(node.right(), result);
	}
	
	public List<E> postOrderRecursive(){
		List<E> result = new ArrayList<E>();
		postOrderHelper(root, result);
		return result;
	}
	
	
	private void postOrderHelper(Node<E> node, List<E> result) {
		if(node == null) return;
		postOrderHelper(node.left(), result);
		postOrderHelper(node.right(), result);
		result.add(node.data());
	}

	public List<E> preOrder(){
		_Stack<Node<E>> stack = new _Stack<>();
		List<E> result = new ArrayList<E>();
		
		stack.push(root);
		
		while(!stack.isEmpty()) {
			
			Node<E> pointer = stack.pop();
			result.add(pointer.data());
			
			if(pointer.right() != null) {
				stack.push(pointer.right());
			}
			
			if(pointer.left() != null) {
				stack.push(pointer.left());
			}
		}
		
		return result;
	}
	
	
	public List<E> inOrderRecursive(){
		List<E> result = new ArrayList<E>();
		inOrderHelper(root, result);
		return result;
		
	}

	private void inOrderHelper(Node<E> node, List<E> result) {
		if(node == null) return;
		inOrderHelper(node.left(), result);
		result.add(node.data());
		inOrderHelper(node.right(), result);
	}
	
	
	
	
	

}
