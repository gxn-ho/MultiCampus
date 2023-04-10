-- SET OPERATOR --
-- 두 개 이상의 SELECT 한 결과를 합치고 하나는
-- 집합 형태의 결과물로 조회하는 명령어

-- 합집합 -- 
-- UNION 
-- 두 개 이상의 select한 결과(result set)를 구하는 명령어
-- 만약 중복이 있을 경우 중복되는 결과는 1번만 보여준다.
-- UNION ALL
-- 두 개 이상의 select한 결과(result set)를 구하는 명령어
-- 만약 중복이 있을 경우 중복되는 내용도 그대로 조회하여 보여준다.

-- UNION 
SELECT EMP_ID ,EMP_NAME ,DEPT_CODE ,SALARY 
FROM EMPLOYEE e 
WHERE DEPT_CODE = 'd5'
UNION all
SELECT EMP_ID ,EMP_NAME ,DEPT_CODE ,SALARY 
FROM EMPLOYEE e 
WHERE SALARY > 3000000;
-- 컬럼의 개수가 맞지 않으면 오류가 발생


-- JOIN --
-- 두 개 이상의 테이블을 하나로 합쳐 사용하는 명령 구문 / 결과가 왼쪽(컬럼)으로 추가됨
-- (Dept_code를 통해 Department테이블의 정보들을 Employee테이블에 추가)

-- 만약에 'J6'라는 직급을 가진 사원들의 정보와 근무 부서명이 궁금하다.

select EMP_NAME ,JOB_CODE ,DEPT_CODE 
FROM EMPLOYEE e 
WHERE JOB_CODE = 'j6';

SELECT DEPT_ID ,DEPT_TITLE 
FROM DEPARTMENT d 
WHERE DEPT_ID in ('d1','d8');

-- join 활용
-- 두 개의 테이블(employee, department)에서 공통 컬럼의 이름이 다를 경우
select EMP_ID ,EMP_NAME ,DEPT_CODE ,dept_title
FROM EMPLOYEE e 
join DEPARTMENT d on(DEPT_CODE = dept_id);

-- using 활용
-- 두 개의 테이블에서 공통 컬럼의 이름이 같은 경우
SELECT EMP_ID ,EMP_NAME ,EMPLOYEE.JOB_CODE ,job_name
from EMPLOYEE
-- join JOB j using(JOB_CODE);
join job on(employee.job_code = job.job_code);



-- 실습 1.--
-- employee 테이블의 직원 급여 정보와
-- sal_grade의 급여 등급을 합쳐서
-- 사번, 사원명, 급여등급, 등급 기준 최소 급여, 최대 급여를 조회

SELECT EMP_ID ,EMP_NAME ,SAL_LEVEL ,MIN_SAL ,MAX_SAL  
FROM employee
-- join sal_grade on(employee.SAL_LEVEL = sal_grade.SAL_LEVEL);
join sal_grade using(sal_level);

-- 실습 2. --
-- department 테이블의 위치 정보와
-- location 테이블을 조인하여
-- 각 부서별 근무지 위치를 조회.
-- 부서코드, 부서명, 근무지 코드, 근무지 위치
SELECT * FROM department;
SELECT * FROM location;

SELECT *
FROM department
join location on(location_id=LOCAL_CODE);


/* inner join // left join // right join
inner : on과 함께 사용. 조건에 만족하는 데이터만 선택.
left : 첫번째 테이블을 기준으로 두번째 테이블을 조합.
		조건에 만족하지 않는 경우에는 첫번째 테이블의 필드값은 그대로 유지.
		두번째 테이블은 모두 Null로 표시. 
right : 두번째 테이블을 기준으로 첫번째 테이블을 조합.
		조건에 만족하지 않는 경우에는 두번째 테이블의 필드값은 그대로 유지.
		첫번째 테이블은 모두 Null로 표시.
*/


select DISTINCT dept_code, dept_title
from employee
inner join department on(DEPT_CODE = dept_id);

SELECT DISTINCT dept_code, dept_title
from employee, department
WHERE DEPT_CODE = dept_id;


-- left join --
select dept_code,emp_name,dept_title
from employee
left join department on(dept_code=DEPT_ID);

-- right join --
select dept_code, dept_id, EMP_NAME _name
from employee
right join department on(DEPT_CODE = dept_id);


