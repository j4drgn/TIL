# Java 객체지향 프로그래밍 학습 정리

## 목차

1. [클래스와 객체](#클래스와-객체)
2. [접근 제어자](#접근-제어자)
3. [생성자](#생성자)
4. [메서드](#메서드)
5. [this 키워드](#this-키워드)
6. [예제 클래스 분석](#예제-클래스-분석)

## 클래스와 객체

### 클래스의 개념

클래스는 객체를 생성하기 위한 템플릿(설계도)입니다. 객체의 상태를 나타내는 필드(멤버 변수)와 객체의 행동을 나타내는 메서드로 구성됩니다.

```java
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
```

### 객체의 개념

객체는 클래스의 인스턴스(실체)입니다. `new` 키워드를 사용하여 객체를 생성합니다.

```java
// 객체 생성
Car myCar = new Car();

// 객체의 메서드 호출
myCar.setCarInfo("11가1111", "k7", "기아");
```

## 접근 제어자

접근 제어자는 클래스, 변수, 메서드의 접근 범위를 제한합니다.

1. **private**: 같은 클래스 내에서만 접근 가능
2. **default**(접근 제어자 생략): 같은 패키지 내에서만 접근 가능
3. **protected**: 같은 패키지 및 상속받은 클래스에서 접근 가능
4. **public**: 어디서든 접근 가능

```java
// sec01/Car.java 예제
public class Car {
    private String carNo;     // private: 클래스 외부에서 직접 접근 불가능
    // ...
}
```

## 생성자

생성자는 객체가 생성될 때 초기화를 담당하는 특수한 메서드입니다.

### 생성자의 특징

- 클래스 이름과 동일한 이름을 가짐
- 반환 타입이 없음 (void도 사용하지 않음)
- 객체 생성 시 한 번만 호출됨
- 명시적 생성자가 없으면 컴파일러가 기본 생성자를 자동으로 생성

```java
// sec07/Constructor.java 예제
public Constructor(int x) {
    this.x = x;  // this는 현재 객체를 참조
}
```

### 생성자 오버로딩

다양한 방식으로 객체를 초기화할 수 있도록 여러 생성자를 정의할 수 있습니다.

```java
// sec08/Car.java 예제
// 기본 생성자
public Car() {
}

// 매개변수가 있는 생성자
public Car(String carNo, String carName, String carMaker) {
    this.carNo = carNo;
    this.carName = carName;
    this.carMaker = carMaker;
}
```

## 메서드

메서드는 객체의 행동을 정의하는 함수입니다.

### 메서드의 구성요소

- 반환 타입: 메서드가 반환하는 값의 데이터 타입
- 메서드 이름: 메서드를 호출할 때 사용하는 이름
- 매개변수 목록: 메서드에 전달되는 입력값
- 메서드 바디: 메서드의 실행 코드

```java
// sec06/Circle.java 예제
public float area() {
    return radius * radius * 3.14f;  // 원의 면적 계산 후 반환
}
```

## this 키워드

`this`는 현재 객체를 참조하는 키워드입니다.

### this의 용도

1. 멤버 변수와 매개변수 이름이 같을 때 구분하기 위해 사용
2. 같은 클래스의 다른 생성자 호출 (`this()`)
3. 현재 객체의 참조를 다른 메서드에 전달

```java
// 멤버 변수와 매개변수 구분 (sec08/Car.java)
public Car(String carNo, String carName, String carMaker) {
    this.carNo = carNo;     // this.carNo는 멤버 변수, carNo는 매개변수
    this.carName = carName;
    this.carMaker = carMaker;
}

// 다른 생성자 호출 (sec09/Book.java)
public Book() {
    this("자바스크립트", "이몽룡", 12000);  // 매개변수가 있는 생성자 호출
}
```

## 예제 클래스 분석

### sec01: Car 클래스 - 기본 클래스와 객체 생성

- 멤버 변수와 메서드의 기본 구조
- 접근 제한자를 활용한 데이터 은닉
- 객체 생성 및 메서드 호출 방법

```java
// Car.java
public class Car {
    private String carNo;
    private String carName;
    private String carMaker;
    private int carYear;
    private int carCC;

    public void setCarInfo(String no, String name, String mak, int year, int cc) {
        carNo = no;
        carName = name;
        carMaker = mak;
        carYear = year;
        carCC = cc;
    }

    public void showCarInfo() {
        System.out.println("차량 번호 : " + carNo);
        System.out.println("차종 : " + carName);
        System.out.println("제조사 : " + carMaker);
        System.out.println("연식 : " + carYear);
        System.out.println("배기량 : " + carCC);
    }
}
```

### sec02: Rectangle 클래스 - 사용자 입력 처리

- 사용자로부터 입력 받아 데이터 처리
- 멤버 변수에 대한 접근 제어자 생략 (default)

```java
// Rectangle.java
public class Rectangle {
    int width;   // 접근 제어자 생략 (default)
    int height;

    public void input() {
        Scanner input = new Scanner(System.in);
        System.out.println("가로 길이 입력 : ");
        width = input.nextInt();
        System.out.println("세로 길이 입력 : ");
        height = input.nextInt();
        input.close();
    }

    public void area() {
        System.out.println("사각형 면적 : " + width * height);
    }
}
```

### sec03: Tv 클래스 - 기본 메서드 구현

- 객체의 상태 변경 메서드 구현
- 클래스 내에 다른 클래스 정의

```java
// TvMain.java 내부에 정의된 Tv 클래스
class Tv {
    String color;
    boolean power;
    int channel;

    void power() {
        power = !power;
    }

    void channelUp() {
        ++channel;
    }

    void channelDown() {
        --channel;
    }
}
```

### sec04: Product 클래스 - 상품 정보 관리

- 복잡한 데이터 관리 구현
- 다양한 기능의 메서드 구현
- 포맷팅 클래스 활용

```java
// ProductMain.java 내부에 정의된 Product 클래스
class Product {
    private String prdName;
    private int prdPrice;
    private int prdSold;
    private int prdStock;
    private DecimalFormat df;

    // 생성자
    public Product() {
        df = new DecimalFormat("#,###");
    }

    // 매개변수가 있는 생성자
    public Product(String prdName, int prdPrice, int prdSold, int prdStock) {
        this.prdName = prdName;
        this.prdPrice = prdPrice;
        this.prdSold = prdSold;
        this.prdStock = prdStock;
        df = new DecimalFormat("#,###");
    }

    // 상품 정보 입력 메서드
    public void inputPrdInfo() {
        // 구현 내용...
    }

    // 상품 정보 출력 메서드
    public void showPrdInfo() {
        // 구현 내용...
    }

    // 매출액 계산 메서드
    public void showSalesAmount() {
        int salesAmount = prdPrice * prdSold;
        System.out.println("매출액: " + df.format(salesAmount) + "원");
    }

    // 재고액 계산 메서드
    public void showStockAmount() {
        int stockAmount = prdPrice * prdStock;
        System.out.println("재고액: " + df.format(stockAmount) + "원");
    }
}
```

### sec05: 확장된 Tv 클래스 - 복잡한 클래스 구현

- 다양한 TV 기능과 정보 관리 구현
- 조건부 메서드 실행
- 객체 배열 활용

```java
// Tv.java
public class Tv {
    // 필드 선언
    private boolean power;
    private int channel;
    private int volume;
    private String brand;
    private int size;

    // 기본 생성자
    public Tv() {
        this.power = false;
        this.channel = 1;
        this.volume = 10;
        this.brand = "삼성";
        this.size = 55;
    }

    // 매개변수가 있는 생성자
    public Tv(String brand, int size) {
        this.power = false;
        this.channel = 1;
        this.volume = 10;
        this.brand = brand;
        this.size = size;
    }

    // 전원 켜기/끄기
    public void powerOnOff() {
        // 구현 내용...
    }

    // 채널 올리기
    public void channelUp() {
        // 구현 내용...
    }

    // TV 정보 출력
    public void showInfo() {
        // 구현 내용...
    }
}
```

### sec06: Circle 클래스 - 메서드 반환값 활용

- 값을 반환하는 메서드 구현
- 메서드 내에서 다른 메서드 호출

```java
// Circle.java
public class Circle {
    int radius;

    public void setCircle(int r) {
        radius = r;
    }

    public float area() {
        this.setCircle(5);  // 메서드 내에서 다른 메서드 호출
        return radius * radius * 3.14f;  // 값 반환
    }
}
```

### sec07: Constructor 클래스 - 생성자 기본 개념

- 생성자의 기본 개념 학습
- this 키워드 활용

```java
// Constructor.java
public class Constructor {
    private int x;
    private int y;

    public Constructor(int x) {
        this.x = x;  // this 키워드로 멤버 변수 참조
    }

    public void show() {
        System.out.println("x: " + x);
    }
}
```

### sec08: Car 클래스 - 생성자 오버로딩

- 여러 생성자 구현 (오버로딩)
- 다양한 초기화 방법 제공

```java
// Car.java
public class Car {
    private String carNo;
    private String carName;
    private String carMaker;
    private int carYear;
    private int carCC;

    // 기본 생성자
    public Car() {
    }

    // 매개변수가 있는 생성자
    public Car(String carNo, String carName, String carMaker) {
        this.carNo = carNo;
        this.carName = carName;
        this.carMaker = carMaker;
    }

    // 메서드
    public void setCarInfo(String no, String name, String mak, int year, int cc) {
        // 구현 내용...
    }

    public void showCarInfo() {
        // 구현 내용...
    }
}
```

### sec09: Book 클래스 - this() 메서드 활용

- 생성자 내에서 다른 생성자 호출 (this())
- 코드 재사용성 향상

```java
// Book.java
public class Book {
    String title;
    String author;
    int price;

    public Book() {
        this("자바스크립트", "이몽룡", 12000);  // 다른 생성자 호출
    }

    public Book(String t, String au, int p) {
        title = t;
        author = au;
        price = p;
    }

    public void show() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}
```

### sec10: Reservation 클래스 - 실전 클래스 구현

- 항공권 예약 정보 관리 클래스
- 포맷팅을 활용한 출력
- 다양한 생성자 활용

```java
// Reservation.java
public class Reservation {
    private String planeId;
    private String passenger;
    private String departure;
    private String destination;
    private int price;
    private String seatNumber;

    DecimalFormat df = new DecimalFormat("#,###");

    // 기본 생성자
    public Reservation() {
        this.planeId = "KE1001";
        this.passenger = "홍길동";
        this.departure = "인천";
        this.destination = "뉴욕";
        this.price = 1600000;
        this.seatNumber = "A38";
    }

    // 매개변수가 있는 생성자
    public Reservation(String planeId, String passenger, String departure,
        String destination, int price, String seatNumber) {
        this.planeId = planeId;
        this.passenger = passenger;
        this.departure = departure;
        this.destination = destination;
        this.price = price;
        this.seatNumber = seatNumber;
    }

    // 예약 정보 출력 메서드
    public void showRsvInfo() {
        System.out.println("\n**항공권 예약 정보**");
        System.out.println("항공기 : " + planeId);
        System.out.println("예약자 : " + passenger);
        System.out.println("출발지 : " + departure);
        System.out.println("도착지 : " + destination);
        System.out.println("금액 : " + df.format(price));
        System.out.println("좌석번호 : " + seatNumber);
    }
}
```
