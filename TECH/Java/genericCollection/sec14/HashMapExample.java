package genericCollection.sec14;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {

  public static void main(String[] args) {
    HashMap<String, String> dictionary = new HashMap<>();
    
    Scanner scanner = new Scanner(System.in);
    
    while (true) {
      System.out.println("\n1. 단어 등록\n2. 단어 검색\n3. 종료");
      System.out.print("메뉴 선택: ");
      
      String choice = scanner.nextLine().trim();
      
      if (choice.equals("1")) {
        while (true) {
          System.out.print("영단어=한글단어 형식으로 입력하세요 (종료: exit): ");
          String entry = scanner.nextLine().trim();
          
          if (entry.equalsIgnoreCase("exit")) {
            System.out.println("단어 등록을 종료합니다.");
            break;
          }
        
          String[] parts = entry.split("=");
          if (parts.length == 2) {
            String english = parts[0].trim();
            String korean = parts[1].trim();
            
            dictionary.put(english, korean);
            System.out.println("단어가 등록되었습니다: " + english + " = " + korean);
          } else {
            System.out.println("잘못된 형식입니다. '영단어=한글단어' 형식으로 입력해주세요.");
          }
        }
      } else if (choice.equals("2")) {
        while (true) {
          System.out.print("찾고 싶은 단어는? ");
          String word = scanner.nextLine().trim();
          
          if (word.equalsIgnoreCase("exit")) {
            System.out.println("종료합니다...");
            break;
          }

          if (dictionary.containsKey(word)) {
            System.out.print(word + " = " + dictionary.get(word));
          } else {
            System.out.print(word + "는 없는 단어 입니다.");
          }
          System.out.println();
        }
      } else if (choice.equals("3")) {
        System.out.println("프로그램을 종료합니다.");
        break;
      } else {
        System.out.println("잘못된 메뉴 선택입니다. 다시 선택해주세요.");
      }
    }
    
    scanner.close();
  }
}
