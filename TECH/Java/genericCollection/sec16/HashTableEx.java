package genericCollection.sec16;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HashTableEx {

  public static void main(String[] args) {
    // HashTable은 HashMap과 사용법은 동일 - 멀티쓰레드에 대한 동기화 구현이 되어 있는 객체
    // 동기화 구현되어 있으므로 쓰레드 접근(main 메소드 등) 하면 객체 잠금 발생 - 다른 쓰레드가 HashTable 사용 못하도록 처리
    // 멀티쓰레드가 아닌 경우 비효율적
    Map<String, String> map = new Hashtable<String, String>();

    map.put("Sping", "12");
    map.put("summer", "123");
    map.put("fall", "123");
    map.put("winter", "123");

    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("아이디와 비밀번호를 입력해주세요");
      System.out.print("아이디 : ");
      String id = sc.nextLine();
      System.out.print("비밀번호 : ");
      String password = sc.nextLine();

      //아이디에 해당하는 키가 존재하는지 확인
      if (map.containsKey(id)) {
        //비밀번호 일치 확인
        if (map.get(id).equals(password)) {
          System.out.println("로그인 되었습니다.");
          break;
        } else {
          System.out.println("비밀번호가 일치하지 않습니다.");
        }
      } else {
        System.out.println("입력하신 아이디가 존재하지 않습니다.");
      }
    }
  }

}
