package com.mc.algorithm.g_divideandconcure;

import com.mc.algorithm.d_datastructure.stack._Stack;
import com.mc.algorithm.util.SortUtil;

/**
 * 퀵 정렬(Quick Sort) - 비재귀적 구현
 * 
 * 분할 정복 알고리즘의 또 다른 예시로, 피벗을 기준으로 배열을 분할하여 정렬합니다.
 * 이 구현은 재귀 대신 스택을 사용하여 메모리 효율성을 높였습니다.
 * 
 * 작동 원리:
 * 1. 배열에서 피벗 요소를 선택합니다(여기서는 첫 번째 요소).
 * 2. 피벗보다 작은 요소는 왼쪽으로, 큰 요소는 오른쪽으로 이동시킵니다(파티션).
 * 3. 파티션 후 생성된 두 부분 배열에 대해 과정을 반복합니다.
 * 
 * 시간 복잡도:
 * - 최선/평균: O(n log n)
 * - 최악: O(n²) - 이미 정렬된 배열이나 모든 요소가 같은 경우
 * 
 * 공간 복잡도: O(log n) - 스택 사용
 * 
 * 장점:
 * - 평균적으로 매우 빠름
 * - 추가 메모리 사용이 적음
 * - 캐시 지역성 우수
 * 
 * 단점:
 * - 최악의 경우 성능 저하
 * - 불안정 정렬(Unstable Sort)
 */
public class QuickSort {
	
	public static void main(String[] args) {
		// 1억 개의 랜덤 정수 배열 생성
		int[] arr = SortUtil.createRandamIntArray(100000000);
		
		// 퀵 정렬 실행 및 시간 측정
		SortUtil.checkTime(() ->{
			quickSort(arr, 0, arr.length-1);	
		});
	}
	
	/**
	 * 스택을 사용한 비재귀적 퀵 정렬 구현
	 * 재귀 호출 대신 스택을 사용하여 스택 오버플로우 방지
	 * 
	 * @param arr 정렬할 배열
	 * @param left 정렬 범위의 시작 인덱스
	 * @param right 정렬 범위의 끝 인덱스
	 */
	private static void quickSort(int[] arr, int left, int right) {
		// 기저 조건: 정렬할 요소가 1개 이하면 이미 정렬된 상태
		if(left >= right) return;
		
		// 분할 작업을 관리할 스택 생성
		_Stack<Integer> stack = new _Stack<Integer>();
		
		// 초기 범위를 스택에 추가
		stack.push(left);
		stack.push(right);
		
		// 스택이 비어있지 않은 동안 반복
		while(!stack.isEmpty()) {
			// 현재 처리할 범위를 스택에서 꺼냄
			right = stack.pop();
			left = stack.pop();
			
			// 현재 범위를 파티셔닝하여 피벗 위치 결정
			int pivotIndex = partition(arr, left, right);
			
			// 피벗 왼쪽 부분 배열이 존재하면 스택에 추가
			if(pivotIndex -1 > left) {
				stack.push(left);
				stack.push(pivotIndex -1);
			}
			
			// 피벗 오른쪽 부분 배열이 존재하면 스택에 추가
			if(pivotIndex + 1 < right) {
				stack.push(pivotIndex + 1);
				stack.push(right);
			}
		}
	}

	/**
	 * 배열의 특정 범위를 피벗을 기준으로 분할하는 메소드
	 * 
	 * @param arr 분할할 배열
	 * @param first 분할 범위의 시작 인덱스
	 * @param last 분할 범위의 끝 인덱스
	 * @return 피벗의 최종 위치 인덱스
	 */
	private static int partition(int[] arr, int first, int last) {
		// 첫 번째 요소를 피벗으로 선택
		int pivotElement = arr[first];
		
		// 왼쪽 포인터와 오른쪽 포인터 초기화
		int lp = first;  // 왼쪽에서 오른쪽으로 이동하는 포인터
		int rp = last;   // 오른쪽에서 왼쪽으로 이동하는 포인터
		
		while(true) {
			// 피벗보다 큰 요소를 찾을 때까지 왼쪽 포인터 이동
			while(lp < last && arr[lp] <= pivotElement ) {
				lp++;
			}
			
			// 피벗보다 작거나 같은 요소를 찾을 때까지 오른쪽 포인터 이동
			while(rp > first && arr[rp] > pivotElement) {
				rp--;
			}
			
			// 포인터가 교차하면 분할 완료
			if(lp >= rp) break;
			
			// 두 요소 교환
			SortUtil.swap(arr, lp, rp);
			
			// 포인터 이동
			lp++;
			rp--;
		}
		
		// 피벗을 올바른 위치로 이동
		SortUtil.swap(arr, first, rp);
		
		// 피벗의 최종 위치 반환
		return rp;
	}
}