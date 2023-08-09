/*----------------*/
drop database if exists sqldb5web;
create database sqldb5web;
use sqldb5web;
drop table if exists table1;
create table table1( 데이터1 int , 데이터2 varchar(100) ) ; 

# CRUD : 
# 1. insert [ C : create ]
	# insert into 테이블명 ( 필드명 , 필드명 ) values( 값1 , 값2 )
insert into table1( 데이터1 , 데이터2 ) values( 1, '유재석');
insert into table1( 데이터1, 데이터2 ) values( 2, '강호동' );

# 2. select [ R : reading ] 로그인 , 아이디찾기 , 비밀번호찾기 , 글목록 , 글조회 , 제품조회 , 주문현황 , 검색 등등
	# select 필드명 from 테이블명
    # select 필드명 from 테이블명 where 조건절
select * from table1;							# 모든 레코드 검색 [ 모든필드 표시 ]
select * from table1 where 데이터2 = '강호동';		# 데이터2 필드의 값이 '강호동'인 레코드 검색 [ 모든 필드 표시 ]
    
# 3. update [ U : update ]
	# update 테이블명 set 필드명 = 수정값 , 필드명 = 수정값
    # update 테이블명 set 필드명 = 수정값 , 필드명 = 수정값 where 조건절
update table1 set 데이터1 = 3;	# 메뉴 -> edit -> Preferences -> sql editor -> 하단 -> safe updates	[ update , delete 사용시 ]
update table1 set 데이터1 = 2 where 데이터2 = '유재석'; # 데이터2 필드의 값이 '유재석' 이면 데이터1 필드의 값을 2로 변경

# 4. delete [ D : delete ]
	# delete from 테이블명
    # delete from 테이블명 where 조건절
delete from table1; # 모든 레코드를 삭제
delete from table1 where 데이터2 = '유재석'; #데이터2 필드의 값이 '유재석'인 레코드 삭제

/*--------------------------*/ 

