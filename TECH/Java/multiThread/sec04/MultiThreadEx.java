package multiThread.sec04;

public class MultiThreadEx {

  public static void main(String[] args) {
    // MultiThread
    MultiThread t1 = new MultiThread(1);
    MultiThread t2 = new MultiThread(2);
    MultiThread t3 = new MultiThread(3);

    //3개 쓰레드 실행
    t1.start();
    t2.start();
    t3.start();

  }

}
