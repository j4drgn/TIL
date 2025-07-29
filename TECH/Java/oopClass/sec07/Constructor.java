package oopClass.sec07;

public class Constructor {

  //멤버 변수
  private int x;
  private int y;

  //생성자 : 클래스 이름과 동일한 메소드, 반환 타입 없음
  //객체 생성될때 한번만 호출 가능
  //생성자 역할 : 멤버변수 값 초기화
  //명시적 생성자가 구현되는 디폴트  생성자(컴파일러가 생성하는)는 구현하지 않는다.
  public Constructor(int x) {
    //메소드 바디 영역이므로 x는 매게변수 x(지역변수)
    //멤버 변수 x 지칭시에는 class 영역을 지칭하는 this 레퍼런스
    //this 레퍼런스 현재 클래스를 참조하는 예약어

    this.x = x;
  }

  //멤버 메소드
  public void show() {
    System.out.println("x: " + x);
  }

}

