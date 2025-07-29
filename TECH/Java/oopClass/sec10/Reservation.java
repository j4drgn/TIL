package oopClass.sec10;

import java.text.DecimalFormat;

public class Reservation {

  private String planeId;     // 항공기 번호
  private String passenger;   // 예약자
  private String departure;   // 출발지
  private String destination; // 도착지
  private int price;          // 금액
  private String seatNumber;  // 좌석번호

  DecimalFormat df = new DecimalFormat("#,###");


  public Reservation() {
    this.planeId = "KE1001";
    this.passenger = "홍길동";
    this.departure = "인천";
    this.destination = "뉴욕";
    this.price = 1600000;
    this.seatNumber = "A38";
  }

  public Reservation(String planeId, String passenger, String departure,
      String destination, int price, String seatNumber) {
    this.planeId = planeId;
    this.passenger = passenger;
    this.departure = departure;
    this.destination = destination;
    this.price = price;
    this.seatNumber = seatNumber;
  }

  public void showRsvInfo() {
    System.out.println("\n**항공권 예약 정보**");
    System.out.println("항공기 : " + planeId);
    System.out.println("예약자 : " + passenger);
    System.out.println("출발지 : " + departure);
    System.out.println("도착지 : " + destination);
    System.out.println("금액 : " + df.format(price));
    System.out.println("좌석번호 : " + seatNumber);
  }
}
