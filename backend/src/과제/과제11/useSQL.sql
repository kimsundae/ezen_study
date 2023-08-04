#-----------------------------------#
# JDBC와 연결할 DB 선언
drop database if exists sqldb4web;
create database sqldb4web;
use sqldb4web;

drop table if exists member;
create table member(
	mno int auto_increment not null unique,
    mid varchar(30) not null unique,
    mpw varchar(30) not null , -- 중복 허용
    mname varchar(15) not null , -- 중복 허용
    mphone varchar(15)  not null unique , 
    primary key(mno) 
);
select mid from member;

# 1. 회원가입 [ 테이블에 레코드 삽입 ]
insert into member( mid , mpw , mname , mphone ) values ( 'ezen01' , '1234' , '이젠' , '031-444-2222' );

# 2. 로그인 [ 테이블에 값 검색(select) ]
select * from member;					# *[모든필드 뜻] 모든필드의 레코드 검색
select mid from member;					# mid 필드의 레코드만 검색
select mid, mpw from member;			# mid와 mpw필드 검색
select mid, mpw , mname from member;	#[모든필드 뜻] 모든필드의 레코드 검색 
# 1. 로그인할 때 필요한 필드[아이디 , 패스워드] 검색
select mid , mpw from member;	
# 2. 아이디와 패스워드가 일치한 레코드 검색
select mid , mpw from member where mid = 'qwe';						#만약에 mid필드에 'qwe'문자열이 있으면 있는 레코드 검색 
select mid , mpw from member where mid = 'ezen01';					#만약에 mid필드에 'ezen01'문자열이 있으면 있는 레코드 검색 
select mid , mpw from member where mid = 'ezen01' and mpw = '1234';	#만약에 mid필드에 'ezen01'이면서 mpw필드가 '1234'인 문자열이 있으면 있는 레코드 검색 
/*	
	1. 테이블의 필드에 해당하는 레코드 검색
		select 필드명 from 테이블명					: 해당 필드의 레코드 검색
        select 필드명 , 필드명 , 필드명 from 테이블	: 여러개 필드들의 레코드 검색
        select * from 테이블명					: 모든 필드의 레코드 검색
	2. 필드에 조건 추가 			[ where 조건절 ( 필드명 연산자 값 ) ]
		select 필드명 				from 테이블명 where 조건
        select 필드명 , 필드명 , 필드명 	from 테이블명 where 조건
        select * 					from 테이블명 where 조건
    

*/
