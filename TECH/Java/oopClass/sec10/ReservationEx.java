package oopClass.sec10;

public class ReservationEx {

  public static void main(String[] args) {

    System.out.println("=== 기본 생성자로 생성한 예약 정보 ===");
    Reservation reservation1 = new Reservation();
    reservation1.showRsvInfo();

    System.out.println("\n=== 매개변수가 있는 생성자로 생성한 예약 정보 ===");
    Reservation reservation2 = new Reservation("KE1002", "김지용", "인천", "도쿄", 4500000, "B24");
    reservation2.showRsvInfo();
  }
}
