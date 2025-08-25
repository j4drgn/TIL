package com.mc.algorithm.h_dp;

/**
 * 동적 계획법(Dynamic Programming) 예제 - 피보나치 수열
 * 
 * 동적 계획법은 복잡한 문제를 더 작은 하위 문제로 나누고, 
 * 하위 문제의 결과를 저장하여 중복 계산을 피하는 알고리즘 기법입니다.
 * 
 * 이 클래스에서는 피보나치 수열을 계산하는 두 가지 방법을 비교합니다:
 * 1. 재귀적 접근법 - 비효율적, 중복 계산 발생
 * 2. 동적 계획법 접근 - 효율적, 중복 계산 방지
 */
public class DP {
	
	public static void main(String[] args) {
		// 피보나치 수열의 5번째 항 계산
		int n = 5;
		
		// 효율적인 동적 계획법 방식으로 계산
		int res = fibonacci(n);
		System.out.println(res);
		
		// 참고: 재귀적 방식은 큰 n 값에 대해 매우 비효율적이므로 호출하지 않음
		// int recursiveResult = fiboRecursive(n);
		// System.out.println(recursiveResult);
	}

	/**
	 * 재귀적 방식의 피보나치 수열 계산 함수
	 * 
	 * 작동 원리: F(n) = F(n-1) + F(n-2)
	 * 
	 * 문제점:
	 * - 중복 계산이 많이 발생 (예: F(3)이 F(5)와 F(4) 계산 시 중복 계산됨)
	 * - 시간 복잡도: O(2^n) - 지수적으로 증가
	 * - n이 커지면 스택 오버플로우 발생 가능
	 * 
	 * @param n 계산할 피보나치 수열의 항 번호
	 * @return n번째 피보나치 수
	 */
	private static int fiboRecursive(int n) {
		// 기저 조건: F(0) = 0
		if(n == 0) return 0;
		
		// 기저 조건: F(1) = F(2) = 1
		if(n == 1 || n == 2) return 1;
		
		// 재귀 호출: F(n) = F(n-1) + F(n-2)
		return fiboRecursive(n-1) + fiboRecursive(n-2);
	}
	
	/**
	 * 동적 계획법을 사용한 효율적인 피보나치 수열 계산 함수
	 * 
	 * 작동 원리:
	 * - 이전에 계산한 결과를 저장하여 재사용
	 * - 반복문을 사용하여 작은 값부터 계산해 나감
	 * - 필요한 값만 저장하여 공간 복잡도 최적화
	 * 
	 * 장점:
	 * - 시간 복잡도: O(n) - 선형 시간
	 * - 공간 복잡도: O(1) - 상수 공간
	 * - 스택 오버플로우 위험 없음
	 * 
	 * @param n 계산할 피보나치 수열의 항 번호
	 * @return n번째 피보나치 수, 유효하지 않은 입력(n < 1)에 대해서는 -1 반환
	 */
	private static int fibonacci(int n) {
		// 유효성 검사: n은 1 이상이어야 함
		if(n < 1) return -1;
		
		// n이 1 또는 2인 경우 1 반환
		if(n <= 2) return 1;
		
		// 이전 두 항을 저장할 변수 초기화
		int prev = 1;  // F(1) = 1
		int cur = 1;   // F(2) = 1
		
		// 3부터 n까지 피보나치 수 계산
		for (int i = 3; i <= n; i++) {
			// 현재 값을 임시 저장
			int temp = cur;
			
			// 현재 값 갱신: F(i) = F(i-1) + F(i-2)
			cur = prev + cur;
			
			// 이전 값 갱신: F(i-1) = temp (이전의 cur 값)
			prev = temp;
		}
		
		// n번째 피보나치 수 반환
		return cur;
	}
}