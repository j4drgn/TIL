
--데이터 조적어(DML)
-- 데이터 입력/삭제/수정/검색
-- INSERT문 : 테이블에 데이터(튜플)을 저장하는 조작
-- INSERT INTO 테이블명(열이름 리스트) VALUES(값 리스트): 부분열만 저장 가능 - NULL 허용하는 열의 값은 생략해도 됨.
-- INSERT INTO 테이블명 VALUES(값 리스트) : 값 리스트에 모든 열의 값이 테이블 생성시 순서에 맞춰 나열되어야 함.

-- STUDENT 테이블에 행 삽입 -- 열이름 리스트 나열하면 열 순서 상관없음, 값 순서는 나열한 열 순서와 동일해야함
INSERT INTO STUDENT(STDNO, STDNAME, STDYEAR, DEPTNO)
values ('2016001', '홍길동', 4, '1');

-- 값 문자열일때는 '' 표시

--열 나열 없이 실제값만 나열 : 단, 모든 필드의 값이 다 나열되어야함.
insert into STUDENT
values ('2016006', '변학도', '4', '1');

-------------------------------------------------

--select EX
select BOOKNAME
from book
where BOOKNO = '1';

-- 여러 개의 DATA(튜플)을 저장 : insert all into 테이블명() values () into 테이블명... select * from daul;

insert all
    into book
values ('6', '데이터베이스', 35000, '2021-05-12', '2')
into book
values ('7', '알고리즘', 35000, '2021-05-12', '1')
select *
from dual;

/*
** 시퀀스란
오라클 데이터베이스 객체로 유일한 값의 일련변호 생성
지정한 수치로 증가하거나 감소
기본키에 자동 증가값을 사용할 때 유용
최대 15개까지 생성 가능
테이블과 독립적으로 저장 생성
하나의 시퀀스 여러 테이블에서 사용 가능
*/
-- 시퀀스 생성 : create sequence 시퀀스명 옵션
create sequence NO_SEQ
    start with 1
    increment by 1
    maxvalue 10000
    minvalue 1
    nocycle;

--  시퀀스 적용할 테이블 생성
CREATE TABLE board
(
    bNo      NUMBER PRIMARY KEY,
    bSubject VARCHAR2(30) NOT NULL,
    bname    VARCHAR2(20) NOT NULL
);


-- 데이터 추가
insert into Board
values (NO_SEQ.nextval, '추석', '홍길동'); -- NO_SEQ.NEXTVAL : 현재값에서 증가분만큼 증가시켜서 반환하고 현재 반환된 값 저장
insert into Board
values (NO_SEQ.nextval, '미세먼지', '홍길동'); -- NO_SEQ.NEXTVAL : 현재값에서 증가분만큼 증가시켜서 반환하고 현재 반환된 값 저장
insert into Board
values (NO_SEQ.nextval, '휴가', '홍길동'); -- NO_SEQ.NEXTVAL : 현재값에서 증가분만큼 증가시켜서 반환하고 현재 반환된 값 저장


select *
from board;

-- 시퀀스 값 검색
select NO_SEQ.currval
from dual;

-- 시퀀스 수정
alter sequence NO_SEQ
    maxvalue 1000;

-- 수정 결과 검색 : 구조에 대한 검색, 시퀀스 정보 저장 테이블 user_sequences
select SEQUENCE_NAME, MAX_VALUE
from USER_SEQUENCES;

-- 시퀀스 삭제 : drop sequences 시퀀스명
drop sequence NO_SEQ;

-- 삭제 확인 -- 삭제 했으므로 반환되는 결과 내용은 없음, 테이블이 반환됨 ( 내용이 빈 테이블 반환)
select SEQUENCE_NAME
from USER_SEQUENCES;

/*
* DUAL테이블
오라클 자체에서 제공되는 테이블
1개의 행과 1개의 열만 있는 더미 테이블
SYS 소요자만 모든 사용자가 사용할 수 있음
간단한 함수 계산 결과값 확인할때 확인 ( 리턴 받을 수 있음)
*/

SELECt CURRENT_DATE
from dual;

--------------------------------------
-- 데이터 임포트
-- 텍스트 파일 읽어서 테이블 생성 및 데이터 구성

-- 데이터 임포트 후 제약 조건 추가
ALTER TABLE PRODUCT
    ADD CONSTRAINT PK_PRODUCT_PRDN01
        primary key (PRDNO);