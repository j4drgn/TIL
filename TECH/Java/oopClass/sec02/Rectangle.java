package oopClass.sec02;

import java.util.Scanner;

public class Rectangle {

  //멤버 변수
  int width;
  int height;

  //멤버 메서드 - width/ height에 값 저장하기 위한 메서드
  public void input() {
    //사용자로부터 입력 받아 저장
    Scanner input = new Scanner(System.in);
    System.out.println("가로 길이 입력 : ");
    width = input.nextInt();
    System.out.println("세로 길이 입력 : ");
    height = input.nextInt();
    input.close();
  }

  public void area() {
    System.out.println("사각형 면적 : " + width * height);
  }
}
