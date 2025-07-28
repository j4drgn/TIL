package package2;

public class Break1 {

  public static void main(String[] args) {
    //숫자를 출력하면서 출력되는 숫자가 20 초과면 출력을 종료

    int i = 0;

    while (true) { //조건이 true이면 무한 반복
      i += 3;
//      if (i > 20) {
//        break; //반복문 종료 - 18까지 출력
//      }
      System.out.println(i);
      if (i > 20) {
        break; //반복문 종료 - 21까지 출력
      }
    }
  }

}
