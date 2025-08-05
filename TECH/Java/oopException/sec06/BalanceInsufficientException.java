package oopException.sec06;

//컴파일러가 처리하는 예외 클래스로 생성 : extends Exception
public class BalanceInsufficientException extends Exception {
  //예외 클래스 여도 사용자 정의 클래스이므로 필드, 생성자, 메소드 포함 가능하지만 보통 생성자만 포함.
  //매개변수가 없는 기본 생성자 - 기본 생성자 없어도 됨
  //문자열 매개변수 변수가 있는 생성자 - 예외 발생 원인을 전달해서 메세지를 출력하기 위한 생성자

  public BalanceInsufficientException() {
    //기본 생성자
  }

  public BalanceInsufficientException(String message) {
    super(message);
  }

}
