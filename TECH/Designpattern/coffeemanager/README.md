# 커피 관리 시스템 (고도화 버전)

이 디렉토리는 b_coffeemanager 패키지의 기본 구현을 발전시켜 도메인 주도 설계(DDD) 개념과 디자인 패턴을 적용한 고도화된 커피 관리 시스템을 구현한 예제입니다.

## 프로젝트 구조

### 도메인 계층 (domain)

비즈니스 도메인 객체들을 포함하는 핵심 계층입니다.

#### account 패키지

계정 및 재무 관리를 담당하는 도메인입니다.

- **Account 클래스**: 싱글톤 패턴을 적용한 계정 관리 클래스
  - 잔고, 매출, 지출 관리
  - 판매 등록 및 지출 등록 기능

```java
public class Account {
    private int balance = 100000;
    private int sales;
    private int expences;
    private static Account instance;

    // 싱글톤 패턴 구현
    public static Account getInstance(int balance) {
        if(instance == null) {
            instance = new Account(balance);
        }
        return instance;
    }

    // private 생성자로 외부에서 인스턴스 생성 방지
    private Account(int balance) {
        super();
        this.balance = balance;
    }

    // 매출 등록 메서드
    public void registSales(int price) {
        this.balance += price;
        this.sales += price;
    }

    // 지출 등록 메서드
    public boolean registExpenses(int price) {
        if(price > balance) {
            return false;
        }
        this.balance -= price;
        this.expences += price;
        return true;
    }

    // 기타 getter 메서드
    // ...
}
```

#### coffee 패키지

커피 관련 도메인 객체들을 포함합니다.

- **Coffee 클래스**: 기본 커피 도메인 객체
  - 커피 속성(이름, 가격, 재고 등) 관리
  - 재고 관리 및 안전재고 확인 기능
- **SeasonCoffee 클래스**: Coffee 클래스를 상속받아 시즌 커피 기능 추가
  - 특정 월에만 판매 가능한 시즌 커피 구현
  - 상속을 통한 기능 확장

```java
public class SeasonCoffee extends Coffee {
    private Month[] seasons;

    public SeasonCoffee(String name, int price, int purchasePrice, int stock, int safetyStock, int salesCnt,
            Month[] seasons) {
        super(name, price, purchasePrice, stock, safetyStock, salesCnt);
        this.seasons = seasons;
    }

    // 현재 월이 시즌에 포함되는지 확인하는 메서드
    public boolean isSeason() {
        Month now = LocalDate.now().getMonth();
        for (Month month : seasons) {
            if(month.equals(now)) return true;
        }
        return false;
    }
}
```

#### purchase 패키지

구매(매입) 관련 기능을 담당합니다.

- **Purchase 클래스**: 커피 매입 처리 담당
  - 매입 가격 계산
  - 매입 처리 및 재고 추가

```java
public class Purchase {
    private Coffee coffee;
    private int purchaseCnt;
    private int purchasePrice;

    public Purchase(Coffee coffee, int cnt) {
        this.coffee = coffee;
        this.purchaseCnt = cnt;
        this.purchasePrice = coffee.getPurchasePrice() * cnt;
    }

    // 매입 처리 메서드
    public boolean proceed() {
        Account account = Account.getInstance();
        if(account.registExpenses(purchasePrice)) {
            System.out.println("system : " + coffee.getName() + "[" + purchaseCnt + "잔] 매입" );
            coffee.addStock(purchaseCnt);
            return true;
        }
        System.out.println("system : 매입에 실패했습니다.");
        return false;
    }

    // 기타 getter 메서드
    // ...
}
```

#### order, payment, sale 패키지

주문, 결제, 판매 관련 기능을 담당합니다.

- **Order 클래스**: 주문 정보 관리 및 생성
- **Payment 클래스**: 결제 정보 관리
- **SaleContext 클래스**: 판매 컨텍스트 관리

### 표현 계층 (presentation)

사용자 인터페이스를 담당하는 계층입니다.

- **Menu 클래스**: 사용자 메뉴 및 입력 처리
  - 메뉴 표시 및 사용자 입력 처리
  - 주문 등록 및 현황 표시

