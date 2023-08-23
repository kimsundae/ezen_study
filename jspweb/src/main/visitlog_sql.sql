drop database if exists jspweb;
create database jspweb;
use jspweb;

drop table if exists visitlog;
create table visitlog(
	vno 		int auto_increment , 		-- 식별번호( 방문록 번호 ) , 자동번호 부여
    vwriter 	varchar(30) not null,		-- (방문록작성자명) , 공백불가능
    vpw 		varchar(10) not null,		-- (방문록비밀번호) , 공백불가능
    vcontent 	text not null,				-- (방문록 내용 )
    vwritedate 	datetime default now() ,		-- (방문록 작성일/시간) , 생략시 자동날짜/시간 등록
    primary key(vno)
);

insert into visitlog( vwriter , vpw , vcontent ) values( '김근배' , '1234' , '안녕하세요');
select * from visitlog;
# 3. 수정 [ 삭제할 식별자 필수 ]
update visitlog set vcontent = "수정내용" where vno = 6 and vpw = '강사테스트';
# 4. 삭제
delete from visitlog where vno = 7 and vpw = '1234';

drop table if exists accountbook;
create table accountbook(

)

