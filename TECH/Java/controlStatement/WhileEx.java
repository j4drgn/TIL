package package2;

import java.util.Scanner;

public class WhileEx {

  public static void main(String[] args) {
    // 사용자가 숫자 7을 입력할 때까지 계속 반복 입력받는 예제
    Scanner sc = new Scanner(System.in);
    int num;

    System.out.print("enter a number: ");
    num = sc.nextInt();

    while (num != 7) {
      System.out.print("다시 입력: ");
      num = sc.nextInt();
    }

    System.out.println("7 입력 종료.");
    sc.close();
  }

}
