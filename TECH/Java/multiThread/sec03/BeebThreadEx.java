package multiThread.sec03;

public class BeebThreadEx {

  public static void main(String[] args) {
    // 사용자 정의 thread 클래스
    Thread thread = new BeepThread();
    thread.start(); //작업 1

    //땡 출력 - 작업 2
    for (int i = 0; i < 5; i++) {
      System.out.println("띵");
      try {
        Thread.sleep(500);
      } catch (Exception e) {
      }
    }

//    Thread thread1 = new BeepThread();
    thread.start(); //작업 3 쓰레드 새로 생성 없이 start() 하면 오류 - start()는 한개 쓰레드 당 한번만 진행
  }

}
