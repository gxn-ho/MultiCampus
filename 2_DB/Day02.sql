-- employee 테이블에서 부서코드가 'D9'가 아닌
-- 직원들의 모든 정보를 조회
SELECT * FROM EMPLOYEE
-- WHERE DEPT_CODE != 'd9';
where dept_code <> 'd9';

-- employee 테이블에서 급여가 350만원 이상 550만원 이하인
-- 직원의 사번, 사원명, 부서코드, 직급코드, 급여 정보를 조회
SELECT emp_id, emp_name, dept_code, job_code, salary
from EMPLOYEE 
WHERE SALARY >= 3500000 and SALARY <= 5500000
-- ORDER BY SALARY asc; -- 오름차순 정렬
order by SALARY DESC; -- 내림차순 정렬

-- 2. Between A and B
SELECT EMP_ID ,EMP_NAME ,DEPT_CODE ,JOB_CODE ,SALARY 
FROM EMPLOYEE e 
WHERE SALARY BETWEEN 3500000 and 5500000;


-- 위와 동일한 정보를 조회하되
-- 조건이 350만원 미만, 550만원 초과인 직원 조회
-- 조건where절에 'not'을 통해 부정
SELECT EMP_ID ,EMP_NAME ,DEPT_CODE ,JOB_CODE ,SALARY 
FROM EMPLOYEE e 
WHERE SALARY not BETWEEN 3500000 and 5500000;

-- Like :
-- 입력한 숫자, 문자가 포함된 정보를 조회할 때 사용하는 연산자
-- '_' : 임의의 한 문자
-- '%' : 몇자리 문자든 상관없이

-- employee 테이블에서 사원 이름의 가운데 글자가 '중'이 들어가는 사원 정보를 조회
SELECT *
FROM EMPLOYEE e 
WHERE EMP_NAME LIKE '_중_';

-- employee 테이블에서 주민등록번호 기준 여성인 사원의 정보만 조회
SELECT *
FROM EMPLOYEE e 
WHERE EMP_NO LIKE '%-2%'; 

-- 사원 중 이메일 아이디가
-- 5글자를 초과하는 사원의
-- 사원명, 사번, 이메일 조회.
SELECT EMP_NAME ,EMP_ID ,EMAIL 
FROM EMPLOYEE e 
WHERE EMAIL LIKE '______%@%';

-- 사원 중 이메일 4번째자리가 '_'인 사원의 정보 조회하기
-- escape 문자를 선언하여 뒤에 오는 특수문자를 특수문자가 아닌 일반문자로 선언하자!
SELECT *
FROM EMPLOYEE e 
WHERE EMAIL LIKE '___#_%@%' ESCAPE '#';


-- in 연산자
-- in(값1, 값2, 값3, ...)
-- 안에 있는 값 중 하나라도 일치하는 경우 조회

-- 부서코드가 D1이거나 D6인 부서에 직원 정보를 조회
-- dept_code = D1 or dept_code D6;
SELECT *
FROM EMPLOYEE e 
WHERE DEPT_CODE in('d1','d6');

-- D1도 아니고, D6도 아닌 부서의 직원 정보 조회
SELECT *
FROM EMPLOYEE e 
WHERE DEPT_CODE NOT IN ('d1','d6');

-- 함수(Function) --

-- 문자 관련 함수
-- length / char_length : 문자열의 길이를 계산하는 함수
-- length() :: byte의 길이(영어 1, 한국 3)
-- char_length : 글자 수
SELECT LENGTH ('hello'),CHAR_LENGTH('hello');
SELECT LENGTH ("정건호"), CHAR_LENGTH("정건호"); 

-- instr : 주어진 값에서 원하는 문자가 몇 번째인지 찾아 반환하는 함수.
SELECT INSTR('abcde', 'a'),	INSTR('abcde', 'c'), INSTR('abcde', 'cd'), INSTR('abcde', 'x');

