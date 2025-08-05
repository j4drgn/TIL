package oopException.sec04;

public class MultiCatch {

  public static void main(String[] args) {
    //동일하게 처리하고 싶은 예외를 |로 연결해서 두개 이상의 예외를 catch할 수 있음.
    try {
      int[] arr = {1, 2, 3};
      int a = arr[5];
      int var = Integer.parseInt("a100");
    } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
      System.out.println("예외처리 1: 배열범위 오류, 문자열 순서변환 오류를 처리 " + e);
    } catch (Exception e) { //위 catch에서 진행하지 않은 모든 오류를 catch
      System.out.println("예외처리 2 : 배열 인덱스 오류, 문자열 숫자 변환 오류를 제외한 나머지 처리");
    }
  }

}
