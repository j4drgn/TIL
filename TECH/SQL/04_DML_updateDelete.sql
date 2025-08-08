/*
* update 문
* 특정 열의 값을 수정하는 명령어
* 기본형식
* UPDATE 테이블명 SET 속성명=값 -> 특정속성열의 모든 값을 동일한 값으로 변경
* WHERE 절을 보통 사용함 -> 특정 튜플에 대해서만 값을 변경
* UPDATE 테이블명 SET 속성명 = 값 WHERE 조건;
*/

-- PRDNO가 5인 상품을 찾아서 PRDNAME을 UHD TV로 변경
UPDATE PRODUCT
SET PRDNAME = 'UHD TV'
where PRDNO = '5';

/*
 * delete 문
 * 테이블의 기존 행을 삭제하는 명령어
 * delete from 테이블명 [where 조건]; -> 조건 생략시 테이블의 모든 데이터가 삭제됨.
 * where 조건 특정 튜플만 삭제
 * delete문으로 테이블의 모든 행을 삭제해도 테이블은 그대로 유지됨.
 * delete from product; -- 테이블의 모든 행 삭제
 */

-- 상품명이 그늘막 텐트인 행 삭제
DELETE
FROM PRODUCT
where PRDNAME = '그늘막 텐트';

-- delete문의 반환 결과는 몇 개행이 삭제되었는지 대한 결과가 반환
-- 삭제한 내용이 없으면 0개 행이 삭제되었다는 결과 간혼
select *
from PRODUCT;

-- DML 삽입 삭제 수정 : 반환 결과가 성공한 튜플의 수 반환됨.