package oopClass.sec17;

public class CarMain {

  public static void main(String[] args) {
    //Car 클래스 사용
    Car myCar = new Car();

    myCar.setSpeed(-50);
    System.out.println("현재 속도: " + myCar.getSpeed());

    myCar.setSpeed(60);
    System.out.println("현재 속도: " + myCar.getSpeed());

    if (!myCar.isStop()) {
      myCar.setStop(true);
    }
    System.out.println("현재 속도: " + myCar.getSpeed());
  }

}
