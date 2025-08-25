package com.mc.algorithm.g_divideandconcure;

import com.mc.algorithm.util.SortUtil;

/**
 * 병합 정렬(Merge Sort) - 상향식(Bottom-up) 구현
 * 
 * 가장 작은 부분 문제부터 해결하여 큰 문제로 확장해 나가는 방식입니다.
 * 재귀 호출을 사용하지 않고 반복문으로 구현하여 스택 오버플로우 위험이 없습니다.
 * 
 * 작동 원리:
 * 1. 크기가 1인 부분 배열부터 시작합니다.
 * 2. 인접한 부분 배열들을 병합하며 크기를 2배씩 늘려갑니다.
 * 3. 전체 배열이 정렬될 때까지 반복합니다.
 * 
 * 시간 복잡도: O(n log n)
 * 공간 복잡도: O(n)
 * 
 * 장점:
 * - 재귀 호출 오버헤드 없음
 * - 캐시 지역성 향상 가능
 * 
 * 단점:
 * - 구현이 약간 복잡함
 * - 여전히 추가 메모리 필요
 */
public class ButtomupMergeSort {
	
	public static void main(String[] args) {
		// 1억 개의 랜덤 정수 배열 생성
		int[] a = SortUtil.createRandamIntArray(100000000);
		
		// 상향식 병합 정렬 실행 및 시간 측정
		SortUtil.checkTime(() -> {
			mergeSort(a);
			//System.out.println(Arrays.toString(a));
		});
	}
	
	/**
	 * 상향식 병합 정렬 알고리즘
	 * 작은 부분 배열부터 시작하여 점점 큰 배열로 병합해 나감
	 * 
	 * @param arr 정렬할 배열
	 */
	private static void mergeSort(int[] arr) {
		int n = arr.length;
		
		// size: 병합할 부분 배열의 크기 (1, 2, 4, 8, ...)
		for (int size = 1; size < n; size *= 2) {
			// left: 첫 번째 부분 배열의 시작 인덱스
			for (int left = 0; left < n-1; left += 2 * size) {
				// mid: 첫 번째 부분 배열의 끝 인덱스
				int mid = Math.min(left + size - 1, n-1);
				// right: 두 번째 부분 배열의 끝 인덱스
				int right = Math.min(left + 2 * size -1, n-1);
				
				// 두 부분 배열 병합
				merge(arr, left, mid, right);
			}
		}
	}

	/**
	 * 원본 배열의 특정 범위에 있는 두 부분 배열을 병합
	 * 
	 * @param arr 원본 배열
	 * @param left 첫 번째 부분 배열의 시작 인덱스
	 * @param mid 첫 번째 부분 배열의 끝 인덱스
	 * @param right 두 번째 부분 배열의 끝 인덱스
	 */
	static void merge(int[] arr, int left, int mid, int right) {
		// 두 부분 배열의 크기 계산
		int lSize = mid - left + 1;
		int rSize = right - mid;
		
		// 두 번째 부분 배열이 없으면 병합할 필요 없음
		if(rSize == 0) return;
		
		// 임시 배열 생성
		int[] l = new int[lSize];
		int[] r = new int[rSize];
		
		// 첫 번째 부분 배열 복사
		for (int i = 0; i < lSize; i++) {
			l[i] = arr[left + i];
		}
		
		// 두 번째 부분 배열 복사
		for (int i = 0; i < rSize; i++) {
			r[i] = arr[mid + 1 + i];
		}
		
		// 병합 과정을 위한 인덱스 초기화
		int i = 0;  // 첫 번째 부분 배열 인덱스
		int j = 0;  // 두 번째 부분 배열 인덱스
		int k = left;  // 결과 배열(원본 배열) 인덱스
		
		// 두 부분 배열을 비교하며 작은 값을 결과 배열에 삽입
		while(i < lSize && j < rSize) {
			if(l[i] < r[j]) {
				arr[k] = l[i];
				i++;
			}else {
				arr[k] = r[j];
				j++;
			}
			k++;
		}
		
		// 첫 번째 부분 배열에 남은 요소가 있으면 결과 배열에 추가
		while(i < lSize) {
			arr[k] = l[i];
			k++;
			i++;
		}
		
		// 두 번째 부분 배열에 남은 요소가 있으면 결과 배열에 추가
		while(j < rSize) {
			arr[k] = r[j];
			k++;
			j++;
		}
	}
}