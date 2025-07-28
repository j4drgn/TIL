package package2;

import java.util.Scanner;

public class Control {

  public static void main(String[] args) {
    // 제어문 반복문 : 프로그램 흐름은 위에서 아래로 진행이 됌. -> 방향을 바꾸는 역할
    // if문
    int score = 85;
    String grade = "";
    if (score >= 90) {
      if (score >= 95) {
        grade = "A+";
      } else {
        grade = "A0";
      }
    } else {
      if (score >= 85) {
        grade = "B+";
      } else {
        grade = "B0";
      }
    }

    //switch
    int year;
    String year1;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter your grade");
    year = sc.nextInt();
    year1 = sc.next();
    switch (year1) {
      case "1":
        System.out.println("1학년");
        break;
      case "2":
        System.out.println("2학년");
        break;
      case "3":
        System.out.println("3학년");
        break;
      case "4":
        System.out.println("4학년");
        break;
      default:
        System.out.println("잘못 입력했습니다.");
    }

    /////////////////////////////////////
    int score1;
    char grade1;

    System.out.println("점수 입력(0~100) : ");
    score1 = sc.nextInt();

    switch (score1) {
      case 100:
      case 90:
        grade1 = 'A';
        break;
      case 80:
        grade1 = 'B';
        break;
      case 70:
        grade1 = 'C';
        break;
      case 60:
        grade1 = 'D';
        break;
      default:
        grade1 = 'F';
    }
    System.out.println(grade1);

  }

}
