package com.mc.oop.b_coffemanger;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * 배열을 사용하여 커피 관리 시스템을 구현한 클래스
 * 개별 변수 대신 배열을 사용하여 코드 중복을 줄이고 확장성을 개선한 버전
 */
public class ArrayCoffeeManager {

  public static void main(String[] args) {

    // 배열을 사용하여 커피 정보 관리
    String[] names = {"americano", "mocha", "latte", "frupuchino"};  // 커피 이름 배열
    int[] prices = {1000, 2000, 3000, 4000};                         // 판매가 배열
    int[] costs = {500, 1000, 1500, 2000};                           // 매입원가 배열
    int[] stocks = {10, 10, 10, 10};                                 // 재고 배열
    int[] safetyStocks = {3, 3, 3, 3};                               // 안전재고 배열
    int[] salesCnts = {0, 0, 0, 0};                                  // 판매량 배열

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
          // 동적으로 메뉴 목록 생성
          for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + "(" + i + ")");
          }

          // 주문 정보 입력
          System.out.print("번호 : ");
          int drinkNo = sc.nextInt();
          System.out.print("수량 : ");
          int orderCnt = sc.nextInt();

          // 유효하지 않은 음료 번호 입력 시
          if (drinkNo < 0 || drinkNo >= names.length) {
            System.out.println("잘못 입력하셨습니다.");
            continue;
          }

          // 주문 처리 - 배열 인덱스를 통해 접근하므로 코드 중복이 감소
          // 주문수량이 재고보다 적거나 같은 경우
          if (orderCnt <= stocks[drinkNo]) {
            // 재고차감
            stocks[drinkNo] -= orderCnt;
            // 매출등록
            salesAmount += orderCnt * prices[drinkNo];
            // 잔고등록
            balance += orderCnt * prices[drinkNo];
          } else {
            // 주문수량이 재고보다 많은 경우, 매입 시도
            int purchasePrice = orderCnt * costs[drinkNo];
            if (purchasePrice >= balance) {
              // 잔고가 부족한 경우 주문 취소
              System.out.println("system : 주문을 취소합니다.");
              continue;
            }

            // 매입 진행
            System.out.println("system : " + names[drinkNo] + " " + orderCnt + "개 매입합니다.");
            // 재고 추가
            stocks[drinkNo] += orderCnt;
            // 지출 등록
            expensesAmount += purchasePrice;
            // 잔고 등록
            balance -= purchasePrice;

            // 매입 후 판매 처리
            // 재고차감
            stocks[drinkNo] -= orderCnt;
            // 매출등록
            salesAmount += orderCnt * prices[drinkNo];
            // 잔고등록
            balance += orderCnt * prices[drinkNo];
          }

          // 안전재고 수량확인 및 확보
          if (stocks[drinkNo] <= safetyStocks[drinkNo]) {
            // 안전재고 확보를 위한 매입가격 계산
            int purchasePrice = safetyStocks[drinkNo] * 2 * costs[drinkNo];

            if (balance >= purchasePrice) {
              // 잔고가 충분한 경우 안전재고 확보
              stocks[drinkNo] += safetyStocks[drinkNo] * 2;
              balance -= purchasePrice;
              expensesAmount += purchasePrice;
              System.out.println("system : 안전재고 확보");
            } else {
              // 잔고가 부족한 경우 안전재고 확보 실패
              System.out.println("system : 잔액부족으로 안전재고 확보 실패");
            }
          }

          // 판매 결과 출력
          System.out.println(
              "\n 제품명 : " + names[drinkNo] + 
              "\n 판매가 : " + prices[drinkNo] + 
              "\n 판매수량 : " + orderCnt + 
              "\n 결재금액 : " + orderCnt * prices[drinkNo] + 
              "\n 남은 재고 : " + stocks[drinkNo]);

        } else {
          // 현황 메뉴 선택 시 - 재고 및 판매 현황 출력
          System.out.println("\n==== info ====\n");

          // 반복문을 통해 모든 커피 정보 출력
          for (int i = 0; i < names.length; i++) {
            System.out.printf("%-10s 재고(%3d) 판매량(%3d) \n"
                , names[i], stocks[i], salesCnts[i]);
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
