package com.mc.oop.b_coffemanger;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * 커피 관리 시스템의 기본 구현 클래스
 * 개별 변수를 사용하여 커피 정보를 관리하는 방식
 * 코드 중복이 많고 확장성이 떨어지는 구조
 */
public class CoffeeManager {

  public static void main(String[] args) {

    // 아메리카노 정보 초기화
    String americanoName = "americano";
    int americanoPrice = 1000;
    int americanoCost = 500;
    int americanoStock = 10;
    int americanoSafetyStock = 3;
    int americanoSalesCnt = 0;

    // 모카 정보 초기화
    String mochaName = "mocha";
    int mochaPrice = 2000;
    int mochaCost = 1000;
    int mochaStock = 10;
    int mochaSafetyStock = 3;
    int mochaSalesCnt = 0;

    // 라떼 정보 초기화
    String latteName = "latte";
    int lattePrice = 3000;
    int latteCost = 1500;
    int latteStock = 10;
    int latteSafetyStock = 3;
    int latteSalesCnt = 0;

    // 재정 정보 초기화
    int balance = 100000;      // 잔고
    int salesAmount = 0;       // 총 매출액
    int expensesAmount = 0;    // 총 지출액

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
          System.out.println("americano(0)");
          System.out.println("mocha(1)");
          System.out.println("latte(2)");

          // 주문 정보 입력
          System.out.print("번호 : ");
          int drinkNo = sc.nextInt();
          System.out.print("수량 : ");
          int orderCnt = sc.nextInt();

          // 유효하지 않은 음료 번호 입력 시
          if (drinkNo < 0 || drinkNo > 2) {
            System.out.println("잘못 입력하셨습니다.");
            continue;
          }

          // 아메리카노 주문 처리
          if (drinkNo == 0) {
            // 주문수량이 재고보다 적거나 같은 경우
            if (orderCnt <= americanoStock) {
              // 재고차감
              americanoStock -= orderCnt;
              // 매출등록
              salesAmount += orderCnt * americanoPrice;
              // 잔고등록
              balance += orderCnt * americanoPrice;
            } else {
              // 주문수량이 재고보다 많은 경우, 매입 시도
              int purchasePrice = orderCnt * americanoCost;
              if (purchasePrice >= balance) {
                // 잔고가 부족한 경우 주문 취소
                System.out.println("system : 주문을 취소합니다.");
                continue;
              }

              // 매입 진행
              System.out.println("system : " + americanoName + " " + orderCnt + "개 매입합니다.");
              // 재고 추가
              americanoStock += orderCnt;
              // 지출 등록
              expensesAmount += purchasePrice;
              // 잔고 등록
              balance -= purchasePrice;

              // 매입 후 판매 처리
              // 재고차감
              americanoStock -= orderCnt;
              // 매출등록
              salesAmount += orderCnt * americanoPrice;
              // 잔고등록
              balance += orderCnt * americanoPrice;
            }

            // 안전재고 수량확인 및 확보
            if (americanoStock <= americanoSafetyStock) {
              // 안전재고 확보를 위한 매입가격 계산
              int purchasePrice = americanoSafetyStock * 2 * americanoCost;

              if (balance >= purchasePrice) {
                // 잔고가 충분한 경우 안전재고 확보
                americanoStock += americanoSafetyStock * 2;
                balance -= purchasePrice;
                expensesAmount += purchasePrice;
                System.out.println("system : 안전재고 확보");
              } else {
                // 잔고가 부족한 경우 안전재고 확보 실패
                System.out.println("system : 잔액부족으로 안전재고 확보 실패");
              }
            }

            // 판매 결과 출력
            System.out.println("\n 제품명 : " + americanoName +
                "\n 판매가 : " + americanoPrice +
                "\n 판매수량 : " + orderCnt +
                "\n 결재금액 : " + orderCnt * americanoPrice +
                "\n 남은 재고 : " + americanoStock
            );

          } else if (drinkNo == 1) {
            // 모카 주문 처리 (아메리카노와 동일한 로직)
            // 주문수량이 재고보다 적거나 같은 경우
            if (orderCnt <= mochaStock) {
              // 재고차감
              mochaStock -= orderCnt;
              // 매출등록
              salesAmount += orderCnt * mochaPrice;
              // 잔고등록
              balance += orderCnt * mochaPrice;
            } else {
              // 주문수량이 재고보다 많은 경우, 매입 시도
              int purchasePrice = orderCnt * mochaCost;
              if (purchasePrice >= balance) {
                // 잔고가 부족한 경우 주문 취소
                System.out.println("system : 주문을 취소합니다.");
                continue;
              }

              // 매입 진행
              System.out.println("system : " + mochaName + " " + orderCnt + "개 매입합니다.");
              // 재고 추가
              mochaStock += orderCnt;
              // 지출 등록
              expensesAmount += purchasePrice;
              // 잔고 등록
              balance -= purchasePrice;

              // 매입 후 판매 처리
              // 재고차감
              mochaStock -= orderCnt;
              // 매출등록
              salesAmount += orderCnt * mochaPrice;
              // 잔고등록
              balance += orderCnt * mochaPrice;
            }

            // 안전재고 수량확인 및 확보
            if (mochaStock <= mochaSafetyStock) {
              // 안전재고 확보를 위한 매입가격 계산
              int purchasePrice = mochaSafetyStock * 2 * mochaCost;

              if (balance >= purchasePrice) {
                // 잔고가 충분한 경우 안전재고 확보
                mochaStock += mochaSafetyStock * 2;
                balance -= purchasePrice;
                expensesAmount += purchasePrice;
                System.out.println("system : 안전재고 확보");
              } else {
                // 잔고가 부족한 경우 안전재고 확보 실패
                System.out.println("system : 잔액부족으로 안전재고 확보 실패");
              }
            }

            // 판매 결과 출력
            System.out.println("\n 제품명 : " + mochaName +
                "\n 판매가 : " + mochaPrice +
                "\n 판매수량 : " + orderCnt +
                "\n 결재금액 : " + orderCnt * mochaPrice +
                "\n 남은 재고 : " + mochaStock
            );

          } else {
            // 라떼 주문 처리 (아메리카노와 동일한 로직)
            // 주문수량이 재고보다 적거나 같은 경우
            if (orderCnt <= latteStock) {
              // 재고차감
              latteStock -= orderCnt;
              // 매출등록
              salesAmount += orderCnt * lattePrice;
              // 잔고등록
              balance += orderCnt * lattePrice;
            } else {
              // 주문수량이 재고보다 많은 경우, 매입 시도
              int purchasePrice = orderCnt * latteCost;
              if (purchasePrice >= balance) {
                // 잔고가 부족한 경우 주문 취소
                System.out.println("system : 주문을 취소합니다.");
                continue;
              }

              // 매입 진행
              System.out.println("system : " + latteName + " " + orderCnt + "개 매입합니다.");
              // 재고 추가
              latteStock += orderCnt;
              // 지출 등록
              expensesAmount += purchasePrice;
              // 잔고 등록
              balance -= purchasePrice;

              // 매입 후 판매 처리
              // 재고차감
              latteStock -= orderCnt;
              // 매출등록
              salesAmount += orderCnt * lattePrice;
              // 잔고등록
              balance += orderCnt * lattePrice;
            }

            // 안전재고 수량확인 및 확보
            if (latteStock <= latteSafetyStock) {
              // 안전재고 확보를 위한 매입가격 계산
              int purchasePrice = latteSafetyStock * 2 * latteCost;

              if (balance >= purchasePrice) {
                // 잔고가 충분한 경우 안전재고 확보
                latteStock += latteSafetyStock * 2;
                balance -= purchasePrice;
                expensesAmount += purchasePrice;
                System.out.println("system : 안전재고 확보");
              } else {
                // 잔고가 부족한 경우 안전재고 확보 실패
                System.out.println("system : 잔액부족으로 안전재고 확보 실패");
              }
            }

            // 판매 결과 출력
            System.out.println("\n 제품명 : " + latteName +
                "\n 판매가 : " + lattePrice +
                "\n 판매수량 : " + orderCnt +
                "\n 결재금액 : " + orderCnt * lattePrice +
                "\n 남은 재고 : " + latteStock
            );
          }

        } else {
          // 현황 메뉴 선택 시 - 재고 및 판매 현황 출력
          System.out.println("\n==== info ====\n");
          System.out.printf("%-10s 재고(%3d) 판매량(%3d) \n", americanoName, americanoStock,
              americanoSalesCnt);
          System.out.printf("%-10s 재고(%3d) 판매량(%3d) \n", mochaName, mochaStock, mochaSalesCnt);
          System.out.printf("%-10s 재고(%3d) 판매량(%3d) \n", latteName, latteStock, latteSalesCnt);
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
