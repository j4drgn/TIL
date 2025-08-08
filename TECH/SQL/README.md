# SQL 학습 내용

이 디렉토리는 SQL 학습 관련 파일들을 포함하고 있습니다.

## 파일 구성

### 1. DDL(Data Definition Language) 관련 파일

- **[01_DDL_create.sql](./01_DDL_create.sql)**: 테이블 생성 관련 SQL 문법

  - CREATE TABLE 구문
  - 기본키(PRIMARY KEY) 설정 방법
  - 외래키(FOREIGN KEY) 설정 방법
  - CHECK, DEFAULT 제약조건 설정

- **[02_DDL_alter.sql](./02_DDL_alter.sql)**: 테이블 구조 변경 관련 SQL 문법

  - ALTER TABLE ADD: 열 추가
  - ALTER TABLE MODIFY: 열 데이터 타입/제약조건 변경
  - ALTER TABLE RENAME COLUMN: 열 이름 변경
  - ALTER TABLE DROP COLUMN: 열 삭제
  - 제약조건 추가/삭제
  - 테이블 삭제 (DROP TABLE)

### 2. DML(Data Manipulation Language) 관련 파일

- **[03_DML_insert.sql](./03_DML_insert.sql)**: 데이터 입력 관련 SQL 문법

  - INSERT INTO 구문
  - INSERT ALL 구문
  - 시퀀스(Sequence) 생성 및 활용

- **[04_DML_updateDelete.sql](./04_DML_updateDelete.sql)**: 데이터 수정 및 삭제 관련 SQL 문법

  - UPDATE 구문: 특정 열의 값 수정
  - DELETE 구문: 테이블의 행 삭제

- **[05_DML_select.sql](./05_DML_select.sql)**: 데이터 조회 관련 SQL 문법
  - SELECT 구문 기본 사용법
  - WHERE 절을 이용한 조건 검색
  - ORDER BY를 이용한 정렬
  - 집계 함수(SUM, AVG, COUNT, MAX, MIN) 사용법

### 3. 종합 예제 파일

- **[SQL_Complete_Examples.sql](./SQL_Complete_Examples.sql)**: SQL 종합 연습 문제 및 예제
  - ALTER 문 연습 문제
  - INSERT 문 연습 문제
  - UPDATE/DELETE 문 연습 문제
  - 테이블 관계 설정 및 데이터 조작 종합 예제
  - SELECT 문 다양한 조건 활용 예제

## 학습 내용 요약

### DDL(Data Definition Language)

데이터베이스 구조를 정의하는 언어로, 테이블 생성(CREATE), 변경(ALTER), 삭제(DROP) 등의 명령어가 포함됩니다.

### DML(Data Manipulation Language)

데이터를 조작하는 언어로, 데이터 입력(INSERT), 수정(UPDATE), 삭제(DELETE), 조회(SELECT) 등의 명령어가 포함됩니다.

#### SELECT 문 주요 기능

- WHERE 절: 조건에 맞는 데이터 필터링
- ORDER BY: 결과 정렬
- 집계 함수: 데이터 집계 및 통계 처리
- LIKE: 패턴 매칭을 통한 검색

### 제약조건

- PRIMARY KEY: 기본키, 테이블에서 각 행을 고유하게 식별
- FOREIGN KEY: 외래키, 다른 테이블의 기본키를 참조
- CHECK: 입력 데이터의 유효성 검사
- DEFAULT: 기본값 설정
- NOT NULL: NULL 값 입력 금지

### 시퀀스(Sequence)

자동으로 증가하는 숫자를 생성하는 데이터베이스 객체로, 주로 기본키 값을 자동으로 생성할 때 사용합니다.
