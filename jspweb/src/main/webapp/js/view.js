getBoard()
// 1. URL에 있는 매개변수(쿼리스트링) 가져오기
function getBoard(){
	// 1. URL에 있는 매개변수(쿼리 스트링) 가져오기
		// 1. 현재 주소(url)상 매개변수 가져오기
	let urlParams = new URL(location.href).searchParams
		console.log(urlParams)
	let bno = urlParams.get("bno"); // url상의 bno 데이터 가져오기
		// new URL(location.href).searchParams.get("매개변수명")
		console.log(bno)
	// 2. AJAX 이용한 bno 전달해서 게시물의 상세 정보 모두
	$.ajax({
		url : "/jspweb/BoardInfoController" ,
		method: "get" ,
		data: {type : 2 , bno : bno } ,
		success : r => {console.log(r)
			// 1. 
			let boardBox = document.querySelector('.boardBox')
			
			// 2. HTML 구성
			let html = 
						`
							부가정보 : <div> ${r.bcname} , ${r.bview} , ${r.bwriteTime}</div>
							부가정보2 : <div> ${r.mid} , <img src="/jspweb/member/img/${r.mimg}" width="25px"></div>
							제목 : <div> ${r.btitle} </div>	
							내용 : <div> ${r.bcontent} </div>
							첨부파일 : <div> <img src="/jspweb/member/img/${r.bimg}" width="25px"> </div>
							
						`
			html += `<a href="list.jsp"><button type="button"> 목록보기 </button></a>`
			if(r.ishost){
				html += `
							<button onclick="ondelete(${r.bno})" type="button"> 삭제 </button>
							<button onclick="onUpdate(${r.bno})"type="button"> 수정 </button>
						`	
			}
			
			// 3. 
			boardBox.innerHTML = html; 
			
		} ,
		error : e => {console.log(r)}
	})	
	
}

// 2. 게시물 삭제 -> 레코드 삭제 -> 레코드 식별 -> pk
function ondelete( bno ){
	
	$.ajax({
		url : "/jspweb/BoardInfoController" ,
		method : "delete",
		data : {bno : bno},
		success : r => { console.log(r)
			if(r){
				alert('삭제 성공')
				location.href="/jspweb/board/list.jsp"
			}else alert('삭제 실패')
			
		} ,
		error : r => {}
	});
}
// 3. 게시물 수정 페이지로 이동
function onUpdate( bno ){
	// 1. 수정페이지로 이동
	location.href = `/jspweb/board/update.jsp?bno=${bno}`
}// f end











