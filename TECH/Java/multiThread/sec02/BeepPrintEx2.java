package multiThread.sec02;

import java.awt.Toolkit;

public class BeepPrintEx2 {

  public static void main(String[] args) {
    // 익명 구현 객체 사용
    Thread thread = new Thread(new Runnable() {
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
    );
    thread.start();

    //땡 출력 - 작업 2
    for (int i = 0; i < 5; i++) {
      System.out.println("띵");
      try {
        Thread.sleep(500);
      } catch (Exception e) {
      }
    }
  }
}
