package inheritance.sec03;

public class EmployeeTostring {

  private String empNo;
  private String name;
  private String part;

  public EmployeeTostring(String empNo, String name, String part) {
    this.empNo = empNo;
    this.name = name;
    this.part = part;
  }

  //toString() 메소드
  //object 클래스가 구현한 메소드 모든 클래스에 상속됨 - Overrider 해야함.
  //객체가 텍스트 값으로 표시되거나 문자열이 예상되는 방식으로 참조될때 자동으로 호출 되는 메소드
  //toString 메소드 호출되면 객체가 갖고 있는 정보나 값들을 문자열 형태로 반환

  //오버라이드 어노테이션 사용하여 상속받은 메소드 재정의
  @Override
  public String toString() {
    return empNo + "\t|" + name + "\t|" + part;
  }
}
