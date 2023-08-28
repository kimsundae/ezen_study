drop database if exists jspweb;
create database jspweb;
use jspweb;
set SQL_SAFE_UPDATES = 0;


drop table if exists visitlog;
create table visitlog(
   vno       int auto_increment ,       -- 식별번호( 방문록 번호 ) , 자동번호 부여
    vwriter    varchar(30) not null,      -- (방문록작성자명) , 공백불가능
    vpw       varchar(10) not null,      -- (방문록비밀번호) , 공백불가능
    vcontent    text not null,            -- (방문록 내용 )
    vwritedate    datetime default now() ,      -- (방문록 작성일/시간) , 생략시 자동날짜/시간 등록
    primary key(vno)
);

insert into visitlog( vwriter , vpw , vcontent ) values( '김근배' , '1234' , '안녕하세요');
select * from visitlog;
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

insert into accountbook(acontent , aprice , adate) values( '가전제품' , '10000' , '2018-10-30');
select * from accountbook;

delete from accountbook where ano = 1;

#----------------------------------------------------------------
# Member 테이블
drop table if exists member;
create table member(
   mno int auto_increment,
    mid varchar(20) ,
    mpwd varchar(20) ,
    memail varchar(20) ,
    mimg longtext ,
    primary key(mno)
);
select * from member;
#--------------------------------------------------------------
drop table if exists seat;
create table seat (
   lseatno int not null,               # 식별번호 프라이머리키
    lisuse boolean default false,         # 사용여부 기본값 false
    primary key(lseatno)
    );
# library 테이블
# library
drop table if exists library;
create table library (
   lno int auto_increment,               # 식별번호 자동번호 프라이머리키
    lname varchar(15) not null,            # 사용자이름
    lphone varchar(13) not null ,      # 사용자전화번호 중복금지
    lseatno int not null,               # 좌석번호
    lindate datetime default now(),         # 입실시간 기본값 now()
    loutdate datetime default null,         # 퇴실시간 기본값 null
    primary key(lno) ,   
    foreign key( lseatno ) references seat( lseatno )
);

select * from library;
select * from library , seat ;
select * from seat ;
select * from library l , seat s where l.lseatno = s.lseatno and l.lphone = '01012345678' and l.lseatno = 1;
select lphone from library where lseatno = 1 and loutdate is null;
insert into library( lname , lphone , lseatno ) values( '김근배' , '01012345678' , 1);
update seat set lisuse = true where lseatno = 1;
update seat set lisuse = true where lseatno = 2;
update seat set lisuse = true where lseatno = 3;
insert into library( lname , lphone , lseatno ) values( '김근배' , '01012345679' , 2);
insert into library( lname , lphone , lseatno ) values( '김근배' , '01012345670' , 3);
update library l , seat s set l.loutdate = now() , s.lisuse = false where l.lseatno = s.lseatno and l.lphone = '01012345679' and l.lseatno = 2;
select * from library l , seat s where l.lseatno = s.lseatno and l.lphone = '01012345679' and l.loutdate is null and l.lseatno = 2;
# seat 테이블 좌석 정보 입력
insert into seat (lseatno) value (1);
insert into seat (lseatno) value (2);
insert into seat (lseatno) value (3);
insert into seat (lseatno) value (4);
insert into seat (lseatno) value (5);
insert into seat (lseatno) value (6);
insert into seat (lseatno) value (7);
insert into seat (lseatno) value (8);
update seat set lisuse = false where lseatno = 1;