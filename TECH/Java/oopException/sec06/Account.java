package oopException.sec06;

public class Account {

  private long balance;

  public Account() {

  }

  public long getBalance() {
    return balance;
  }

  public void deposit(int money) {
    balance += money;
  }

  //예외 발생코드를 가지고 있는 메소드
  //호출한 곳에서 예외를 처리하도록 떠넘기기(throws)
  public void withdraw(int money) throws BalanceInsufficientException {
    if (balance < money) {
      throw new BalanceInsufficientException("잔고 부족 : " + (money - balance) + " 모자람");
    }
    balance -= money; //인출하려는 money보다 balance가 작으면 인출 불가 - 예외 발생하도록구현
  }

}
