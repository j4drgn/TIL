package com.mc.algorithm.b_star;

import java.util.Scanner;

public class Diamond {

  public static void main(String[] args) {

    int input = new Scanner(System.in).nextInt();

    for (int i = 1; i <= input; i++) {
      for (int j = 1; j <= input - i; j++) {
        System.out.print(" ");
      }
      // 별을 찍는 반복문
      for (int k = 1; k <= 2 * i - 1; k++) {
        System.out.print("*");
      }
      // 한 줄이 끝나면 줄바꿈
      System.out.println();
    }
    for (int i = input - 1; i >= 1; i--) {
      // 공백을 찍는 반복문
      for (int j = 1; j <= input - i; j++) {
        System.out.print(" ");
      }
      // 별을 찍는 반복문
      for (int k = 1; k <= 2 * i - 1; k++) {
        System.out.print("*");
      }
      // 한 줄이 끝나면 줄바꿈
      System.out.println();
    }

  }
}
