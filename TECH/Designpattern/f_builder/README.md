# 빌더 패턴 (Builder Pattern)

이 디렉토리는 빌더 패턴을 구현한 예제 코드를 포함하고 있습니다.

## 빌더 패턴이란?

빌더 패턴은 복잡한 객체의 생성 과정과 표현 방법을 분리하여 다양한 구성의 인스턴스를 생성할 수 있게 해주는 생성 패턴입니다. 이 패턴은 특히 생성자 매개변수가 많을 때 유용하며, 객체 생성 코드의 가독성을 높이고 불변 객체를 쉽게 생성할 수 있게 해줍니다.

## 주요 구성 요소

### Book.java

빌더 패턴을 적용한 Book 클래스입니다.

```java
public class Book {
    // 불변 객체를 위한 private 필드
    private String title;
    private String author;
    private int page;
    private int price;

    // private 생성자 - 외부에서 직접 생성 불가능
    private Book(Builder builder) {
        title = builder.title;
        author = builder.author;
        page = builder.page;
        price = builder.price;
    }

    // 내부 정적 클래스로 Builder 구현
    public static class Builder {
        // Book과 동일한 필드를 가짐
        private String title;
        private String author;
        private int page;
        private int price;

        // 메서드 체이닝을 위해 this 반환
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        // 기타 setter 메서드들...

        // 최종적으로 Book 객체 생성 및 반환
        public Book build() {
            return new Book(this);
        }
    }
}
```

### Run.java

빌더 패턴을 사용하여 Book 객체를 생성하는 예제 클래스입니다.

```java
public class Run {
    public static void main(String[] args) {
        // 빌더 패턴을 사용한 Book 객체 생성
        Book book = new Book.Builder()
                .title("해리포터")
                .author("포터해리")
                .price(90000)
                .page(300)
                .build();
        System.out.println(book);
    }
}
```

## 빌더 패턴의 장점

1. **가독성 향상**:

   - 매개변수가 많은 생성자보다 어떤 값이 어디에 설정되는지 명확하게 알 수 있습니다.
   - 메서드 이름이 설정하는 속성을 명확히 나타냅니다.

2. **유연한 객체 생성**:

   - 필요한 값만 선택적으로 설정할 수 있습니다.
   - 매개변수 순서에 구애받지 않습니다.

3. **불변 객체 생성**:

   - 객체 생성 후 상태를 변경할 수 없는 불변 객체를 쉽게 만들 수 있습니다.
   - setter 메서드 없이도 다양한 속성을 설정할 수 있습니다.

4. **매개변수 검증**:
   - 빌더 메서드에서 유효성 검사를 수행할 수 있습니다.
   - 객체 생성 전에 모든 필수 속성이 설정되었는지 확인할 수 있습니다.

## 다른 객체 생성 패턴과의 비교

### 자바빈 패턴

기본 생성자로 객체를 생성한 후 setter로 값을 설정하는 방식입니다.

```java
Book book = new Book();
book.setTitle("해리포터");
book.setAuthor("포터해리");
book.setPrice(90000);
book.setPage(300);
```

- **장점**: 가독성이 좋음
- **단점**: 객체 생성 과정이 여러 단계로 분리되어 일관성이 없을 수 있고, 불변 객체를 만들 수 없음

### 점층적 생성자 패턴

여러 개의 오버로딩된 생성자를 제공하는 방식입니다.

```java
Book book = new Book("해리포터", "포터해리", 300, 90000);
```

- **장점**: 불변 객체를 만들 수 있음
- **단점**: 매개변수가 많아지면 가독성이 떨어지고 관리가 어려움

## 빌더 패턴 사용 시기

1. 생성자 매개변수가 많을 때 (4개 이상)
2. 불변 객체를 만들어야 할 때
3. 선택적 매개변수가 많을 때
4. 객체 생성 코드의 가독성이 중요할 때

## 학습 포인트

1. 빌더 패턴의 구조와 구현 방법
2. 메서드 체이닝을 활용한 가독성 높은 코드 작성
3. 불변 객체 생성 기법
4. 내부 정적 클래스를 활용한 디자인 패턴 구현
