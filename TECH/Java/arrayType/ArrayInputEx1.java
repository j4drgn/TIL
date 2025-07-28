package arrayType;

import java.util.Scanner;

public class ArrayInputEx1 {

  public static void main(String[] args) {
    //숫자 5개를 입력 받아서 최대값을 구하는 프로그램 작성

    Scanner sc = new Scanner(System.in);
    int[] num = new int[5];

    for (int i = 0; i < num.length; i++) {
      System.out.print("num[" + i + "]: ");
      num[i] = sc.nextInt();
    }

    int max = num[0];
    for (int i = 1; i < num.length; i++) {
      if (num[i] > max) {
        max = num[i];
      }
    }
    
    System.out.print("입력된 값: ");
    for (int val : num) {
      System.out.print(val + " ");
    }
    System.out.println();
    System.out.println("최대값: " + max);

    sc.close();
  }
}
