package oopClass.sec08;


public class Car {

  private String carNo;     //차량 번호
  private String carName;   //차종
  private String carMaker;  //제조사
  private int carYear;      //연식
  private int carCC;        //배기량

  //생성자 오버로딩
  //매개변수가 없는 생성자
  public Car() {
    
  }

  //생성자 메서드 private 필드를 초기화
  public Car(String carNo, String carName, String carMaker) {
    //멤버 필드와 매개변수명이 동일
    this.carNo = carNo;
    this.carName = carName;
    this.carMaker = carMaker;
  }


  public void setCarInfo(String no, String name, String mak, int year, int cc) {
    carNo = no;
    carName = name;
    carMaker = mak;
    this.carYear = year;
    this.carCC = cc;
  }

  //(2) 멤버 변수 값을 출력하는 메소드
  public void showCarInfo() {
    System.out.println("차량 번호 : " + carNo);
    System.out.println("차종 : " + carName);
    System.out.println("제조사 : " + carMaker);
    System.out.println("연식 : " + carYear);
    System.out.println("배기량 : " + carCC);
  }

}