-- substr : 주어진 문자열에서 특정 부분만 꺼내어 오는 함수.
SELECT 'hello world', SUBSTR('hello world', 1,5), SUBSTR('hello world', 7) ;

-- 실습 1.
-- employee 테이블에서
-- 사원들의 이름과, 이메일 주소를 조회하되,
-- 이메일은 아이디 부분만 조회하기.
-- 조회 결과 --
-- 홍길동		hong_gd
SELECT EMP_NAME ,SUBSTR(EMP_ID,1,INSTR(EMP_ID ,'@')) 
FROM EMPLOYEE e;

-- 2. @ 위치찾기
SELECT INSTR(email, '@')
from EMPLOYEE e ;

-- 3. substr
SELECT emp_name '사원', SUBSTR(email, 1, INSTR(email,'@')-1) 'Email'
from EMPLOYEE e ;

-- LPAD / RPAD
-- 빈칸을 지정한 문자로 채우는 함수
SELECT LPAD(email,20,'#'),RPAD(EMAIL,20,'-') from EMPLOYEE e ;

-- ltrim / rtrim
-- 값으로부터 공백을 찾아 지워주는 함수
SELECT LTRIM('      hello');
SELECT RTRIM('      hello');

SELECT LTRIM(RTRIM('     데이트     '));
-- trim
-- 주어진 문자열에서 양끝을 기준으로
-- 특정 문자를 지워주는 함수(기본은 공백을 지운다).
SELECT TRIM('     데이트     ');

-- 양 끝의 특정 문자 지우기
SELECT TRIM('0' FROM '0000012300');

-- leading: 앞에 있는 문자만 찾아 지운다.
SELECT TRIM(LEADING '0' FROM '0000012300'); 
-- trailing: 뒤에서부터 문자를 찾아 지운다.
SELECT TRIM(TRAILING '0' FROM '0000012300'); 

-- concat: 여러 문자열을 하나의 문자열로 합치는 함수
SELECT CONCAT('마이에스큐엘',' 재밌어요 ^_^'); 

-- replace: 주어진 문자열에서 특정 문자를 변경할 때 사용하는 함수
-- replace(주어진 문자열, 대상 문자열, 바꿀 문자열)
SELECT REPLACE ('hello world', 'hello', 'bye');

-- 실습 2.
-- employee 테이블에서
-- 사원의 주민번호를 확인하여
-- 생년, 월, 일을 각각 조회.
SELECT emp_name "이름", 
	CONCAT(SUBSTR(emp_no,1,2), "년") "생년",
	CONCAT(SUBSTR(emp_no,3,2), "월") "생월",
	CONCAT(SUBSTR(emp_no,5,2), "일") "생일"
from EMPLOYEE e ;

-- 실습 3.
-- employee 테이블에서
-- 모든 사원의 사번, 사원명, 이메일, 주민번호를 조회.
-- 이때, 이메일은 '@' 전까지,
-- 주민번호는 7번째 자리 이후 '*' 처리하여 조회!
SELECT EMP_ID "사번", 
	EMP_NAME "사원명", 
	SUBSTR(email, 1, INSTR(email,'@')-1) "이메일",
	RPAD(SUBSTR(emp_no,1,7),14,'*') 주민번호
from EMPLOYEE e; 
-- CONCAT(SUBSTR(EMP_NO , 1, INSTR(EMP_NO ,'-')),'*******') "주민번호"

-- 실습 4.
-- employee 테이블에서 현재 근무하는
-- 여성사원의 사번, 사원명, 직급코드를 조회.
-- ent_yn : 현재 근무 여부 파악하는 컬럼(퇴사 여부)
-- where 절에서도 함수 사용 가능.

SELECT EMP_ID 사번,
	EMP_NAME 사원명,
	JOB_CODE 직급코드,
	ENT_YN "퇴사 여부"
FROM EMPLOYEE e
WHERE ENT_YN = 'n'
	AND SUBSTR(EMP_NO,8,1) = '2'; 

