package com.mc.algorithm.g_divideandconcure;

import com.mc.algorithm.util.SortUtil;

/**
 * 분할 정복 알고리즘의 응용 예제 - 거듭제곱 계산
 * 
 * 이 클래스는 분할 정복 방법을 사용하여 a의 b승을 효율적으로 계산하는 방법을 구현합니다.
 * 일반적인 반복문으로 계산하면 O(b) 시간이 걸리지만, 분할 정복을 사용하면 O(log b) 시간에 계산 가능합니다.
 */
public class Quiz {

  public static void main(String[] args) {
    // 거듭제곱 함수 테스트
    q1();
  }

  /**
   * 거듭제곱 함수를 테스트하는 메소드
   * 2^10과 5^13의 결과를 계산하여 출력합니다.
   */
  private static void q1() {
    System.out.println("--- 거듭제곱 함수 테스트 시작 ---");

    // 첫 번째 테스트 케이스: 2^10
    long base = 2;
    long exponent = 10;
    long result = power(base, exponent);
    System.out.println(base + "의 " + exponent + " 제곱은 " + result + "입니다."); // 예상 결과: 1024

    // 두 번째 테스트 케이스: 5^13
    base = 5;
    exponent = 13;
    result = power(base, exponent);
    System.out.println(base + "의 " + exponent + " 제곱은 " + result + "입니다."); // 예상 결과: 1220703125

    System.out.println("--- 거듭제곱 함수 테스트 종료 ---");
  }

  /**
   * 분할 정복을 이용한 거듭제곱 계산 함수
   * a^b를 O(log b) 시간 복잡도로 계산합니다.
   * 
   * 작동 원리:
   * 1. b가 짝수일 때: a^b = (a^(b/2))^2
   * 2. b가 홀수일 때: a^b = a * (a^(b/2))^2
   * 
   * 예시: 2^10 계산
   * power(2, 10) -> temp = power(2, 5) = 32, return 32*32 = 1024
   *   power(2, 5) -> temp = power(2, 2) = 4, return 2*4*4 = 32
   *     power(2, 2) -> temp = power(2, 1) = 2, return 2*2 = 4
   *       power(2, 1) -> temp = power(2, 0) = 1, return 2*1 = 2
   *         power(2, 0) -> return 1
   *
   * @param a 밑 (base)
   * @param b 지수 (exponent)
   * @return a^b의 결과값
   */
  public static long power(long a, long b) {
    // 1. 종료 조건 (Base Case): 지수가 0이면 1을 반환합니다.
    if (b == 0) {
      return 1;
    }

    // 2. 분할 및 정복 (Divide and Conquer): b/2에 대한 거듭제곱을 재귀적으로 계산합니다.
    long temp = power(a, b / 2);

    // 3. 조합 (Combine): 계산된 하위 문제의 결과를 조합합니다.
    long result = temp * temp;

    // 4. 지수 b가 홀수인 경우, 밑 a를 한 번 더 곱해줍니다.
    if (b % 2 != 0) {
      result *= a;
    }

    return result;
  }

  /**
   * 2차원 배열 초기화 성능을 측정하는 메소드
   * 현재는 사용하지 않음 (주석 처리됨)
   */
  private static void extracted() {
    int size = 10240;
    int[][] dArr = new int[size][size];

    // 배열 초기화 시간 측정
    long startTime = System.nanoTime();
    for (int i = 0; i < dArr.length; i++) {
      for (int j = 0; j < dArr[i].length; j++) {
        dArr[i][j] = i;
      }
    }
    long endTime = System.nanoTime();
    System.out.println("배열 초기화에 걸린 시간: " + (endTime - startTime) / 1_000_000.0 + " ms");
  }
}