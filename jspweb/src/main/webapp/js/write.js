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
			if( r ){
				alert('글 등록 성공')
				location.href="/jspweb/board/list.jsp"
			}
			else
				alert('글 등록 실패')
		},
		error : e => {}	
	});
}






