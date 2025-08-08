
-- ALTER 문과 INSERT 문 연습 문제 풀이 파일
-- 테이블 ALTER 연습문제

-- 1. product 테이블에 숫자 값을 갖는 prdStock과 제조일을 나타내는 prdDate 열 추가
ALTER TABLE product
    ADD (prdStock NUMBER(12), prdDate DATE);

-- 2. product 테이블의 prdCompany 열 기본 추가해서 을 NOT NULL로 변경
ALTER TABLE PRODUCT
    ADD(prdCompany VARCHAR2(20));
ALTER TABLE product
    MODIFY prdCOMPANY VARCHAR2(30) NOT NULL;

-- 3. publisher 테이블에 pubPhone, pubAddress 열 추가
ALTER TABLE publisher
    ADD (pubPhone VARCHAR2(15), pubAddress VARCHAR2(100));

-- 4. publisher 테이블에서 pubPhone 열 삭제
ALTER TABLE publisher
    DROP COLUMN pubPhone;

-- 테이블 Insert 연습문제 1
INSERT ALL
    INTO STUDENT (STDNO, STDNAME, STDYEAR, STDBIRTHDAY, DEPTNO)
VALUES ('2016001', '홍길동', 4, '1997-01-01', '1')
INTO STUDENT (STDNO, STDNAME, STDYEAR, STDBIRTHDAY, DEPTNO)
VALUES ('2015002', '성춘향', 3, '1996-12-10', '3')
INTO STUDENT (STDNO, STDNAME, STDYEAR, STDBIRTHDAY, DEPTNO)
VALUES ('2014004', '이몽룡', 2, '1996-03-03', '2')
INTO STUDENT (STDNO, STDNAME, STDYEAR, STDBIRTHDAY, DEPTNO)
VALUES ('2016002', '변학도', 4, '1995-05-07', '1')
INTO STUDENT (STDNO, STDNAME, STDYEAR, STDBIRTHDAY, DEPTNO)
VALUES ('2015003', '수홍미', 3, '1997-11-11', '2')
SELECT *
FROM dual;
