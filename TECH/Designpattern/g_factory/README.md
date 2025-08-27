# 팩토리 패턴 (Factory Pattern)

이 디렉토리는 팩토리 패턴을 구현한 예제 코드를 포함하고 있습니다.

## 팩토리 패턴이란?

팩토리 패턴은 객체 생성 로직을 캡슐화하여 클라이언트 코드와 분리하는 생성 패턴입니다. 이 패턴을 사용하면 객체 생성의 유연성을 높이고 코드 결합도를 낮출 수 있습니다.

## 주요 구성 요소

### 1. 제품 인터페이스 (SMTPConnector.java)

모든 제품 클래스가 구현해야 하는 공통 인터페이스입니다.

```java
public interface SMTPConnector {
    void connect();
}
```

### 2. 구체적인 제품 클래스 (GoogleMail.java, NaverMail.java, DaumMail.java)

제품 인터페이스를 구현하는 구체적인 클래스들입니다.

```java
public class GoogleMail implements SMTPConnector {
    private EmailConfig config;

    public GoogleMail(EmailConfig config) {
        super();
        this.config = config;
    }

    @Override
    public void connect() {
        System.out.println(config.url);
        System.out.println("구글 메일서버에 연결되었습니다.");
    }
}
```

### 3. 팩토리 클래스 (ConnectorFactory.java)

객체 생성 로직을 캡슐화하는 클래스입니다.

```java
public class ConnectorFactory {
    public static SMTPConnector create(EmailConfig config) {
        switch (config) {
        case DAUM: {
            return new DaumMail(config);
        }
        case NAVER: {
            return new NaverMail(config);
        }
        case GOOGLE: {
            return new GoogleMail(config);
        }
        default:
            throw new IllegalArgumentException("Unexpected value: " + config);
        }
    }
}
```

### 4. 설정 정보 (EmailConfig.java)

제품 생성에 필요한 설정 정보를 담은 열거형입니다.

```java
public enum EmailConfig {
    NAVER("smtp.naver.com", "mc", "123abc", 5000),
    DAUM("smtp.daum.com", "mc", "123abc", 5000),
    GOOGLE("smtp.google.com", "mc", "123abc", 5000);

    public final String url;
    public final String id;
    public final String password;
    public final int timeout;

    private EmailConfig(String url, String id, String password, int timeout) {
        this.url = url;
        this.id = id;
        this.password = password;
        this.timeout = timeout;
    }
}
```

### 5. 클라이언트 코드 (Run.java)

팩토리를 사용하여 객체를 생성하고 사용하는 클라이언트 코드입니다.

```java
public class Run {
    public static void main(String[] args) {
        SMTPConnector connector = ConnectorFactory.create(EmailConfig.GOOGLE);
        connector.connect();
    }
}
```

## 팩토리 패턴의 장점

1. **결합도 감소**:

   - 객체 생성 코드와 사용 코드의 결합도를 낮춥니다.
   - 클라이언트 코드는 구체적인 구현 클래스를 알 필요 없이 인터페이스만 사용합니다.

2. **캡슐화**:

   - 객체 생성 로직을 캡슐화하여 클라이언트 코드를 간결하게 유지합니다.
   - 객체 생성의 복잡성을 숨깁니다.

3. **유지보수성**:

   - 새로운 제품 클래스 추가 시 팩토리 클래스만 수정하면 됩니다.
   - 클라이언트 코드는 변경할 필요가 없습니다.

4. **일관된 객체 생성**:
   - 객체 생성 과정에서 일관된 방식으로 전처리/후처리를 적용할 수 있습니다.
   - 객체 생성 로직을 중앙화하여 관리할 수 있습니다.

## 팩토리 패턴의 종류

### 1. 단순 팩토리(Simple Factory)

이 예제에서 구현한 방식으로, 하나의 팩토리 클래스가 모든 객체 생성을 담당합니다.

### 2. 팩토리 메서드(Factory Method)

객체 생성을 서브클래스에 위임하는 방식입니다. 추상 팩토리 클래스를 정의하고 서브클래스에서 구체적인 객체 생성 메서드를 구현합니다.

```java
// 추상 팩토리 클래스
public abstract class MailConnectorFactory {
    public abstract SMTPConnector createConnector();
}

// 구체적인 팩토리 클래스
public class GoogleMailFactory extends MailConnectorFactory {
    @Override
    public SMTPConnector createConnector() {
        return new GoogleMail(EmailConfig.GOOGLE);
    }
}
```

### 3. 추상 팩토리(Abstract Factory)

관련된 객체들의 집합을 생성하는 인터페이스를 제공하는 방식입니다. 여러 종류의 관련 객체를 함께 생성할 때 유용합니다.

## 팩토리 패턴 사용 시기

1. 객체 생성 로직이 복잡할 때
2. 객체 생성 과정을 클라이언트 코드와 분리하고 싶을 때
3. 객체 생성 시 일관된 전처리/후처리가 필요할 때
4. 시스템이 사용할 객체의 종류를 미리 알 수 없거나 확장 가능해야 할 때

## 학습 포인트

1. 팩토리 패턴의 구조와 구현 방법
2. 객체 생성 로직을 캡슐화하는 방법
3. 인터페이스를 활용한 결합도 낮은 코드 설계
4. 열거형을 활용한 설정 정보 관리
