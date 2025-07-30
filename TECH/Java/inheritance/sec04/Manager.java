package inheritance.sec04;

public class Manager extends Employee {

  private String position;


  public Manager(String empNo, String name, String part, String position) {
    //초기화에 필요한 모든 정보는 자식 인스턴스 생성 시에 받고
    super(empNo, name, part); //부모가 필요시에 정보 전달
    this.position = position;
  }

  @Override
  public String toString() {
    //super 레퍼런스 : 부모클래스를 참조할 때 사용
    return super.toString() + "\t |" + position;
  }

}
