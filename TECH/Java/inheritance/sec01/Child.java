package inheritance.sec01;

// Parent 클래스 상속
public class Child extends Parent {

  private int c;

  public void setChild() {
    c = 20;
  }

  public void showChild() {
    //부모 클래스의 필드와 메서드 중 private 접근 제한이 아닌 멤버들은 자식 클래스에서 사용이 가능함.
    showParent(); //부모클래스 메소드 사용
    System.out.println("자식 클래스 c: " + c);
  }

}
