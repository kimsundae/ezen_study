

function onRegiste(){
	
	const formDate = document.registeForm;
	
	if( formDate.custno.value === '' ){ alert('회원번호를 입력해주세요'); formDate.custno.focus(); return false; }
	if( formDate.custname.value === '' ){ alert('회원성명를 입력해주세요'); formDate.custname.focus(); return false; }
	if( formDate.phone.value === '' ){ alert('회원전화를 입력해주세요'); formDate.phone.focus(); return false; }
	if( formDate.address.value === '' ){ alert('회원주소를 입력해주세요'); formDate.address.focus(); return false; }
	if( formDate.joindate.value === '' ){ alert('가입일자를 입력해주세요'); formDate.joindate.focus(); return false; }
	if( formDate.grade.value === '' ){ alert('고객등급를 입력해주세요'); formDate.grade.focus(); return false; }
	if( formDate.city.value === '' ){ alert('도시코드를 입력해주세요'); formDate.city.focus(); return false; }
	
	alert('회원등록이 완료되었습니다.');
	
	formDate.submit();
	
}