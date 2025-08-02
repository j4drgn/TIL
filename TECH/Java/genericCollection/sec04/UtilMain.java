package genericCollection.sec04;

public class UtilMain {

  public static void main(String[] args) {
    // Util 클래스 static 메소드 사용 예시
    // Util 클래스 boxing 메소드 제네릭, static Box 타입 변환
    // 메소드 호출 시 타입을 구체화
    Box<Integer> box1 = Util.<Integer>boxing(100);
    int intValue = box1.get();

//    Box<String> box2 = Util.<String>boxing("홍길동"); //타입파라미터가 T고 매개변수는 T 타입을 전달해야함
    Box<String> box2 = Util.boxing("홍길동"); //매개변수 홍길동 문자열이 타입 파라미터를 결정하게 됨. - 파라미터 구체화 생략가능<>
    String strValue = box2.get();

    System.out.println(intValue);
    System.out.println(strValue);
  }

}
