-- 한줄 주석
/* 여러 줄 주석 */

show TABLES;

SELECT * FROM EMPLOYEE;

-- SELECT : 조회용 SQL 문장
-- SELECT *(조회용 컬럼) : 조회하려는 내용(컬럼)
-- FROM 테이블명 : 조회하려는 테이블
-- [WHERE 조건] : 특정 조건
-- [ORDER BY 컬럼] : 정렬
-- ;

-- 모든 행과 모든 컬럼 조회
SELECT * FROM EMPLOYEE;

-- 모든 사원의 ID와 사원명, 연락처를 조회
SELECT emp_id, emp_name, phone FROM employee;

-- 실습 --
-- 모든 사원의 아이디, 사원명, 이메일, 연락처,
-- 부서번호(DEPT_CODE), 직급코드(JOB_CODE)를 조회
SELECT emp_id, emp_name, email, phone, dept_code, job_code from employee;

-- WHERE 구문(절)
-- 테이블에서 조건을 만족하는 행을 따로 선택하여 조회.
-- 여러 개의 조건을 선택하려면
-- AND , OR 명령어로 조건을 작성

-- 실습 1 --
-- 부서코드가 'D6'인 사원 정보를 모두 조회
SELECT * FROM employee WHERE dept_code='d6';

-- 실습 2 --
-- 직급이 'J1'인 사원의 사번, 사원명, 직급 코드, 부서코드 조회
SELECT emp_id, emp_name, job_code, dept_code
from employee
WHERE job_code='j1';

-- 실습 3 --
SELECT emp_id, emp_name, job_code, salary
from employee
WHERE salary>=3000000;

-- 조건이 2개 이상일 경우 AND, OR
-- 부서코드가 'D6'이면서, 그리고 이름이 '유재식'인
-- 사원의 모든 정보 조회

SELECT *
FROM employee
WHERE emp_name='유재식' AND dept_code='d6';

-- 컬럼명에 별칭 달아 조회
-- 1. as(alias) 표현
SELECT emp_id as "사원번호", emp_name as '사원명'
from employee;

-- 2. as 생략 / ""를 사용하면 띄어쓰기나 쉼표 등을 사용할 수 있다.
SELECT emp_id "사원번호", emp_name "사원명"
from employee;

SELECT emp_id 사원번호, emp_name 사원명
from employee;

-- 실습3 --
-- employee 테이블에서 사원번호가
-- 205번인 사원의
-- 사원명, 이메일, 급여, 입사일자를 조회.
-- (단, 조회하는 컬럼에 별칭을 각각 부여)
SELECT emp_name "사원명", email "이메일", salary "급여", hire_date "입사일자"
from employee
WHERE emp_id = '205';

-- 컬럼값을 사용하여 계산식 적용
SELECT emp_name "사원명",
		(salary*12) "연봉",
		bonus "보너스",
		(salary + (salary*bonus))*12 "연봉 총합"
from employee;

-- ifnull() : 만약 현재 조회한 컬럼값이 null일 경우 별도로 설정한 값으로 변경.
SELECT emp_name "사원명",
		(salary*12) "연봉",
		bonus "보너스",
		(salary + (salary*ifnull(bonus, 0)))*12 "연봉 총합"
from employee;

-- 컬럼에 일반값 사용하기
SELECT emp_name, salary*12, '원' 단위
from employee;

-- DISTINCT
-- 만약 해당 하는 값이 컬럼에 여러개 존재할 경우
-- 중복 제거하고 하나만 조회(Null값도 포함).

SELECT dept_code from employee;
SELECT DISTINCT dept_code from employee;

-- 실습 4--
-- employee 테이블에서 해당 부서의(해외영업 2부)
-- 사원들 중 급여를 200만원보다 많이 받는 직원의
-- 사번, 사원명, 급여를 조회

SELECT emp_id "사번", emp_name "사원명", salary "급여", dept_title "부서"
from employee, department
WHERE DEPT_TITLE = '해외영업2부' and salary > 2000000;

-- 연산자 --
-- 비교 연산자 --
-- <, >, <=, >= : 크기를 비교
-- = : 같다.
-- !=, <> : 같지 않다.






