package oopClass.sec13;

public class Share {

  int a; //인스턴스 필드
  static int staticA; //static 필드

  public void set(int n) {
    a += n;
    staticA += n;
  }

  public int showA() {
    return a;
  }

  public int showStaticA() {
    return staticA;
  }
}
