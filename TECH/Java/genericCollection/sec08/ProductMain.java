package genericCollection.sec08;

import java.util.LinkedList;

public class ProductMain {
  public static void main(String[] args) {
    LinkedList<Product> prdList = new LinkedList<>();

    prdList.add(new Product("노트북", 1500000, "전자기기"));
    prdList.add(new Product("스마트폰", 1200000, "전자기기"));
    prdList.add(new Product("무선이어폰", 300000, "액세서리"));

    System.out.println("=== 상품 목록 ===");
    for (Product product : prdList) {
      System.out.println(product);
    }

  }
}