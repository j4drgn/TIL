package genericCollection.sec06;

import java.util.Arrays;
import java.util.List;

public class AsListMain {

  public static void main(String[] args) {
    //Arrays클래스의 asList메소드 : 초기화된 List 생성
    List<String> list1 = Arrays.asList("홍길동", "이몽룡", "성춘향");
    for (String value : list1) {
      System.out.println(value);
    }

    List<Integer> list2 = Arrays.asList(1, 2, 3);
    for (int no : list2) {
      System.out.println(no);
    }

    list2.set(1, 5);
    for (int no : list2) {
      System.out.println(no);
    }

    list2.add(10); //오류
    for (int no : list2) {
      System.out.println(no);
    }
  }

}
