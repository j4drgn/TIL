package multiThread.sec02;

import java.awt.Toolkit;

public class BeepTask implements Runnable {

  //beep음 출력 담당 - Runnable을 구현
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
