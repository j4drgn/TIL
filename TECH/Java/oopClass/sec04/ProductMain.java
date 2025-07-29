package oopClass.sec04;

import java.text.DecimalFormat;
import java.util.Scanner;

class Product {

  private String prdName;
  private int prdPrice;
  private int prdSold;
  private int prdStock;
  private DecimalFormat df;

  public Product() {
    df = new DecimalFormat("#,###");
  }

  public Product(String prdName, int prdPrice, int prdSold, int prdStock) {
    this.prdName = prdName;
    this.prdPrice = prdPrice;
    this.prdSold = prdSold;
    this.prdStock = prdStock;
    df = new DecimalFormat("#,###");
  }

  public void inputPrdInfo() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("상품명 입력: ");
    this.prdName = scanner.nextLine();

    System.out.print("상품 가격 입력: ");
    this.prdPrice = scanner.nextInt();

    System.out.print("판매 수량 입력: ");
    this.prdSold = scanner.nextInt();

    System.out.print("재고 수량 입력: ");
    this.prdStock = scanner.nextInt();
  }

  public void showPrdInfo() {
    System.out.println("\n**** 상품 정보 출력 **** ");
    System.out.println("상품명: " + prdName);
    System.out.println("가격: " + df.format(prdPrice) + "원");
    System.out.println("판매 수량: " + prdSold + "개");
    System.out.println("재고 수량: " + prdStock + "개");
  }

  public void showSalesAmount() {
    int salesAmount = prdPrice * prdSold;
    System.out.println("매출액: " + df.format(salesAmount) + "원");
  }

  public void showStockAmount() {
    int stockAmount = prdPrice * prdStock;
    System.out.println("재고액: " + df.format(stockAmount) + "원");
  }

}

public class ProductMain {

  public static void main(String[] args) {
    Product product = new Product();
    System.out.println("**** 상품 정보 입력 **** ");
    product.inputPrdInfo();
    product.showPrdInfo();
    product.showSalesAmount();
    product.showStockAmount();
  }
} 