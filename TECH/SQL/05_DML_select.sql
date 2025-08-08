/*
 * SELECT [ALL | DISTINCT] 열이름 리스트
 * FROM 테이블명
 * [WHERE 검색조건(들)]
 * [GROUP BY 열이름]
 * [HAVING 검색조건(들)]
 * [ORDER BY 열이름 [ASC┃DESC]
 */

-- 서점 관계 테이블 IMPORT
-- 테이블 이름을 소문자로 사용 (테이블 목록에서 확인됨)
SELECT *
FROM BOOK;

-- 테이블에 제약 조건 설정

-- 참조 무결성 제약 조건
-- 참조되는 테이블의 기본키 먼저 구성 참조하는 테이블의 외래키 구성

-- 서점의 모든 도서는 거래하고 있는 출판사에서 구매된다 - 도서테이블(BOOK) 출판사 데이터(PUBNO)는 출판사 테이블(PUBLISHER)의 기본키 도메인의 범위에 국한된다
-- 서점의 모든 도서는 회원가입 되어 있는 회원(CLIENT)이 서점에 등록되어 있는 도서를 구매할 수 있다 : 구매관계테이블(BOOKSALE)

-- 기본키 제약조건
ALTER TABLE PUBLISHER
    ADD CONSTRAINT PK_publisher_pubNo
        primary key (PUBNO);

alter TABLE BOOK
    ADD CONSTRAINT PK_book_bookno
        primary key (BOOKNO);

ALTER TABLE CLIENT
    ADD CONSTRAINT PK_client_clientno
        PRIMARY KEY (CLIENTNO);

ALTER TABLE BOOKSALE
    ADD CONSTRAINT PK_booksale_bsno
        PRIMARY KEY (BSNO);

-- 외래키 제약 조건 추가
ALTER TABLE BOOK
    ADD CONSTRAINT FK_book_publisher
        foreign key (PUBNO) references PUBLISHER (PUBNO);

alter table BOOKSALE
    add constraint fk_booksale_client
        foreign key (CLIENTNO) references CLIENT (CLIENTNO);

alter table BOOKSALE
    add constraint fk_booksale_book
        foreign key (BOOKNO) references book (BOOKNO);

---------------------------
-- 특정 테이블의 모든 튜플을 반환 -> 반환결과 테이블
select *
from PUBLISHER;

select *
from book;

select *
from CLIENT;

select *
from BOOKSALE;

---------------------------

--book 테이블에서 도서명, 도서가격만 출력
SELECT BOOKNAME, BOOKPRICE
from book;

-- BOOK 테이블에서 저자 검색
select BOOKAUTHOR
from book;

-- BOOK 테이블에서 저자 검색 (중복 튜플은 한번만 검색) : distinct
select distinct BOOKAUTHOR
from book;

----------------------------
/*
 * WHERE 조건절 : 검색의 세분화
 * 조건 사용 연산자
 * 비교 : = < > <= >= !=
 * 범위 : BETWEEN
 * 리스트에 포함 : IN, NOT IN
 * NULL : IS NULL, IS NOT NULL
 * 논리 : AND, OR
 * 패턴 매칭 : LIKE
 */

-- 비교
-- 저자가 홍길동인 도서의 도서명, 저자변환
SELECT BOOKNAME, BOOKAUTHOR
FROM BOOK
WHERE BOOKAUTHOR = '홍길동';

-- 도서가가 30000원 이상인 도서의 도서명, 가격, 재고 반환
SELECT BOOKNAME, BOOKPRICE, BOOKSTOCK
FROM BOOK
WHERE BOOKPRICE >= 30000;

-- 도서재고가 3권 이상이고 5권 이하인 도서의 도서명과 재고 수량
SELECT BOOKNAME, BOOKSTOCK
FROM BOOK
WHERE BOOKSTOCK >= 3
  and BOOKSTOCK <= 5;

-- 범위
-- 도서재고가 3권 이상이고 5권 이하인 도서의 도서명과 재고 수량
SELECT BOOKNAME, BOOKSTOCK
FROM BOOK
WHERE BOOKSTOCK between 3 and 5;

-- 리스트의 포함 : in, not in : 속성명 in (값1, 값2, ...) -> 리스트
-- 서울 출판사('1')와 도서출판 강남('2')의 도서명과 출판사 번호 출력
SELECT BOOKNAME, PUBNO
FROM BOOK
WHERE PUBNO IN ('1', '2');

-- 1,2가 아닌 3을 내보내게 됨.
SELECT BOOKNAME, PUBNO
FROM BOOK
WHERE PUBNO NOT IN ('1', '2');

-- NULL

-- 모든 클라이언트의 이름과 취미를 반환
SELECT CLIENTNAME, CLIENTHOBBY
from client;

-- 취미 정보가 NULL인 클라이언트의 이름과 취미를 반환
SELECT CLIENTNAME, CLIENTHOBBY
from client
WHERE CLIENTHOBBY is NULL;

