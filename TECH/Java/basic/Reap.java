package package2;

import java.util.Scanner;

public class Reap {

  public static void main(String[] args) {
    int sum = 0;
    int i;
    for (i = 1; i <= 100; i++) {
      System.out.println(i);
      sum += i;
    }
    System.out.println(sum);

    Scanner sc = new Scanner(System.in);
    int dan = sc.nextInt();
    for (i = 1; i <= 9; i++) {
      System.out.println(dan + " x " + i + " = " + dan * i);
    }
  }

}
