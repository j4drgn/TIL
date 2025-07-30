package oopClass.sec12;

public class Calcuator {

  static double pi = 3.14159; //객체 생성 없이 사용 가능한 필드이므로 보통 선언할 때 초기값 선언

  static int plus(int x, int y) {
    return x + y;
  }

  static int minus(int x, int y) {
    return x - y;
  }

  static int dd(int x, int y) {
    return x * y;
  }

  static int ff(int x, int y) {
    return x / y;
  }

}
