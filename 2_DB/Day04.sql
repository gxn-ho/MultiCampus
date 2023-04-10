-- FOREIGN KEY
-- 외래키, 외부키, 참조키
-- 다른 테이블의 컬럼값을 참조(Reference)하여 참조하는 테이블의 값만 허용한다.
-- FOREIGN KEY 제약조건을 통해서 다른 테이블과의 관계가 형성된다.
DROP table user_foreign_key;
create table USER_GRADE(
	GRADE_CODE INT primary key,
	GRADE_NAME VARCHAR(100) not null
);

INSERT into USER_GRADE VALUES(1, '일반 회원');
INSERT into USER_GRADE VALUES(2, 'VIP');
INSERT into USER_GRADE VALUES(3, 'VVIP');
INSERT into USER_GRADE VALUES(4, 'VVVIP');

SELECT * FROM USER_GRADE ;


CREATE table user_foreign_key(
	USER_NO INT primary key,
	USER_ID VARCHAR(20),
	USER_PW VARCHAR(20),
	USER_NAME VARCHAR(15),
	GENDER VARCHAR(1) CHECK(GENDER in('M','F')),
	GRADE_CODE INT,
	constraint FK_GRADE_CODE foreign key (GRADE_CODE) references USER_GRADE(GRADE_CODE)
);

INSERT into user_foreign_key values(1,'123','321','정건호','M',1);
INSERT into user_foreign_key values(2,'456','654','박현주','F',2);
INSERT into user_foreign_key values(3,'789','987','최시우','F',3);
INSERT into user_foreign_key values(4,'012','210','손동준','M',3);
INSERT into user_foreign_key values(5,'345','543','박문수','M',4);
INSERT into user_foreign_key values(6,'678','876','이세광','M',4);
SELECT * FROM user_foreign_key ;

INSERT into user_foreign_key values(6,'876','876','배상혁','M',10);
-- SQL Error [1452] [23000]: Cannot add or update a child row: a foreign key constraint fails 
-- (`multi`.`user_foreign_key`, CONSTRAINT `FK_GRADE_CODE` FOREIGN KEY (`GRADE_CODE`) REFERENCES `user_grad` (`GRADE_CODE`))
-- 외래키로 지정된 GRAD_CODE는 참조하는 user_grad 테이블의 grade_code에 있는 데이터만 insert 가능하다.

select *
FROM user_foreign_key 
join user_grad using(grade_code);


-- user_grad 테이블에 저장된 데이터들 중에 grade_code가 4인 데이터 삭제
-- dml: DELETE 
delete from USER_GRADE 
WHERE grade_code=4;

SELECT * FROM user_grad;
SELECT * from user_foreign_key ;

-- foreign key 삭제 옵션
-- 일반적으로 참조되는 원본 컬럼 내용을 삭제하려고 할 때
-- 외래키로 사용 중인 자식 컬럼(user_foreign_key.grad_code)이 있다면 함부로 삭제할 수 없다.
-- 참조되고 있는 원본 테이블의 컬럼값이 삭제될 때
-- 참조하는 값을 어떻게 처리할 것인지 설정하는 옵션.

-- ON DELETE CASCADE: 부모 컬럼 삭제할 때 참조된 자식도 함께 삭제
-- ON UPDATE CASCADE: 부모 컬럼 수정할 때 참조된 자식도 함께 수정

drop table user_foreign_key ;

CREATE table user_foreign_key(
	USER_NO INT primary key,
	USER_ID VARCHAR(20),
	USER_PW VARCHAR(20),
	USER_NAME VARCHAR(15),
	GENDER VARCHAR(1) CHECK(GENDER in('M','F')),
	GRADE_CODE INT,
	constraint FK_GRADE_CODE foreign key (GRADE_CODE) 
	references USER_GRAD(GRADE_CODE) on DELETE CASCADE
);

INSERT into user_foreign_key values(1,'123','321','정건호','M',4);
INSERT into user_foreign_key values(2,'456','654','박현주','F',3);
INSERT into user_foreign_key values(3,'789','987','최시우','F',2);
INSERT into user_foreign_key values(4,'012','210','손동준','M',2);
INSERT into user_foreign_key values(5,'345','543','박문수','M',3);
INSERT into user_foreign_key values(6,'678','876','이세광','M',4);

SELECT * from USER_GRAD ;
SELECT * FROM user_foreign_key ;

DELETE FROM USER_GRAD 
WHERE grade_code = 2;


-- dml(데이터 조작언어) --
-- INSERT ,UPDATE ,DELETE, SELECT(DQL)
-- [CRUD]
-- c (create)	: imsert / 데이터 추가
-- r (read)		: select / 데이터 조회
-- u (update)	: update / 데이터 수정
-- d (delete)	: delete / 데이터 삭제

-- insert : 새로운 행을 특정 테이블에 추가하는 명령어,
-- 			해당 명령어 실행 후에는 테이블 행의 개수가 증가.

-- [사용형]
-- 1. 특정 컬럼에 값을 추가
-- 		insert into 테이블명(컬럼, 컬럼, ...) values(값, 값, ...);
-- 2. 모든 컬럼에 값을 추가
-- 		insert into 테이블명 values(값, 값, ...);

