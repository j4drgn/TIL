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

--------------------------------------------------------------
-- BOOK 테이블 연습문제
-- 1. book 테이블에 다음과 같이 행 삽입
INSERT ALL
    INTO BOOK (bookno, bookname, bookprice, bookdate, pubno)
VALUES ('6', 'JAVA 프로그래밍', 30000, '2021-03-10', '1')
INTO BOOK (bookno, bookname, bookprice, bookdate, pubno)
VALUES ('7', '파이썬 데이터 과학', 24000, '2018-02-05', '2')
SELECT *
FROM dual;

-- 2. book 테이블에서 도서명이 '데이터베이스'인 행의 가격을 22000으로 변경
UPDATE BOOK
SET bookprice = 22000
WHERE bookname = '데이터베이스';

-- 3. book 테이블에서 발행일이 2018년도인 행 삭제
DELETE
FROM BOOK
WHERE EXTRACT(YEAR FROM bookdate) = 2018;

--------------------------------------------------------------

-- 종합 연습문제: orderProduct와 customer 테이블에 적절한 관계 설정
-- 고객테이블 생성
DROP TABLE CUSTOMER;

create table customer
(
    custNo      varchar2(10) not null primary key,
    custName    varchar2(30) not null,
    custTel     varchar2(30),
    custAddress varchar2(40)
);

-- 주문 테이블 : 고객이 상품을 주문한다
CREATE TABLE ORDERPRODUCT
(
    ORDERNO   VARCHAR2(10) NOT NULL PRIMARY KEY,
    ORDERDATE DATE,
    ORDERQTY  NUMBER(3),
    CUSTNO    VARCHAR2(10) NOT NULL,
    PRDNO     VARCHAR2(4)  NOT NULL,
    CONSTRAINT FK_ORDERPRODUCT_CUSTOMER FOREIGN KEY (CUSTNO) REFERENCES CUSTOMER (CUSTNO),
    CONSTRAINT FK_ORDERPRODUCT_PRODUCT FOREIGN KEY (PRDNO) REFERENCES PRODUCT (PRDNO)
);


-- 3. 고객 테이블의 전화번호 열을 NOT NULL로 변경
ALTER TABLE customer
    MODIFY custPhone VARCHAR2(13) NOT NULL;

-- 4. 고객 테이블에 '성별', '나이' 열 추가
-- 이미 위에서 생성할 때 포함했으므로 생략

-- 5. 고객, 주문 테이블에 데이터 삽입 (3개씩)
-- 고객 데이터 삽입
INSERT ALL
    INTO customer (custNo, custName, custPhone, custAddress, custGender, custAge)
VALUES (1001, '홍길동', '010-1111-1111', '경기도 수원시', '남', 22)
INTO customer (custNo, custName, custPhone, custAddress, custGender, custAge)
VALUES (1002, '이몽룡', '010-2222-2222', '서울 종로구', '남', 25)
INTO customer (custNo, custName, custPhone, custAddress, custGender, custAge)
VALUES (1003, '성춘향', '010-3333-3333', '서울시 강남구', '여', 22)
SELECT *
FROM dual;

-- 주문 데이터 삽입 (product 테이블에 prdNo 3, 7, 2가 있다고 가정)
INSERT ALL
    INTO orderProduct (orderNo, orderDate, orderQty, custNo, prdNo)
VALUES (1, '2018-01-10', 3, 1003, 3)
INTO orderProduct (orderNo, orderDate, orderQty, custNo, prdNo)
VALUES (2, '2018-03-03', 1, 1001, 7)
INTO orderProduct (orderNo, orderDate, orderQty, custNo, prdNo)
VALUES (3, '2018-04-05', 3, 1002, 2)
SELECT *
FROM dual;

-- 6. 주문 테이블에서 상품번호가 2인 행의 주문수량을 3으로 수정
UPDATE orderProduct
SET orderQty = 3
WHERE prdNo = 2;

--------------------------------------------------------------

-- 1.고객 테이블에서 고객명, 생년월일, 성별 출력
SELECT CLIENTNAME, CLIENTBIRTH, CLIENTGENDER
FROM CLIENT;
-- 2.고객 테이블에서 주소만 검색하여 출력 (중복되는 튜플은 한번만 출력)
SELECT distinct CLIENTADDRESS
FROM CLIENT;
-- 3.고객 테이블에서 취미가 '축구'이거나 '등산'인 고객의 고객명, 취미 출력
SELECT CLIENTNAME, CLIENTHOBBY
FROM CLIENT
WHERE CLIENTHOBBY = '축구'
   or CLIENTHOBBY = '등산';
-- 4.도서 테이블에서 저자의 두 번째 위치에 '길'이 들어 있는 저자명 출력 (중복되는 튜플은 한번만 출력)
SELECT DISTINCT BOOKAUTHOR
FROM BOOK
WHERE BOOKAUTHOR LIKE '%길%';
-- 5.도서 테이블에서 발행일이 2018년인 도서의 도서명, 저자, 발행일 출력
SELECT BOOKNAME, BOOKAUTHOR, BOOKDATE
FROM BOOK
WHERE EXTRACT(YEAR FROM BOOKDATE) = 2018;
-- 6.도서판매 테이블에서 고객번호1, 2를 제외한 모든 튜플 출력
SELECT *
FROM ORDERPRODUCT
WHERE custNo != 1
  and custNo != 2;
-- 7.고객 테이블에서 취미가 NULL이 아니면서 주소가 '서울'인 고객의 고객명, 주소, 취미 출력
SELECT CLIENTNAME, CLIENTADDRESS, CLIENTHOBBY
FROM CLIENT
WHERE CLIENTHOBBY IS NOT NULL
  and CLIENTADDRESS LIKE '%서울%';
-- 8.도서 테이블에서 가격이 25000 이상이면서 저자 이름에 '길동'이 들어가는 도서의 도서명, 저자, 가격, 재고 출력
SELECT BOOKNAME, BOOKAUTHOR, BOOKPRICE, BOOKSTOCK
FROM BOOK
WHERE BOOKPRICE >= 25000
  and BOOKAUTHOR LIKE '%길동%';
-- 9.도서 테이블에서 가격이 20,000 ~25,000원인 모든 튜플 출력
SELECT *
FROM BOOK
WHERE BOOKPRICE BETWEEN 20000 AND 25000;
-- 10.도서 테이블에서 저자명에 '길동'이 들어 있지 않는 도서의 도서명, 저자 출력
SELECT BOOKNAME, BOOKAUTHOR
FROM BOOK
WHERE BOOKAUTHOR NOT LIKE '%길동%';
-- order by 절은 정렬시 기준필드의 값이 동일한 경우 2번째 기준을 추가할 수 있음
-- 도서 테이블에서 저자명에 '길동'이 들어 있지 않는 도서의 도서명, 저자 출력
-- 도서가격 기준으로 오름차순 정렬, 가격이 동일하면 저자 기준 내림차순 정렬 결과 추출
select bookName, bookAuthor
from book
where bookAuthor not like '%길동%'
order by bookPrice asc, BOOKAUTHOR desc;

