package arrayType;

public class ArrayCopy {

  public static void main(String[] args) {
    // 얕은 복사 : 참조 주소만 복사(변수들끼리 참조값 공유)
    // 변수 이름만 다르고 동일한 배열 참조
    // 원본 변수를 통해 변경하면 복사본 참조 내용도 변경됨.
    int[] a = {1, 2, 3, 4};
    int b[] = a; //a가 참조하는 배열 주소가 b에 저장 => 동일 배열 참조

    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();
    for (int i = 0; i < b.length; i++) {
      System.out.print(b[i] + " ");
    }
    System.out.println();
    b[0] = 10;
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " "); //a의 0번 idx 값도 변경
    }

    System.out.println();
    for (int i = 0; i < b.length; i++) {
      System.out.print(b[i] + " ");
    }
  }

}
