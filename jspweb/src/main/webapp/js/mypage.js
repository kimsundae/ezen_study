
// 0.로그인된 회원의정보 호출
getInfo();
function getInfo(){
	
	$.ajax({
		url : "/jspweb/MemberInfoController",
		methd : "get",
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
	
}

// 2. 탈퇴
function mdelete(){
	// 1. 탈퇴여부 확인 confirm() 확인true/취소false 버튼 알림창
	let dconfirm = confirm('정말 탈퇴하시겠습니까?')
	// 2. 확인 버튼을 눌렀을 때
	if( dconfirm == true ){
		let mpwd = prompt('비밀번호 확인');
			// 3. ajax [ 입력받은 패스워드 전송해서 로그인 회원번호와 입력받은 패스워드와 일치하면 탈퇴 ]
			$.ajax({
				url : "/jspweb/MemberInfoController",
				methd : "get",
				data : { type : "info"},
				success : r => {
					
					
					
					
					
					
					
					
					
					}
					
				} ,
			error : e => {}
		});
	
}