```java
public class Menu {
    private SaleContext saleContext = new SaleContext();
    private Coffee[] coffees;
    private Account account = Account.getInstance();

    // 메뉴 표시 및 사용자 입력 처리 메서드
    public void menu() {
        // 메뉴 표시 및 사용자 입력 처리 로직
        // ...
    }

    // 주문 등록 메서드
    private void registOrder(int drinkNo, int orderCnt) {
        Order order = Order.createOrder(coffees[drinkNo], orderCnt);

        if (order.getStatus().isFail()) {
            System.out.println("system : " + order.getStatus().desc());
            return;
        }

        Payment payment = saleContext.init(order);

        // 주문 정보 출력
        // ...
    }
}
```

## 적용된 디자인 패턴

### 1. 싱글톤 패턴 (Singleton Pattern)

Account 클래스에 적용되어 시스템 내에서 단일 인스턴스만 존재하도록 보장합니다.

```java
public static Account getInstance(int balance) {
    if(instance == null) {
        instance = new Account(balance);
    }
    return instance;
}

private Account(int balance) {
    super();
    this.balance = balance;
}
```

**장점**:

- 시스템 전체에서 공유되는 자원(잔고, 매출, 지출)의 일관성 유지
- 전역적인 접근점 제공

### 2. 팩토리 메서드 패턴 (Factory Method Pattern)

Order 클래스의 createOrder 정적 메서드를 통해 주문 객체 생성을 캡슐화합니다.

```java
public static Order createOrder(Coffee coffee, int orderCnt) {
    Order order = new Order(coffee, orderCnt);
    // 생성 과정에서의 추가 로직 처리
    return order;
}

private Order(Coffee coffee, int orderCnt) {
    // 생성자 private으로 제한
}
```

**장점**:

- 객체 생성 로직 캡슐화
- 클라이언트 코드와 객체 생성 로직 분리

### 3. 상속을 통한 확장 (Inheritance)

Coffee 클래스를 상속받아 SeasonCoffee 클래스를 구현하여 기능을 확장합니다.

```java
public class SeasonCoffee extends Coffee {
    private Month[] seasons;

    // 생성자 및 메서드 구현
    // ...
}
```

**장점**:

- 기존 코드 재사용
- 기능 확장의 용이성

### 4. 컨텍스트 객체 (Context Object)

SaleContext 클래스를 통해 판매 프로세스의 컨텍스트를 관리합니다.

**장점**:

- 복잡한 프로세스의 캡슐화
- 관심사 분리를 통한 코드 모듈화

## 도메인 주도 설계(DDD) 적용

### 1. 도메인별 패키지 구조화

- account: 계정 관련 도메인
- coffee: 커피 관련 도메인
- purchase: 구매 관련 도메인
- order: 주문 관련 도메인
- payment: 결제 관련 도메인
- sale: 판매 관련 도메인

### 2. 계층 분리

- domain: 비즈니스 로직을 담당하는 도메인 계층
- presentation: 사용자 인터페이스를 담당하는 표현 계층

### 3. 풍부한 도메인 모델

각 도메인 객체가 자신의 상태와 행위를 캡슐화하여 풍부한 기능을 제공합니다.

## 개선 사항

1. **인터페이스 도입**

   - 다양한 결제 방식, 할인 정책 등을 위한 인터페이스 설계

2. **예외 처리 강화**

   - 더 세분화된 예외 처리를 통한 시스템 안정성 향상

3. **데이터 영속성 추가**

   - 파일 또는 데이터베이스를 통한 데이터 저장 기능

4. **로깅 시스템 도입**
   - 시스템 동작 로그 기록 및 모니터링 기능

## 학습 포인트

1. 도메인 주도 설계(DDD)의 기본 개념과 적용 방법
2. 디자인 패턴(싱글톤, 팩토리 메서드 등)의 실제 적용 사례
3. 관심사 분리를 통한 코드 모듈화와 유지보수성 향상
4. 객체지향 설계 원칙(SOLID)의 적용
