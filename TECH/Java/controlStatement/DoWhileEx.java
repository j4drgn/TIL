package package2;

import java.util.Scanner;

public class DoWhileEx {

  public static void main(String[] args) {
    // 입력되는 번호에 따라 해당 과목을 출력하는 프로그램
    Scanner sc = new Scanner(System.in);
    int input;
    String answer;

    System.out.println("과정 안내 프로그램");

    do {
      System.out.println("\n 1~4 번호 입력 : ");
      input = sc.nextInt();

      switch (input) {
        case 1:
          System.out.println("Java프로그래밍");
          break;
        case 2:
          System.out.println("데이터베이스");
          break;
        case 3:
          System.out.println("빅데이터 분석");
          break;
        case 4:
          System.out.println("AI");
          break;
        default:
          System.out.println("잘못 입력하였습니다.");
      }
      System.out.println("\n 계속 입력하시겠습니까? (y/n 입력) : ");
      answer = sc.next();
    } while (answer.contains("y"));

    System.out.println("종료합니다");
    sc.close();
  }

}
