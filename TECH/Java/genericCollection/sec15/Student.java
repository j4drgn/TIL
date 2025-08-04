package genericCollection.sec15;

public class Student {

  //Map 콜렉션에 저장될 데이터의 key로 사용할 클래스
  private int stdNo;
  private String stdName;

  public Student(int stdNo, String stdName) {
    this.stdNo = stdNo;
    this.stdName = stdName;
  }

  public int getStdNo() {
    return stdNo;
  }

  public void setStdNo(int stdNo) {
    this.stdNo = stdNo;
  }

  public String getStdName() {
    return stdName;
  }

  public void setStdName(String stdName) {
    this.stdName = stdName;
  }
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Student)) return false;
    Student student = (Student) obj;
    return stdNo == student.stdNo && (stdName != null ? stdName.equals(student.stdName) : student.stdName == null);
  }
  
  @Override
  public int hashCode() {
    return stdNo + (stdName != null ? stdName.hashCode() : 0);
  }
}
