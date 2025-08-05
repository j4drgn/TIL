package oopApi.sec04;


public class AutoBoxingUnBoxing {

  public static void main(String[] args) {
    //포장 객체와 기본 타입에 대한 자동 박싱 / 언박싱
    // 자동 박싱
    Integer obj = 100; //100 기본값이 obj가 참조하게 된 객체의 필드로 저장 (객체 생성)
    System.out.println(obj.intValue());

    // 자동 언박싱 -> 객체 참조 변수 기본 변수에 대입하면
    int value = obj;

    //기본값과 래퍼참조 객체와 연산시 자동 언박싱
    int result = obj + 100; // obj 객체와 기본값의 연산
    System.out.println(result);

    //래퍼 클래스는 Static 메소드로 문자열을 기본 타입값으로 변환하는 기능을 갖고 있음.
    //parseXXX()
    Short.parseShort("100"); //short 타입의 기본값 100으로 변환
    Double.parseDouble("3.5"); //double타입의 기본리터럴 3.5로 변환
    Boolean.parseBoolean("true"); //boolean 타입의 리터럴 true 변환

    //래퍼 클래스의 내부 값 비교 : == != 연산자 사용불가, 언박싱해서 비교하거나 equals() 사용
    
  }

}
