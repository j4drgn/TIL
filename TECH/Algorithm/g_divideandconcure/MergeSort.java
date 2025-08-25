package com.mc.algorithm.g_divideandconcure;

import java.util.Arrays;

import com.mc.algorithm.util.SortUtil;

/**
 * 병합 정렬(Merge Sort) - 하향식(Top-down) 구현
 * 
 * 분할 정복(Divide and Conquer) 알고리즘의 대표적인 예시입니다.
 * 큰 문제를 작은 부분으로 분할하고, 해결한 다음 다시 합치는 방식으로 동작합니다.
 * 
 * 작동 원리:
 * 1. 분할(Divide): 배열을 절반으로 나눕니다.
 * 2. 정복(Conquer): 나눈 배열을 재귀적으로 정렬합니다.
 * 3. 병합(Merge): 정렬된 두 배열을 하나의 정렬된 배열로 합칩니다.
 * 
 * 시간 복잡도: O(n log n) - 모든 경우에서 동일한 성능을 보장합니다.
 * 공간 복잡도: O(n) - 추가 배열이 필요합니다.
 * 
 * 장점:
 * - 안정적인 정렬(Stable Sort)
 * - 대용량 데이터 처리에 효율적
 * 
 * 단점:
 * - 추가 메모리 공간 필요
 * - 작은 데이터셋에서는 오버헤드 발생 가능
 */
public class MergeSort {
	
	public static void main(String[] args) {
		// 1억 개의 랜덤 정수 배열 생성
		int[] a = SortUtil.createRandamIntArray(100000000);
		
		// 병합 정렬 실행 및 시간 측정
		SortUtil.checkTime(() -> {
			mergeSort(a);
		});
	}

	/**
	 * 병합 정렬 알고리즘의 핵심 메소드
	 * 
	 * @param arr 정렬할 배열
	 * @return 정렬된 새 배열
	 */
	private static int[] mergeSort(int[] arr) {
		int n = arr.length;
		
		// 기저 조건: 배열 크기가 0 또는 1이면 이미 정렬된 상태로 간주
		if(n <= 1) return arr;
		
		// 배열을 중간 지점에서 분할
		int mid = n/2;
		
		// 왼쪽 부분 배열을 재귀적으로 정렬
		int[] arr1 = mergeSort(Arrays.copyOfRange(arr, 0, mid));
		
		// 오른쪽 부분 배열을 재귀적으로 정렬
		int[] arr2 = mergeSort(Arrays.copyOfRange(arr, mid, n));
		
		// 정렬된 두 배열을 병합
		return merge(arr1, arr2);
	}

	/**
	 * 두 개의 정렬된 배열을 하나의 정렬된 배열로 병합
	 * 
	 * @param a 첫 번째 정렬된 배열
	 * @param b 두 번째 정렬된 배열
	 * @return 병합된 정렬 배열
	 */
	private static int[] merge(int[] a, int[] b) {
		// 결과 배열 생성
		int[] res = new int[a.length + b.length];
		
		// 각 배열의 포인터와 결과 배열의 인덱스
		int p1 = 0;  // 첫 번째 배열 포인터
		int p2 = 0;  // 두 번째 배열 포인터
		int idx = 0; // 결과 배열 인덱스
		
		// 두 배열을 비교하며 작은 값을 결과 배열에 삽입
		while(p1 < a.length && p2 < b.length) {
			if(a[p1] < b[p2]) {
				res[idx] = a[p1];
				p1++;
			} else {
				res[idx] = b[p2];
				p2++;
			}
			idx++;
		}
		
		// 첫 번째 배열에 남은 요소가 있으면 결과 배열에 추가
		while(p1 < a.length) {
			res[idx] = a[p1];
			p1++;
			idx++;
		}
		
		// 두 번째 배열에 남은 요소가 있으면 결과 배열에 추가
		while(p2 < b.length) {
			res[idx] = b[p2];
			p2++;
			idx++;
		}
		
		return res;
	}
}