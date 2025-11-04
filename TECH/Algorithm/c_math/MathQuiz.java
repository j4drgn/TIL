package com.mc.algorithm.c_math;

/**
 * 수학 관련 알고리즘 문제들을 다루는 클래스
 * 
 * 이 클래스는 소수 판별, 최대공약수, 최소공배수, 팩토리얼 등의
 * 기본적인 수학 알고리즘을 구현하고 테스트합니다.
 */
public class MathQuiz {

	/**
	 * 메인 메소드 - 다양한 수학 함수들을 테스트합니다.
	 * 
	 * @param args 명령행 인자
	 */
	public static void main(String[] args) {
		System.out.printf("소수입니까? : %s \n", isPrime2(11));
		System.out.printf("12, 18의 최대공약수 : %d \n", gcd2(12,18));
		System.out.printf("12, 18의 최소공배수 : %d \n", lcm(12, 18));
		System.out.printf("5! : %d \n", factorial(5));
		System.out.printf("5! : %d \n", factorialTail(5,1));
	}

	/**
	 * 일반적인 재귀를 사용한 팩토리얼 계산 메소드
	 * 
	 * 재귀적으로 팩토리얼을 계산합니다.
	 * n! = n * (n-1)! 공식을 사용합니다.
	 * 
	 * @param i 팩토리얼을 계산할 정수
	 * @return 팩토리얼 계산 결과
	 * @throws IllegalArgumentException 음수가 입력될 경우 예외 발생
	 */
	private static int factorial(int i) {
		// 음수 팩토리얼은 정의되지 않으므로 예외 발생
		if(i < 0 ) throw new IllegalArgumentException("음수 펙토리얼은 존재하지 않습니다.");
		// 0! 또는 1!은 1
		if(i <= 1) return 1;
		
		// 재귀적 호출 과정 예시:
		// 5 * factorial(4) => 5 * 4 * 3 * 2 * 1
		//		4 * factorial(3) => 4 * 3 * 2 * 1
		//			3 * factorial(2) => 3 * 2 * 1
		//				2 * factorial(1) => 2 * 1
		return i * factorial(i-1);
	}
	
	/**
	 * 꼬리 재귀(tail recursion)를 사용한 팩토리얼 계산 메소드
	 * 
	 * 꼬리 재귀는 반환부에 연산이 없는 재귀함수로,
	 * 일부 컴파일러에서는 내부적으로 반복문으로 최적화됩니다.
	 * (단, 자바 컴파일러는 이러한 최적화를 지원하지 않습니다.)
	 * 
	 * @param i 팩토리얼을 계산할 정수
	 * @param res 현재까지의 계산 결과
	 * @return 팩토리얼 계산 결과
	 * @throws IllegalArgumentException 음수가 입력될 경우 예외 발생
	 */
	private static int factorialTail(int i, int res) {
		// 음수 팩토리얼은 정의되지 않으므로 예외 발생
		if(i < 0 ) throw new IllegalArgumentException("음수 펙토리얼은 존재하지 않습니다.");
		// 기저 조건: i가 0이나 1일 때 현재까지의 결과 반환
		if(i <= 1) return res;
		
		// 현재 값을 결과에 곱함
		res = i * res;
		// 다음 단계로 재귀 호출 (i를 감소시키고 갱신된 결과 전달)
		return factorialTail(--i, res);
	}

	/**
	 * 최소공배수(LCM)를 계산하는 메소드
	 * 
	 * 최소공배수는 두 수의 곱을 최대공약수로 나눈 값입니다.
	 * LCM(a, b) = (a * b) / GCD(a, b)
	 * 
	 * @param i 첫 번째 정수
	 * @param j 두 번째 정수
	 * @return 두 정수의 최소공배수
	 */
	private static int lcm(int i, int j) {
		// 최대공약수 계산
		int gcd = gcd2(i, j);
		// 최소공배수 = (a * b) / 최대공약수
		return i * j / gcd;
	}

