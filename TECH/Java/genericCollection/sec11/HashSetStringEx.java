package genericCollection.sec11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetStringEx {

  public static void main(String[] args) {
    // HashSet의 중복 객체 저장불가 확인
    // String 객첼르 통해 확인
    Set<String> set = new HashSet<String>();

    //Set은 get()나 idx 사용하는 메소드는 없음, 순서를 보장하지 않는다.
    //String 클래스는 문자열 값이 같은 경우 동등 객체가 될 수 있도록 HashCode()/equals() 메소드가 재정의 되어 있음.
    set.add("JAVA");
    set.add("JDBC");
    set.add("Servlet/JSP");
    set.add("JAVA");  //중복 객체이므로 저장하지 않음.
    set.add("MyBatis");

    int size = set.size();
    System.out.println("총 객체수 : " + size);

    //set은 idx가 없으므로 반복 순회를 위해서 interator() 통해 반복자를 얻을 수 있음.
    Iterator<String> it = set.iterator();
    while (it.hasNext()) {
      String ele = it.next();
      System.out.println("\t" + ele);
    }

    set.remove("JAVA");
    set.remove("MyBatis");
    System.out.println("총 객체수 : " + set.size());
    for (String ele : set) {
      System.out.println("\t" + ele);
    }

    set.clear(); //모든 객체 제거하고 비움
    if (set.isEmpty()) {
      System.out.println("객체가 없습니다.");
    }
  }
}
