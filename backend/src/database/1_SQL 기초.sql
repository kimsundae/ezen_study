#한줄주석
# 확대축소 : ctrl + 마우스 휠
-- 한줄주석
/* 여러 줄 주석 */

/*
	데이터베이스 : 데이터[자료] , 베이스[모임] 
		- 종류
			1. 계층형 데이터 베이스 : 트리형태
            2. 네트워크형 데이터 베이스 : 양방향 형태
            3. *관계형 데이터 베이스 : 행/열 구성된 테이블[표] 형태
            4. NoSQL 데이터 베이스 : Key-value 
		
        - 용어
				DBA[ 데이터베이스 관리자 ]
					- 개발자
                DBMS[ 데이터베이스 관리 시스템 ]
					- MYSQL , ORACLE(1) , MARIADB , SQLSERVER - 각 회사별 소프트웨어
                    - SQL [ 구조화된 질의 언어 ]
                DB[ 데이터베이스 ]
					- 실제 데이터가 저장된 곳 = DB SERVER
                    - 메모리[ 16진수/기계어 ] : 개발자는 직접적으로 관리 힘이 듬
                    
		- 관계
        
			DBA ---------------> DB   [x]
            개발자				기계어
            
            DBA	---------------> DBMS	-------------> DB	[o]
            개발자				관리시스템				  기계어
								MYSQL
								ORACLE
            
					표 만들어줘				기계어
					create
                    SQL언어 학습
            이클립스 ------------> JVM -----------------> 메모리 [o]
            개발자				번역						
					출력해줘				기계어
					print()
					자바언어 학습
                    
		- SQL : DB 조작/관리/제어 할 때 사용되는 언어/문법 (대소문자 구분X)
			- 1. DDL	[ 데이터베이스 정의어 ]
				- 1. create		: 데이터베이스 , 테이블 , 뷰(가상테이블) 생성
					- create database db명;
                    - create table table명( 필드명 속성명 , 필드명 속성명 , 필드명 속성명 )
                    
                - 2. drop		: 데이터베이스 , 테이블 , 뷰(가상테이블) 삭제
					- drop database db명;
                    - drop database if exists db명;
                    
                - 3. alter		: 테이블 , 뷰(가상테이블) 속성 수정
                - 4. truncate 	: 테이블내 데이터 초기화/삭제
                - 5. rename		: 테이블 , 뷰(가상테이블)의 이름 변경
                - 6. show		:
					- show databases;					: 데이터베이스 전체 목록보기
                    - show variables like 'datadir';	: 데이터베이스 저장소 로컬 경로 확인
				- 7. use
					- use db명	: 데이터베이스 사용 선택
            - 2. DWL	[ 데이터베이스 조작어 ]
				- 1. insert		: 테이블(표)에 레코드(행) 삽입
                - 2. select		: 테이블(표)에 레코드(행) 검색
					- select * from 테이블명	: 테이블내 모든 필드의 레코드(행) 검색[ * : 와일드카드(모든) ]
                - 3. update		: 테이블(표)에 레코드(행) 수정
                - 4. delete		: 테이블(표)에 레코드(행) 삭제
            - 3. DCL	[ 데이터베이스 제어어 ]
				- 1. grant		: 사용자 권한 부여
                - 2. revoke		: 사용자 권한 취소
            - 4. TCL	[ 트랜잭션 제어어 ]
				- 1. commit		: !! 트랜잭션[명령어 단위]  완료
                - 2. rollback	: 트랜잭션[명령어 단위] 취소
			
		- 테이블 용어 / 테이블 [ 표 ]
                (컬럼 , colum , 열 , 필드)
				 |		  |		  |				 |
				학번		학생명	전화번호			주소
                1010	김현수	010-4444-3333	안산		가로 = 행 = row = 레코드
                1011	강호동	010-3333-3333	수원		
			1. 속성=column=열=필드=속성 : 테이블[표]의 열
				학번필드 , 학생명필드 , 전화번호필드 주소필드
                
			2. 가로 = 행 = row = 레코드 : 테이블[표]의 행
				1번레코드 , 2번레코드 , 3번레코드
			
            3. 행/열로 구성된 테이블(표)를 다른 테이블(표)와 연결/관계 = 관계형 데이터베이스

	- 데이터 필드 타입 [ mysql 기준 *DBMS 조금씩 다름 ]
		(숫자) : 바이트 단위
		1.정수
			tinyint		[1] 		: -128~127 
            smallint	[2] 		: 약 +-3만 
			mediumint	[3] 		: +-8백만정도
            int			[4]			: 약 +-21억
            bigint		[8]			: +-21억 이상
		2.실수
			float(4) 		: 소수점 7자리
            double(8)		: 소수점 15자리
		3.문자
				( 글자수 최소 1~최대255 )
			char(문자길이)		: 고정길이		char(3) -> 'ab' -> 3바이트	[ *저장할 데이터의 글자수가 정확히 정해져 있는 경우 ]
			( 글자수 최소 1 ~ 최대65535
            varchar(문자길이)	: 가변길이		varchar(3) -> 'ab' -> 2바이트 [ *저장할 데이터의 글자수가 정확하지 않을 때 ]
		4.대용량 문자
			text (최소 1~최대65535)
            longtext ( 4G )		: 게시물 내용물 , 첨부파일 , 이미지 , 동영상 [ 4G ]
            mediumtext( 최소1 ~ 최대 1600000 )
		5.날짜
			date(날짜)			: YYYY-MM-DD
            time(시간) 			: HH:MM:SS
            datetime(날짜시간) 	: YYYY-MM-DD HH:MM:SS
		
		6.논리
			boolean(1)
            
		- 제약조건
			1. pk	: primary key( pk 필드명 )
            2. fk	: foreign key( fk 필드명 ) referances pk테이블명( pk 필드명 ) [ 선택 옵션 ]
            
*/
#예1 : 데이터베이스( 여러개의 테이블(표) 들이 저장 할 수 있는 공간 ) 생성
create database sqldb1;
	#create		: 생성한다.
    #database  	: 데이터베이스.
    #sqldb1 	: 이름정의 [ 아무거나 , 대소문자 구분X , 키워드 X ]
    # ;			: 명령어 끝마침.
		# 명령어 실행 : 해당 명령어 줄에 커서 위치한 상태에서 ctrl+엔터
        # nevigateor 새로고침
