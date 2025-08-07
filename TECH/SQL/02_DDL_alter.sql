-- ALTER TABLE (ADD. DROP, MODIFY,RENAME)

-- ALTER TABLE ADD : 속성 추가
ALTER TABLE product
    ADD (prdUITPRICE NUMBER(8), prdSTOCK NUMBER(12)
        );

-- 열의 데이터 형식 변경 : ALTER TABLE 테이블명 MODIFY 속성명 변경타입
ALTER TABLE product
    MODIFY prdUITPRICE NUMBER(4);
--데이터가 저장된 상태에서 크기 변경 진행 시 오류 발생 가능

-- 열의 제약 조건 NOT NULL -> NULL로 변경 MODIFY
ALTER TABLE product
    MODIFY PRDNAME VARCHAR2(30) NULL;

-- 열 이름 변경 ALTER TABLE 테이블 명 RENAME COLUMN 기존컬럼명 to 새로운컬럼명
ALTER TABLE PRODUCT RENAME COLUMN PRDUITPRICE TO PRDUPRICE;

-- 열 삭제
ALTER TABLE PRODUCT
    DROP COLUMN prdSTOCK;

-- 여러 열 삭제
ALTER TABLE PRODUCT
    DROP (PRDCOMPANY, PRDUPRICE);

-- 기본키 삭제 : 기본키는 반드시 있어야 하는 건 아님 단, 릴레이션 논리적 특징 유지하려면 기본키는 설정해야 함.
-- 학생테이블 교수 테이블이 참조하고 있음 - 외부 테이블 참조 기본키는 참조 오류로 기본키 제약 조건 삭제 불가
ALTER TABLE DEPARTMENT
    drop primary key;

-- 제약조건(참조제약) 무시 무조건 기본키 삭제 - cascade
-- 참조하는 외래키 제약 조건 같이 삭제됨.
ALTER TABLE DEPARTMENT
    drop primary key cascade;

-- 제약 조건 추가 : 기본 키 추가
ALTER TABLE DEPARTMENT
    ADD CONSTRAINT PK_DEPARTMENT_dptNO
        primary key (DEPTNO);

ALTER TABLE STUDENT
    ADD constraint FK_Student_department
        foreign key (DEPTNO) references DEPARTMENT (DEPTNO);

-- 외래키 제약조건 삭제 : Drop constraint 제약 조건명
ALTER TABLE STUDENT
    drop constraint FK_Student_department;

-- 기본키 삭제 - 참조하고 있는 다른 테이블이 없으면 바로 삭제됨
ALTER TABLE DEPARTMENT
    drop primary key;

-- 기본키 삭제하려고 할 때 기본키 참조하는 테이블들에 대해 참조제약조건 삭제 후 기본키 제약조건 삭제 진행
-- cascade 이용하면 강제로 모든 참조 없앰.

-----------------------------
--테이블 제약조건 확인 쿼리
-- 일반유저 설정 제약 조건은 USER_CONSTRAINTS 테이블에 정보가 저장되어 있음
-- 일반 유저는 조회 권한을 갖고 있음
SELECT *
FROM USER_CONSTRAINTS; -- 해당 USER 소유 테이블의 모든 제약 조건을 확인함

select *
from USER_CONSTRAINTS
where TABLE_NAME = 'STUDENT';
--해당 USER가 소유한 STUDENT 테이블의 제약조건 확인.

-- 제약조건 타입
-- C: Check on a table, check, not NULL
-- P : Primary Key
-- R : Foreign Key

--------------------------------
alter table DEPARTMENT
    add constraint PK_department_deptNO
        primary key (DEPTNO);

--데이터가 삭제되는 경우 삭제되는 레코드가 다른 테이블에서 참조되고 있는 경우 데이터 삭제 제약 받음
--on delete cascade : 참조하는 테이블의 데이터도 같이 삭제 시킴
ALTER TABLE STUDENT
    add constraint FK_STUDENT_DEPARTMENT
        foreign key (DEPTNO) REFERENCES DEPARTMENT (deptno)
            on delete cascade;

--------------------------------------
-- 테이블 삭제 ㅣ 테이블 모든 구조와 모든 데이터 삭제
-- 데이터만 삭제 : DML의 DELETE 문
-- DROP TABLE 테이블명 [PURGE| CASCADE CONSTRAINT]
-- PURGE : 복구 가능한 임시 테이블 생성하지 않고 영구히 삭제
-- CASCADE CONSTRAINTS : 제약조건 무시하고 기준 테이블을 강제 삭제, 권장하지 않음.

-- 외래 키에 의해 참조되는 고유/ 기본키가 테이블에 있습니다. 삭제불가
DROP TABLE DEPARTMENT;

-- 참조 상관없이 무조건 테이블 삭제
DROP TABLE DEPARTMENT cascade constraints;

-- 참조 제약 조건 상관 없는 테이블
DROP TABLE PRODUCT;