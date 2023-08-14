drop database if exists sqldb6web;
create database sqldb6web;
use sqldb6web;
# 1. 회원테이블
drop table if exists member;
create table member(            # 아이돌 그룹
   mid char(8) not null ,         # 식별키       최대 8자리
    mname varchar(10) not null ,   # 그룹명      최대 10자리
    mnumber int not null ,         # 인원수      정수 +-21억정도
    maddr char(2) not null ,       # 지역      최대 2자리
    mphone1 char(3) ,            # 지역번호   최대 2자리 
    mphone2 char(8) ,            # 전화번호    최대 8자리
    mheight smallint ,            # 평균키       정수 +-3만정도
   mdebut date ,               # 데뷔일       yyyy-mm-dd 
    primary key ( mid )            # 제약조건 
);
# 2. 구매테이블
drop table if exists buy;
create table buy(
   bnum int auto_increment ,          # 구매번호   정수    자동번호 부여 
    mid char(8),                  # 구매자      FK 
    bpname char(6) not null ,         # 제품명      최대 6자리 
    bgname char(4) ,                # 분류명       최대   4자리
    bprice int not null ,            # 가격       정수 
    bamout smallint not null ,         # 구매수량   정수 
    primary key(bnum) ,               # 제약조건 
    foreign key ( mid ) references member(mid) # 제약조건 
);

# 샘플데이터 
INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');

INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);

# 1. 날짜/함수

select now();			# 1. now() 		: 현재 시스템[DB서버의PC]의 날짜/시간 반환
select curdate();		# 2. curdate() 	: 현재 시스템[DB서버의 PC]의 날짜 반환
select curtime();		# 3. curtime()	: 현재 시스템[DB서버의 PC]의 시간 반환

# 4. year(날짜) , month(날짜) , day(날짜) , weekday( 날짜 ) , last_day(날짜) , date( '연도-월-일' )
# 해당 날짜의 연도 	, 월			, 일			, 요일[월 = 0 ~ 일 = 6] , 해당날짜 월의 마지막 날짜 반환
select year( now() ) , month( now() ) , day( now() ) , weekday( now() ) , last_day( now() ) , date( '2023-08-14');
# 5. hour(시간) , minute(시간) , second(시간) ,
# 해당시간 시		, 분alter	,	초
select hour( now() ) , minute( now() ) , second( now() );
# 6. date_format(필드명 , '형식') 날짜/시간 형식 기준으로 변환
# 형식 : %y 년도 2자리 %Y 년도 4자리 %m 월2자리 %c 월1자리 %M 월[영문] %d 일 %D 일[서수] %
select date_format( now() , '%y년 - %Y년 - %m월 - %M월 - %c월 - %D일 - %e일' );
	# 예)
    select * from member;
    select mname as 그룹명 , date_format( mdebut , '%Y년 %m월 %d일' ) as 데뷔일 from member;
    select date_format( time('11:10:30') , '%H %i분 %5초' );
# 2. 집계함수
select sum(bamout) as 총구매수량 from buy;		# 1. sum(필드명) : 해당 필드의 값 총합계
select avg(bamout) as 구매수량평균 from buy;	# 2. avg(필드명)	: 해당 필드의 값 평균
select max(mheigth) as 가장큰키 from member;	# 3. max(필드명 ) : 해당 필드의 최댓값
select min(mheigth) as 가장작은키 from member;	# 4. min(필드명)	: 해당 필드의 최솟값
select count(bgname) as 구매횟수 from buy;	# 5. count(필드명)	: 해당 필드의 레코드 수 [null 제외]
select count(*) as 구매회수 from buy;			# 6. count(*)	: 해당 필드의 레코드 수 [null 포함]
# 3. 수학함수 
select abs(100) , abs(-100);					# 7. abs( 필드/값 ) 	: 절대값
select ceil(10.1) , ceil(10.4) , ceil(10.5) , ceil(10.0);	# 8.ceil( 필드/값 ) : 올림
select floor(10.1) , floor(10.4) , floor(10.5) , floor(10.0);	# 8.floor( 필드/값 ) : 내림
select round(10.1) , round(10.4) , round(10.5) , round(10.0);	# 10.round( 필드/값 ) : 반올림 [5이상]
select round( 1.23456789 , 1) , round( 1.23456789 , 4) , round(1.23456789 , 7); # 12.truncate( 필드/값 , [표시할자릿수] ) : 자르기
select pow( 10, 2)												# 13.pow(값,승) : 제곱



