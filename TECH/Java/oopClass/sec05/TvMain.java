package oopClass.sec05;

public class TvMain {

  public static void main(String[] args) {
    //객체 배열 생성
    Tv[] tvArr = new Tv[3];
    for (int i = 0; i < tvArr.length; i++) { //길이가 3일 Tv 객체 배열
      tvArr[i] = new Tv(); //각 배열 idx에서 참조할 객체 생성
//      tvArr[i].channel = i + 10;
    }
  }
}
