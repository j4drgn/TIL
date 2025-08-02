package genericCollection.sec03;

public class ProductMain {

  public static void main(String[] args) {
    //멀티 타입 파라미터 제네릭 클래스 사용
    Product<Tv, String> prd1 = new Product<Tv, String>();
    Product<Car, String> prd2 = new Product<>();

    prd1.setKind(new Tv());
    prd1.setModel("스마트 티비");
    prd2.setKind(new Car());
    prd2.setModel("디젤");

    String tvModel = prd1.getModel();
    String carModel = prd2.getModel();

    System.out.println();
  }

}
