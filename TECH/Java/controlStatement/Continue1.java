package package2;

public class Continue1 {

  public static void main(String[] args) {
    // 짝수만 출력하고 홀수는 skip
    for (int i = 1; i <= 10; i++) {
      if (i % 2 != 0) { //홀수인 경우
        continue;
      }
      System.out.println(i); //9번 문장 continue에 해당되면 실행되지 않는 문장
    }
  }

}
