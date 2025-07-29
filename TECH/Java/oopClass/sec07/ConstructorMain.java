package oopClass.sec07;

public class ConstructorMain {

  public static void main(String[] args) {
    //생성자 호출
    Constructor c = new Constructor(5); //클래스 내에 명시적 생성자가 있음, 생성자가 정수형 인수 1개를 요구함.
    //객체 생성시 생성자 인수로 정수형 값을 전달해야함.

    //show 호출
    c.show();

    //명시적 생성자가 없음면 x=100 코드가 진행되지 않으므로 x:0 출력
  }

}
