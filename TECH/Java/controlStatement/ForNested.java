package package2;

public class ForNested {

  public static void main(String[] args) {
    // 구구단 전체 테이블 형식으로 출력 예제
    // 2단 ~ 9단 : 2X1 = 2 3X1=3 .... 9X1=9

    for (int n = 1; n <= 9; n++) {
      for (int dan = 2; dan <= 9; dan++) {
        System.out.print(dan + " x " + n + " = " + (dan * n) + "\t");
      }
      System.out.println();
    }

  }

}
