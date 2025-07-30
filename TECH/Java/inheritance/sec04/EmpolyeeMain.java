package inheritance.sec04;

public class EmpolyeeMain {

  public static void main(String[] args) {
    // 서브 클래스의 인스턴스(객체) 생성하면서
    // 서브 클래스의 생성자에게 매개변수를 전달함.
    // 슈퍼 클래스가 필요한 인수도 같이 전달하고 서브 클래스의 생성자에서 부모클래스로 전달하도록 구현
    Manager mg = new Manager("1234", "홍길동", "마케팅", "대리");

    //자식 클래스 인스턴스 출력
    //toString 오버라이딩 함
    System.out.println(mg);

  }

}
