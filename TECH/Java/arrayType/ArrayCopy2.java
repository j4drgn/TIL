package arrayType;

public class ArrayCopy2 {

  public static void main(String[] args) {
    //메소드 사용 없이 깊은 복사
    //새로운 배열 생성 후 원본 배열의 원소값을 저장
    int[] a = {1, 2, 3, 4};
    int[] b = new int[4];

    for (int i = 0; i < a.length; i++) {
      b[i] = a[i];
    }

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