desc EMPLOYEE ;
-- 컬럼 명시
insert into EMPLOYEE (emp_id, EMP_NAME,EMP_NO,EMAIL,PHONE,DEPT_CODE,JOB_CODE,SAL_LEVEL,
						SALARY,BONUS,MANAGER_ID,HIRE_DATE,ENT_DATE,ENT_YN)
values(500,'정건호','970307-1234567','gxnho@naver.com','01012345678','a1','j7','s4',3199999,0.1,'200',now(),null,default);

select * FROM EMPLOYEE e WHERE EMP_ID = 500;


-- 컬럼 생략
INSERT into EMPLOYEE 
values(900,'양승현','900101-1234567','jfeiawj@naver.com','01022223333','d1','j3','s3',4300000,0.2,'200',now(),null,default);

select * FROM EMPLOYEE e WHERE EMP_ID in (500,900);


-- INSERT _ subquery
-- INSERT 문에 서브쿼리를 사용하여 values에 작성하던 값 대신 저장하여 추가 가능하다.

CREATE table emp_01(
	emp_id int,
	emp_name varchar(20),
	dept_title varchar(40)
	
);

/* SELECT emp_id,emp_name, dept_title
from EMPLOYEE e 
left join DEPARTMENT d on(DEPT_CODE=dept_id); */

INSERT into emp_01();
	SELECT emp_id,emp_name, dept_title
	from EMPLOYEE e 
	left join DEPARTMENT d on(DEPT_CODE=dept_id
);

SELECT * FROM emp_01;

CREATE table TEST0101
as select EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
	from EMPLOYEE e ;

SELECT * FROM test0101;


-- UPDATE : 해당 테이블의 데이터를 수정하는 명령어
-- update 테이블명 set 컬럼명 = 바꿀 값 [where 조건식]
-- update 실행 후 데이터의 개수는 변하지 않는다.
create table DEPT_COPY
as select * FROM DEPARTMENT d ;

SELECT * from DEPT_COPY ;

-- d9부서를 총무부에서 -> 미래사업부
UPDATE DEPT_COPY set DEPT_TITLE = '미래사업부'
WHERE DEPT_ID = 'D9';


-- 실습 1.
-- employee 테이블에서 주민번호가 잘못 표기되어 있는 사원들이 있다.
-- 해당 사원을 찾아 사번 순으로 각 주민번호 앞자리를
-- '621230','631126','850705'로 변경하는 UPDATE 구문 작성

select emp_id, emp_no from EMPLOYEE e ;
-- 200, 201, 214

UPDATE EMPLOYEE set emp_no = CONCAT('621230',SUBSTR(emp_no,7))
WHERE emp_id = '200';

UPDATE EMPLOYEE set emp_no = CONCAT('631126',SUBSTR(emp_no,7))
WHERE emp_id = '201';

UPDATE EMPLOYEE set emp_no = CONCAT('850705',SUBSTR(emp_no,7))
WHERE emp_id = '214';



-- UPDATE + SUBQUERY
-- 여러 행을 변경하거나, 여러 컬럼의 값을 변경하고자 할 때, 서브쿼리를 사용하여 UPDATE문 작성 가능.
-- SET 컬럼 = (서브쿼리)

CREATE TABLE emp_salary
as
select EMP_ID ,EMP_NAME ,DEPT_CODE ,SALARY ,BONUS 
from EMPLOYEE e ;

SELECT * FROM emp_salary;

SELECT * FROM emp_salary where emp_name in('유재식','방명수');

UPDATE emp_salary
set salary = (SELECT salary from EMPLOYEE where emp_name='유재식'),
	bonus = (SELECT bonus from EMPLOYEE WHERE emp_name='유재식')
	WHERE emp_name = '방명수';

-- 
/* UPDATE emp_salary
set (salary, bonus) = (SELECT salary, bonus from emp_salary where emp_name = '유재식')
where emp_name in('노옹철','전형돈','정중하','하동운'); */


-- UPDATE 할 때도 변경할 값이 해당 컬럼의 제약조건을 위배하지 않아야 한다.
desc user_foreign_key ;

UPDATE user_foreign_key 
set grade_code = 10
where grade_code =1;


-- DELETE --
-- 테이블의 행을 삭제하는 명령어
-- 실행 후에는 테이블의 행의 개수가 줄어든다

create table test_delete
as select * FROM EMPLOYEE e ;

SELECT * FROM test_delete;

commit;

-- 데이터 전체 삭제
DELETE FROM test_delete;
SELECT * FROM test_delete;


rollback;
SELECT * FROM test_delete;

-- 선택 삭제
commit;

DELETE FROM test_delete
WHERE emp_id in(200,201);

SELECT * FROM test_delete;

rollback;
SELECT * FROM test_delete;

-- DCL --
-- commit, rollback --> tcl(transaction control language)

