package com.mc.algorithm.b_star;

import java.util.Scanner;

public class Butterfly {

  public static void main(String[] args) {

    int input = new Scanner(System.in).nextInt();

    // 윗부분 날개
    for (int i = 1; i <= input; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      for (int k = 1; k <= 2 * input - 2 * i; k++) {
        System.out.print(" ");
      }
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }

    // 아랫부분 날개
    for (int i = input - 1; i >= 1; i--) {
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      for (int k = 1; k <= 2 * input - 2 * i; k++) {
        System.out.print(" ");
      }
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
