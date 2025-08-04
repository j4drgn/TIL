package oopException.sec01;

public class NullPointerExceptionEx {

  public static void main(String[] args) {
    // null을 참조하는 객체변수를 통해 메서드를 접근하려 할 때 발생하는 예외
    String data = null;
    int[] arr = {1, 2, 3};
    String data1 = "100";
    String data2 = "a100";
//    System.out.println(data.toString()); //Cannot invoke "String.toString()" because "data" is null
    //오류 발생 프로그램 종료
//    System.out.println(arr[5]); //Index 5 out of bounds for length 3
    int value1 = Integer.parseInt(data1); //문자열 정수로 변환
    int value2 = Integer.parseInt(data2); //문자열 정수로 변환 -> 변환 불가능한 문자로 인한 예외 발생

    System.out.println(value1 + value2);

  }


}
