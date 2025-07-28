package arrayType;

import java.util.Arrays;

public class ArrayCopyOfRange {

  public static void main(String[] args) {
    // Arrays.copyOfRange(원본 배열, 시작 인덱스, 끝인덱스+1) : 원본 배열에서 시작 인덱스 ~ 끝 인덱스까지 원소 복사 후 새로운 배열 생성
    int a[] = {1, 2, 3, 4};
    int[] b = Arrays.copyOfRange(a, 1, 3);

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
