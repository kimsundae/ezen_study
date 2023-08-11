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
select * from member;

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

use sqldb4web;
/*1. 테이블의 모든 레코드 검색 */
select * from member;
/* 2. 회원가입 : mno 자동부여 이므로 생략 */
insert into member( mid , mpw , mname , mphone ) values ( 'ezen02' , '1234' , '이젠' , '010-443-1234' );
# insert into member( mid , mpw , mname , mphone ) values ( ? , '? , ? , ? );
/* 3. 로그인 : 입력한 값이 존재하는지 검색 */ 
select * from member where mid = 'ezen02' and mpw = '1234'; # 로그인성공 : 레코드 1개이상 검색되면
select * from member where mid = 'ezen02' and mpw = '12345'; # 로그인실패 : 레코드 0개 검색
# 4. 아이디 / 전화번호 중복 체크 (유효성검사) : 입력한 값이 존재하는지 검색 
select * from member where mid = 'ezen02';									# 조건에 맞는 충족한 레코드의 모든 필드 검색
# select * from member where mid = ?;
select * from member where mphone = '010-443-1234';							# 조건에 맞는 충족한 레코드의 모든 필드 검색
# select * from member where mid = ?;										
# 5. 아이디 /비밀번호 찾기 : 입력한 값의 레코드 검색
select mid from member where mname = '이젠' and mphone = '010-443-1234';		# 조건에 맞는 충족한 레코드의 아이디 필드만 검색
# select mid from member where mname = ? and mphone = ?;
select mpw from member where mid = 'ezen02' and mphone = '010-443-1234';	# 조건에 맞는 충족한 레코드의 비밀번호 필드만 검색
# select mpw from memeber where mid = ? and mphone = ?;
# 6. 회원수정 : 비밀번호 수정 : pk식별 조건 [pk필드는 수정 하지 않음 - 권장 ] ]
update member set mpw = '12345' where mno = 4;	# 4번 회원인 레코드의 비밀번호 수정
# update member set mpw from memeber where mpw = ? and mno = ?;
# 6. 회원수정 : 이름 , 전화번호 수정 : pk식별 조건[pk필드는 수정 하지 않음 - 권장 ] 
update member set mname = 'ezen' , mphone = '010-1234-1234' where mno = 4;
# update member set mname from memeber where mpw = ? and mno = ?;

# 7. 회원탈퇴 : pk식별 조건
delete from member where mno = 4;		-- 4번 회원인 레코드 삭제
delete from member where mno = ?;
select * from member where mid = 'naa';

drop table if exists board;
create table board(			
	bno 		int auto_increment , 			#정수 , 자동번호 부여
    btitle 	varchar(50) not null ,				#문자50 , 공백불가 
    bcontent	longtext ,						#긴글[4G] 
	bdate 		datetime default now(),			#날짜/시간 , 기본값을 레코드삽입기준 자동
    bview		int default 0 ,					#정수 , 기본값을 0
    mno 		int , 							#작성자의 회원번호 [ 작성자의 식별번호 ]
    primary key( bno ) ,
    foreign key( mno ) references member( mno ) on delete cascade ,		# 회원탈퇴[PK레코드삭제] 되면 Fk의 레코드 같이 삭제
    foreign key( mno ) references member( mno ) on delete restrict ,	# (생략시기본값)회원탈퇴[PK레코드삭제] 할 때 FK의 레코드가 존재하면 탈퇴 불가능
    foreign key( mno ) references member( mno ) on delete set null ,	# 회원탈퇴[PK레코드삭제] 되면 FK의 값을 NULL 수정
    foreign key( mno ) references member( mno ) on delete no action 	# 아무런 변화 없는 상태.
);
select * from board;
select bview from board where bno = 3;
update board set bview = 1 where bno = 3;
update board set bview = 2 where bno = 2;


/*-------*/
use sqldb4web;
select * from board;
# 1. 3번째 게시물의 제목과 내용 수정
	# update 테이블명 set 수정할필드명 = 수정할값 , 수정할필드명 = 수정할값 where 조건
update board set btitle = '수정한제목' , bcontent = '수정한내용' where bno = 3;

# 게시물 삭제
delete from board where bno = 2;
update board set bview = bview + 1 where bno = 5; 

# 쪽지table
drop table if exists tableMsg;
create table tableMsg(
	msgnum smallint not null auto_increment ,
    smno int ,
    rmno int ,
    mcontent varchar(500),
    mdate datetime default now() ,
    foreign key(smno) references member(mno) ,
    foreign key(rmno) references member(mno) ,
    primary key(msgnum)
);
select mno from board where bno = 5;
select * from tableMsg where rmno = 4;
select * from tableMsg t natural join member m;
select m.mid from tableMsg t natural join member m where rmno = 1;
select mid from member m , tableMsg t where m.mno = t.rmno and m.mno = 1;
select mid from member m , tableMsg t where m.mno = t.smno and m.mno = 1;
select mid from member m , tableMsg t where m.mno = 1;
select * from member;
select * from tableMsg;
insert into tableMsg(smno , rmno , mcontent ) values( 1 , 2 , '안녕' );
insert into tableMsg(smno , rmno , mcontent ) values( 2 , 1 , '안녕2' );

/* 선택옵션
기본키에 변화가 있을 때
- 기본키 삭제 되었을 때 참조키는 어떻게??
	on delete cascade : 기본키의 레코드가 삭제되면 참조키의 레코드 같이 삭제
		예) 회원탈퇴하면 회원 작성한 글도 같이 삭제 
	on delete restrict : (기본값) 참조되고 있는 기본키는 삭제 불가능.
    on delete no action : 아무런 변화 없는 상태 [ restrict ] 
    on delete set null : 기본키의 레코드가 삭제되면 참조키의 값을 null로 변경
		예) 회원탈퇴하면 회원이 작성한 글 그대로 존재 작성자는 null
- 기본키 수정 되었을 때 참조키는 어떻게?
	on update cascade : 기본키가 변경되면 참조키도 같이 변경
		예) 회원번호가 수정되면 작성자의 번호도 같이 수정된다.
	
	


*/
