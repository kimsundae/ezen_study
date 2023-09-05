
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

/* 게시물 조회 조건 객체 */
let pageObject = { type: 1 , bcno : 0 , listsize: 10}
	// * type 		: (1:전체조회 , 2:개별조회)
	// * bcno	 	: 조회할 카테고리번호 [ 기본값은 전체보기 ]
	// * listsize	: 하나의 페이지에 최대 표시할 게시물 수
listRead();
function listRead( ){
	
	$.ajax({
		url : "/jspweb/BoardInfoController",
		data : pageObject,
		method : "get",
		success : r => {
			console.log(r)
				let html = `<tr>
								<th>게시글 번호</th>
								<th>카테고리</th>
								<th>제목</th>
								<th>글쓴이</th>
								<th>조회수</th>
								<th>작성일</th>				
							</tr>`;					
			// 배열명.forEach
			r.forEach( b => {
				html += `
							<tr class="list">
								<td>${b.bno}</td>
								<td>${b.bcname}</td>
								<td><a href="/jspweb/board/view.jsp?bno=${b.bno	}">${b.btitle}</a></td>
								<td>${b.mid} / <img src="/jspweb/member/img/${b.mimg}"/></td>	
								<td>${b.bview}</td>
								<td>${b.bwriteTime}</td>		
							</tr>
						`	
				});
							
			document.querySelector('.boardTable').innerHTML = html;				
		},
		error : e => {}
	});		
}
	
// 3. 카테고리 버튼을 클릭했을 때.
function onCategory( bcno ){ 
	pageObject.bcno = bcno; // 조회 조건객체 내 카테고리 번호를 선택한 카테고리로 변경
	listRead()
}
// 4. 한페이지 최대 표시할 게시글 개수를 변경했을 때
function onListSize(){
	pageObject.listsize = document.querySelector('.listsize').value;
	listRead();
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