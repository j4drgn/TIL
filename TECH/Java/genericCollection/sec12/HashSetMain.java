package genericCollection.sec12;

import java.util.HashSet;
import java.util.Set;

public class HashSetMain {

  public static void main(String[] args) {
    //Member class 인스턴스 HashSet에 저장
    Set<Member> set = new HashSet<Member>();

    //동일값이 필드에 저장되지만 객체의 참조 주소가 다르기 때문에 두 개의 객체로 보고 두 객체 모두 set에 저장
    set.add(new Member("홍길동", 30));
    set.add(new Member("홍길동", 30));

    System.out.println("총 객체수 : " + set.size());

    //Member2 클래스 객체는 필드의 값이 완전히 동일하면 동일 객체로 보고 중복 저장되지 않도록 구현
    Set<Member2> set1 = new HashSet<Member2>();

    //동일값이 필드에 저장되지만 객체의 참조 주소가 다르기 때문에 두 개의 객체로 보고 두 객체 모두 set에 저장
    set1.add(new Member2("홍길동", 30));
    set1.add(new Member2("홍길동", 30));

    System.out.println("총 객체수 : " + set1.size());

  }

}
