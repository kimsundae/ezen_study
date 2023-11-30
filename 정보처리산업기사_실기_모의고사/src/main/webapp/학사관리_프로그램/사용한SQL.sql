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