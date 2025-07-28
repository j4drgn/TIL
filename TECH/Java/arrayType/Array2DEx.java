package arrayType;

import java.util.Scanner;

public class Array2DEx {

  public static void main(String[] args) {
    //영어 단어의 뜻을 알아 맞히는 프로그램 작성
    // chair,computer,integer 배열로 만들기
    
    // 영어 단어와 한글 뜻을 저장하는 2차원 배열
    String[][] words = {
        {"chair", "의자"},
        {"computer", "컴퓨터"},
        {"integer", "정수"}
    };
    
    Scanner sc = new Scanner(System.in);
    
    for (int i = 0; i < words.length; i++) {
      System.out.printf("Q%d. %s의 뜻은? ", i+1, words[i][0]);
      
      String answer = sc.nextLine();
      
      if (answer.equals(words[i][1])) {
        System.out.println("정답입니다!");
      } else {
        System.out.printf("틀렸습니다. 정답은 %s입니다.\n", words[i][1]);
      }
    }
    
    sc.close();
  }
}
