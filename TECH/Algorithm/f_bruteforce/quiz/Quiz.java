package com.mc.algorithm.f_bruteforce.quiz;

public class Quiz {

  public static void main(String[] args) {
    q1(10);
  }

  private static void q1(int n) {
    int count = 0;
    int num = 665;
    while (true) {
      num++;

      if (String.valueOf(num).contains("666")) {
        count++;
      }

      if (count == n) {
        System.out.println(num);

        break;
      }
    }
  }


  private static void q2() {
  
  }

}
