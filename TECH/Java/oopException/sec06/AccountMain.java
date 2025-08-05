package oopException.sec06;

public class AccountMain {

  public static void main(String[] args) {
    // 예외를 포함하고 있는 클래스 메소드 사용
    Account account = new Account();
    //예금하기
    account.deposit(10000);
    System.out.println("예금액 : " + account.getBalance());

    //출금하기
    try {
      account.withdraw(30000);  //메소드 구현에 예외를 포함하고 있는 메소드
    } catch (BalanceInsufficientException e) {
      String message = e.getMessage();//예외 발생시킬 때 생성자로 전달된 문자열이 super() 호출되면서 전달됨
      System.out.println(message);
      System.out.println();
      System.out.println("예외 추적 내용 출력");
      e.printStackTrace(); //예외 발생된 경로 출력
    }
  }

}