-- 단일 행 함수(Single Row Function) --
-- 결과를 찾아 출력할 때마다 각 행에 함수가 적용

-- 다중 행 함수(Multiple Row Function) --
-- 조건절에 만족하는 모든 행을 다 찾고나서 한번에 연산

-- 그룹 함수(Group Function)
-- sum(), avg(), max(), min(), count()

-- sum(해당 컬럼): 조건에 맞는 row에서 컬럼들의 합
SELECT SUM(salary)
from EMPLOYEE e ;

-- avg(): 평균, max(): 최댓값, min(): 최솟값, count(): 갯수
SELECT AVG(salary), MAX(SALARY), MIN(SALARY), COUNT(SALARY)  
from EMPLOYEE e ;

-- 실습 5.
-- employee 테이블에서
-- '해외영어1부'에 근무하는 모든 사원의 (department)
-- 평균급여, 가장 높은 급여, 낮은 급여, 급여 합계 조회
SELECT AVG(SALARY), MAX(SALARY), MIN(SALARY)  
FROM EMPLOYEE e ,DEPARTMENT d 
WHERE DEPT_CODE ='d5';

-- 에러 발생
SELECT MAX(salary), emp_name from EMPLOYEE e ;

-- count: 행의 개수 
SELECT COUNT(*),
	count(DEPT_CODE), -- (Null 값은 계산하지 않는다)
	COUNT(DISTINCT DEPT_CODE) 
	from EMPLOYEE e;

SELECT DISTINCT dept_code from EMPLOYEE e ;

-- 날짜 처리 함수


-- sysdate(), now(): 현재 컴퓨터의 날짜를 반환하는 함수
SELECT SYSDATE(), NOW();

-- 둘 다 현재 날짜를 반환하지만 현재라고 하는 기준이 조금 다름.
SELECT NOW(), SLEEP(10), SYSDATE(); -- sysdate가 10초 늦다. 
SELECT SYSDATE(), SLEEP(10), NOW();  

-- now()는 쿼리 실행 시점이 현재 / sysdate() 연산이 될 때가 현재

-- 두 날짜 사이의 차
-- datediff(): 단순 일 차이
-- timestampdiff(): 연(year), 주(week), 일(day), 시(hour), 분(minute), 초(second)
-- 					분기(quarter) 등을 지정하여 가져올 
SELECT hire_date,
	DATEDIFF(NOW(), hire_date) "입사 후 일 수"
from EMPLOYEE e ;

SELECT HIRE_DATE ,
	timestampdiff(YEAR, HIRE_DATE, NOW()) "입사 후 년 수"
FROM EMPLOYEE e ;

-- extract(): 지정한 날짜로부터 값을 추출함.
SELECT EXTRACT(YEAR from hire_date), 
	extract(month from hire_date),
	extract(day from hire_date)
from EMPLOYEE e ;

-- date_format(): 날짜 정보 포맷 변경
SELECT HIRE_DATE ,
	DATE_FORMAT(HIRE_DATE, '%Y%m%d%H%i%s'),
	DATE_FORMAT(HIRE_DATE, '%Y/%m/%d/ %H:%i:%s'), 
	DATE_FORMAT(NOW() , '%Y/%m/%d/ %H:%i:%s')
FROM EMPLOYEE e ;

-- str_to_date()
SELECT 20230322, str_to_date('20230322', '%Y%m%d'),
	str_to_date('230322', '%y%m%d');
-- 00~69: 2000년대, 70~99: 1900년대로 계산


-- if() --
-- java의 3항연산자
-- () ? 값1:값2;

-- 현재 근무하는 직원들의 성별을 남, 여로 구분짓기
SELECT emp_name, emp_no,
	IF (SUBSTR(emp_no,8,1)='1','남','여') 성별
from EMPLOYEE e ;

