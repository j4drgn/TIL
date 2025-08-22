package com.mc.algorithm.f_bruteforce;

import com.mc.algorithm.util.SortUtil;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] arr = SortUtil.createRandamIntArray(100000);
		
		// 함수형프로그래밍을 지원하는 언어에서 함수는 1급객체
		// 1급객체 : 값으로 다루어 질 수 있다.
		//   => 반환값, 인자, 변수에 할당
		
		// 자바는 함수가 1급객체가 아님...
		// 자바의 람다는 함수가 1급객체처럼 보일 수 있도록 syntax sugar
		SortUtil.checkTime(() -> bubbleSort(arr));
		SortUtil.checkTime(() -> bubbleSort2(arr));
	}

	private static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if(arr[j] > arr[j+1]) {
					SortUtil.swap(arr, j, j+1);
				}
			}
		}
	}
	
	private static void bubbleSort2(int[] arr) {
		for (int i = 1; i <= arr.length; i++) {
			boolean notSwap = true;
			for (int j = 0; j < arr.length - i; j++) {
				if(arr[j] > arr[j+1]) {
					SortUtil.swap(arr, j, j+1);
					notSwap = false;
				}
			}
			
			if(notSwap) break;
		}
	}
	
	

}
