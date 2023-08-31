
// 1. 현재 로그인된 회원정보 요청

getMemberInfo();
function getMemberInfo(){
	
	// 1. ajax 이용한 서블릿세션 정보 가져오기
	$.ajax({
		url : "/jspweb/MemberInfoController" ,
		method : "get" ,
		data : {type : "info" },
		success : r=> {
			// - 로그인 상태에 따른 서로 다른 html 구성
			let submenu = document.querySelector('.submenu')
			let html = ``;
			console.log( r );
			if( r == null ){ // 비로그인
				html += `
							<li><a href="/jspweb/member/signup.jsp">회원가입</a></li>
							<li><a href="/jspweb/member/login.jsp">로그인</a></li>
						`
			}else{ // 로그인
				if( r.mid == "admin"){} // 로그인 했는데 관리자 메뉴
				html += `
							<li>${r.mid}님</li>
							<li><img class="hmimg" src="/jspweb/member/img/${r.mimg}"></li>						
							<li><a href="/jspweb/member/mypage.jsp">마이페이지</a></li>
							<li><a onclick="logout()" href="#">로그아웃</a></li>								
						`	
			}
			// - 구성된 html 대입
			submenu.innerHTML = html;
		},
		error : e => {}
	});
	
	
}
// 2. 로그아웃 함수 [ 서블릿에 세션을 삭제.. 그리고 로그아웃 성공시]
function logout(){
	$.ajax({
		url : "/jspweb/MemberInfoController" ,
		method : "get" ,
		data : {type : "logout"},
		success : r=> {
			alert('로그아웃 되었습니다.');
			location.href="/jspweb/index.jsp";
		} ,
		error : e => {} 
	});
}

