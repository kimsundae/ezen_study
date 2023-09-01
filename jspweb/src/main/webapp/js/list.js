
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
		data : {},
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
								<td>${b.btitle}</td>
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