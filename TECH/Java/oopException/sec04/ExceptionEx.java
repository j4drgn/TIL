package oopException.sec04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    try {
      System.out.print("정수 1 입력 : ");
      int num1 = scanner.nextInt();

      System.out.print("정수 2 입력 : ");
      int num2 = scanner.nextInt();

      int result = num1 / num2;
      System.out.println("나누기 결과 : " + result);

    } catch (ArithmeticException e) {
      System.out.println("0으로 나눌 수 없습니다.");
    } catch (InputMismatchException e) {
      System.out.println("숫자만 입력해야 합니다.");
    } finally {
      scanner.close();
    }
  }
}
