--데이터 조적어(DML)
-- 데이터 입력/삭제/수정/검색
-- INSERT문 : 테이블에 데이터(튜플)을 저장하는 조작
-- INSERT INTO 테이블명(열이름 리스트) VALUES(값 리스트): 부분열만 저장 가능 - NULL 허용하는 열의 값은 생략해도 됨.
-- INSERT INTO 테이블명 VALUES(값 리스트) : 값 리스트에 모든 열의 값이 테이블 생성시 순서에 맞춰 나열되어야 함.

-- STUDENT 테이블에 행 삽입 -- 열이름 리스트 나열하면 열 순서 상관없음, 값 순서는 나열한 열 순서와 동일해야함
INSERT INTO STUDENT(STDNO, STDNAME, STDYEAR, DEPTNO)
values ('2016001', '홍길동', 4, '1');

SELECT *
FROM STUDENT
WHERE STDNO = '2016001';