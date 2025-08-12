----------------------------------

--1. 도서 테이블에서 가격 순으로 내림차순 정렬하여,  도서명, 저자, 가격 출력 (가격이 같으면 저자 순으로 오름차순 정렬) 
select BOOKNAME, BOOKAUTHOR, BOOKPRICE
from book
order by BOOKPRICE desc, BOOKAUTHOR;

--2. 도서 테이블에서 저자에 '길동'이 들어가는 도서의 총 재고 수량 계산하여 출력 
select sum(BOOKSTOCK)
from book
where BOOKAUTHOR like '%길동%';

--3. 도서 테이블에서 '서울 출판사' 도서 중 최고가와 최저가 출력 
select Max(BOOKPRICE) as "최고가", MIN(BOOKPRICE) as "최저가"
from book
where PUBNO = (select PUBNO from publisher where PUBNAME='서울 출판사');

--4. 도서 테이블에서 출판사별로 총 재고수량과 평균 재고 수량 계산하여 출력 ('총 재고 수량'으로 내림차순 정렬)
select sum(BOOKSTOCK) as "총 재고 수량", avg(BOOKSTOCK) as "평균 재고 수량"
from book
group by pubno
order by avg(BOOKSTOCK) desc;

-- 점수표현(반올림) : ROUND(대상, 소수점이하 자리수)
select sum(BOOKSTOCK) as "총 재고 수량", round(avg(BOOKSTOCK),2) as "평균 재고 수량"
from book
group by pubno
order by "총 재고 수량" desc; -- order by절이 가장 나중에 실행되므로(select보다 나중에 실행되므로) 

--5. 도서판매 테이블에서 고객별로 '총 주문 수량'과 '총 주문 건수' 출력. 단 주문 건수가 2이상인 고객만 해당
select sum(BSQTY), count(*)
from booksale
group by clientno
having count(*)>= 2;

----------------------------------

--1.모든 도서에 대하여 도서의 도서번호, 도서명, 출판사명 출력
select BOOKNO, BOOKNAME, BOOKAUTHOR from book;

--2.'서울 출판사'에서 출간한 도서의 도서명, 저자명, 출판사명 출력 (출판사명 사용)
select b.BOOKNAME, b.BOOKAUTHOR, p.pubname
from book b inner join publisher p on b.pubno = p.pubno
where p.pubname = '서울 출판사';

--3.＇정보출판사'에서 출간한 도서 중 판매된 도서의 도서명 출력 (중복된 경우 한 번만 출력) (출판사명 사용)
select distinct b.BOOKNAME
from book b inner join publisher p on b.pubno = p.pubno
            inner join booksale bs on bs.bookno = b.bookno
where p.pubname = '정보출판사';

--4.도서가격이 30,000원 이상인 도서를 주문한 고객의 고객명, 도서명, 도서가격, 주문수량 출력
select c.clientname, b.bookname, b.bookprice, bs.bsqty
from booksale bs inner join client c on c.clientno = bs.clientno
            inner join book b on b.bookno = bs.bookno
where b.bookprice >= 30000;

--5.'안드로이드 프로그래밍' 도서를 구매한 고객에 대하여 도서명, 고객명, 성별, 주소 출력 (고객명으로 오름차순 정렬)
select c.clientname, b.bookname, c.clientgender, c.clientaddress
from booksale bs inner join client c on c.clientno = bs.clientno
            inner join book b on b.bookno = bs.bookno
where b.bookname = '안드로이드 프로그래밍'
order by c.clientname;

--6.'도서출판 강남'에서 출간된 도서 중 판매된 도서에 대하여 '총 매출액' 출력
select p.pubname, sum(bs.bsqty*b.bookprice) as "총 매출액"
from book b inner join publisher p on b.pubno = p.pubno
            inner join booksale bs on bs.bookno = b.bookno
where p.pubname = '도서출판 강남'
group by p.pubname;

--7.'서울 출판사'에서 출간된 도서에 대하여 판매일, 출판사명, 도서명, 도서가격, 주문수량, 주문액 출력
select  b.bookdate, p.pubname, b.bookname, b.bookprice, bs.bsqty, (b.bookprice * bs.bsqty) as 주문액
from book b inner join publisher p on b.pubno = p.pubno
            inner join booksale bs on bs.bookno = b.bookno
where p.pubname = '서울 출판사';

--8.판매된 도서에 대하여 도서별로 도서번호, 도서명, 총 주문 수량 출력
select b.bookno, b.bookname, sum(bs.bsqty) as "총 주문 수량"
from book b inner join booksale bs on b.bookno = bs.bookno
group by b.bookno, b.bookname;

--9.판매된 도서에 대하여 고객별로 고객명, 총구매액 출력 ( 총구매액이 100,000원 이상인 경우만 해당)
select c.clientname, sum (bs.bsqty*b.bookprice) as 총구매액
from booksale bs inner join client c on bs.clientno = c.clientno
            inner join book b on b.bookno = bs.bookno
group by c.clientno, c.clientname
having sum (bs.bsqty*b.bookprice) >= 100000;

--10.판매된 도서 중 ＇도서출판 강남'에서 출간한 도서에 대하여 고객명, 주문일, 도서명, 주문수량, 출판사명 출력 (고객명으로 오름차순 정렬)
select c.clientname, bs.bsdate, b.bookname, bs.bsqty, p.pubname
from book b inner join publisher p on b.pubno = p.pubno
            inner join booksale bs on bs.bookno = b.bookno
            inner join client c on c.clientno = bs.clientno
where p.pubname = '도서출판 강남'
order by c.clientname;