-- 실습 6.
-- employee 테이블에서
-- 모든 직원의 사번, 사원명, 부서코드, 직급코드, 근무여부, 관리자 여부를 조회
-- 만약 근무여부가 'Y'면 퇴사자, 'N'이면 근무자,
-- 		관리자 사번(manager_id)이 있으면 사원, 없으면 관리자
SELECT EMP_ID 사번,
	EMP_NAME 사원명,
	DEPT_CODE 부서코드,
	JOB_CODE 직급코드,
	IF(ENT_YN='Y','퇴사자','근무자') "근무 여부",
	if(IFNULL(MANAGER_ID,0)=0, '관리자','사원') "관리자 여부"
FROM EMPLOYEE e ;

-- case문
-- 자바의 if, switch처럼 사용할 수 있는 함수 표현식

-- 사용방법
-- case
-- 		when (조건식1) then 결과1
-- 		when (조건식2) then 결과2


-- end '별칭'
SELECT EMP_ID 사번,
	EMP_NAME 사원명,
	DEPT_CODE 부서코드,
	JOB_CODE 직급코드,
	CASE 
		when ent_yn='Y' then '퇴사자'
		ELSE '근무자'
	END "근무 여부",
	CASE 
		when manager_id is null then '관리자'
		ELSE '사원'
	END "관리자 여부"
FROM EMPLOYEE e ;


-- 숫자 데이터 함수 --
-- abs(): 절댓값을 표현
SELECT ABS(10), abs(-10); 

-- mod: 컬럼이나 값을 나눈 나머지를 반환하는 함수
SELECT MOD (10,3);
-- round(): 지정한 숫자를 반올림할 때 사용하는 함수
SELECT ROUND(123.456,0),
	ROUND(123.456,1), -- 소숫점 둘째자리 반올림
	ROUND(123.456,2),
	ROUND(123.456,-2); -- 십의 자리 반올림

-- ceil(): 소숫점 첫째자리에서 올
SELECT CEIL (123.456),FLOOR(123.456) ;

-- TRUNCATE(): 지정한 위치까지 숫자를 버리는 함수
select TRUNCATE(123.456,0), truncate(123.456, 1), truncate(123.456, -2); 

-- dayofweek(날짜)
-- 해당 날짜의 요일을 숫자로 구분.
-- 1:일요일 ~ 7:토요일
SELECT DAYOFWEEK(NOW()); 

-- 입사일을 확인하여 무슨 요일인지 조회
SELECT emp_name,
	CASE 
		when dayofweek(hire_date)=1 then '일요일'
		WHEN dayofweek(hire_date)=2 then '월요일'
		WHEN dayofweek(hire_date)=3 then '화요일'
		WHEN dayofweek(hire_date)=4 then '수요일'
		WHEN dayofweek(hire_date)=5 then '목요일'
		WHEN dayofweek(hire_date)=6 then '금요일'
		WHEN dayofweek(hire_date)=7 then '토요일'
	END "요일"
from EMPLOYEE e ;

-- date_add(): 특정 날짜를 기준으로 이후의 날짜
-- date_ sub(): 특정 날짜를 기준으로 이전의 날짜

SELECT EMP_NAME ,HIRE_DATE ,
	DATE_ADD(HIRE_DATE, INTERVAL 1 month),
	DATE_SUB(HIRE_DATE, INTERVAL 1 year) 
from EMPLOYEE e 

-- 실습 7.
-- EMPLOYEE e 테이블에서
-- 근무 년수가 20년 이상인 사원들의
-- 사번, 사원명, 부서코드, 입사일 조회

select EMP_ID 사번, EMP_NAME 사원명, DEPT_CODE 부서코드, HIRE_DATE 입사일
from EMPLOYEE e 
WHERE DATE_ADD(HIRE_DATE,INTERVAL 20 YEAR) <= now(); 

-- 형변환 함수 --
-- date_format(): 날짜 정보를 특정 포맷으로 변경하여 조회
SELECT DATE_FORMAT(NOW(), '%Y/%m/%d'), DATE_FORMAT(NOW(), '%T') ;

