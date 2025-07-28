package refType;

public class StringEquals {

  public static void main(String[] args) {
    // 문자열 객체 생성 1: String 변수명 = "문자열"
    // ""이용해서 문자열 객체 생성한 경우 문자열 값이 같으면 동일 객체 참조

    String strVar1 = "홍길동";
    String strVar2 = "홍길동";

    if (strVar1 == strVar2) {
      System.out.println("strVar1과 strVar2는 참조가 같음");
    } else {
      System.out.println("strVar1과 strVar2는 참조가 다름");
    }

    // strVar1은 String 클래스의 객체 참조 변수 -> 클래스 메소드 사용 가능
    // equals는 참조 객체의 값이 같은지 확인하는 메소드
    if (strVar1.equals(strVar2)) {
      System.out.println("strVar1과 strVar2는 저장된 문자열 값이 같음");
    }

    //문자열 객체 생성 2 : String 변수명 = new String("홍길동");
    String strVar3 = new String("홍길동");
    String strVar4 = new String("홍길동");

    if (strVar3 == strVar4) {
      System.out.println("strVar1과 strVar2는 참조가 같음");
    } else {
      System.out.println("strVar1과 strVar2는 참조가 다름");
    }

    // strVar1은 String 클래스의 객체 참조 변수 -> 클래스 메소드 사용 가능
    // equals는 참조 객체의 값이 같은지 확인하는 메소드
    if (strVar3.equals(strVar4)) {
      System.out.println("strVar3과 strVar4는 저장된 문자열 값이 같음");
    }

  }

}
