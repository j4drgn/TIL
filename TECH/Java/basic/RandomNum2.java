package randomEx;

import java.util.Random;

public class RandomNum2 {

  public static void main(String[] args) {
    // 난수발생 : Random 클래스 사용
    // import java.until.Random;
    // 참조 객체 생성해서 사용해야 함
    // 객체.nextInt(숫자) 특정 범위에서 생성
    Random random = new Random();

    for (int i = 1; i <= 10; i++) {
      int num = random.nextInt(10);
      int num2 = random.nextInt(10) + 1;
      System.out.println(num);
      System.out.println(num2);
    }
  }

}
