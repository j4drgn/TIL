package com.mc.oop.b_coffemanger;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * 클래스를 사용하여 커피 관리 시스템을 구현한 클래스
 * 객체지향적 접근 방식으로 Coffee 클래스를 활용하여 데이터와 행위를 캡슐화한 버전
 * 배열 버전에서 더 발전하여 객체 배열을 사용하는 방식
 */
public class ClassCoffeeManager {

  public static void main(String[] args) {

    // Coffee 객체 배열을 사용하여 커피 정보 관리
    // 객체를 통해 데이터와 행위를 함께 관리할 수 있음
    Coffee[] coffees = {
        new Coffee("americano", 1000, 500, 10, 3, 0),
        new Coffee("mocha", 2000, 1000, 10, 3, 0),
        new Coffee("latte", 3000, 1500, 10, 3, 0),
        new Coffee("frupuchino", 4000, 2000, 10, 3, 0)
    };

    // 재정 정보 초기화
    int balance = 100000;       // 잔고
    int salesAmount = 0;        // 총 매출액
    int expensesAmount = 0;     // 총 지출액

    // 메인 루프 - 프로그램 실행
    while (true) {
      Scanner sc = new Scanner(System.in);

      try {
        // 메뉴 표시
        System.out.println("\n==== menu ====\n");
        System.out.println("판매등록(1)");
        System.out.println("현황(2)");
        System.out.println("종료(3)");

        System.out.print("입력 : ");
        int menu = sc.nextInt();

        // 종료 메뉴 선택 시
        if (menu == 3) {
          System.out.println("system : 종료합니다.");
          break;
        }

        // 잘못된 메뉴 번호 입력 시
        if (menu < 1 || menu > 3) {
          System.out.println("system : 잘못 입력하셨습니다.");
          continue;
        }

        // 판매등록 메뉴 선택 시
        if (menu == 1) {
          System.out.println("\n==== list ====\n");
          // 동적으로 메뉴 목록 생성 - 객체의 getName() 메소드 활용
          for (int i = 0; i < coffees.length; i++) {
            System.out.println(coffees[i].getName() + "(" + i + ")");
          }

          // 주문 정보 입력
          System.out.print("번호 : ");
          int drinkNo = sc.nextInt();
          System.out.print("수량 : ");
          int orderCnt = sc.nextInt();

          // 유효하지 않은 음료 번호 입력 시
          if (drinkNo < 0 || drinkNo >= coffees.length) {
            System.out.println("잘못 입력하셨습니다.");
            continue;
          }

          // 주문 처리 - 객체의 메소드를 활용하여 코드 가독성 향상
          // 주문수량이 재고보다 적거나 같은 경우
          if (orderCnt <= coffees[drinkNo].getStock()) {
            // 재고차감 - 객체의 메소드 사용
            coffees[drinkNo].deductStock(orderCnt);
            // 매출등록
            salesAmount += orderCnt * coffees[drinkNo].getPrice();
            // 잔고등록
            balance += orderCnt * coffees[drinkNo].getPrice();
          } else {
            // 주문수량이 재고보다 많은 경우, 매입 시도
            int purchasePrice = orderCnt * coffees[drinkNo].getCost();
            if (purchasePrice >= balance) {
              // 잔고가 부족한 경우 주문 취소
              System.out.println("system : 주문을 취소합니다.");
              continue;
            }

            // 매입 진행
            System.out.println(
                "system : " + coffees[drinkNo].getName() + " " + orderCnt + "개 매입합니다.");
            // 재고 추가 - 객체의 메소드 사용
            coffees[drinkNo].addStock(orderCnt);
            // 지출 등록
            expensesAmount += purchasePrice;
            // 잔고 등록
            balance -= purchasePrice;

            // 매입 후 판매 처리
            // 재고차감 - 객체의 메소드 사용
            coffees[drinkNo].deductStock(orderCnt);
            // 매출등록
            salesAmount += orderCnt * coffees[drinkNo].getPrice();
            // 잔고등록
            balance += orderCnt * coffees[drinkNo].getPrice();
          }

          // 안전재고 수량확인 및 확보 - 객체의 메소드를 통한 정보 접근
          if (coffees[drinkNo].getStock() <= coffees[drinkNo].getSafetyStock()) {
            // 안전재고 확보를 위한 매입가격 계산
            int purchasePrice = coffees[drinkNo].getSafetyStock() * 2 * coffees[drinkNo].getCost();

            if (balance >= purchasePrice) {
              // 잔고가 충분한 경우 안전재고 확보
              coffees[drinkNo].addStock(coffees[drinkNo].getSafetyStock() * 2);
              balance -= purchasePrice;
              expensesAmount += purchasePrice;
              System.out.println("system : 안전재고 확보");
            } else {
              // 잔고가 부족한 경우 안전재고 확보 실패
              System.out.println("system : 잔액부족으로 안전재고 확보 실패");
            }
          }

          // 판매 결과 출력 - 객체의 getter 메소드를 통한 정보 접근
          System.out.println("\n 제품명 : " + coffees[drinkNo].getName()
              + "\n 판매가 : " + coffees[drinkNo].getPrice()
              + "\n 판매수량 : " + orderCnt
              + "\n 결재금액 : " + orderCnt * coffees[drinkNo].getPrice()
              + "\n 남은 재고 : " + coffees[drinkNo].getStock());

        } else {
          // 현황 메뉴 선택 시 - 재고 및 판매 현황 출력
          System.out.println("\n==== info ====\n");

          // 반복문을 통해 모든 커피 정보 출력 - 객체의 getter 메소드 활용
          for (int i = 0; i < coffees.length; i++) {
            System.out.printf("%-10s 재고(%3d) 판매량(%3d) \n",
                coffees[i].getName(), coffees[i].getStock(), coffees[i].getSalesAmount());
          }

          // 재정 정보 출력
          System.out.printf("잔고 : %4d | 매출 : %8d | 지출 %8d \n", balance, salesAmount,
              expensesAmount);
        }

      } catch (NoSuchElementException e) {
        // 입력 오류 처리
        System.out.println("system : 잘못 입력하셨습니다.");
        continue;
      }
    }
  }
}
