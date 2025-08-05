package oopException.sec05;

public class Throws {

  public static void main(String[] args) {
    //메소드에서 호출한 곳으로 예외 떠 넘기기 (throws 구문)
    //findClass(); //메소드에서 throws 구문이 있는 경우는 try ~ catch 구문을 반드시 사용해야함 (단ㄴ독 호출 에러 발생)
    try {
      findClass();
    } catch (ClassNotFoundException e) {
      System.out.println("메소드에서 throws로 떠넘긴 예외는 메소드 호출시 반드시 처리해야함.");
    }
  }

  public static void findClass() throws ClassNotFoundException {
    Class clazz = Class.forName("java.lang.String2");
  }

}
