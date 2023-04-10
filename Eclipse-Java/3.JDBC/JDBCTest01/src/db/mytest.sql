-- 실행: SQL 블럭 후 ALT + X
DROP TABLE MYTEST;

create table mytest(
	mno int,
	mname varchar(20),
	nickname varchar(20)
);
select * from mytest;


-- Score

drop table score;
create table score(
	name varchar(20) primary key,
	kor int not null,
	eng int not null,
	math int not null
);

insert into score values('lee',100,100,100);
select * from score;












