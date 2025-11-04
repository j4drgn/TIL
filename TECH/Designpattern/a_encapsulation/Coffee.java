package com.mc.oop.a_encapsulation;

public class Coffee {

  private String name;
  private int price;
  private int stock;

  // 읽기, 수정 : getter/setter
  // 읽기 	  : getter
  // 접근 x	  : x
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }


}
