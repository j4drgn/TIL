package multiThread.sec03;

import java.awt.Toolkit;

//thread 클래스 상속 - 객체 인스턴스가 thread가 됨.
public class BeepThread extends Thread {

  @Override
  public void run() {
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    //비프음 출력 - 작업 1
    for (int i = 0; i < 5; i++) {
      toolkit.beep(); //비프음 발샐
      try {
        Thread.sleep(500);
      } catch (Exception e) {
      }
    }
  }
}
