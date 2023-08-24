drop database if exists jspweb;
create database jspweb;
use jspweb;
#----------------------------------------------------------------------------
# 방문록 테이블
drop table if exists visitlog;
create table visitlog(
	vno 		int auto_increment , 		-- 식별번호( 방문록 번호 ) , 자동번호 부여
    vwriter 	varchar(30) not null,		-- (방문록작성자명) , 공백불가능
    vpw 		varchar(10) not null,		-- (방문록비밀번호) , 공백불가능
    vcontent 	text not null,				-- (방문록 내용 )
    vwritedate 	datetime default now() ,		-- (방문록 작성일/시간) , 생략시 자동날짜/시간 등록
    primary key(vno)
);

select * from visitlog;
insert into visitlog( vwriter , vpw , vcontent ) values( '김근배' , '1234' , '안녕하세요');
# 3. 수정 [ 삭제할 식별자 필수 ]
update visitlog set vcontent = "수정내용" where vno = 6 and vpw = '강사테스트';
# 4. 삭제
delete from visitlog where vno = 7 and vpw = '1234';


#---------------------------------------------------------------
# 가계부 테이블
drop table if exists accountbook;

create table accountbook(
	ano int auto_increment,
    acontent varchar(20) ,
    aprice varchar(20) ,
    adate varchar(20),
    primary key(ano)
);

select * from accountbook;
insert into accountbook(acontent , aprice , adate) values( '가전제품' , '10000' , '2018-10-30');
delete from accountbook where ano = 1;

#----------------------------------------------------------------
# Member 테이블
drop table if exists member;
create table member(
	mno int auto_increment,					-- 식별번호 ( 회원번호 ) , 자동번호
    mid varchar(50) not null unique ,		-- 아이디 , 공백 불가능 , 중복불가
    mpwd varchar(20) not null,				-- 비밀번호 , 공백 불가능
    memail varchar(50) not null unique,		-- 이메일 , 공백 불가능 , 중복불가
    mimg longtext default null,				-- 프로필의 이미지 사진 이름 , 기본값 null
    primary key(mno)						-- pk 회원번호
);
select * from member;
# 1.회원가입
insert into member(mid , mpwd , memail , mimg) values('유재석' , 'a1234' , 'qwe@qwe.com' , 'default.jpg' );
# 2. 아이디중복검사. [ 특정 mid의 아이디로 검색했을 때 존재하면 사용 중인 아이디 o , 없으면 사용 중인 아이디 x ]
select * from member where mid = 'qweqwe';
# select * from member where mid = ?;