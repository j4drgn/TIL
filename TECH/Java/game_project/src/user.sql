-- 사용자 정보를 저장하는 회원 테이블
CREATE TABLE users (
                       id NUMBER PRIMARY KEY,                -- 사용자 고유 식별자
                       username VARCHAR2(50) UNIQUE NOT NULL, -- 로그인 아이디(중복 불가)
                       password VARCHAR2(50) NOT NULL,        -- 비밀번호
                       name VARCHAR2(50) NOT NULL,            -- 사용자 이름
                       status CHAR(1) DEFAULT 'A'             -- 상태 (A:활성, D:탈퇴)
);

-- 사용자 ID 자동 생성용 시퀀스
CREATE SEQUENCE users_seq;

-- 사용자 테이블에 ID 자동 할당 트리거
CREATE OR REPLACE TRIGGER users_tr BEFORE INSERT ON users FOR EACH ROW
BEGIN
SELECT users_seq.NEXTVAL INTO :new.id FROM dual; -- 새 레코드 삽입 시 시퀀스에서 ID 값 자동 할당
END;
/

-- 테스트용 사용자 데이터 추가 (선택사항)
INSERT INTO users (username, password, name) VALUES ('admin', 'admin123', '관리자');
INSERT INTO users (username, password, name) VALUES ('test', 'test123', '테스트유저');

-- 변경사항 저장
COMMIT;