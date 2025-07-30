package inheritance.pack2;

//패키지가 다른 클래스의 객체 인스턴스를 만들려면 : import해야함.

import inheritance.pack1.A;
import inheritance.pack1.B;

public class C {

  B b; //패키지가 달라도 import했고 public 클래스이므로 접근가능
  A a; //default 클래스이고 패키지가 다르기 때문에 접근 불가
}
