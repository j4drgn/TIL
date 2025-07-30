package oopClass.sec17;

public class Car {

  //private 멤버 필드이므로 인스턴스 통한 접근 불가
  private int speed;
  private boolean stop;

  //private 멤버 필드에 접근하려면 클래스 내에서 접근해야함.
  //private 멤버 필드의 값을 수정하기 위한 setter와 멤버 필드 값을 참조하기 위한 getter가 필요함

  //setter
  public void setSpeed(int speed) {
    //멤버 필드에 값 저장
    if (speed < 0) {
      this.speed = 0;
    } else {
      this.speed = speed;
    }
  }

  //getter
  public int getSpeed() {
    return speed;
  }

  public boolean isStop() {
    return stop;
  }

  public void setStop(boolean stop) {
    this.speed = 0;
    this.stop = stop;
  }

}