-- 취미 정보가 NOT NULL인 클라이언트의 이름과 취미를 반환
SELECT CLIENTNAME, CLIENTHOBBY
from client
WHERE CLIENTHOBBY is NOT NULL;

-- 취미 정보가 공백인 클라이언트의 이름과 취미를 반환
SELECT CLIENTNAME, CLIENTHOBBY
from client
WHERE CLIENTHOBBY = ' ';

-- 논리(AND, OR)
-- 저자가 홍길동이면서 재고가 3권 이상인 도서의 정보 반환
SELECT *
FROM BOOK
WHERE BOOKAUTHOR = '홍길동'
  AND BOOKSTOCK >= 3;

-- 저자가 홍길동이거나 성춘향인 도서의 정보 반환
SELECT *
FROM BOOK
WHERE BOOKAUTHOR = '홍길동'
   OR BOOKAUTHOR = '성춘향';

-- IN
SELECT *
FROM BOOK
WHERE BOOKAUTHOR IN ('홍길동', '성춘향');

-- 패턴 매칭 : LIKE
--WHERE 컬럼명 LIKE '패턴'
-- % : 0개 이상의 문자를 가진 문자열, _ : 한개의 문자
-- '홍%' : 홍으로 시작하는 문자열
-- '%길%' : 길을 포함하는 문자열
-- '%동' : 동으로 끝나는 문자열
-- _ _ _ _ : 4개의 문자로 구성된 문자열

-- 출판사 명에 출판사 문자열이 포함된 출판사 정보
SELECT *
FROM PUBLISHER
WHERE PUBNAME LIKE '%출판사%';

-- 출생년도가 1990년대인 고객 정보 반환
SELECT *
FROM CLIENT
WHERE CLIENTBIRTH LIKE '199%';

-- 이름이 4글자인 고객의 정보 반환
SELECT *
FROM CLIENT
WHERE CLIENTNAME LIKE '____';

-- NOT LIKE
-- 도서명에 안드로이드가 포함되지 않은 도서의 정보
SELECT *
FROM BOOK
WHERE BOOKNAME LIKE '%안드로이드%';

----------------------------------------
-- ORDER BY : 정렬
-- 특정 열의 값을 기준으로 질의 결과 정렬
-- 가장 마지막에 진행되는 연산 (ORDER BY 절은 마지막 질의가 나옴)
-- 기준열을 두 개 이상 나열 가능 - 우선 기준, 두번째 기준, 세번째 기준
-- ASC : 오름차순(생략가능)
-- DESC : 내림차순
SELECT *
FROM BOOK
ORDER BY BOOKNAME;

-- 내림차순
SELECT *
FROM BOOK
ORDER BY BOOKNAME DESC;

-- 조건절 뒤에 ORDER BY
SELECT BOOKNAME, BOOKAUTHOR, BOOKSTOCK, BOOKPRICE
FROM BOOK
WHERE BOOKPRICE >= 20000
ORDER BY BOOKPRICE;

-- 정렬 조건 2개 이상일 경우
-- 도서재고를 기준으로 내림차순정렬하고 재고가 동일한 튜플일 경우 저자를 기준으로 오름차순 정렬한 도서 정보 반환
SELECT *
FROM BOOK
ORDER BY BOOKSTOCK DESC, BOOKAUTHOR ASC;

---------------------------------------
-- 집계 함수
-- SUM()/AVG()/COUNT()/COUNT(*)/MAX()/MIN()

-- SUM()
-- 도서의 총 재고 수량 출력
SELECT SUM(BOOKSTOCK)
FROM BOOK;
-- 테이블 반환 -> 컬럼명이 있음.

-- 모든 컬럼은 컬럼의 별명 생성 가능(SELECT 문에서 AS를 활용해서)
SELECT SUM(BOOKSTOCK) AS "SUM OF BOOKSTOCK"
FROM BOOK;

-- 한글 가능
SELECT SUM(BOOKSTOCK) AS "총재고량"
FROM BOOK;

-- 2번 고객이 주문한 총 주문 도서 권수
SELECT SUM(BSQTY) AS "총주문수량"
FROM BOOKSALE
WHERE CLIENTNO = '2';

-- 2번 고객이 주문한 총 주문 도서 권수
-- 총 주문 수량은 1개의 튜플
-- 도서 번호는 3개의 튜플
-- GROUP BY절을 포함하고 있는 경우가 아니면 SELECT에 집계함수가 포함되면 다른 컬럼도 집계함수를 사용해서 포함되어야함.
-- SELECT SUM(BSQTY) AS "총주문수량", BOOKNO AS "도서번호" -- ERROR : 단일 그룹의 그룹 함수가 아닙니다
-- FROM BOOKSALE
-- WHERE CLIENTNO = '2';

-- 2번 고객이 주문한 총 주문 도서 권수
SELECT SUM(BSQTY) AS "총주문수량", AVG(BSQTY) as "평균주문수량"
FROM BOOKSALE
WHERE CLIENTNO = '2';
