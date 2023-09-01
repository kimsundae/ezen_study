function bwrite(){

	// 1. form 가져오기
	let form = document.querySelectorAll('.writeForm')[0]
	// 2. form 객체화 하기
	let formData = new FormData(form);
	// 3. ajax로 대용량 form 전송하기
	$.ajax({
		url : "/jspweb/BoardInfoController",
		data : formData ,
		method : "post",
		contentType : false ,
		processData : false,
		success: r => {
			if( r )
				alert('글 등록 성공')
			else
				alert('글 등록 실패')
		},
		error : e => {}	
	});
}
function listRead(){
	
	$.ajax({
		url : "/jspweb/BoardInfoController",
		data : {},
		method : "get",
		success : r => {
			let html = `<tr>
							<th>게시글 번호</th>
							<th width="60%">제목</th>
							<th>글쓴이</th>
							<th>작성일</th>
							<th>조회수</th>
						</tr>`;
			for(let i = 0; i < r.length; i++){
				html += `
							<tr class="list">
								<td>${r[i].bno}</td>
								<td>${r[i].btitle}</td>
								<td>${r[i].mid}</td>
								<td>${r[i].bwriteTime}</td>
								<td>${r[i].bview}</td>
							</tr>
						`	
			}
			
			
			
		},
		error : e => {}
	});
	
	
}