create database sqldb2;
create database sqldb3;
create database sqldb4;
create database sqldb5;

#예2 : 데이터베이스 목록 보기
show databases;

#예3 : 데이터베이스 저장된ㄹ 로컬[pc] 경로 확인
show variables like 'datadir';
	
#예4 : 데이터베이스 삭제
drop database sqldb1;
	# drop : 삭제한다.
    # database : 데이터베이스
    # sqldb1 : DB명
drop database sqldb2;
drop database sqldb3;
drop database sqldb4;
drop database sqldb5;

#예5 : 만약에 데이터베이스 존재했을 때 삭제 [ *만약에 데이터베이스 없을 때 삭제명령어 사용하면 오류 발생!! ]
drop database if exists sqldb1;
	# if exists : 만약에 존재하면

#예6 : 여러개의 데이터베이스 중 사용할 데이터베이스 선택
use sqldb1;
use sqldb2;

#활용1 : 데이터베이스 새롭게 생성하세요.
# 1. 데이터베이스 존재하면 삭제처리
drop database if exists test1;

# 2. 데이터베이스 생성
create database test1;

# 3. 데이터베이스 사용준비
use test1;

/* --------------- 테이블(표) 만들기 ---------------- */
# 테이블(표)는 데이터베이스 안에 저장 [ * 무슨 데이터베이스 생성할 것인지 ... use DB명; ]
# 예1 : 테이블 생성
use sqldb1; # 테이블을 생성할 데이터베이스 선택
create table member( 아이디 text , 비밀번호 text );
	# create	: 생성한다.
    # table		: 테이블
    # member	: 이름정의 [ 아무거나 , 대소문자 구분x , 키워드x ]
    # ( );		: 테이블 속성/열/필드 정의 구역
		# ( 필드명 타입 , 필드명 타입 , 필드명 타입 , 필드명 타입 ) : 테이블(표) 제목/속성/열/필드 정의
