package genericCollection.sec12;

public class Member2 {

  public String name;
  public int age;

  public Member2(String name, int age) {
    this.name = name;
    this.age = age;
  }

  //객체 인스턴스에 저장된 필드값이 완전히 같으면 객체 참조 주소가 다르더라도 같은 객체로 보고 Set에 중복 저장되지 않도록 구현
  //Object로부터 상속 받은 HashCode() 메소드를 재정의
  //HashCode는 객체의 참조값을 반환하는데 이 값을 값이 동일한 경우 동일한 값이 반환될 수 있도록 구현
  @Override
  public int hashCode() {
    System.out.println(name.hashCode() + age);
    return name.hashCode() + age;
  }

  //Object로부터 상속받은 equals() 메소드를 재정의 -> 필드값이 어떤 상태일때 두 객체가 동등하다고 볼 것인지
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Member2) {
      Member2 member2 = (Member2) obj;
      return member2.name.equals(name) && (member2.age == age);
    } else {
      return false;
    }
  }
}
