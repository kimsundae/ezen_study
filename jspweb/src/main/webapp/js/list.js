
// 1. 글쓰기 버튼을 클릭하면
function onWrite(){
	// - 만약에 비 로그인이면 로그인 페이지로 이동
	if( loginState ){
		location.href="write.jsp";
	}else{
		alert('로그인 후 글쓰기 가능합니다.')
		location.href="/jspweb/member/login.jsp"
	}
}
listRead();
function listRead(){
	
	$.ajax({
		url : "/jspweb/BoardInfoController",
		data : {type : 1 },
		method : "get",
		success : r => {
			console.log(r)
			let html = ``;
			// 배열명.forEach
			r.forEach( b => {
				html += `
							<tr class="list">
								<td>${b.bno}</td>
								<td>${b.bcname}</td>
								<td><a href="/jspweb/board/view.jsp?bno=${b.bno	}">${b.btitle}</a></td>
								<td>${b.mid} / <img width="25px" src="/jspweb/member/img/${b.mimg}"/></td>
								<td>${b.bwriteTime}</td>
								<td>${b.bview}</td>
								
							</tr>
						`	
				});
							
			document.querySelector('.board').innerHTML += html;				
		},
		error : e => {}
	});		
}

/*
	HTTP URL에 매개변수(파라미터) 전달 ( 쿼리[질의]스트링 방식)
		- 
		- 형태
			URL?변수명=데이터
			URL?변수명=데이터&변수명=데이터
			http://localhost:80/jspweb/board/view.jsp?bno=3
			href="/jspweb/board/view.jsp?bno=${b.bno}"
		- 정의 : 페이지 전환 시 매개변수(PK,식별) 전달
		
	
*/