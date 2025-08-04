package genericCollection.sec15;

import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapStudent {

  public static void main(String[] args) {
    // 3명의 학생 정수를 Map에 저장
    // Student 클래스를 key로 정수를 value로 저장

//    Map<Student, Integer> map = new HashMap<Student, Integer>(); //입력순서 보장되지 않음.
    Map<Student, Integer> map = new LinkedHashMap<Student, Integer>(); //입력순서 보장 됨.

    //map에 entry 저장 시 key가 사용자 정의 클래스 인스턴스 인것 제외하고는 동일
    map.put(new Student(1, "홍길동"), 90);
    map.put(new Student(2, "홍길동"), 85);
    map.put(new Student(3, "성춘향"), 95); //학생 번호로 학생을 구분 : 번호가 같은 학생은 존재하지 않는다 규칙이 있음.
    //key가 중복되면 value를 update진행 함. - Student 객체를 따로 구성했으므로 update 진행되지 않고 새로 추가 됨.
    //Student 클래스가 상속받은 hasCode(), equals() 메소드 재정의해서 객체 필드 값이 동일하면 동일한 객체로 처리되게 끔 구현
    //HashSet()과 같은 내용
    map.put(new Student(3, "성춘향"), 100);
    
    // 같은 학번이지만 다른 이름의 학생 - 학번만으로 비교하므로 동일 학생으로 간주
    map.put(new Student(3, "김유신"), 80);

    //3명 학생의 data가 출력 - 순서를 보장하지 않음 ( 순서가 보장되게 하고자 하면 LinkedHashMap 사용)
    for (Student k : map.keySet()) {
      System.out.println(k.getStdNo() + " " + k.getStdName() + map.get(k));
    }
  }
}
