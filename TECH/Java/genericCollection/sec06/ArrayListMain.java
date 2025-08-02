package genericCollection.sec06;

import java.util.ArrayList;

public class ArrayListMain {

  public static void main(String[] args) {
    //ArrayList 콜렉션 : 제네릭 타입이 아닌 경우
    ArrayList list = new ArrayList();

    //리스트 항목 추가 : add(매개변수 e) -> ArrayList 마지막에 추가
    list.add(100);
    list.add("홍길동");
    list.add(7.7);
    list.add("자바");
    list.add("홍길동"); //값 중복이 가능

    //리스트 전체 내용 출력 : 입력된 순서대로 0번 인덱스부터 출력됨
    //순서를 보장하는 콜렉션
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }

    System.out.println();
    //리스트 항목 추가 2: add(idx,e) -> ArrayList에 항목추가 매개변수로 전달된 idx 위치에 추가
    list.add(0, "변경"); //0번 인덱스에 항목 추가 -> 기존 0번 idx의 값은? 뒤로 하나씩 이동.

    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }

    System.out.println();
    //리스트 항목 삭제 : remove(idx) -> ArrayList에 특정 idx의 항목 삭제
    list.remove(1); //1번 인덱스에 항목 삭제 -> 1번 idx 공간 처리는? 뒷쪽 idx의 항목들이 한칸씩 앞으로 이동

    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }

    System.out.println();
    //리스트에 특정 항목이 포함되어 있는지의 여부 반환 : contains(e) 포함여부 T/F 반환
    System.out.println(list.contains("홍길동"));

    if (!(list.contains("이몽룡"))) {
      list.add("이몽룡");
    }
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }

}