	/**
	 * 기본적인 방법으로 최대공약수(GCD)를 계산하는 메소드
	 * 
	 * 두 수 중 작은 수부터 시작하여 1까지 감소시키면서
	 * 두 수를 모두 나눌 수 있는 가장 큰 수를 찾습니다.
	 * 
	 * @param a 첫 번째 정수
	 * @param b 두 번째 정수
	 * @return 두 정수의 최대공약수
	 */
	private static int gcd(int a, int b) {
		// 두 수 중 작은 수 찾기
		int min = Math.min(a, b);
		
		// 작은 수부터 1까지 감소시키며 공약수 찾기
		for (int i = min; i > 0; i--) {
			// 두 수를 모두 나눌 수 있으면 그 수가 최대공약수
			if(a % i == 0 && b % i == 0) {
				return i;
			}
		}
		
		// 공약수가 1밖에 없는 경우 (서로소)
		return 1;
	}
	
	/**
	 * 유클리드 호제법을 이용한 최대공약수(GCD) 계산 메소드
	 * 
	 * 유클리드 호제법 원리:
	 * a와 b가 최대공약수 G를 가질 때, a를 b로 나눈 나머지도 G를 약수로 가집니다.
	 * 따라서 GCD(a, b) = GCD(b, a % b)가 성립합니다.
	 * 
	 * 수학적 증명:
	 * a = MG, b = NG (M, N은 서로소)
	 * a = bq + r (q: 몫, r: 나머지)
	 * MG = NGq + r
	 * r = MG - NGq = G(M - Nq)
	 * 따라서 r도 G의 배수입니다.
	 * 
	 * @param a 첫 번째 정수
	 * @param b 두 번째 정수
	 * @return 두 정수의 최대공약수
	 */
	private static int gcd2(int a, int b) {
		// b가 0이 될 때까지 반복
		while(b > 0) {
			// a를 b로 나눈 나머지를 계산하기 위해 임시 변수에 b 저장
			int temp = b;
			// b를 a를 b로 나눈 나머지로 업데이트
			b = a % b;
			// a를 이전 b 값으로 업데이트
			a = temp;
		}
		// b가 0이 되면 a가 최대공약수
		return a;
	}
	
	/**
	 * 기본적인 방법으로 소수(Prime Number)를 판별하는 메소드
	 * 
	 * 2부터 (num-1)까지의 모든 수로 나누어 보고,
	 * 나누어 떨어지는 수가 없으면 소수로 판별합니다.
	 * 
	 * @param num 소수 여부를 판별할 정수
	 * @return 소수이면 true, 아니면 false
	 */
	private static boolean isPrime(int num) {
		// 2는 소수
		if(num == 2) return true;
		// 2를 제외한 모든 짝수는 소수가 아님
		if(num % 2 == 0) return false;
		
		// 3부터 (num-1)까지 모든 수로 나누어 봄
		for (int i = 3; i < num; i++) {
			// 나누어 떨어지면 소수가 아님
			if(num % i == 0) return false;
		}
		
		// 모든 검사를 통과하면 소수
		return true;
	}
	
	/**
	 * 최적화된 방법으로 소수(Prime Number)를 판별하는 메소드
	 * 
	 * 약수의 특성을 이용하여 sqrt(num)까지만 검사합니다.
	 * 약수는 항상 쌍으로 존재하며, 그 쌍 중 하나는 반드시 sqrt(num) 이하입니다.
	 * 
	 * @param num 소수 여부를 판별할 정수
	 * @return 소수이면 true, 아니면 false
	 */
	private static boolean isPrime2(int num) {
		// 2는 소수
		if(num == 2) return true;
		// 2를 제외한 모든 짝수는 소수가 아님
		if(num % 2 == 0) return false;
		
		// 3부터 sqrt(num)까지만 검사
		// 약수는 쌍으로 존재하며, 그 쌍 중 하나는 반드시 sqrt(num) 이하임
		// 예: 16의 약수는 1, 2, 4, 8, 16이고, sqrt(16) = 4까지만 검사하면 됨
		for(int i = 3; i <= Math.sqrt(num); i++) {
			// 나누어 떨어지면 소수가 아님
			if(num % i == 0) return false;
		}
		
		// 모든 검사를 통과하면 소수
		return true;
	}
}