-- inner / outer(left, right)

-- on() 안에 컬럼 뿐만 아니라 계산식, 함수식, and, or 등의 표현식 사용 가능
SELECT emp_name, dept_code, salary, e.sal_level
from employee e
join sal_grade s on(salary BETWEEN MIN_SAL and MAX_SAL);

/* self join
 * 자기 자신을 조인. 한 테이블의 정보 중 값 비교가 필요한 정보들을 계산 조회하는 방식
 * 직원의 정보(emp)와 직원을 관리하는 매니저(emp)의 정보를 조회.*/
select * FROM employee;

SELECT e.EMP_ID "사번", 
	e.EMP_NAME "사원명", 
	e.MANAGER_ID "관리자 사번", 
	m.emp_name "관리자명"
from employee e
join employee m on(e.MANAGER_ID=m.EMP_ID);


-- 다중 join --
-- 여러 개의 테이블을 join 하는 것
-- 일반 조인과 선언 방식은 같으나, 앞서 조인한 결과를 기준으로
-- 나중에 조인하는 테이블을 연결 짓는다.
-- 조인 순서에 주의.;

SELECT EMP_NAME ,dept_title, local_name
FROM employee e
join department on(DEPT_CODE=dept_id)
join location on(location_id=LOCAL_CODE);


-- 실습 3. 
-- 한국(KO)과 일본(JP)에 근무하는 직원들의 정보 조회.
-- 사원명, 부서명, 지역명, 국가명
-- employee, department, location, national
SELECT EMP_NAME 사원명, dept_title 부서명, LOCAL_name 지역명, national_name 국가
FROM employee e
join department d on(DEPT_CODE=dept_id)
join location l on(location_id = local_code)
join national n on(l.national_code = n.NATIONAL_CODE)
WHERE NATIONAL_name in('한국','일본');


-- sub query --
-- 주과 되는 메인쿼리 안에서
-- 조건이나 검색을 위해 또 하나의 쿼리를 추가하는 기법

-- 단일 행 서브쿼리 : 결과 값이 1개 나오는 서브쿼리

-- ex) 최소 급여를 받는 사원의 정보 조회
SELECT min(salary)
from EMPLOYEE e 

select *
FROM EMPLOYEE e 
where salary = (SELECT min(SALARY) from EMPLOYEE e2 );

-- 다중 행 서브쿼리
-- 결과 값이 여러 줄 나오는 서브쿼리

-- 각 직급별 최소 급여 받는 사원의 정보
SELECT JOB_CODE ,MIN(salary)
from EMPLOYEE e 
group by JOB_CODE ;


SELECT *
FROM EMPLOYEE e 
WHERE SALARY IN (SELECT MIN(SALARY) from EMPLOYEE e2 group by JOB_CODE);


-- 다중 행 다중 열 서브쿼리를 사용하여 결과 조회.
SELECT JOB_CODE ,min(SALARY)
FROM EMPLOYEE e 
group by JOB_CODE ;


SELECT *
FROM EMPLOYEE e 
WHERE (JOB_CODE ,SALARY) IN (SELECT JOB_CODE ,MIN(SALARY) from EMPLOYEE e2 group by JOB_CODE);


-- 서브쿼리의 사용 위치
-- SELECT ,FROM ,WHERE ,GROUP BY ,HAVING ,ORDER by,JOIN 
-- dml : insert, update, delete
-- ddl : create table, create view ...

	
-- inline view(인라인뷰)
-- from 위치에 사용되는 서브쿼리
-- 테이블을 테이블명으로 직접 조회를 하는 대신
-- 서브쿼리의 결과(result set)을 활용하여 데이터 조회.
-- 기존의 테이블을 대체한다.

SELECT EMP_ID ,EMP_NAME ,dept_title, job_name
FROM EMPLOYEE e 
join DEPARTMENT d on (DEPT_CODE=dept_id)
JOIN JOB j on(e.JOB_CODE=j.JOB_CODE);

SELECT *
FROM (SELECT EMP_ID ,EMP_NAME ,dept_title, job_name
FROM EMPLOYEE e 
join DEPARTMENT d on (DEPT_CODE=dept_id)
JOIN JOB j on(e.JOB_CODE=j.JOB_CODE)
	) A;



