package genericCollection.sec02;

public class BoxGenMain {

  public static void main(String[] args) {
    //제네릭 클래스 활용 : 객체 생성 시 구체적 타입 지정
    Box<String> box1 = new Box<String>(); //타임파라미터에 String 대입
    box1.set("hello"); //형변환 발생하지 않음
    String str = box1.get(); // 형변환 발생하지않음.
    System.out.println(str);

    //정수형 Box 인스턴스 생성 -> Integer 클래스 사용
    Box<Integer> box2 = new Box<>();
    box2.set(7);   //타입변환 없음.
    int no = box2.get();
    System.out.println(no);
  }

}
