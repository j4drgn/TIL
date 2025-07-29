package oopClass.sec06;

public class CircleMain {

  public static void main(String[] args) {
    // Circle 클래스 사용
    Circle circle = new Circle();

    circle.setCircle(5);
    float result = circle.area();
    System.out.println("원의 넓이 : " + circle.area());
  }

}
