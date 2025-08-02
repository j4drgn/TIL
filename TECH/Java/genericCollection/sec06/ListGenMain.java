package genericCollection.sec06;

import java.util.ArrayList;
import java.util.List;

public class ListGenMain {

  public static void main(String[] args) {
    // 제네릭타입으로 ArrayList 사용 -> List interface 활용
    //ArrayList:String 객체만 저장가능
    List<String> list = new ArrayList<String>();

    list.add("java");
    list.add("dataBase");
    list.add("HTML");
    list.add("java"); //중복값 저장
//    list.add(100); //String으로 저장 타입을 구체화 했으므로 정수형은 String형 제외 저장 불가

    System.out.println("총 객채수 : " + list.size());
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }

    System.out.println();
    list.remove(1);
    for (String value : list) {
      System.out.println(value);
    }

    System.out.println();
    list.add("MultiMedia");
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i) + ": " + list.get(i).length());
    }

    for (String value : list) {
      System.out.println(value.length());
    }
  }

}
