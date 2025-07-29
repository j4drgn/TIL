# Java 배열 학습 정리

## 배열(Array)의 개념

배열은 동일한 타입의 데이터를 연속적으로 저장하는 자료구조입니다. 인덱스를 통해 각 요소에 접근할 수 있으며, 메모리에 연속적으로 할당됩니다.

## 배열의 특징

- 고정된 크기를 가집니다 (생성 후 크기 변경 불가)
- 동일한 데이터 타입만 저장 가능합니다
- 인덱스는 0부터 시작합니다
- 배열의 길이는 `배열명.length`로 구할 수 있습니다

## 배열의 선언과 초기화

### 1차원 배열

```java
// 배열 선언 방법
int[] arr;       // 권장되는 방식
int arr[];       // C/C++ 스타일 (사용 가능하지만 권장하지 않음)

// 배열 생성 방법
arr = new int[5];  // 크기가 5인 int 배열 생성

// 선언과 생성을 동시에
int[] numbers = new int[10];

// 선언과 초기화를 동시에
int[] scores = {90, 80, 85, 75, 95};
```

### 다차원 배열

```java
// 2차원 배열 선언 및 생성
int[][] matrix = new int[3][4];  // 3행 4열의 2차원 배열

// 2차원 배열 초기화
int[][] points = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
```

## 가변 배열 (Jagged Array)

Java에서는 각 행마다 열의 개수가 다른 가변 배열을 지원합니다.

### ArrayIrregular.java 예제 분석

```java
// 가변 배열 선언 및 초기화
int a[][] = new int[4][];
a[0] = new int[1];  // 첫 번째 행은 1열
a[1] = new int[2];  // 두 번째 행은 2열
a[2] = new int[3];  // 세 번째 행은 3열
a[3] = new int[4];  // 네 번째 행은 4열

// 초기값과 함께 가변 배열 선언
char b[][] = {{'a'}, {'b', 'c'}, {'d', 'e', 'f'}};

// 문자열 가변 배열
String student[][] = {
    {"홍길동", "학생"},
    {"성춘향", "3학년", "영문학과"}
};

// 가변 배열 값 할당
for (int i = 0; i < a.length; i++) {
    for (int j = 0; j < a[i].length; j++) {
        a[i][j] = j;
    }
}
```

## 배열 활용 예제

### 로또 번호 생성 프로그램 (ArrayExer3.java)

```java
import java.util.Random;

public class ArrayExer3 {

  public static void main(String[] args) {
    // 로또 번호 생성 프로그램
    // 1~45 숫자 중 중복되지 않는 6개의 숫자 출력

    int[] lotto = new int[6];
    Random random = new Random();

    for (int i = 0; i < lotto.length; i++) {
      lotto[i] = random.nextInt(45) + 1;

      // 중복 검사
      for (int j = 0; j < i; j++) {
        if (lotto[i] == lotto[j]) {
          i--;  // 현재 인덱스를 다시 처리하기 위해 감소
          break;
        }
      }
    }

    // 결과 출력
    System.out.println("로또 번호 생성 결과:");
    for (int i = 0; i < lotto.length; i++) {
      System.out.print(lotto[i] + " ");
    }
    System.out.println();
  }
}
```

### 코드 분석

1. 크기가 6인 정수형 배열 `lotto`를 생성합니다.
2. `Random` 클래스를 사용하여 1~45 사이의 난수를 생성합니다.
3. 중첩 반복문을 사용하여 중복된 번호가 있는지 확인합니다.
4. 중복된 번호가 발견되면 인덱스를 감소시켜 해당 위치에 다시 난수를 생성합니다.
5. 생성된 로또 번호를 출력합니다.

## 배열 관련 주요 알고리즘

### 1. 배열 요소 합계 구하기

```java
int sum = 0;
for (int i = 0; i < arr.length; i++) {
    sum += arr[i];
}
```

### 2. 배열 최대/최소값 찾기

```java
int max = arr[0];
int min = arr[0];
for (int i = 1; i < arr.length; i++) {
    if (arr[i] > max) max = arr[i];
    if (arr[i] < min) min = arr[i];
}
```

### 3. 배열 요소 검색

```java
boolean found = false;
for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) {
        found = true;
        break;
    }
}
```

### 4. 배열 정렬 (버블 정렬 예시)

```java
for (int i = 0; i < arr.length - 1; i++) {
    for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
        }
    }
}
```

## 향상된 for문 (Enhanced for loop)

Java 5부터 도입된 향상된 for문을 사용하면 배열이나 컬렉션의 요소를 더 간단하게 순회할 수 있습니다.

```java
int[] numbers = {1, 2, 3, 4, 5};
for (int num : numbers) {
    System.out.println(num);
}
```

## 배열 관련 유틸리티 클래스

Java의 `java.util.Arrays` 클래스는 배열을 다루는 다양한 메서드를 제공합니다.

```java
import java.util.Arrays;

// 배열 정렬
Arrays.sort(arr);

// 배열 요소 검색 (정렬된 배열에서)
int index = Arrays.binarySearch(arr, target);

// 배열 복사
int[] copied = Arrays.copyOf(arr, arr.length);

// 배열 내용 문자열로 출력
System.out.println(Arrays.toString(arr));

// 배열 비교
boolean equal = Arrays.equals(arr1, arr2);
```