#예2 : 테이블 확인
select * from member;

# 활용 2 :
/* 
	문제1 :
		1. 웹개발 하는데 DB저장소 'sqldb1web' 이름으로 DB 생성
        2. 해당 db에 member 테이블 생성
			id( 문자열 최대 20 )
            password( 문자열 최대 10 )

*/
# 1. 만약에 생성할 이름의 DB명이 존재하면 삭제
drop database if exists sqldb1web;
# 2. DB 생성
create database sqldb1web;
# 3. DB 사용 선택
use sqldb1web;
# 4. 만약에 생성할 이름의 테이블명이 존재하면 삭제
drop table if exists member;
# 5. table 생성
create table member( id varchar(20)   , password varchar(10) );
# 6. 테이블 생성 여부 확인
select * from member;

/* 
	문제2 :
		1. 웹개발 하는데 DB저장소 'sqldb1web2' 이름으로 DB 생성
        2. 해당 db에 board 테이블 생성
			 게시물번호	( 필드명 : bno			타입 : 최대 21억정도 )
             게시물제목	( 필드명 : btitle		타입 : 문자열 최대 100 )
             게시물내용	( 필드명 : bcontent	타입 : 문자열 최대 6만5천 이상 )
             게시물조회수	( 필드명 : bview   	타입 : 최대 21억정도 )
            게시물작성일	( 필드명 : bdate	타입 : 날짜/시간 )
*/
drop table if exists sqldb1web2;
create database sqldb1web2;
use sqldb1web2;
drop table if exists board;
create table board( bno int , btitle varchar(100) , bcontent longtext , bview int , bdate datetime );
select * from board;

/* 
	문제3 :
		1. 웹개발 하는데 DB저장소 'sqldb1web2' 이름으로 DB 생성
        2. 해당 db에 board 테이블 생성
			 회원번호	    ( 필드명 : mno		타입 : 최대 21억정도 )
             회원아이디	( 필드명 : mid		타입 : 문자열 최대 20 )
             회원비밀번호	( 필드명 : mpw 		타입 : 문자열 최대 20 )
			 게시물번호	( 필드명 : bno		타입 : 최대 21억정도 )
             게시물제목	( 필드명 : btitle		타입 : 문자열 최대 100 )
             게시물내용	( 필드명 : bcontent	타입 : 문자열 최대 6만5천 이상 )
             게시물조회수	( 필드명 : bview   	타입 : 최대 21억정도 )
            게시물작성일	( 필드명 : bdate	타입 : 날짜/시간 )
*/
# 1. 데이터베이스 생성
# 만약에 동일한 db명이 존재했을 때 생성불가능 하기 때문에 먼저 드롭
drop database if exists sqldb1web2;
create database sqldb1web2;
use sqldb1web2;
drop table if exists memberboard;
create table membeboard2board2rboard( 
	mno int , 
    mid varchar(20) ,
    mpw varchar(20) ,
    bno int , 
    btitle varchar(100) , 
    bcontent longtext , 
    bview int , 
    bdate datetime 
);
select * from memberboard;

/* 
	문제4 :
		1. 웹개발 하는데 DB저장소 'sqldb1web2' 이름으로 DB 선택
        2. 해당 db에 memberboard 테이블 기준으로 2개의 테이블로 생성 [ 필드와 타입은 문제3 동일 ]
			 회원번호	    ( 필드명 : mno		타입 : 최대 21억정도 )
             회원아이디	( 필드명 : mid		타입 : 문자열 최대 20 )
             회원비밀번호	( 필드명 : mpw 		타입 : 문자열 최대 20 )
			 게시물번호	( 필드명 : bno		타입 : 최대 21억정도 )
             게시물제목	( 필드명 : btitle		타입 : 문자열 최대 100 )
             게시물내용	( 필드명 : bcontent	타입 : 문자열 최대 6만5천 이상 )
             게시물조회수	( 필드명 : bview   	타입 : 최대 21억정도 )
			게시물작성일	( 필드명 : bdate	타입 : 날짜/시간 )
*/

