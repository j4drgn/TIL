# 커피 관리 시스템 발전 과정

이 디렉토리는 객체지향 설계의 발전 과정을 보여주는 커피 관리 시스템 예제를 포함하고 있습니다. 절차적 프로그래밍에서 객체지향 프로그래밍으로 발전하는 과정을 단계별로 구현했습니다.

## 디렉토리 구성

### 1. CoffeeManager.java

개별 변수를 사용한 절차적 프로그래밍 방식의 기본 구현입니다.

- **주요 특징**:
  - 각 커피 종류마다 개별 변수로 속성 관리
  - 코드 중복이 많고 확장성이 떨어짐
  - 새로운 커피 종류 추가 시 많은 코드 수정 필요

```java
// 개별 변수로 커피 정보 관리
String americanoName = "americano";
int americanoPrice = 1000;
int americanoCost = 500;
int americanoStock = 10;
int americanoSafetyStock = 3;
int americanoSalesCnt = 0;

String mochaName = "mocha";
// ... 다른 커피 종류의 변수들
```

### 2. ArrayCoffeeManager.java

배열을 활용하여 데이터 관리를 개선한 버전입니다.

- **주요 특징**:
  - 배열을 사용하여 동일한 속성끼리 그룹화
  - 반복문을 통한 동적 처리 가능
  - 코드 중복 감소 및 확장성 향상

```java
// 배열을 사용한 데이터 관리
String[] names = { "americano", "mocha", "latte", "frupuchino" };
int[] prices = { 1000, 2000, 3000, 4000 };
int[] costs = { 500, 1000, 1500, 2000 };
int[] stocks = { 10, 10, 10, 10 };
int[] safetyStocks = { 3, 3, 3, 3 };
int[] salesCnts = { 0, 0, 0, 0};
```

### 3. Coffee.java

커피 객체를 표현하는 클래스입니다.

- **주요 특징**:
  - 캡슐화를 통한 데이터와 행위의 결합
  - 속성(필드)과 행위(메서드)를 하나의 클래스로 정의
  - 객체의 자율성과 응집도 향상

```java
public class Coffee {
    private String name;
    private int price;
    private int cost;
    private int stock;
    private int safetyStock;
    private int salesAmount;

    // 생성자
    public Coffee(String name, int price, int cost, int stock, int safetyStock, int salesAmount) {
        // 초기화 코드
    }

    // 메서드
    public void deductStock(int cnt) {
        this.stock -= cnt;
    }

    public void addStock(int cnt) {
        this.stock += cnt;
    }

    // getter/setter 메서드
    // ...
}
```

### 4. ClassCoffeeManager.java

Coffee 클래스를 활용한 객체지향적 구현입니다.

- **주요 특징**:
  - Coffee 객체 배열을 사용하여 데이터 관리
  - 객체의 메서드를 통한 행위 추상화
  - 코드의 가독성과 유지보수성 향상

```java
// 객체 배열을 사용한 데이터 관리
Coffee[] coffees = {
    new Coffee("americano", 1000, 500, 10, 3, 0),
    new Coffee("mocha", 2000, 1000, 10, 3, 0),
    new Coffee("latte", 3000, 1500, 10, 3, 0),
    new Coffee("frupuchino", 4000, 2000, 10, 3, 0)
};

// 객체의 메서드를 통한 행위 추상화
coffees[drinkNo].deductStock(orderCnt);
```

## 객체지향 설계의 발전 과정

### 1. 절차적 접근 방식 (CoffeeManager.java)

- 데이터와 행위가 분리되어 있음
- 코드 중복이 많고 유지보수가 어려움
- 확장성이 떨어짐 (새로운 커피 종류 추가 시 코드 전체 수정 필요)

### 2. 배열을 활용한 개선 (ArrayCoffeeManager.java)

- 동일한 속성끼리 배열로 그룹화
- 반복문을 통한 코드 중복 감소
- 여전히 데이터와 행위가 분리되어 있음

### 3. 객체지향적 구현 (ClassCoffeeManager.java)

- 데이터와 행위를 Coffee 클래스로 캡슐화
- 객체의 자율성과 책임 명확화
- 확장성과 유지보수성 향상

## 주요 개선 사항

1. **코드 중복 감소**

   - 개별 변수 → 배열 → 객체로 발전하며 중복 코드 감소
   - 반복문과 객체 메서드를 통한 코드 재사용

2. **확장성 향상**

   - 새로운 커피 종류 추가 시 객체만 추가하면 됨
   - 기존 코드 수정 최소화

3. **유지보수성 향상**

   - 관련 데이터와 행위가 하나의 클래스로 캡슐화
   - 코드 구조 개선으로 가독성 향상

4. **객체의 자율성**
   - Coffee 객체가 자신의 상태를 스스로 관리
   - 메서드를 통한 상태 변경으로 일관성 유지

## 향후 개선 방향

1. **인터페이스와 추상 클래스 도입**

   - 다양한 커피 유형을 표현할 수 있는 계층 구조 설계

2. **디자인 패턴 적용**

   - 싱글톤 패턴: 시스템 전체에서 공유되는 자원 관리
   - 팩토리 패턴: 커피 객체 생성 로직 캡슐화
   - 전략 패턴: 다양한 할인 정책 구현

3. **예외 처리 강화**

   - 더 세분화된 예외 처리로 시스템 안정성 향상

4. **도메인 주도 설계 적용**
   - 비즈니스 도메인별 패키지 구조화
   - 관심사 분리를 통한 코드 모듈화