-- rank() 함수 / dense_rank()	 함수
-- rank() : 동일한 순번이 있을 경우 이후 순번은 이전과
-- 			동일한 순번의 개수만큼 건너뛰고 번호를 매기는 함수이다.

-- 1
-- 2
-- 2
-- 4

SELECT emp_name, salary, RANK () over(order by salary desc) 순위
from EMPLOYEE e 
WHERE 순위 <4 ;
-- 오류/ 1.from 2.where 3.select 순으로 진행되기때문에 순위 테이블이 생성되지 않은 상태라 조건을 못 적용

SELECT *
FROM (SELECT emp_name, 
			salary, 
			RANK () over(order by salary desc) 순위
			from EMPLOYEE e) a
WHERE 순위 <4 ;

-- dense_rank(): 동일한 순번이 있을 경우 이후 순번에는 영향을 미치지 않는 함수
-- 1
-- 2
-- 2
-- 3
SELECT emp_name,
		salary,
		DENSE_RANK () over(order by salary desc) 순위
from EMPLOYEE e ;

-- row_number(): 동일 순번은 무시, 그냥 넘버링
SELECT emp_name,
		salary,
		ROW_NUMBER  () over(order by salary desc) 순위
from EMPLOYEE e ;


-- 실습 4.
-- 부서별 급여 합계가 전체 부서 급여 총합의
-- 20%보다 많은 부서의 부서명과 부서별 급여 합계를 조회.
SELECT sum(salary) * 0.2
from EMPLOYEE e ;

/*SELECT emp_name ,SUM(salary) 
FROM (select emp_name, salary, RANK() over(ORDER by salary desc) 순위 from EMPLOYEE e ) a
WHERE  순위> sum(salary) * 0.2
GROUP BY salary;*/

-- 인라인뷰
SELECT dept_code, SUM(salary) sumsal
from EMPLOYEE e 
group by DEPT_CODE ;


SELECT *
FROM (
		SELECT dept_code, SUM(salary) sumsal
		from EMPLOYEE e 
		group by DEPT_CODE
	) A
where sumsal > (SELECT sum(salary)*0.2 from EMPLOYEE e2 );


SELECT DEPT_CODE ,SUM(SALARY) sumsal 
FROM EMPLOYEE e 
group by DEPT_CODE 
having sum(SALARY) > (SELECT sum(SALARY)*0.2 from EMPLOYEE e2 );

-- 상호 연관 쿼리: 상관 쿼리
-- 일반적으로 서브쿼리는 서브쿼리대로, 메인쿼리는 서브쿼리의 결과만 받아서 실행 방식.
-- 메인쿼리가 사용하는 컬럼값, 계산식 등을 서브쿼리에 적용.
-- 서브쿼리 실행 시 메인쿼리의 값도 함께 사용하는 방식

-- 사원의 직급에 따른 급여 평균보다 많이 받는 사원 정보 조회
SELECT JOB_CODE ,TRUNCATE(avg(salary), -3) 
FROM EMPLOYEE e
group by JOB_CODE ;

SELECT EMP_ID ,EMP_NAME ,JOB_CODE ,SALARY 
FROM EMPLOYEE e 
WHERE SALARY > (
				SELECT AVG(salary)
				from EMPLOYEE e2 
				WHERE e.JOB_CODE/*메인*/ =e2.JOB_CODE/*서브*/ 
);


-- 스칼라 서브쿼리 : 상관쿼리 + 단일 행 (보통 select에 많이 사용하여 select list라고도 부른다.)
-- 모든 사원의 사번, 사원명, 관리자 사번, 관리자명을 조회.
-- 관리자가 없을 경우 '없음'이라고 표시
select emp_id, emp_name, manager_id,IFNULL((SELECT emp_name from EMPLOYEE e2 where e.MANAGER_ID=e2.EMP_ID),'없음') "관리자 이름"
from EMPLOYEE e ;


