package oopClass.sec14;

public class SingletonMain {

  public static void main(String[] args) {
    //싱글톤 패턴 클래스 사용
//    Singleton obj1 = new Singleton(); //컴파일 에러, 생성자 private으로 접근 제한 시켜둬서

    //Singleton 객체가 필요할 경우 메서드 getInstance 활용
    Singleton obj1 = Singleton.getInstance();
    Singleton obj2 = Singleton.getInstance();

    if (obj1 == obj2) {
      System.out.println("obj1 == obj2");
    } else {
      System.out.println("obj1 != obj2");
    }
  }

}
