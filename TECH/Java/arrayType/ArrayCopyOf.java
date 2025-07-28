package arrayType;

import java.util.Arrays;

public class ArrayCopyOf {

  public static void main(String[] args) {
    //Arrays.copyOf(원본 배열, 복사되는 배열의 크기)
    int[] a = {1, 2, 3, 4};
    int[] b = Arrays.copyOf(a, a.length);
//    int[] b = Arrays.copyOf(a, 7); //원본 길이보다 크게 복사하면 0으로 채움
//    int[] b = Arrays.copyOf(a, 2); //원본 idx 0부터 2개의 원소만 복사

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
