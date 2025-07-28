package randomEx;

import java.util.Scanner;

public class BreakEx {

  public static void main(String[] args) {
    //현재 잔액은 100,000으로 지정
    //인출 수행시 잔액이 부족하면 : 인출수행코드(while)
    //프로그램 종료하고
    //현재 잔액 출력
    //변수 잔액 balance , withdrawal(인출액)
    int balance = 100000;
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("현재 잔액 : " + balance);
      System.out.print("인출액 입력 : ");

      int withdrawal = sc.nextInt();

      if (withdrawal > balance) {
        System.out.println("잔액이 부족합니다. 프로그램을 종료합니다.");
        break;
      } else {
        balance -= withdrawal;
        System.out.println(withdrawal + "원이 인출되었습니다.");

        if (balance == 0) {
          System.out.println("잔액이 0원이 되었습니다. 프로그램을 종료합니다.");
          break;
        }
      }
    }

    System.out.println("최종 잔액 : " + balance);
    sc.close();
  }

}