-- 트랜잭션 -- 
-- 정의: 데이터를 처리하는 작업을 잘게 나눈 데이터처리의 최소 단위
-- 하나의 트랜잭션으로 이루어진 작업 내용은 전체 성공(저장) or 하나라도 실패하면 전체 실패(복구)
-- 각각의 작업마다 저장시점을 구분해서 COMMIT(작업 내역 저장/반영) / ROLLBACK(작업 내역 취소)

commit;

CREATE table user_tb(
	no INT unique,
	ID VARCHAR(20) not null unique,
	PW VARCHAR(20) not Null
);

INSERT into user_tb values(1, 'test01', 'pass01');
INSERT into user_tb values(2, 'test02', 'pass02');
SELECT * FROM user_tb;

commit; -- 현재까지 작업한 DML(insert 두번) 내용을 DB에 반영(저장)

INSERT into user_tb values(3,'test03','pass03');

SELECT * from user_tb;

rollback; -- 가장 최근에 commit 했던 구간으로 되돌아 가겠따.

SELECT * from user_tb;

INSERT into user_tb values(3,'test03','pass03');

savepoint sp1;

INSERT into user_tb values(4,'test04','pass04');

SELECT * from user_tb;

rollback to sp1; -- 해당 savepoint로 되돌아 가겠다.


-- ALTER: 생성한 객체를(table, view ...) 수정할 때 
drop table dept_copy;
create table dept_copy
as select * from department;

SELECT * from dept_copy;

-- 컬럼을 추가하기 
ALTER table dept_copy add lname varchar(20);

-- 컬럼을 삭제하기
ALTER table dept_copy drop column lname;

desc dept_copy;

-- 컬럼 추가(기본값 적용)
alter table dept_copy add lname varchar(20) default '한국';
SELECT * from dept_copy;

-- 제약조건 추가
alter table dept_copy add constraint pk_dept_cp primary key(dept_id);

ALTER table dept_copy modify dept_id varchar(30);
desc dept_copy;

-- 테이블 이름 변경
ALTER table dept_copy
rename to deptcopy;

SELECT * from deptcopy;

-- DROP --
-- 객체의 특정 요소를 제거하거나 객체 자체를 제거할 때 사용하는 명령어.
-- 1. 객체의 특정 요소를 제거
-- ALTER 객체 객체명
-- DROP column 컬럼명

-- 2. 객체 자체를 제거
-- drop 객체 객체명;

drop table deptcopy;

-- view(뷰) --
-- select를 실행한 결과 화면을 담는 객체
-- select 문장 자체를 저장.
-- 호출할 때마다 저장된 쿼리를 실행하여 결과를 보여주는 객체다.

-- 실질적으로 데이터를 담고 있지 않다.
-- 보통 노출하고 싶지 않은 정보나, 업무에 불필요한 정보를 제외한
-- 필요 정보들만 조회하고자 할 때 사용한다.

-- create [or replace] view 뷰 이름
-- as 서브쿼리(뷰에 저장하여 확인할 select 쿼리)

create or REPLACE view v_emp
as select emp_id, emp_name, dept_code from employee;

SELECT * FROM v_emp ;

CREATE or replace view v_emp(사번,사원명,부서,직급)
as select emp_id, emp_name, dept_code, job_code from employee;

drop view v_emp;


-- 
CREATE or REPLACE view v_result_emp(사번,이름,직급명,부서명,근무지)
as select emp_id, emp_name, job_name,dept_title, local_name
from employee
LEFT join job using(job_code)
LEFT join department on(DEPT_CODE=dept_id)
LEFT join location on(location_id=local_code);

SELECT * FROM v_result_emp ;


-- view는 SELECT  쿼리를 저장하고 있기에
-- 원본이 변경되었을 때 뷰도 함께 변경해서 조회 가능하다.
UPDATE employee
set emp_name='정중앙'
where EMP_ID = '205';

SELECT * from employee;
commit;

-- 뷰에는 연산 결과를 포함한 SELECT문 저장 가능하다.
create or REPLACE view v_emp
as SELECT EMP_ID 이름,EMP_NAME 사원명,EMP_NO 성별
from employee;

SELECT emp_id, emp_name, if(substr(emp_no, 8, 1)=1,'남성','여성')
from employee;

SELECT * FROM v_emp;

-- 뷰에 데이터 삽입, 수정, 삭제하기
CREATE or REPLACE VIEW v_job
as select job_code, job_name
from job;


select * FROM v_job;


-- 뷰를 통해 데이터 추가
insert into V_job values('J8','인턴');

-- 수정
UPDATE v_job
set job_name = '알바'
WHERE job_code = 'j8';

SELECT * FROM v_job;
SELECT * FROM job;


-- 삭제
DELETE FROM v_job
WHERE job_code = 'j8';

SELECT job_code from v_job;


-- auto_increment
-- INSERT 할 때 자동으로 키를 1씩 증가.

CREATE table at_test(
	id int auto_increment primary key,
	name varchar(30)
);

INSERT into at_test values(2,'정건호');
INSERT into at_test values(null, '유관순');
INSERT into at_test values(null, '박문수');
INSERT into at_test values(null, '배상혁');
INSERT into at_test(name) values('유관순');
SELECT * FROM at_test;













