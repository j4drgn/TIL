package oopClass.sec09;

public class Book {

  String title;
  String author;
  int price;

  public Book() {
    //this() : 생성자에서 다른 생성자 호출 할 수 있는 메서드
    this("자바스크립트", "이몽룡", 12000); //매개변수로 생성자를 구분
  }

  public Book(String t, String au, int p) {
    title = t;
    author = au;
    price = p;
  }

  public void show() {
    System.out.println("Title: " + title);
    System.out.println("Author: " + author);
    System.out.println("Price: " + price);
  }
}
