package multiThread.sec01;

import java.awt.Toolkit;

public class BeepPrint {

  public static void main(String[] args) {
    // main thread 1개 위에서 아래로 순차적 진행
    Toolkit toolkit = Toolkit.getDefaultToolkit();

    //비프음 출력 - 작업 1
    for (int i = 0; i < 5; i++) {
      toolkit.beep();
      try {
        Thread.sleep(500);
      } catch (Exception e) {
      }

    }
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