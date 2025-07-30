package inheritance.sec05;

//super ref 사용 예제
class SuperClass {

  int x; //디폴트 타입의 인스턴스 멤버 변수 선언 -> 동일 패키지 클래스에게는 상속됨.
  int y;

  public SuperClass() {
    x = 5;
    y = 50;
  }
}

class SubClass extends SuperClass {

  int x; //익스턴스 멤버 변수

  public SubClass() {
    x = 10;
  }

  public void show() {
    System.out.println(x); //SubClass의 필드 x 값 출력
    System.out.println("this.x : " + this.x); //SubClass의 필드 x의 값 출력
    System.out.println("super.x : " + super.x);  //SuperClass의 필드 x의 값 출력
    System.out.println(y); //SuperClass에만 있는 필드기 때문에 SuperClass의 y를 참조

  }

}

public class SuperRefMain {

  public static void main(String[] args) {
    //SubClass 인스턴스 생성
    SubClass sc = new SubClass(); //SuperClass 생성자 자동 호출 -> 멤버필드 초기화 진행
    sc.show();

  }

}
