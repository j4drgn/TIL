# Java 예외 처리 (Exception Handling)

자바에서 예외(Exception)는 프로그램 실행 중에 발생할 수 있는 오류 상황을 의미합니다. 예외 처리는 이러한 오류 상황을 적절히 처리하여 프로그램이 비정상적으로 종료되지 않도록 하는 기법입니다.

## 예외의 종류

### 1. 일반 예외 (Checked Exception)
- 컴파일러가 예외 처리 코드 여부를 검사하는 예외
- 예외 처리 코드가 없으면 컴파일 오류 발생
- 예: IOException, ClassNotFoundException

### 2. 실행 예외 (Unchecked Exception, Runtime Exception)
- 컴파일러가 예외 처리 코드 여부를 검사하지 않는 예외
- 개발자의 경험에 의해 예외 처리 코드 작성
- 예: NullPointerException, ArrayIndexOutOfBoundsException, ClassCastException

## 예제 구성

### sec01 - 실행 예외 (Runtime Exception)

- [NullPointerExceptionEx.java](./sec01/NullPointerExceptionEx.java): null 참조 변수를 통해 메소드를 호출할 때 발생하는 예외
- [ClassCastExceptionEx.java](./sec01/ClassCastExceptionEx.java): 타입 변환이 불가능한 경우 발생하는 예외

### sec02 - 예외 처리 (Exception Handling)

- [TryCatchEx.java](./sec02/TryCatchEx.java): try-catch 블록을 사용한 예외 처리 예제

## 예외 처리 방법

### 1. try-catch-finally 블록

```java
try {
    // 예외 발생 가능 코드
} catch (Exception1 e) {
    // Exception1 예외 처리
} catch (Exception2 e) {
    // Exception2 예외 처리
} finally {
    // 항상 실행되는 코드
}
```

### 2. throws 키워드

```java
public void method() throws Exception {
    // 예외 발생 코드
}
```

## 주요 예외 클래스

1. **NullPointerException**: null 참조 변수로 객체 접근 시도 시 발생
2. **ArrayIndexOutOfBoundsException**: 배열의 인덱스 범위를 초과할 때 발생
3. **ClassCastException**: 타입 변환이 불가능한 경우 발생
4. **NumberFormatException**: 문자열을 숫자로 변환할 수 없을 때 발생
5. **ClassNotFoundException**: 클래스를 찾을 수 없을 때 발생

## 예외 처리의 이점

1. 프로그램의 비정상 종료 방지
2. 오류 원인 파악 용이
3. 안정적인 프로그램 구현
4. 예외 상황에 대한 적절한 대응 가능