-- 계정에 할당된 QUOTA 확인
SELECT * FROM USER_TS_QUOTAS; -- 할당량 MAX_BYTES 값이 -1이면 무제한의미

-- 계정 조회
-- SELECT * FROM DBA_USERS; -- DBA권한으로만 조회 가능
SELECT * FROM ALL_USERS; -- DBA권한보다 낮은 모든 사용자 권한으로 조회가 가능
SELECT * FROM USER_USERS; -- 현재 계정에 대한 정보 조회

-- ALL_XXX : DBA권한보다 낮으면서 부여된 권한으로 조회할 수 있는 객체 확인
SELECT * FROM ALL_TABLES;

-- USER_XXX : 자신이 생성한 모든 객체에 대한 정보
SELECT * FROM USER_TABLES;

-- 관리자가 아닌경우 계정, 객체 정보 확인
SELECT * FROM ALL_USERS;
SELECT * FROM USER_TABLES; -- 현재 계정 DB
SELECT * FROM TAB; -- 현재 계정 DB

-- 현재 계정에 부여된 권한 조회
SELECT * FROM USER_ROLE_PRIVS;

---------------------------------------------------------------------------------------------
-- 다른 계정(C##USER_SELECT)의 객체(BOOK)에 접근
-- 소유주의 허가가 있어야 접근 가능
-- 소유주 계정에서 허가
GRANT SELECT ON BOOK TO NEWUSER11;
GRANT INSERT ON BOOK TO NEWUSER11;
GRANT UPDATE ON BOOK TO NEWUSER11;
GRANT DELETE ON BOOK TO NEWUSER11;

-- 현재 계정에서 
SELECT * 
FROM C##USER_SELECT.BOOK;

-- DML에 질의어에 대해서 각각 권한을 부여 받아야 함
UPDATE C##USER_SELECT.BOOK SET BOOKNAME ='TESTBOOK' WHERE BOOKNO='12345678';

-- 소유주 계정에서 권한 회수
REVOKE SELECT ON BOOK FROM NEWUSER11;

-- 현재 계정에서 진행 - 권한 회수 후 이므로 오류 발생
SELECT * 
FROM C##USER_SELECT.BOOK;

