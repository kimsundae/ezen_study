
getBoard()
// 1. 수정할 게시물의 정보를 보여주기
function getBoard(){
	
	// 2.쿼리스트링(URL주소상의 변수) 의 변수 가져오기
		// 쿼리스트링 : URL?변수명=값&변수명=값
	let bno = new URL(location.href).searchParams.get("bno");
	
	// 3. ajax에게 bno 전달해서 게시물 정보 가져오기
	$.ajax({
		url: "/jspweb/BoardInfoController" ,
		method : "get" ,
		data : { type : 2 , bno : bno },
		success : r => { console.log (r)
			// 응답 결과 html 대입
			document.querySelector('.bcno').value = r.bcname
			document.querySelector('.btitle').value = r.btitle
			document.querySelector('.bcontent').value = r.bcontent
			document.querySelector('.oldfile').src = `/jspweb/board/img/${r.bimg}`;
		},
		error : e => {}
	});
}




