package inheritance.sec04;

public class Employee {

  private String empNo;
  private String name;
  private String part;

  //매개 변수가 있는 생성자 함수
  public Employee(String empNo, String name, String part) {
    this.empNo = empNo;
    this.name = name;
    this.part = part;
  }

  @Override
  public String toString() {
    return empNo + "\t|" + name + "\t|" + part;
  }
}


