package arrayType;

public class ArrayClone {

  public static void main(String[] args) {
    //Object.clone()메소드 사용한 깊은 복사
    int[] a = {1, 2, 3, 4};
    int[] b = a.clone();

    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }

    System.out.println();

    for (int i = 0; i < b.length; i++) {
      System.out.print(b[i] + " ");
    }

    System.out.println();
    b[0] = 10; //b배열 원소값 변환
    
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }

    System.out.println();
    for (int i = 0; i < b.length; i++) {
      System.out.print(b[i] + " "); //b배열과 a배열은 서로 다른 객체
    }

  }

}
