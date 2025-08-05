package oopApi.sec01;

public class Count {

  private int no;

  public Count(int no) {
    this.no = no;
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println(no + "번 객체의 finalize()가 실행됨.");
  }

}
