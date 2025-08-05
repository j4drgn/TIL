package oopException.sec03;

public class CacthOrderEx {

  public static void main(String[] args) {
    // 다중 catch구문 있을 시 catch 순서
    // 모든 예외처리 클래스는 Exception 클래스를 상속 받아서 구현되어 있음
    // 상위 클래스인 Exception은 모든 예외 처리
    try {
      String data = "a3";
      int arr[] = {1, 2, 3};
      int var1 = Integer.parseInt(data);
      int var2 = arr[5];
      System.out.println(var1 + 10);

    } catch (NumberFormatException e) {
      System.out.println("오류발생");
    } catch (Exception e) { //모든 예외 처리하는 catch 구문 이므로 아래 표현된 catch는 필요없음- 문법오류
      //특정 오류 외의 모든 오류 처리하게 하려고 하면 현재 catch 구문을 순서를 가장 아래로 내려야함.
      System.out.println("오류 발생 : 상위 클래스");
    } finally {

    }
  }

}
