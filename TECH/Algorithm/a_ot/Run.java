package com.mc.algorithm.a_ot;

public class Run {

  public static void main(String[] args) {

    // a 에 담긴 값을 b에, b에 담긴 값을 a에 넣어주세요.
    // 단 대입연산자만 사용해야합니다.
    // 값을 직접 변수에 할당할 수는 없습니다.

    int a = 10;
    int b = 15;

    // (a ^ b) ^ b = a
    // (a ^ b) ^ a = b
    a = a ^ b;
    b = a ^ b;
    a = b ^ a;

    swap(a, b);

    //a xor 0은 언제나 a
    //a xor 1은 언제나 not a

    // a = 1001
    // b = 0101
  }

  private static void swap(int a, int b) {
    int c = a;
    a = b;
    b = c;

    System.out.println(a);
    System.out.println(b);
  }

}
