# Java 상속(Inheritance)

이 디렉토리는 Java의 상속(Inheritance) 개념과 관련된 예제 코드를 포함하고 있습니다.

## 상속이란?

상속은 기존 클래스의 필드와 메소드를 물려받아 새로운 클래스를 작성하는 기법입니다. 이를 통해 코드의 재사용성을 높이고 클래스 간의 계층적 관계를 구성할 수 있습니다.

## 디렉토리 구조

### sec01 - 기본 상속 개념

- `Parent.java`: 부모 클래스 정의
- `Child.java`: 부모 클래스를 상속받는 자식 클래스
- `InheritanceMain.java`: 상속 관계의 클래스 사용 예제

### sec02 - 생성자 상속과 super() 호출

- `SuperConstTest.java`: 부모 클래스의 생성자 호출 방법과 super() 키워드 사용 예제

### sec03 - Object 클래스 메소드 오버라이딩

- `EmployeeTostring.java`: toString() 메소드 오버라이딩 예제
- `EmpolyeeMain.java`: 오버라이딩된 toString() 메소드 사용 예제

### sec04 - 상속과 생성자 매개변수 전달

- `Employee.java`: 기본 직원 클래스
- `Manager.java`: Employee를 상속받는 관리자 클래스
- `EmpolyeeMain.java`: 상속 관계에서 생성자 매개변수 전달 예제

### sec05 - super 레퍼런스 활용

- `SuperRefMain.java`: super 키워드를 사용하여 부모 클래스의 필드에 접근하는 예제

### sec06 - 메소드 오버라이딩

- `Calculator.java`: 기본 계산기 클래스
- `Computer.java`: Calculator를 상속받아 메소드를 오버라이딩하는 클래스
- `ComputerMain.java`: 오버라이딩된 메소드 사용 예제

### sec07 - 상속과 toString() 오버라이딩

- `Car.java`: 기본 자동차 클래스
- `Automobile.java`: Car를 상속받는 자동차 클래스
- `CarAutomobile.java`: 상속 관계에서 toString() 메소드 사용 예제

### pack1, pack2 - 패키지와 접근 제한자

- `pack1/A.java`, `pack1/B.java`: 같은 패키지 내에서의 클래스 접근
- `pack2/C.java`: 다른 패키지의 클래스 접근

## 주요 개념

### 1. extends 키워드

```java
public class Child extends Parent {
    // 자식 클래스 내용
}
```

### 2. super() 생성자 호출

```java
public Child(int x) {
    super(x); // 부모 클래스의 생성자 호출
    // 자식 클래스 초기화 코드
}
```

### 3. super 레퍼런스

```java
System.out.println("super.x : " + super.x); // 부모 클래스의 필드 x 접근
```

### 4. 메소드 오버라이딩

```java
@Override
public String toString() {
    return super.toString() + "\n추가 정보: " + extraInfo;
}
```

### 5. 접근 제한자와 상속

- private: 자식 클래스에서 접근 불가
- default: 같은 패키지 내에서만 상속 가능
- protected: 다른 패키지의 자식 클래스에서도 접근 가능
- public: 모든 곳에서 접근 가능

## 상속의 특징

1. 자바는 단일 상속만 지원 (다중 상속 불가)
2. 모든 클래스는 Object 클래스를 상속받음
3. 상속을 통해 코드 재사용성 증가
4. 메소드 오버라이딩을 통한 다형성 구현 가능
5. super 키워드로 부모 클래스의 멤버에 접근 가능
