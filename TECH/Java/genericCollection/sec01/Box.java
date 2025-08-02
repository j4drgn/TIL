package genericCollection.sec01;

public class Box {

  //필드 1개와 getter/setter가 필요한 클래스
  //어떤 타입의 필드인지는 결정하지 않고 모든 타입의 필드를 사용할수 있도록 클래스를 구성
  //모든 타입을 포함하는 클래스가 Object
  private Object object;

  public void set(Object obj) {
    this.object = obj;
  }

  public Object get() {
    return object;
  }
}
