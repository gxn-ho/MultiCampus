DROP TALBE MYBOARD;

CREATE TABLE MYBOARD(
	MYNO INT auto_increment primary KEY,
	MYNAME VARCHAR(100) not null,
	MYTITLE VARCHAR(2000) not null,
	MYCONTENT VARCHAR(4000) not null,
	MYDATE DATE not NULL
);
insert into MYBOARD VALUES(null, '관리자','게시판 테스트',
'테스트 중입니다.
12345676AB CDE', NOW());
 
select * from MYBOARD;