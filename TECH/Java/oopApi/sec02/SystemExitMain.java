package oopApi.sec02;

public class SystemExitMain {

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      System.out.println(i);
      if (i == 5) {
        System.exit(0); //프로그램 완전 종료
        break;
      }
    }
    System.out.println("종료");
  }


}
