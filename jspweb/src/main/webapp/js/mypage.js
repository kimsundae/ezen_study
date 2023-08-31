
// 0.로그인된 회원의정보 호출
getInfo();
function getInfo(){
	
	$.ajax({
		url : "/jspweb/MemberInfoController",
		method : "get",
		data : { type : "info"},
		success : r => {
			if( r == null){ // 비로그인 상태 -> 페이지 차단  
				alert('회원전용 페이지입니다.[로그인]페이지로 이동');
				location.href="/jspweb/member/login.jsp";
			}else{ // 로그인 상태 -> 마이페이지 구역에 정보 넣어주기
				document.querySelector('.preimg').src = `img/${r.mimg}`;
				document.querySelector('.mid').innerHTML = r.mid;
				document.querySelector('.memail').innerHTML = r.memail;
			}
			
		} ,
		error : e => {}
	});
} 
// 1. 수정
function mupdate(){
	let mpwd = document.querySelector('.mpwd');
	let newmpwd = document.querySelector('.newmpwd');
	let mimg = document.querySelector('.mimg');
	if(mpwd.value == '' && newmpwd.value == '' && mimg.value == '' )
		return alert('변경할 정보를 입력해주세요')
	if(mpwd.value == newmpwd.value)
		return alert('같은 비밀번호입니다.')
	if(mpwd.value != '' && newmpwd.value == '')
		return alert('변경할 비밀번호를 입력해주세요')
	 
		// 1. form 가져오기
	let form = document.querySelectorAll('.signupForm')[0];
		// 2. form 데이터 객체화 하기
	let formdata = new FormData( form );
	
	// form 전송 ajax
	$.ajax({
			url: "/jspweb/MemberInfoController",
			method: "put",
			data: formdata ,
			contentType : false ,	// form
			processData : false ,
			success: r => {
				if (r) {
					alert('수정 완료');
					location.reload();
				} else {
					alert('수정 실패');
				}

			},
			error: e => { }
		});	

	
}

// 2. 탈퇴
function mdelete(){
	// 1. 탈퇴여부 확인 confirm() 확인true/취소false 버튼 알림창
	let dconfirm = confirm('정말 탈퇴하시겠습니까?')
	// 2. 확인 버튼을 눌렀을 때
	if (dconfirm == true) {
		let mpwd = prompt('비밀번호 확인');	

		// 3. ajax [ 입력받은 패스워드 전송해서 로그인 회원번호와 입력받은 패스워드와 일치하면 탈퇴 ]
		$.ajax({
			url: "/jspweb/MemberInfoController",
			method: "delete",
			data: { type: "delete", mpwd: mpwd },
			success: r => {
				if (r) {
					alert('회원 탈퇴 되었습니다.');
					logout();
				} else {
					alert('회원 탈퇴 실패되었습니다.');
				}

			},
			error: e => { }
		});
	
	}
}
