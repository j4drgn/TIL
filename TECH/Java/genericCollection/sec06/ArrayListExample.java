package genericCollection.sec06;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {

  public static void main(String[] args) {
    ArrayList<String> words = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    String longestWord = "";

    System.out.println("단어 4개를 입력하세요.");
    for (int i = 0; i < 4; i++) {
      System.out.print((i + 1) + "번째 단어 >> ");
      String word = scanner.next();
      words.add(word);
      if (word.length() > longestWord.length()) {
        longestWord = word;
      }
    }

    System.out.println("==========================");

    for (String word : words) {
      System.out.print(word + " ");
    }

    System.out.println("\n가장 긴 단어는: " + longestWord);
    System.out.println("가장 긴 단어의 길이는: " + longestWord.length());

    scanner.close();
  }
}
