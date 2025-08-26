# 디자인 패턴 학습

이 디렉토리는 객체지향 디자인 패턴 학습과 관련된 코드와 개념을 정리한 공간입니다.

## 디렉토리 구조

### a_encapsulation

- 캡슐화(Encapsulation) 원칙 구현 예제
- 객체의 속성과 행위를 하나로 묶고, 실제 구현 내용 일부를 외부에 감추는 기법
- `Coffee.java`: 속성 캡슐화 예제
- `method/`: 메소드 캡슐화 예제

### b_coffemanger

- 커피 관리 시스템의 초기 구현 버전
- 객체지향 설계의 발전 과정을 보여주는 예제
- `CoffeeManager.java`: 개별 변수를 사용한 기본 구현
- `ArrayCoffeeManager.java`: 배열을 활용한 개선 버전
- `ClassCoffeeManager.java`: 클래스를 활용한 객체지향적 구현

### coffeemanger

- 커피 관리 시스템의 고도화된 구현 버전
- 도메인 주도 설계(DDD) 개념을 적용한 구조
- 디자인 패턴을 적용한 객체지향적 설계
- 주요 패키지:
  - `domain`: 비즈니스 도메인 객체 (Coffee, Order 등)
  - `presentation`: 사용자 인터페이스 계층

## 주요 학습 내용

### 1. 캡슐화(Encapsulation)

캡슐화는 객체지향 프로그래밍의 핵심 원칙 중 하나로, 객체의 속성과 행위를 하나로 묶고 실제 구현 내용 일부를 외부에 감추어 객체의 자율성과 응집도를 높이는 기법입니다.

#### 속성 캡슐화

```java
public class Coffee {
    private String name;   // private 필드로 직접 접근 제한
    private int price;
    private int stock;

    // getter/setter를 통한 제어된 접근 제공
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    // ... 기타 getter/setter 메소드
}
```

속성 캡슐화의 장점:

- 데이터 은닉(Data Hiding)을 통한 보안 강화
- 유효성 검사를 통한 데이터 무결성 보장
- 내부 구현 변경 시 외부 영향 최소화
- 읽기 전용 또는 쓰기 전용 속성 정의 가능

#### 메소드 캡슐화

```java
public class Player {
    private String instrument;

    // 공개 인터페이스
    public void play() {
        prepare();    // 내부 구현 메소드 호출
        playing();
        stop();
        leave();
        curtainCall();
    }

    // 내부 구현 메소드 - private으로 외부 접근 차단
    private void prepare() {
        System.out.println(instrument + " 연주를 준비합니다.");
    }
    // ... 기타 private 메소드
}
```

메소드 캡슐화의 장점:

- 객체의 자율성 보장
- 복잡한 내부 로직 은닉
- 사용자는 간단한 인터페이스만 알면 됨
- 내부 구현 변경 시 외부 영향 최소화
- 메소드 실행 순서 보장

### 2. 객체지향 설계의 발전 과정

#### 2.1 절차적 접근 방식 (CoffeeManager.java)

- 개별 변수를 사용하여 데이터 관리
- 코드 중복이 많고 확장성이 떨어짐
- 커피 종류 추가 시 많은 코드 수정 필요

#### 2.2 배열을 활용한 개선 (ArrayCoffeeManager.java)

- 배열을 사용하여 데이터 관리
- 코드 중복 감소 및 확장성 향상
- 반복문을 통한 동적 처리 가능

#### 2.3 클래스를 활용한 객체지향적 구현 (ClassCoffeeManager.java)

- Coffee 클래스를 통한 데이터와 행위의 캡슐화
- 객체 배열을 사용하여 데이터 관리
- 메소드를 통한 행위 추상화

#### 2.4 도메인 주도 설계 적용 (coffeemanger 패키지)

- 비즈니스 도메인별 패키지 구조화
- 관심사 분리를 통한 코드 모듈화
- 다양한 디자인 패턴 적용

### 3. 적용된 디자인 패턴

#### 3.1 싱글톤 패턴 (Account 클래스)

- 시스템 내에서 단일 인스턴스만 존재하도록 보장
- 전역적인 접근점 제공
- 자원 공유 및 상태 일관성 유지

```java
public class Account {
    private static Account instance;
    
    public static Account getInstance() {
        if(instance == null) {
            instance = new Account();
        }
        return instance;
    }
    
    private Account() { /* 생성자 private으로 제한 */ }
}
```

#### 3.2 팩토리 메소드 패턴 (Order 클래스)

- 객체 생성 로직을 캡슐화
- 생성 과정에서의 복잡한 로직 처리
- 클라이언트 코드와 객체 생성 로직 분리

```java
public class Order {
    public static Order createOrder(Coffee coffee, int orderCnt) {
        Order order = new Order(coffee, orderCnt);
        // 생성 과정에서의 추가 로직 처리
        return order;
    }
    
    private Order(Coffee coffee, int orderCnt) { /* 생성자 private으로 제한 */ }
}
```

#### 3.3 열거형(Enum) 활용 (OrderStatus)

- 관련된 상수들을 그룹화
- 타입 안전성 보장
- 추가 메소드와 속성을 통한 기능 확장

```java
public enum OrderStatus {
    OK(200, "주문 생성 성공"),
    FAIL_SOLD_OUT(500, "재고 확보 실패로 인한 주문 취소");
    
    private int code;
    private String desc;
    
    OrderStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
```

### 4. 템플릿 메소드 패턴의 전조

현재 구현된 콘서트 클래스들은 템플릿 메소드 패턴을 적용할 수 있는 구조를 가지고 있습니다.

```java
// 세 클래스 모두 동일한 구조
public class SpringConcert {
    public void start() {
        System.out.println("Spring concert 시작합니다. ^^ ******");
        Player player = new Player("바이올린");
        player.play();
        System.out.println("=====================================");
    }
}
```

개선 방향:

1. 추상 클래스 `Concert` 생성
2. 공통 로직은 템플릿 메소드로 구현
3. 변경되는 부분은 추상 메소드로 선언하여 하위 클래스에서 구현

```java
// 추상 클래스 예시 (아직 구현되지 않음)
public abstract class Concert {
    // 템플릿 메소드
    public final void start() {
        displayStartMessage();
        Player player = createPlayer();
        player.play();
        displayEndMessage();
    }

    // 하위 클래스에서 구현할 추상 메소드
    protected abstract void displayStartMessage();
    protected abstract Player createPlayer();
}
```

## 디자인 패턴 적용 원칙

1. **단일 책임 원칙(SRP)**: 클래스는 단 하나의 책임만 가져야 함
2. **개방-폐쇄 원칙(OCP)**: 확장에는 열려 있고, 수정에는 닫혀 있어야 함
3. **리스코프 치환 원칙(LSP)**: 하위 타입은 상위 타입을 대체할 수 있어야 함
4. **인터페이스 분리 원칙(ISP)**: 클라이언트는 자신이 사용하지 않는 메소드에 의존하지 않아야 함
5. **의존 역전 원칙(DIP)**: 구체적인 것이 아닌 추상화에 의존해야 함

## 향후 학습 계획

1. 템플릿 메소드 패턴 구현
2. 팩토리 패턴 심화 학습
3. 옵저버 패턴 학습
4. 전략 패턴 학습
5. 컴포지트 패턴 학습

## 참고 자료

- GoF(Gang of Four) 디자인 패턴
- Head First Design Patterns
- Effective Java
- 도메인 주도 설계(Domain-Driven Design) - Eric Evans
