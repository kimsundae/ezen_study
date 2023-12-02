create table tbl_patient_202004(
	p_no char(4) not null,
	p_name varchar2(20),
	p_birth char(8),
	p_gender char(1),
	p_tel1 char(3),
	p_tel2 char(4),
	p_tel3 char(4),
	p_city char(2),
	primary key(p_no)
);
insert into tbl_patient_202004( p_no, p_name, p_birth, p_gender, p_tel1, p_tel2, p_tel3, p_city)
	values( '1001', '김환자', '19850301', 'M', '010', '2222', '0001', '10' );
insert into tbl_patient_202004( p_no, p_name, p_birth, p_gender, p_tel1, p_tel2, p_tel3, p_city)
	values( '1002', '이환자', '19900301', 'M', '010', '2222', '0002', '20' );
insert into tbl_patient_202004( p_no, p_name, p_birth, p_gender, p_tel1, p_tel2, p_tel3, p_city)
	values( '1003', '박환자', '19770301', 'F', '010', '2222', '0003', '30' );
insert into tbl_patient_202004( p_no, p_name, p_birth, p_gender, p_tel1, p_tel2, p_tel3, p_city)
	values( '1004', '조환자', '19650301', 'F', '010', '2222', '0004', '10' );
insert into tbl_patient_202004( p_no, p_name, p_birth, p_gender, p_tel1, p_tel2, p_tel3, p_city)
	values( '1005', '황환자', '19400301', 'M', '010', '2222', '0005', '40' );
insert into tbl_patient_202004( p_no, p_name, p_birth, p_gender, p_tel1, p_tel2, p_tel3, p_city)
	values( '1006', '양환자', '19440301', 'F', '010', '2222', '0006', '40' );
insert into tbl_patient_202004( p_no, p_name, p_birth, p_gender, p_tel1, p_tel2, p_tel3, p_city)
	values( '1007', '허환자', '19760301', 'F', '010', '2222', '0007', '10' );
commit;

create table tbl_lab_test_202004(
	t_code char(4) not null,
	t_name varchar2(20),
	primary key(t_code)
);
insert into tbl_lab_test_202004( t_code, t_name ) 
	values( 'T001', '결핵' );
insert into tbl_lab_test_202004( t_code, t_name ) 
	values( 'T002', '장티푸스' );
insert into tbl_lab_test_202004( t_code, t_name ) 
	values( 'T003', '수두' );
insert into tbl_lab_test_202004( t_code, t_name ) 
	values( 'T004', '홍역' );
insert into tbl_lab_test_202004( t_code, t_name ) 
	values( 'T005', '콜레라' );
commit;

create table tbl_result_202004(
	p_no char(4) not null,
	t_code char(4),
	t_sdate date,
	t_status char(1),
	t_ldate date,
	t_result char(1),
	primary key(p_no, t_code, t_sdate)
);
insert into tbl_result_202004( p_no, t_code, t_sdate, t_status, t_ldate, t_result )
	values( '1001', 'T001', '2020-01-01', '1', '2020-01-02', 'X' );
insert into tbl_result_202004( p_no, t_code, t_sdate, t_status, t_ldate, t_result )
	values( '1002', 'T002', '2020-01-01', '2', '2020-01-02', 'P' );
insert into tbl_result_202004( p_no, t_code, t_sdate, t_status, t_ldate, t_result )
	values( '1003', 'T003', '2020-01-01', '2', '2020-01-02', 'N' );
insert into tbl_result_202004( p_no, t_code, t_sdate, t_status, t_ldate, t_result )
	values( '1004', 'T004', '2020-01-01', '2', '2020-01-02', 'P' );
insert into tbl_result_202004( p_no, t_code, t_sdate, t_status, t_ldate, t_result )
	values( '1005', 'T005', '2020-01-01', '2', '2020-01-02', 'P' );
insert into tbl_result_202004( p_no, t_code, t_sdate, t_status, t_ldate, t_result )
	values( '1006', 'T001', '2020-01-01', '2', '2020-01-02', 'N' );
insert into tbl_result_202004( p_no, t_code, t_sdate, t_status, t_ldate, t_result )
	values( '1007', 'T002', '2020-01-01', '2', '2020-01-02', 'P' );
insert into tbl_result_202004( p_no, t_code, t_sdate, t_status, t_ldate, t_result )
	values( '1005', 'T003', '2020-01-01', '2', '2020-01-02', 'P' );
insert into tbl_result_202004( p_no, t_code, t_sdate, t_status, t_ldate, t_result )
	values( '1006', 'T004', '2020-01-01', '2', '2020-01-02', 'N' );
insert into tbl_result_202004( p_no, t_code, t_sdate, t_status, t_ldate, t_result )
	values( '1007', 'T005', '2020-01-01', '2', '2020-01-02', 'N' );

select r.p_no, p.p_name, l.t_name, r.t_sdate, r.t_status, r.t_ldate, r.t_result from 
	tbl_result_202004 r inner join tbl_patient_202004 p on r.p_no = p.p_no 
	inner join tbl_lab_test_202004 l on r.t_code = l.t_code order by r.p_no asc;

select p.p_city, case when p.p_city = '10' then '서울'
		when p.p_city = '20' then '경기'
		when p.p_city = '30' then '강원'
		else '대구' end as p_city,
count(*) from tbl_patient_202004 p inner join tbl_result_202004 r on p.p_no
 = r.p_no group by p.p_city order by p.p_city asc;