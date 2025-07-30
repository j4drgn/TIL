package inheritance.sec07;

public class Car {
  String carNo;      // 차량 번호
  String carName;    // 차종
  String carMaker;   // 제조사
  int carYear;       // 연식

  public Car() {
  }

  public Car(String carNo, String carName, String carMaker, int carYear) {
    this.carNo = carNo;
    this.carName = carName;
    this.carMaker = carMaker;
    this.carYear = carYear;
  }

  @Override
  public String toString() {
    return "차량 번호: " + carNo + "\n" +
        "차종: " + carName + "\n" +
        "제조사: " + carMaker + "\n" +
        "연식: " + carYear;
  }
}
