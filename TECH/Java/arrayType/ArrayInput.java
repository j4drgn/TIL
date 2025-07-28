package arrayType;

import java.util.Scanner;

public class ArrayInput {

  public static void main(String[] args) {
    // 배열 생성 후 배열 크기만큼 명단 입력 받고 입력 받은 명단 출력
    Scanner sc = new Scanner(System.in);
    String[] name = new String[5];

    System.out.print("이름 입력 : ");
    for (int i = 0; i < name.length; i++) {
      System.out.printf("name[%d] : ", i);
      name[i] = sc.next();
    }

    System.out.println("명단 출력");
    for (int i = 0; i < name.length; i++) {
      System.out.printf("name[%d] = %s%n", i, name[i]);
    }
  }

}