-- cast(), convert(): 주어진 값을 원하는 형식으로 변경
-- 숫자를 날짜
SELECT CAST(20230310 as date),CONVERT (20230310,date);
-- 숫자를 문자
SELECT CAST(20230310 as char), CONVERT(20230310, char);
-- 날짜를 문자
SELECT CAST(NOW() as char);


-- SELECT 문의 실행 순서 --
/*
 * 5: select 컬럼명, 계산식, 함수식
 * 1: from 테이블명
 * 2: where 조건
 * 3: group by 그룹을 묶을 컬럼명
 * 4: having 그룹에 대한 조건식, 함수식
 * 6: order by 컬럼|별칭|순서
 */

-- order by 절
-- SELECT를 통해 조회한 행의 결과를 특정 기준에 맞춰 정렬하는 구문
SELECT emp_id, emp_name, salary, dept_code
from EMPLOYEE e
-- order by emp_id;
-- order by EMP_NAME; --기본값은 asc(오름차순)
-- order by DEPT_CODE , EMP_ID DESC;
order by 2;

-- group by --
-- 평균 급여
SELECT TRUNCATE(avg(SALary), -3)
from EMPLOYEE e ;

-- 부서별 평균
SELECT TRUNCATE(avg(salary), -3)
from EMPLOYEE e 
WHERE dept_code = 'd1';

SELECT TRUNCATE(avg(salary), -3)
from EMPLOYEE e 
WHERE dept_code = 'd6';

-- group by 절
-- 특정 컬럼이나 계산식을 하나의 그룹으로 묶어
-- 한 테이블 내에서 소그룹별로 조회하고자할 때 선언하는 구문

SELECT DEPT_CODE, TRUNCATE(avg(salary), -3) 
FROM EMPLOYEE e 
GROUP BY DEPT_CODE 
order by 1;

-- 실습 8.
-- employee 테이블에서
-- 부서별 총인원, 급여 합계, 급여 평균, 최대 급여, 최소 급여
-- 조회하여 부서코드 기준으로 오른차순 정렬.
-- 숫자 데이터는 백의 자리까지 처리(내림처리 truncate)
SELECT DEPT_CODE, 
	COUNT(*), 
	TRUNCATE(avg(salary), -2) "급여 평균",
	sum(salary)"급여 합계",
	max(salary)"최대 급여",
	min(salary) "최소 급여"
FROM EMPLOYEE e 
GROUP BY DEPT_CODE 
order by 1;

-- 실습 9.
-- employee 테이블에서
-- 직급코드 별 보너스를 받는 사원수를 조회하되,
-- 직급코드 순으로 내림차순으로 정렬하여
-- 직급코드, 보너스 받는 사원수를 조회

SELECT job_code, COUNT(bonus)
from EMPLOYEE e 
group by JOB_CODE 
order by 1 desc;

-- 남성직원과 여성직원의 수를 조회
SELECT COUNT(*) "직원 수"
from EMPLOYEE e 
group by SUBSTR(EMP_NO,8,1); 

SELECT DEPT_CODE, JOB_CODE , SUM(salary)
from EMPLOYEE e 
group by DEPT_CODE, JOB_CODE;

SELECT job_code from EMPLOYEE e WHERE DEPT_CODE ='d9';

-- having 구문
-- GROUP BY로 묶은 각 소그룹에 대한 조건을 설정할 때
-- 그룹함수와 함께 사용하는 조건 구문
SELECT DEPT_CODE , AVG(SALARY) 평균 
from EMPLOYEE e 
group by DEPT_CODE
HAVING AVG(SALARY)>3000000;

-- 실습 10.
-- 부서별 그룹의 급여 합계 중 900만원을 초과하는
-- 부서의 코드와 급여 합을 조회
SELECT DEPT_CODE , SUM(SALARY) 합 
from EMPLOYEE e 
group by DEPT_CODE
HAVING SUM(SALARY)>9000000;


-- set operator --










