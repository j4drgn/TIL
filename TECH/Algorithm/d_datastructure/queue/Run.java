package com.mc.algorithm.d_datastructure.queue;

public class Run {

	public static void main(String[] args) {
		
		_Queue<Integer> queue = new _Queue<Integer>();
		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);
		}
		

		for (int i = 0; i < 10; i++) {
			System.out.println(queue.dequeue());
			System.out.println(queue);
		}
		
	}

}
