# JDBC (Java Database Connectivity) 학습

이 디렉토리는 Java와 데이터베이스를 연결하는 JDBC 관련 학습 내용을 포함하고 있습니다.

## JDBC란?

JDBC(Java Database Connectivity)는 자바 프로그램이 데이터베이스에 접근하여 데이터를 조회, 삽입, 수정, 삭제할 수 있도록 하는 자바 API입니다. JDBC는 다양한 데이터베이스 시스템에 대해 일관된 인터페이스를 제공합니다.

## 디렉토리 구조

- **sec01**: 기본 데이터베이스 연결 테스트
- **sec02**: 데이터베이스 연결 클래스 분리
- **sec03**: 데이터 조회(SELECT) 기능 구현
- **sec04**: 상품 정보 조회 및 도서 정보 CRUD 예제 (코드 문서화)
- **sec05**: DML 작업 구현 (INSERT, UPDATE, DELETE)
- **sec06**: 학생 정보 관리 시스템 (DAO/DTO 패턴, 인터페이스 활용)

## JDBC 사용 과정

1. **JDBC 드라이버 로드**

   ```java
   Class.forName("oracle.jdbc.driver.OracleDriver");
   ```

2. **데이터베이스 연결**

   ```java
   String url = "jdbc:oracle:thin:@localhost:1521:xe";
   String user = "사용자명";
   String pwd = "비밀번호";
   Connection conn = DriverManager.getConnection(url, user, pwd);
   ```

3. **SQL 문 실행을 위한 Statement 객체 생성**

   ```java
   Statement stmt = conn.createStatement();
   ```

4. **SQL 문 실행**

   - 조회(SELECT) 문 실행:
     ```java
     ResultSet rs = stmt.executeQuery("SELECT * FROM 테이블명");
     ```
   - 수정(INSERT, UPDATE, DELETE) 문 실행:
     ```java
     int result = stmt.executeUpdate("INSERT INTO 테이블명 VALUES(...)");
     ```

5. **결과 처리**

   ```java
   while(rs.next()) {
       String column1 = rs.getString("컬럼명");
       int column2 = rs.getInt("컬럼명");
       // 데이터 처리
   }
   ```

6. **자원 해제**
   ```java
   rs.close();
   stmt.close();
   conn.close();
   ```

## 주요 클래스 및 인터페이스

- **Connection**: 데이터베이스 연결을 나타내는 인터페이스
- **DriverManager**: 데이터베이스 드라이버를 관리하고 데이터베이스 연결을 생성하는 클래스
- **Statement**: SQL 문을 실행하기 위한 인터페이스
- **PreparedStatement**: 미리 컴파일된 SQL 문을 실행하기 위한 인터페이스 (SQL 인젝션 방지)
- **ResultSet**: SQL 쿼리 실행 결과를 저장하는 인터페이스

## 예제 코드 설명

### 1. 기본 데이터베이스 연결 테스트 (sec01)

- **DBTestConn.java**: 데이터베이스 연결을 테스트하는 기본 예제
  - JDBC 드라이버 로드 및 데이터베이스 연결 확인

### 2. 데이터베이스 연결 클래스 분리 (sec02)

- **DBConnect.java**: 데이터베이스 연결 기능을 별도 클래스로 분리
- **DBConnMain.java**: 분리된 연결 클래스를 사용하는 메인 클래스

### 3. 데이터 조회 기능 구현 (sec03)

- **DBConnect.java**: 데이터베이스 연결 클래스
- **DBConnectMain.java**: 도서 정보를 조회하는 예제
  - Statement 객체를 사용하여 SELECT 쿼리 실행
  - ResultSet을 통한 결과 처리 및 출력

### 4. 상품 정보 조회 및 도서 정보 CRUD 예제 (sec04)

- **PrdDBConn.java**: 상품 데이터베이스 연결 클래스 (문서화 적용)
- **ProductMain.java**: 상품 정보를 조회하는 메인 클래스
  - 코드 문서화(JavaDoc) 적용
  - 예외 처리 및 자원 해제 코드 개선
- **BookDTO.java**: 도서 정보를 담는 데이터 전송 객체
  - 도서 관련 속성 정의 및 Getter/Setter 구현
- **BookDAO.java**: 도서 데이터 액세스 객체
  - CRUD 기능 구현 (도서 등록, 조회, 수정, 삭제)
  - PreparedStatement를 활용한 SQL 인젝션 방지
- **BookMain.java**: 도서 관리 프로그램 메인 클래스
  - 도서 정보에 대한 CRUD 작업 테스트

### 5. DML 작업 구현 (sec05)

- **DBConnect.java**: 데이터베이스 연결 및 자원 관리 클래스
  - 다양한 자원 해제 메소드 오버로딩 구현
- **insertBookMain.java**: PreparedStatement를 활용한 도서 정보 등록
- **insertInputBookMain.java**: 사용자 입력을 통한 도서 정보 등록
- **SelectMain.java**: 도서 정보 조회 기능
- **UpdateMain.java**: 도서 정보 수정 기능
- **DeleteMain.java**: 도서 정보 삭제 기능

### 6. 학생 정보 관리 시스템 (sec06)

- **DBConnect.java**: 데이터베이스 연결 및 자원 관리 클래스 (개선 버전)
- **IStudentDAO.java**: 학생 정보 관리를 위한 인터페이스
  - 표준화된 CRUD 메소드 정의
- **StudentDTO.java**: 학생 정보를 담는 데이터 전송 객체
- **StudentDAO.java**: 학생 데이터 액세스 객체 (인터페이스 구현)
  - 기본 CRUD 기능 구현
  - 학과별 학생 검색 기능 추가
- **ReadWrite.java**: 학생 정보 입출력 기능 클래스
- **StudentMainMenu.java**: 학생 관리 프로그램 메인 클래스
  - 메뉴 기반 사용자 인터페이스 구현

## 주의사항

1. 데이터베이스 연결 후에는 반드시 자원을 해제해야 합니다.
2. SQL 인젝션 공격을 방지하기 위해 PreparedStatement 사용을 권장합니다.
3. 예외 처리를 통해 데이터베이스 연결 및 쿼리 실행 중 발생할 수 있는 오류에 대응해야 합니다.