-- ddl: CREATE 
/*
 * create: 데이터베이스의 객체를 생성하는 ddl (database, table, view ...)
 * [사용 형식]
 * create 객체종류 객체명 (관련 내용)
 * 
 * -- 테이블 생성 시
 * create table test(
 *  컬럼명 자료형(길이) 제약조건
 * );
 * 
 * 제약조건: 테이블에 데이터를 저장하고자할 때 지켜야하는 규칙
 * 	not null - null값을 허용하지 않는다.(필수 입력 사항)
 * 	unique - 중복 값을 허용하지 않는다.
 * 	check - 지정한 입력 사항 외에는 받지 못하게 하는 조건
 * 	primary key - (not null + unique)
 * 			테이블 내에서 해당 행(row)를 인식하 수 있는 고유한 값.
 * 			테이블에서 단 1개만 설정 가능
 * 	foreign key - 다른 테이블에서 저장된 값을 연결 지어서
 * 				참조로 가져오는 데이터를 지정하는 제약 조건
 * 
 */


-- 테이블 생성 --
-- 테이블 : 데이터를 저장하기 위한 틀, 2차원 표 형태로 데이터들을 담을 수 있는 객체.
DROP table member; -- 테이블 삭제
CREATE table member(
	member_no int, member_id varchar(20), member_pwd varchar(30), member_name varchar(15) comment '회원이름'
);

select * FROM member ;

show full columns from `member` ;

SELECT table_name, table_comment
from information_schema.tables
where table_name = 'member';

-- 테이블 정보 수정(주석 달기)
ALTER table `member` comment = '회원';
ALTER table `member` modify member_no int comment '회원번호';

show full columns from `member` ;


-- 제약조건
-- not null
-- 'null값을 허용하지 않는다.'
-- 해당 제약조건을 등록한 컬럼에 반드시 값을 기록해야 하는 경우
-- 데이터를 INSERT /UPDATE /DELETE Null값 고려
drop table user_notcons;
CREATE table user_notcons(
	user_no int,
	user_id varchar(20),
	user_pwd varchar(30),
	user_name varchar(15),
	gender varchar(3),
	phone varchar(14),
	email varchar(30)
);

SELECT * FROM user_notcons ;

-- 테이블에 값 추가
-- dml : INSERT
INSERT into user_notcons values(1,'user01','pass01','정건호','남','010-1234-5678','vicd123@naver.com');
INSERT into user_notcons values(2, null,null,null,'여',null,null);


-- not null 제약조건 추가
CREATE table user_not_null(
	user_no int not null,	-- 컬럼 레벨 제약조건 등록
	user_id varchar(20) not null,
	user_pwd varchar(30) not null,
	user_name varchar(15) not null,
	gender varchar(3),
	phone varchar(14),
	email varchar(30)
);

SELECT * from user_not_null ;
INSERT into user_not_null values(1,'user01','pass01','정건호','남','010-1234-5678','vicd123@naver.com');
INSERT into user_not_null values(2, 'user02',null,null,'여',null,null);

-- not null 추가(user_not_null 테이블을 수정)
ALTER table user_not_null modify column gender varchar(3) not null;

desc user_not_null ;


-- unique 제약조건 --
-- 중복을 허용하지 않는 제약조건

CREATE table user_unique(
	user_no int,
	user_id varchar(20) unique, -- 컬럼 레벨 제약 조건
	user_pwd varchar(30),
	user_name varchar(15),
	gender varchar(3),
	phone varchar(13),
	email varchar(30)
);

SELECT * from user_unique ;

INSERT into user_unique values(1,'user01','pass01','정건호','남','010-1234-5678','vicd123@naver.com');
INSERT into user_unique values(1,'user01','pass01','정건호','남','010-1234-5678','vicd123@naver.com');
-- SQL Error [1062] [23000]: Duplicate entry 'user01' for key 'user_unique.user_id'
-- 중복되서 에러 발생


-- 테이블 레벨에서 제약조건 설정하기
CREATE table user_unique2(
	user_no int,
	user_id varchar(20),
	user_pwd varchar(30),
	user_name varchar(15),
	gender varchar(3),
	phone varchar(13),
	email varchar(30),
	unique(user_id)
);
-- 컬럼이 모두 작성된 후에 별도로 작성하는 제약조건을 테이블 레벨 제약조건이라고 한다.

SELECT * FROM user_unique2;


-- unique 제약조건을 여러 컬럼에 적용하기
-- 두개 이상의 컬럼을 제약조건으로 묶을 경우
-- 반드시 테이블 레벨에서 제약조건을 선언해야 한다.
CREATE table user_unique3(
	no int,
	id varchar(20),
	pw varchar(30),
	name varchar(15),
	unique(no,id)
);