# I 기본키 : [pk]primary key : 식별키 : 테이블의 유일한 값을 가지는 필드 : 중복이 없고 null과 공백이 없는 필드

# M 외래키 : [fk]foreign key : 참조키 : PK필드와 연결된 다른 테이블의 필드 : 중복이 있다.
	# PK : 데이터의 중복이 없는 식별가능한 필드 [ 후보 : mno , mid ]
		# mno : 회원번호 [ 절대적인 식별 ] 권장o 
        # mid : 회원아이디 [ 강호동 qwe 라는 아이디로 가입 후 탈퇴하고 5년 후 asd라는 아이디로 유재석 가입 ] 권장 x
		# -번호 형태의 pk필드 권장하는 이유 : 문자열 데이터 필드보다는 메모리 효율적으로 사용 가능.
        # -테이블 1개당 PK필드 1개이상 권장 O 
	# FK : 다른 테이블에 있는 PK필드와 연결
		# 1. FK필드명은 PK필드명과 동일하게 사용 [ 권장 ]
        # 2. [필수] FK필드의 타입은 PK필드의 타입과 동일
        # 3. [ 참조하는테이블 ] 에서 FK 필드 선언 [ 1:M 관계에서 M쪽이 참조하는 테이블 1:참조당하는 테이블 ]
        
-- 예1 : 1:M 관계 / PK:FK 관계
drop database if exists sqldb1web2;
create database sqldb1web2;
use sqldb1web2;
drop table if exists memberList;
create table member2(
	mno int , 
    mid varchar(20) ,
    mpw varchar(20) ,
    primary key( mno )	-- 현재 테이블에서 mno라는 필드를 식별키로 사용
); 
drop table if exists boardList;
create table board2(
	bno int , 
    btitle varchar(100) , 
    bcontent longtext , 
    bview int , 
    bdate datetime ,
    mno int ,	-- 1. FK 필드 선언
    foreign key( mno ) references member2( mno )-- 2. 현재 테이블에서 mno라는 필드를 외래키로 사용
		# foreign key( mno_fk ) 		: 'mno_fk' 라는 필드를 FK 필드로 설정
        # references member2( mno_pk )	: FK필드를 member2 테이블의 
);

# 문제 5
drop database if exists sqldb2sys;
create database sqldb2sys;
use sqldb2sys;
# 조건2) 1. 테이블선언하고 필드명과 필드타입 선언 2. PK선정 [ 테이블당 1개 권장 ] 3. 1:M 관계 할 경우에는 M테이블 FK 필드 선언/결정
drop table if exists category;
create table category(
	cno tinyint ,
    cname varchar(15) ,
    primary key( cno ) -- 현재 테이블에서 cno라는 필드를 식별키로 사용
);
drop table if exists product;
create table product(
	pno int ,
    pname varchar(15) ,
    pprice mediumint ,
    cno tinyint , # FK필드로 사용할 필드 선언 [ 연결할 PK필드명/타입과 동일하게 선언 ]
    primary key( pno ) ,
    foreign key ( cno ) references category( cno ) 
    ); 
drop table if exists ordertable;
create table ordertable(
	ix tinyint ,
    ordernum tinyint ,
    orderproduct varchar(15) ,
    orderdate datetime
    
	);
    
# --------------------------------

drop database if exists sqldb2team1;
create database sqldb2team1;
use sqldb2team1;

drop table if exists category;
create table category( cno int , cname varchar(7) , primary key (cno));

drop table if exists movie;
create table movie( mno int , mname varchar(10) , cno int , primary key(mno) , foreign key(cno) references category(cno) );

drop table if exists localtheater;
create table localtheater( lno int , lname varchar(5) , primary key(lno) );

drop table if exists movieroom;
create table movieroom( mrno int , mrname varchar(5) , lno int , primary key(mrno) , foreign key(lno) references localtheater(lno));

drop table if exists screening;
create table screening( sno int ,  mrno int , mno int , foreign key(mrno) references movieroom(mrno) ,foreign key(mno) references movie(mno) , primary key(sno));