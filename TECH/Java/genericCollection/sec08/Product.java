package genericCollection.sec08;

public class Product {

  private String name;
  private int price;
  private String category;

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

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Product(String name, int price, String category) {
    this.name = name;
    this.price = price;
    this.category = category;
  }

  @Override
  public String toString() {
    return "상품명: " + name + ",가격: " + price + ",카테고리: " + category;
  }
}