INSERT into user_unique3 values(1,'user01','pass01','정건호');
SELECT * FROM user_unique3;
INSERT into user_unique3 values(1,'user02','pass01','정건호');


-- check 제약조건
-- 컬럼에 값을 기록할 때 지정한 값 이외에는 값이 기록되지 않도록 범위를 제한하는 조


CREATE table user_check(
	no int,
	id varchar(20),
	pw varchar(30),
	name varchar(15),
	-- gender varchar(3) check(gender in ('남','여')) -- 컬럼 레벨
	gender varchar(3),
	constraint usercheck_gender_ck check(gender in('남','여'))
);

SELECT * from user_check ;

INSERT into user_check 
values(1,'user01','pass01','정건호','남');

INSERT into user_check 
value(2,'user02','pass02','정이','여');

SELECT * FROM information_schema.table_constraints WHERE table_name='user_check';

-- check 제약조건에 부등호 표기하기
CREATE table user_check2(
	test_data int,
	constraint ck_testdata check(test_data > 0)
);

INSERT into user_check2 values(10);

INSERT into user_check2 values(-10);
-- SQL Error [3819] [HY000]: Check constraint 'ck_testdata' is violated.


CREATE table user_check3(
	c_name varchar(15),
	c_price int,
	c_date date,
	c_qual varchar(1),
	constraint ck_usercheck3_price check(c_price between 1 and 99999)
);

insert into user_check3 values('정건호',2,now(),'B');

SELECT * FROM user_check3 ;

CREATE table test_multi_cons(
	no1 int not null unique,
	no2 int not null,
	check(no2>0),
	unique(no2)
);

SELECT * FROM test_multi_cons ;


-- primary key 제약조건 --
-- '기본키 제약조건'
-- 테이블 내에서 행을 식별하기 위한 고유값을 가지는 컬럼에 부여하는 제약조건.
-- not null과 unique 제약조건이 함께 걸린다.
-- 테이블 전체에 대한 각 로우별 식별자 역할을 수행시키는 제약조건이다.
-- 반드시 값이 들어가고, 중복이 없어야 한다.
-- 기본키 제약조건은 각 테이블마다 한개 존재해야 한다.
-- primary key 제약조건은 한 컬럼에 적용 가능하고, 여러 컬럼 묶어서도 적용 가능하다.

CREATE table USER_PK_TABLE(
	USER_NO INT primary key,
	USER_ID VARCHAR(20) unique,
	USER_PW VARCHAR(30) not null,
	USER_NAME VARCHAR(15) not null,
	GENDER VARCHAR(3) CHECK(GENDER in('남','여'))
);

desc USER_PK_TABLE ;

insert into USER_PK_TABLE values(1,'user01','pass01','lee','남');
insert into USER_PK_TABLE values(2,'user02','pass02','jung','여');
insert into USER_PK_TABLE values(1,'user03','pass03','hong','여');

SELECT * FROM USER_PK_TABLE ;


-- 기본키 제약조건을 여러 컬럼에 적용하기
CREATE table USER_PK_TABLE2(
	USER_NO INT,
	USER_ID VARCHAR(20) unique,
	USER_PW VARCHAR(30) not null,
	USER_NAME VARCHAR(15) not null,
	GENDER VARCHAR(3) CHECK(GENDER in('남','여')),
	constraint PK_USER_NO primary KEY(USER_NO, USER_ID)
);

-- 1, user01 -- 성공
-- 2, user02 -- 성공
-- 1, user03 -- 성공
-- 2, user01 -- 실패! (user_id는 unique이기때문에 1, user01과 중복되서 에러 발생함)

-- CREATE 생성, drop 삭제
DROP table member;

CREATE table MEMBER(
	M_NO INT,
	M_ID VARCHAR(15) not null,
	M_PW VARCHAR(30) not null,
	M_NAME VARCHAR(15),
	M_GENDER VARCHAR(1),
	M_EMAIL VARCHAR(30),
	M_PHONE VARCHAR(14),
	M_BIRTH DATE,
	constraint PK_MEMBER_MNO primary KEY(M_NO),
	constraint UK_MEMBER_MID UNIQUE(M_ID),
	constraint CK_MEMBER_MGENDER CHECK(M_GENDER in('M','F'))
);






