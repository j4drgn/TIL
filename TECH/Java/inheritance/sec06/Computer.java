package inheritance.sec06;

public class Computer extends Calculator {

  // 컴파일러는 부모클래스의 areaCircle 메소드의 정의부와 재정의되는 메소드의 정의부가 같은지 확인
  // 재정의 하려는 메소드가 부모 클래스에 없음: areacircle는 없기 때문에 재정의 불가 에러가 발생
  @Override
  double areaCircle(double r) { // default -> 부모클래스 메서드가 default이므로 접근제한이 같거나 범위가 넓어야 함
    System.out.println("Computer 객체의 areaCircle() 실행");
    return Math.PI * r * r; // 좀더 정밀한 계산을 위해 3.14159대신 Math.PI 상수 이용
  }
}
