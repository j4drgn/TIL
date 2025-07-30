package oopClass.sec13;

public class StaticBlock {

  //static 블록 - static 멤버만 모아놓은 영역, 모든 static 멤버가 영역에 무조건 있어야 하는 건 아님
  //인스턴스 필드와 메소드
  int a;

  void method() {/*...*/}

  static int staticA;

  static void staticMethod() {/*...*/}

  static {
    int b = 1;
//    method(){/*...*/}
    staticA = 10;
    staticMethod();
  }

  {//인스턴스 필드는 대부분 생성자 통해서 초기화가 이루어지기 때문에 초기화 블록을 사용하지 않는다.
    int a1 = 50;
    int b1 = 50;
  }

  static {  //static 필드의 선언과 초기화는 static 블럭을 이용함. - 클래스가 메소드 영역으로 로딩될때 자동으로 실행하는 블럭
    int c = 0;
    double bc = 5.0;
  }

  static void staticMethod2() {
    //static 메소드에서는 this 사용 불가
    //this.a = 2;
    //객체를 생성하고 인스턴스로 접근하는 건 가능
    StaticBlock s = new StaticBlock(); //객체 인스턴스 생성
    s.a = 200;
    s.method();
  }

}
