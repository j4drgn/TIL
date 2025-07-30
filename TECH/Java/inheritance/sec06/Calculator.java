package inheritance.sec06;

public class Calculator {

  double areaCircle(double r) { // default -> 부모클래스 메서드가 default이므로 접근제한이 같거나 범위가 넓어야 함
    System.out.println("Computer 객체의 areaCircle() 실행");
    return Math.PI * r * r; // 좀더 정밀한 계산을 위해 3.14159대신 Math.PI 상수 이용
  }
}
