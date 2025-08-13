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
3. [상속](#상속)
   - [extends 키워드](#extends-키워드)
   - [super 키워드](#super-키워드)
   - [메소드 오버라이딩](#메소드-오버라이딩)
   - [접근 제한자와 상속](#접근-제한자와-상속)
4. [인터페이스](#인터페이스)
   - [인터페이스 정의와 구현](#인터페이스-정의와-구현)
   - [인터페이스의 활용](#인터페이스의-활용)
5. [제네릭과 컬렉션 프레임워크](#제네릭과-컬렉션-프레임워크)
   - [제네릭 클래스와 메소드](#제네릭-클래스와-메소드)
   - [컬렉션 프레임워크](#컬렉션-프레임워크)
6. [Java API](#java-api)
   - [String 클래스](#string-클래스)
7. [멀티스레드](#멀티스레드)
   - [스레드 생성과 실행](#스레드-생성과-실행)
   - [스레드 구현 방법](#스레드-구현-방법)
8. [예외 처리](#예외-처리)
   - [예외의 종류](#예외의-종류)
   - [try-catch-finally](#try-catch-finally)
   - [예외 처리 고급 기법](#예외-처리-고급-기법)
9. [JDBC (Java Database Connectivity)](#jdbc-java-database-connectivity)
   - [JDBC 개요](#jdbc-개요)
   - [JDBC 사용 과정](#jdbc-사용-과정)
   - [주요 클래스 및 인터페이스](#주요-클래스-및-인터페이스)

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

### 객체지향 프로그래밍 예제 코드

객체지향 프로그래밍의 다양한 예제는 [oopClass](./oopClass) 디렉토리에서 확인할 수 있습니다. 각 예제는 클래스 설계, 생성자, 메서드, 접근 제어자 등 객체지향 프로그래밍의 핵심 개념을 다루고 있습니다.

## 상속

상속은 기존 클래스의 필드와 메소드를 물려받아 새로운 클래스를 작성하는 기법입니다. 이를 통해 코드의 재사용성을 높이고 클래스 간의 계층적 관계를 구성할 수 있습니다.

### extends 키워드

Java에서는 `extends` 키워드를 사용하여 상속 관계를 표현합니다.

```java
// inheritance/sec01/Child.java 예제
public class Child extends Parent {
    private int c;

    public void setChild() {
        c = 20;
    }

    public void showChild() {
        showParent(); // 부모 클래스의 메소드 호출
        System.out.println("자식 클래스 c: " + c);
    }
}
```

### super 키워드

`super` 키워드는 부모 클래스의 멤버에 접근하거나 부모 클래스의 생성자를 호출할 때 사용합니다.

```java
// inheritance/sec04/Manager.java 예제
public Manager(String empNo, String name, String part, String position) {
    super(empNo, name, part); // 부모 클래스의 생성자 호출
    this.position = position;
}

@Override
public String toString() {
    return super.toString() + "\t |" + position; // 부모 클래스의 메소드 호출
}
```

### 메소드 오버라이딩

메소드 오버라이딩은 부모 클래스의 메소드를 자식 클래스에서 재정의하는 것입니다.

```java
// inheritance/sec06/Computer.java 예제
@Override
double areaCircle(double r) {
    System.out.println("Computer 객체의 areaCircle() 실행");
    return Math.PI * r * r; // 좀더 정밀한 계산을 위해 3.14159대신 Math.PI 상수 이용
}
```

### 접근 제한자와 상속

접근 제한자는 상속 관계에서 중요한 역할을 합니다:

- `private`: 자식 클래스에서 접근 불가
- `default`: 같은 패키지 내에서만 상속 가능
- `protected`: 다른 패키지의 자식 클래스에서도 접근 가능
- `public`: 모든 곳에서 접근 가능

```java
// inheritance/pack1/A.java, inheritance/pack1/B.java, inheritance/pack2/C.java 예제
// 다른 패키지의 클래스 접근 제한 예제
```

### 상속 예제 코드

Java 상속에 관한 다양한 예제는 [inheritance](./inheritance) 디렉토리에서 확인할 수 있습니다. 각 예제는 상속의 기본 개념, 생성자 호출, 메소드 오버라이딩, 접근 제한자 등 상속의 핵심 개념을 다루고 있습니다.

## 인터페이스

인터페이스는 객체의 사용 방법을 정의한 타입으로, 다중 상속과 유사한 기능을 제공합니다.

### 인터페이스 정의와 구현

```java
// InterfacePkg/sec05/IMemberDAO.java 예제
public interface IMemberDAO {
    void insertMember(MemberDTO dto);
    void deleteMember(String memId);
    MemberDTO selectMember(String memId);
    void updateMember(MemberDTO dto);
    ArrayList<MemberDTO> getAllMember();
    ArrayList<MemberDTO> getNameMember(String nameStr);
}

// 인터페이스 구현
public class MemberDAO implements IMemberDAO {
    @Override
    public void insertMember(MemberDTO dto) {
        // 구현 코드
    }

    // 다른 메소드 구현...
}
```

### 인터페이스의 활용

인터페이스는 다형성 구현, 표준화, 모듈 간 결합도 감소 등의 목적으로 사용됩니다. 특히 데이터 접근 계층(DAO)에서 많이 활용됩니다.

인터페이스에 관한 자세한 내용은 [InterfacePkg](./InterfacePkg) 디렉토리에서 확인할 수 있습니다.

## 제네릭과 컬렉션 프레임워크

### 제네릭 클래스와 메소드

제네릭은 클래스, 인터페이스, 메소드를 정의할 때 타입을 파라미터로 사용할 수 있게 하는 기능입니다.

```java
// genericCollection/sec02/Box.java 예제
public class Box<T> {
    private T tObj;

    public void set(T tObj) {
        this.tObj = tObj;
    }

    public T get() {
        return this.tObj;
    }
}

// 제네릭 메소드
public static <T> Box<T> boxing(T t) {
    Box<T> box = new Box<>();
    box.set(t);
    return box;
}
```

### 컬렉션 프레임워크

컬렉션 프레임워크는 데이터를 저장하고 관리하기 위한 클래스들의 집합입니다.

```java
// ArrayList 예제
ArrayList<String> list = new ArrayList<>();
list.add("Java");
list.add("Python");
list.add("C++");

// HashMap 예제
Map<String, Integer> map = new HashMap<>();
map.put("홍길동", 90);
map.put("이몽룡", 80);

// HashSet 예제
Set<String> set = new HashSet<>();
set.add("JAVA");
set.add("JDBC");
set.add("JAVA");  // 중복 객체이므로 저장되지 않음
```

제네릭과 컬렉션 프레임워크에 관한 자세한 내용은 [genericCollection](./genericCollection) 디렉토리에서 확인할 수 있습니다.

## Java API

Java API는 Java 프로그래밍 언어에서 제공하는 클래스 라이브러리로, 다양한 기능을 구현하는 데 필요한 클래스와 인터페이스를 포함하고 있습니다.

### String 클래스

String 클래스는 문자열을 다루기 위한 다양한 메서드를 제공합니다.

```java
// oopApi/StringAPI.java 예제
String title = "자바 프로그래밍";
System.out.println(title.indexOf("프로그래밍")); // 인덱스 위치 3부터 시작
System.out.println(title.replace("자바", "Java")); // 문자열 찾아 대체
System.out.println(title.substring(3)); // 3번 인덱스부터 끝까지 추출
System.out.println(title.split(" ")[0]); // 주어진 기준 문자로 분리
```

Java API에 관한 자세한 내용은 [oopApi](./oopApi) 디렉토리에서 확인할 수 있습니다.

## 멀티스레드

멀티스레드는 하나의 프로세스 내에서 여러 작업을 동시에 실행하는 기법입니다. Java에서는 Thread 클래스와 Runnable 인터페이스를 통해 멀티스레드 프로그래밍을 지원합니다.

### 스레드 생성과 실행

Java에서 스레드를 생성하고 실행하는 기본적인 방법은 다음과 같습니다:

```java
// multiThread/sec01/BeepPrint.java 예제
// 단일 스레드에서 순차적 실행
public static void main(String[] args) {
    // 비프음 출력
    for (int i = 0; i < 5; i++) {
        toolkit.beep();
        Thread.sleep(500);
    }

    // 텍스트 출력
    for (int i = 0; i < 5; i++) {
        System.out.println("띵");
        Thread.sleep(500);
    }
}
```

### 스레드 구현 방법

Java에서 스레드를 구현하는 방법은 크게 두 가지가 있습니다:

1. **Runnable 인터페이스 구현**

```java
// multiThread/sec02/BeepTask.java 예제
public class BeepTask implements Runnable {
    @Override
    public void run() {
        // 스레드가 실행할 코드
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            Thread.sleep(500);
        }
    }
}

// 스레드 생성 및 실행
Runnable beepTask = new BeepTask();
Thread thread = new Thread(beepTask);
thread.start();
```

2. **Thread 클래스 상속**

```java
// multiThread/sec03/BeepThread.java 예제
public class BeepThread extends Thread {
    @Override
    public void run() {
        // 스레드가 실행할 코드
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            Thread.sleep(500);
        }
    }
}

// 스레드 생성 및 실행
Thread thread = new BeepThread();
thread.start();
```

3. **익명 구현 객체 사용**

```java
// multiThread/sec02/BeepPrintEx2.java 예제
Thread thread = new Thread(new Runnable() {
    @Override
    public void run() {
        // 스레드가 실행할 코드
    }
});
thread.start();
```

멀티스레드에 관한 자세한 내용은 [multiThread](./multiThread) 디렉토리에서 확인할 수 있습니다.

## 예외 처리

### 예외의 종류

Java에서 예외는 크게 두 가지로 나뉩니다:

1. **일반 예외 (Checked Exception)**

   - 컴파일러가 예외 처리 코드 여부를 검사하는 예외
   - 예: IOException, ClassNotFoundException

2. **실행 예외 (Unchecked Exception, Runtime Exception)**
   - 컴파일러가 예외 처리 코드 여부를 검사하지 않는 예외
   - 예: NullPointerException, ArrayIndexOutOfBoundsException

```java
// oopException/sec01/NullPointerExceptionEx.java 예제
String data = null;
System.out.println(data.toString()); // NullPointerException 발생
```

### try-catch-finally

예외 처리는 주로 try-catch-finally 블록을 사용합니다:

```java
// oopException/sec02/TryCatchEx.java 예제
try {
    // 예외 발생 가능 코드
    int[] arr = {1, 2, 3};
    System.out.println(arr[5]); // 예외 발생
} catch (ArrayIndexOutOfBoundsException e) {
    // 예외 처리 코드
    System.out.println("배열 인덱스가 범위를 벗어났습니다.");
} finally {
    // 항상 실행되는 코드
    System.out.println("프로그램 종료");
}
```

### 예외 처리 고급 기법

```java
// oopException/sec03/CacthOrderEx.java 예제
try {
    // 예외 발생 가능 코드
} catch (NumberFormatException e) {
    // 구체적인 예외 처리
} catch (Exception e) {
    // 모든 예외 처리
}

// oopException/sec04/MultiCatch.java 예제
try {
    // 예외 발생 가능 코드
} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
    // 여러 예외를 동일하게 처리
}

// oopException/sec05/Throws.java 예제
public void method() throws ClassNotFoundException {
    // 예외를 호출한 곳으로 떠넘기기
}

// oopException/sec06/BalanceInsufficientException.java 예제
// 사용자 정의 예외 클래스 생성
public class BalanceInsufficientException extends Exception {
    // 사용자 정의 예외 구현
}
```

예외 처리에 관한 자세한 내용은 [oopException](./oopException) 디렉토리에서 확인할 수 있습니다.

## JDBC (Java Database Connectivity)

JDBC는 자바 애플리케이션에서 데이터베이스에 접속하여 SQL 문을 실행하고 결과를 처리하기 위한 Java API입니다.

### JDBC 개요

JDBC는 다양한 데이터베이스 시스템에 대해 일관된 인터페이스를 제공하여 데이터베이스 종류에 상관없이 동일한 방식으로 데이터를 처리할 수 있게 합니다.

```java
// jdbc/sec01/DBTestConn.java 예제
// JDBC 드라이버 로드
Class.forName("oracle.jdbc.driver.OracleDriver");
```

### JDBC 사용 과정

JDBC를 사용한 데이터베이스 연동은 다음과 같은 단계로 진행됩니다:

1. **JDBC 드라이버 로드**: 사용할 데이터베이스의 JDBC 드라이버를 로드합니다.
2. **데이터베이스 연결**: Connection 객체를 생성하여 데이터베이스에 연결합니다.
3. **SQL 문 실행 객체 생성**: Statement 또는 PreparedStatement 객체를 생성합니다.
4. **SQL 문 실행**: 쿼리를 실행하고 결과를 받아옵니다.
5. **결과 처리**: ResultSet 객체를 통해 조회 결과를 처리합니다.
6. **자원 해제**: 사용한 자원을 해제합니다.

```java
// jdbc/sec03/DBConnectMain.java 예제
// 데이터베이스 연결
Connection conn = dbCon.getConnection();

// Statement 객체 생성
Statement stmt = conn.createStatement();

// SQL 문 실행
String sql = "select * from book order by bookno";
ResultSet rs = stmt.executeQuery(sql);

// 결과 처리
while (rs.next()) {
    String bookNo = rs.getString("BOOKNO");
    String bookName = rs.getString("BOOKNAME");
    // 데이터 처리
}

// 자원 해제
rs.close();
stmt.close();
conn.close();
```

### 주요 클래스 및 인터페이스

- **Connection**: 데이터베이스 연결을 나타내는 인터페이스
- **DriverManager**: 데이터베이스 드라이버를 관리하고 연결을 생성하는 클래스
- **Statement**: SQL 문을 실행하기 위한 인터페이스
- **PreparedStatement**: 미리 컴파일된 SQL 문을 실행하는 인터페이스 (SQL 인젝션 방지)
- **ResultSet**: SQL 쿼리 실행 결과를 저장하는 인터페이스

```java
// jdbc/sec04/ProductMain.java 예제
// PreparedStatement 사용 예
PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM product WHERE prdno = ?");
pstmt.setString(1, "P001");
ResultSet rs = pstmt.executeQuery();
```

JDBC에 관한 자세한 내용은 [jdbc](./jdbc) 디렉토리에서 확인할 수 있습니다.
