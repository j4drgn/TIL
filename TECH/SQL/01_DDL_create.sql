--테이블 생성
--동일DB(동일계정)에 동일명 테이블이 있으면 안됨.
--기본키 제약조건
-- 1. 속성 설정 시 기본키 지정
CREATE TABLE product
(
    prdNo      VARCHAR2(10) NOT NULL PRIMARY KEY,
    prdNAME    VARCHAR2(30) NOT NULL,
    prdPRICE   NUMBER(8),
    prdCOMPANY VARCHAR2(30)
);

--2. 기본키 따로 설정 : primary key(기본키 필드명)
CREATE TABLE product
(
    prdNo      VARCHAR2(10) NOT NULL,
    prdNAME    VARCHAR2(30) NOT NULL,
    prdPRICE   NUMBER(8),
    prdCOMPANY VARCHAR2(30),
    PRIMARY KEY (prdNo)
);

--3. 제약 이름과 같이 설정 : 제약 변경이나 삭제 시 유용함
CREATE TABLE product
(
    prdNo      VARCHAR2(10) NOT NULL
        CONSTRAINT PK_product_prdNo PRIMARY KEY,
    prdNAME    VARCHAR2(30) NOT NULL,
    prdPRICE   NUMBER(8),
    prdCOMPANY VARCHAR2(30)
);

--4. 따로 설정 제약명 추가
CREATE TABLE product2
(
    prdNo      VARCHAR2(10) NOT NULL,
    prdNAME    VARCHAR2(30) NOT NULL,
    prdPRICE   NUMBER(8),
    prdCOMPANY VARCHAR2(30),
    CONSTRAINT PK_product_prdNo PRIMARY KEY (prdNo)
);

----------------------------------------
/* 출판사 테이블 생성(출판사 번호, 출판사명)
-- 출판사 테이블 먼저 생성하고 도서 테이블 생성(외래키 참조필드)
-- 외래키 필드에 입력되는 값은 참조테이블의 기본키로서 값과 동일해야 함
-- 외래키 필드의 도메인과 참조테이블의 기본키 도메인은 동일해야 함
-- 테이블 삭제시에는 생성과 반대로 참조하는 book을 먼저 삭제하고 참조되는 publisher를 삭제
   /* 출판사 테이블 생성(출판사 번호, 출판사명)
제약조건
 - 기본키 not null
*/


CREATE TABLE publisher
(
    pubNo   VARCHAR2(10) NOT NULL PRIMARY KEY,
    pubNAME VARCHAR2(30) NOT NULL
);

/*
도서테이블(도서 번호, 도서명, 가격, 발행일, 출판사 번호)
기본키
외래키
기본값 체크조건
*/

CREATE TABLE book
(
    bookNO    VARCHAR2(10) NOT NULL PRIMARY KEY,
    bookNAME  VARCHAR2(30) NOT NULL,
    bookPRICE NUMBER(8) DEFAULT 10000 CHECK (bookPRICE > 1000),
    bookDATE  DATE,
    pubNO     VARCHAR2(10) NOT NULL,
    CONSTRAINT FK_book_publisher FOREIGN KEY (pubNO) REFERENCES publisher (pubNO)
);

-- 학과(department) 테이블 생성
CREATE TABLE department
(
    deptNo   VARCHAR2(10) NOT NULL PRIMARY KEY,
    deptName VARCHAR2(30) NOT NULL
);

-- 학생(student) 테이블 생성
CREATE TABLE student
(
    stdNo   VARCHAR2(10) NOT NULL PRIMARY KEY,
    stdName VARCHAR2(30) NOT NULL,
    stdYear NUMBER(1) DEFAULT 4 CHECK (stdYear BETWEEN 1 AND 4),
    deptNo  VARCHAR2(10) NOT NULL,
    CONSTRAINT FK_student_department FOREIGN KEY (deptNo) REFERENCES department (deptNo)
);

-- 교수 테이블
create table professor
(
    profNo       varchar2(10) not null primary key,
    profName     varchar2(30) not null,
    profPosition varchar2(30),
    profTel      varchar2(13),
    deptNo       varchar2(10) not null,
    foreign key (deptNo) references department (deptNo)
);

-- 과목 테이블
create table course
(
    courseId     varchar(10) not null primary key,
    courseName   varchar(30) not null,
    courseCredit int,
    profNo       varchar(10) not null,
    foreign key (profNo) references professor (profNo)
);

CREATE TABLE SCORES
(
    STDNO    VARCHAR2(10) NOT NULL,
    COURSEID VARCHAR2(10) NOT NULL,
    score    number(3),
    grade    varchar2(2),
    constraint PK_SCORES_STDNO_COOURSEID PRIMARY KEY (STDNO, COURSEID),
    CONSTRAINT FK_SCORES_STUDENT foreign key (STDNO) REFERENCES STUDENT (stdNo),
    CONSTRAINT fk_SCORES_COURSE foreign key (COURSEID) references course (courseId)
);