# 캡슐화(Encapsulation) 학습

이 디렉토리는 객체지향 프로그래밍의 핵심 원칙 중 하나인 캡슐화(Encapsulation)에 대한 학습 예제를 포함하고 있습니다.

## 캡슐화란?

캡슐화는 객체의 속성(데이터)과 행위(메서드)를 하나로 묶고, 실제 구현 내용 일부를 외부에 감추는 기법입니다. 이를 통해 객체의 자율성과 응집도를 높이고, 객체 간의 결합도를 낮출 수 있습니다.

## 디렉토리 구조

### Coffee.java

속성 캡슐화의 기본 예제입니다.

- **주요 내용**:
  - private 필드를 통한 데이터 은닉
  - getter/setter 메서드를 통한 제어된 접근
  - 접근 제어자를 활용한 캡슐화 구현

```java
public class Coffee {
  // private 필드: 외부에서 직접 접근 불가능
  private String name;
  private int price;
  private int stock;

  // getter/setter 메서드를 통한 제어된 접근
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // ... 기타 getter/setter 메서드
}
```

### method 패키지

메서드 캡슐화 및 객체의 자율성을 보여주는 예제입니다.

#### Player.java

- **주요 내용**:
  - 객체의 자율성 구현
  - 공개 인터페이스와 내부 구현 분리
  - 메서드 캡슐화를 통한 실행 순서 보장

```java
public class Player {
  private String instrument;

  // 공개 인터페이스: 외부에서 호출 가능한 메서드
  public void play() {
    prepare();    // 내부 구현 메서드 호출
    playing();
    stop();
    leave();
    curtainCall();
  }

  // 내부 구현 메서드: private으로 외부 접근 차단
  private void prepare() {
    System.out.println(instrument + " 연주를 준비합니다.");
  }

  // ... 기타 private 메서드
}
```

#### Concert 클래스들 (Spring/Summer/AutumnConcert)

- **주요 내용**:
  - 동일한 구조를 가진 클래스들
  - 템플릿 메서드 패턴 적용 가능성 보여줌
  - Player 객체의 자율성 활용

```java
public class SpringConcert {
  public void start() {
    System.out.println("Spring concert 시작합니다. ^^ ******");
    Player player = new Player("바이올린");
    player.play();  // Player 객체에게 연주 책임 위임
    System.out.println("=====================================");
  }
}
```

## 캡슐화의 장점

### 속성 캡슐화 장점

1. **데이터 은닉(Data Hiding)**: 외부에서 객체 내부 데이터에 직접 접근할 수 없어 보안 강화
2. **유효성 검사**: setter 메서드에서 데이터 유효성 검사를 수행하여 무결성 보장
3. **구현 변경 유연성**: 내부 구현 변경 시 외부 영향 최소화
4. **읽기/쓰기 제어**: 읽기 전용 또는 쓰기 전용 속성 정의 가능

### 메서드 캡슐화 장점

1. **객체의 자율성**: 객체가 자신의 책임을 스스로 수행
2. **복잡한 로직 은닉**: 내부 구현 복잡성을 감추고 간단한 인터페이스 제공
3. **사용 편의성**: 사용자는 간단한 인터페이스만 알면 됨
4. **유지보수성**: 내부 구현 변경 시 외부 영향 최소화
5. **실행 순서 보장**: 메서드 실행 순서를 객체 내부에서 제어

## 개선 방향

현재 구현된 Concert 클래스들은 동일한 구조를 가지고 있어 코드 중복이 발생합니다. 이는 템플릿 메서드 패턴을 적용하여 개선할 수 있습니다:

1. 추상 클래스 `Concert` 생성
2. 공통 로직은 템플릿 메서드로 구현
3. 변경되는 부분은 추상 메서드로 선언하여 하위 클래스에서 구현

## 학습 포인트

1. 객체의 속성과 행위를 적절히 캡슐화하는 방법
2. getter/setter를 통한 데이터 접근 제어
3. 객체의 자율성을 높이는 메서드 설계
4. 코드 중복을 발견하고 개선 방향 도출
