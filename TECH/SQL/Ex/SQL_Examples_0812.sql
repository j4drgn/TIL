-- 1.호날두(고객명)가 주문한 도서의 총 구매량 출력
SELECT SUM(BSQTY) AS "호날두 총 구매량"
FROM BOOKSALE
WHERE CLIENTNO = (
    SELECT CLIENTNO
    FROM CLIENT
    WHERE CLIENTNAME = '호날두'
);

-- 2.'정보출판사'에서 출간한 도서를 구매한 적이 있는 고객명 출력
SELECT DISTINCT C.CLIENTNAME
FROM CLIENT C
WHERE C.CLIENTNO IN (
    SELECT BS.CLIENTNO
    FROM BOOKSALE BS
    WHERE BS.BOOKNO IN (
        SELECT B.BOOKNO
        FROM BOOK B
        WHERE B.PUBNO = (
            SELECT P.PUBNO
            FROM PUBLISHER P
            WHERE P.PUBNAME = '정보출판사'
        )
    )
);

-- 3.베컴이 주문한 도서의 최고 주문수량 보다 더 많은 도서를 구매한 고객명 출력
SELECT DISTINCT C.CLIENTNAME
FROM CLIENT C
JOIN BOOKSALE BS ON C.CLIENTNO = BS.CLIENTNO
WHERE BS.BSQTY > ALL (
    SELECT BS2.BSQTY
    FROM BOOKSALE BS2
    WHERE BS2.CLIENTNO = (
        SELECT C2.CLIENTNO
        FROM CLIENT C2
        WHERE C2.CLIENTNAME = '베컴'
    )
)
AND C.CLIENTNAME != '베컴';

-- 4.천안에 거주하는 고객에게 판매한 도서의 총 판매량 출력
SELECT SUM(BS.BSQTY) AS "천안 고객 총 판매량"
FROM BOOKSALE BS
WHERE BS.CLIENTNO IN (
    SELECT C.CLIENTNO
    FROM CLIENT C
    WHERE C.CLIENTADDRESS LIKE '%천안%'
);
----------------------------------------------------------------------------------
-- 저자 중 성(姓)이 '손'인 모든 저자 출력
SELECT BOOKAUTHOR
FROM BOOK
WHERE BOOKAUTHOR LIKE '손%';

-- 저자 중에서 같은 성(姓)을 가진 사람이 몇 명이나 되는지 알아보기 위해 성(姓)별로 그룹 지어 인원수 출력
SELECT SUBSTR(BOOKAUTHOR, 1, 1) AS 성, COUNT(*) AS 인원수
FROM BOOK
GROUP BY SUBSTR(BOOKAUTHOR, 1, 1)
ORDER BY 성;

-----------------------------------------------------------------------------------
-- 연습문제: 아래와같은 테이블을 생성하고 CUBE, ROLLUP, GROUPING SETS를 적용시켜 결과를 설명하시오
-- 테이블 생성
CREATE TABLE sales
(
    prdName     VARCHAR2(20),
    salesDate   VARCHAR2(10),
    prdCompany  VARCHAR2(10),
    salesAmount NUMBER(8)
);

-- 데이터 삽입
INSERT INTO sales
VALUES ('노트북', '2021.01', '삼성', 10000);
INSERT INTO sales
VALUES ('노트북', '2021.03', '삼성', 20000);
INSERT INTO sales
VALUES ('냉장고', '2021.01', 'LG', 12000);
INSERT INTO sales
VALUES ('냉장고', '2021.03', 'LG', 20000);
INSERT INTO sales
VALUES ('프린터', '2021.01', 'HP', 3000);
INSERT INTO sales
VALUES ('프린터', '2021.03', 'HP', 1000);

-- 기본 조회
SELECT *
FROM sales;

-- CUBE 적용 (모든 가능한 조합에 대한 소계 생성)
SELECT prdName, salesDate, prdCompany, SUM(salesAmount) AS 총판매액
FROM sales
GROUP BY CUBE (prdName, salesDate, prdCompany)
ORDER BY prdName, salesDate, prdCompany;

-- ROLLUP 적용 (계층적 소계 생성)
SELECT prdName, salesDate, prdCompany, SUM(salesAmount) AS 총판매액
FROM sales
GROUP BY ROLLUP (prdName, salesDate, prdCompany)
ORDER BY prdName, salesDate, prdCompany;

-- GROUPING SETS 적용 (지정한 그룹화 조합에 대한 소계 생성)
SELECT prdName, salesDate, prdCompany, SUM(salesAmount) AS 총판매액
FROM sales
GROUP BY GROUPING SETS ((prdName), ( salesDate), ( prdCompany), ())
ORDER BY prdName, salesDate, prdCompany;

----------------------------------------------------
-- 연습문제: 주문일에 7일을 더한 날을 배송일로 계산하여 출력
SELECT BSDATE AS 주문일, TO_CHAR(TO_DATE(BSDATE, 'YYYY-MM-DD') + 7, 'YYYY-MM-DD') AS 배송일
FROM BOOKSALE
ORDER BY BSDATE;

-- EXTRACT() 함수 사용
SELECT BOOKNAME AS 도서명, EXTRACT(YEAR FROM BOOKDATE) AS 출판연도
FROM BOOK;


