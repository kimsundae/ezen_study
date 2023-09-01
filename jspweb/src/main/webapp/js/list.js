
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
