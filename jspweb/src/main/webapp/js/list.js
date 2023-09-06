


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
let pageObject = { type: 1 , bcno : 0 , listsize: 10 , page : 1 , key : '' , keyword : ''}
	// * type 		: (1:전체조회 , 2:개별조회)
	// * bcno	 	: 조회할 카테고리번호 [ 기본값은 전체보기 ]
	// * listsize	: 하나의 페이지에 최대 표시할 게시물 수
listRead(1);
function listRead( page ){ // page : 조회할 페이지
	
	pageObject.page = page;
	
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
			r.boardList.forEach( b => {
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
			
			//------------ 2. 페이지번호 출력 -------------//		
			html = ``;
			
		// 페이지 개수만큼 페이징번호 구성
			// 이전버튼
			html += `<button onclick="listRead(${ page == 1 ? page : page-1})" type="button"> < </button>`
			// 페이지 번호 버튼 [ 페이지 개수만큼 반복]
			for( let i = 1; i <= r.totalpage; i++){
				
				html += `<button class="${page == i ? 'selectpage' : ''}" onclick="listRead(${i})" type="button"> ${i} </button>`
			}	
			// 다음버튼
			html += `<button onclick="listRead(${page+1})"type="button"> > </button>`
					
		//pagebox 구역에 구성된 html 대입
		document.querySelector('.pagebox').innerHTML = html;
		
		// ------------- 3. 게시물 수 출력 -------------//
		let boardcount = document.querySelector('.boardcount');
		
			// 1. 검색이 없을 때
			if( pageObject.key == '' && pageObject.keyword == '')
				boardcount.innerHTML = `총 게시물 수 : ${ r.totalsize }`
			else
				boardcount.innerHTML = `검색한 게시물 수 : ${r.totalsize}`
		 
		boardcount.innerHTML = `총 게시물 수 : ${ r.totalsize }`
		
		},
		error : e => {}
	});		
}
	
// 3. 카테고리 버튼을 클릭했을 때.
function onCategory( bcno ){ 
	pageObject.bcno = bcno; // 조회 조건객체 내 카테고리 번호를 선택한 카테고리로 변경
	listRead(1)
}
// 4. 한페이지 최대 표시할 게시글 개수를 변경했을 때
function onListSize(){
	pageObject.listsize = document.querySelector('.listsize').value;
	listRead(1);
}

function onSearch(){
	console.log(document.querySelector('.key').value)
	console.log(document.querySelector('.keyword').value)
	pageObject.key = document.querySelector('.key').value;
	pageObject.keyword = document.querySelector('.keyword').value;
	
	listRead(1);
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