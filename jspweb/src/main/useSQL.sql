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
delete from member where mid is null;
delete from member where mid = 'naa123' and mpwd = 'qwe123456';
#--------------------------------------------------------------
drop table if exists seat;
create table seat (
   lseatno int not null,               # 식별번호 프라이머리키
    lisuse boolean default false,         # 사용여부 기본값 false
    primary key(lseatno)
    );
    
# seat 테이블 좌석 정보 입력---------------------------------------------------------
insert into seat (lseatno) value (1);
insert into seat (lseatno) value (2);
insert into seat (lseatno) value (3);
insert into seat (lseatno) value (4);
insert into seat (lseatno) value (5);
insert into seat (lseatno) value (6);
insert into seat (lseatno) value (7);
insert into seat (lseatno) value (8);

# library 테이블-----------------------------------------------------------
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

# hrm 테이블 ---------------------------------------
drop table if exists hrm;
create table hrm(
	hno int auto_increment,
    hname varchar(10) ,
    hphone varchar(15) ,
    hrank varchar(5) ,
	himg longtext , 
    hindate datetime default now() ,
    primary key(hno)
);

# 카테고리 테이블 ------------------------------------
create table category(
	cno int auto_increment ,
    cname varchar(30) not null,
    primary key(cno)
);
select * from category;
insert into category( cname ) values( '공지사항' );
insert into category( cname ) values( '자유게시판' );
insert into category( cname ) values( '노하우' );
# 게시판 테이블----------------------------
drop table if exists board;
create table board(
	bno int auto_increment ,
    btitle varchar(30) not null ,
    bcontent longtext ,
    bimg longtext , 
    bwriteTime datetime default now(),
    bview int default 0 ,
    mno int ,
	cno int , 
	primary key( bno ) ,
    foreign key(cno) references category(cno) on delete cascade on update cascade,
    foreign key (mno) references member(mno) on delete cascade
);
select * from board;

select * from hrm;
select * from member;

delete from board where bno = 1;

select count(*) from board b where b.cno = 1; 
select count(*) from board b ;
 select b.* , m.mid , m.mimg , bc.cname from board b natural join category bc natural join member m  order by b.bwriteTime desc limit 1 , 5;
 select b.* , m.mid , m.mimg , bc.cname from board b natural join category bc natural join member m  order by b.bwriteTime desc limit 1 , 5;
 select count(*) from board b natural join member m where b.cno = 1;
#--------------------------------------------
# 1. 제품 카테고리 
drop table if exists pcategory;
create table pcategory( pcno int auto_increment , pcname varchar(100) not null , primary key(pcno)  );
	# 샘플 
	insert pcategory(pcname) values( '노트북' ); insert pcategory(pcname) values( '태블릿' ); insert pcategory(pcname) values( '냉장고' );
select * from pcategory;
# 2. 제품 
drop table if exists product;
create table product(
	pno			int auto_increment ,  
    pname		varchar(100)  not null , 
    pcontent	longtext , 
    pprice		int unsigned default 0 not null ,	-- signed(기본값:음수사용 +-21억) / unsigned(음수사용X-음수만큼의메모리를 양수로 사용 0~42억정도 ) : 음수 사용여부 
    pstate		tinyint default 0 not null , -- [ 0 : 판매중(기본값) , 1:거래중 , 2:판매대기 3:판매완료 ]
    pdate 		datetime default now() not null , 
    plat		varchar(30) not null, 
    plng		varchar(30) not null, 	
    pcno		int ,
    mno			int ,
    primary key( pno ) , 
    foreign key( pcno ) references pcategory(pcno) on delete set null on update cascade , 
    foreign key( mno ) references member(mno) on delete cascade on update cascade
);
# 3. 제품 이미지 
drop table if exists productimg;
create table productimg(  
	pimgno int auto_increment , 
    pimg longtext , 
    pno int ,
    primary key ( pimgno ) , 
    foreign key( pno ) references product( pno ) on delete cascade on update cascade
);
select * from product;
select * from productimg;
# 1. 제품 등록 [ 제품정보 등록 후에 이미지등록 이미지 등록 시 제품번호[FK] 필요하기 때문 ] 
	# 1-1 제품 테이블 내 제품 정보 등록
insert
	into product( pcno, pname, pcontent, pprice, plat, plng, mno ) 
    values( 1, '삼성노트북', '2023최신형')