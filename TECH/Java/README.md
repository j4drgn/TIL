# Java 학습 정리

## 목차

1. [배열](#배열)
   - [일반 배열](#일반-배열)
   - [다차원 배열](#다차원-배열)
   - [가변 배열](#가변-배열)
2. [객체지향 프로그래밍](#객체지향-프로그래밍)
   - [클래스와 객체](#클래스와-객체)
   - [접근 제어자](#접근-제어자)
   - [생성자](#생성자)
   - [메서드](#메서드)
   - [this 키워드](#this-키워드)
   - [static 멤버](#static-멤버)
   - [final 키워드](#final-키워드)
   - [싱글톤 패턴](#싱글톤-패턴)
   - [캡슐화](#캡슐화)

## 배열

### 일반 배열

배열은 동일한 타입의 데이터를 연속적으로 저장하는 자료구조입니다.

```java
// 배열 선언 및 초기화
int[] arr = new int[5];  // 크기가 5인 정수형 배열 선언
int[] numbers = {1, 2, 3, 4, 5};  // 초기값과 함께 배열 선언
```

### 다차원 배열

다차원 배열은 배열의 요소로 배열을 가지는 구조입니다.

```java
// 2차원 배열 선언 및 초기화
int[][] matrix = new int[3][4];  // 3행 4열의 2차원 배열
int[][] points = {{1, 2}, {3, 4}, {5, 6}};  // 초기값과 함께 선언
```

### 가변 배열

Java에서는 각 행마다 열의 개수가 다른 가변 배열을 지원합니다.

```java
// ArrayIrregular.java 예제
int a[][] = new int[4][];
a[0] = new int[1];
a[1] = new int[2];
a[2] = new int[3];
a[3] = new int[4];

char b[][] = {{'a'}, {'b', 'c'}, {'d', 'e', 'f'}};
```

### 배열 활용 예제

로또 번호 생성 프로그램 예제:

```java
// ArrayExer3.java
int[] lotto = new int[6];
Random random = new Random();

for (int i = 0; i < lotto.length; i++) {
    lotto[i] = random.nextInt(45) + 1;

    // 중복 검사
    for (int j = 0; j < i; j++) {
        if (lotto[i] == lotto[j]) {
            i--;
            break;
        }
    }
}
```

## 객체지향 프로그래밍

### 클래스와 객체

클래스는 객체를 만들기 위한 템플릿이며, 객체는 클래스의 인스턴스입니다.

```java
// Car 클래스 정의 (oopClass/sec01)
public class Car {
    // 멤버 변수(필드)
    private String carNo;     // 차량 번호
    private String carName;   // 차종
    private String carMaker;  // 제조사

    // 멤버 메서드
    public void setCarInfo(String no, String name, String maker) {
        carNo = no;
        carName = name;
        carMaker = maker;
    }
}

// 객체 생성 및 사용
Car myCar = new Car();
myCar.setCarInfo("11가1111", "k7", "기아");
```

### 접근 제어자

접근 제어자는 클래스, 변수, 메서드의 접근 범위를 제한합니다.

- `private`: 같은 클래스 내에서만 접근 가능
- `default`: 같은 패키지 내에서만 접근 가능
- `protected`: 같은 패키지 및 상속받은 클래스에서 접근 가능
- `public`: 어디서든 접근 가능

```java
// oopClass/sec01/Car.java 예제
private String carNo;     // private: 클래스 외부에서 직접 접근 불가능
```

### 생성자

생성자는 객체가 생성될 때 초기화를 담당하는 특수한 메서드입니다.

```java
// oopClass/sec07/Constructor.java 예제
public Constructor(int x) {
    this.x = x;  // this는 현재 객체를 참조
}

// 생성자 오버로딩 (oopClass/sec08/Car.java 예제)
public Car() {
    // 기본 생성자
}

public Car(String carNo, String carName, String carMaker) {
    this.carNo = carNo;
    this.carName = carName;
    this.carMaker = carMaker;
}
```

### 메서드

메서드는 객체의 행동을 정의합니다.

```java
// oopClass/sec05/Tv.java 예제
public void powerOnOff() {
    this.power = !this.power;
    if(this.power) {
        System.out.println("TV가 켜졌습니다.");
    } else {
        System.out.println("TV가 꺼졌습니다.");
    }
}
```

### this 키워드

`this`는 현재 객체를 참조하는 키워드입니다.

```java
// oopClass/sec09/Book.java 예제
public Book() {
    // this()를 사용하여 다른 생성자 호출
    this("자바스크립트", "이몽룡", 12000);
}

public Book(String t, String au, int p) {
    title = t;
    author = au;
    price = p;
}
```

### static 멤버

`static` 키워드는 클래스 레벨의 멤버를 정의할 때 사용됩니다. static 멤버는 객체 생성 없이 클래스 이름으로 직접 접근할 수 있습니다.

```java
// oopClass/sec11/StaticTest.java 예제
public class StaticTest {
    // 인스턴스 멤버
    int a;
    void f1(int x) { a = x; }

    // static 멤버
    static int b;
    static void s1(int x) { /* static 메소드는 인스턴스 멤버 사용 불가 */ }
    static void s3(int x) { b = x; } // static 메소드에서 static 필드 사용 가능
}
```

static 블록은 클래스가 로딩될 때 자동으로 실행되는 초기화 블록입니다.

```java
// oopClass/sec13/StaticBlock.java 예제
static {
    // 클래스 로딩 시 실행되는 코드
    staticA = 10;
    staticMethod();
}
```

### final 키워드

`final` 키워드는 변수, 메서드, 클래스를 상수화할 때 사용됩니다.

```java
// oopClass/sec15/Person.java 예제
final String nation = "Korea"; // 상수로 초기화
final String ssn;  // 생성자에서 초기화할 수 있는 final 필드

public Person(String ssn) {
    this.ssn = ssn; // 생성자에서 초기화
}
```

static final을 함께 사용하면 클래스 상수를 정의할 수 있습니다.

```java
// oopClass/sec16/Earth.java 예제
static final double EARTH_RADIUS = 6400;
static final double EARTH_SURFACE_AREA;

static {
    EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
}
```

### 싱글톤 패턴

싱글톤 패턴은 클래스의 인스턴스가 하나만 생성되도록 보장하는 디자인 패턴입니다.

```java
// oopClass/sec14/Singleton.java 예제
public class Singleton {
    // private static 필드로 자기 자신의 인스턴스를 생성
    private static Singleton singleton = new Singleton();

    // private 생성자로 외부에서 인스턴스 생성 방지
    private Singleton() {}

    // public static 메서드로 유일한 인스턴스 접근 제공
    static Singleton getInstance() {
        return singleton;
    }
}
```

### 캡슐화

캡슐화는 데이터와 해당 데이터를 처리하는 메서드를 하나로 묶고, 외부에서의 접근을 제한하는 것입니다. Getter와 Setter 메서드를 통해 구현합니다.

```java
// oopClass/sec17/Car.java 예제
public class Car {
    // private 필드
    private int speed;
    private boolean stop;

    // Getter 메서드
    public int getSpeed() {
        return speed;
    }

    // Setter 메서드
    public void setSpeed(int speed) {
        if (speed < 0) {
            this.speed = 0;
        } else {
            this.speed = speed;
        }
    }
}
```

### 객체지향 프로그래밍 예제 코드

객체지향 프로그래밍의 다양한 예제는 [oopClass](./oopClass) 디렉토리에서 확인할 수 있습니다. 각 예제는 클래스 설계, 생성자, 메서드, 접근 제어자 등 객체지향 프로그래밍의 핵심 개념을 다루고 있습니다.
