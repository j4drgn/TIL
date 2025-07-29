package arrayType;

import java.util.Random;

public class ArrayExer3 {

  public static void main(String[] args) {
    // 로또 번호 생성 프로그램
    // 1~45 숫자 중 중복되지 않는 6개의 숫자 출력

    int[] lotto = new int[6];
    Random random = new Random();

    for (int i = 0; i < lotto.length; i++) {
      lotto[i] = random.nextInt(45) + 1;

      for (int j = 0; j < i; j++) {
        if (lotto[i] == lotto[j]) {
          i--;
          break;
        }
      }
    }

    System.out.println("로또 번호 생성 결과:");
    for (int i = 0; i < lotto.length; i++) {
      System.out.print(lotto[i] + " ");
    }
    System.out.println();
  }
}
