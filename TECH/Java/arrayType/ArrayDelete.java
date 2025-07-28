package arrayType;

public class ArrayDelete {

  public static void main(String[] args) {
    int[] num = {1, 2, 3, 4, 5};
    //num의 원소값을 유지하고 크기는 10인 배열이 필요해 짐
    int[] newNum = new int[10];

    //num원소값 newNum에 저장
    for (int i = 0; i < num.length; i++) {
      newNum[i] = num[i];
    }

    //newNum 출력
    for (int i = 0; i < newNum.length; i++) {
      System.out.println(newNum[i]);
    }

    //num 출력 : num과 newNum은 다른 객체 참조
    for (int i = 0; i < num.length; i++) {
      System.out.println(num[i]);
    }

    num = newNum; //num과 newNum은 같은 객체 참조
    //기존에 num이 참조하고 있던 배열(크기가 5인 배열)은 참조를 잃어버리게 됨 - 가비지콜렉터가 메모리 할당을 풀어버림

    //num = null ; //num이 참조하고 있던 배열에 대한 참조값을 지우고 null이 저장 - 어느 객체도 참조하고 있지 않다는 의미
    //기존에 num이 참조하고 있던 배열(크기가 5인 배열)은 참조를 잃어버리게 됨 - 가비지콜렉터가 메모리 할당을 풀어버림

    //newNum 출력
    for (int i = 0; i < newNum.length; i++) {
      System.out.println(newNum[i]);
    }

    //num 출력 : num과 newNum은 다른 객체 참조
    for (int i = 0; i < num.length; i++) {
      System.out.println(num[i]);
    }

    num = null; //num이 참조하는 배열 (크기가 10인 배열)의 참조값 num에서는 null로 변경 - 어느 객체도 참조하지 않음
    //단, newNum이 크기가 10인 배열 참조하므로 그대로 유지되어야 함
    //num[1] = 10;//Cannot store to int array because "num" is null
    //java.lang.NullPointerException
    System.out.println(num);
    //System.out.println(num[1]);//Cannot load from int array because "num" is null

  }
}
