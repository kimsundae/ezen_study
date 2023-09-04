let bno = new URL(location.href).searchParams.get("bno");
getBoard()
// 1. 수정할 게시물의 정보를 보여주기
function getBoard(){
	
	// 2.쿼리스트링(URL주소상의 변수) 의 변수 가져오기
		// 쿼리스트링 : URL?변수명=값&변수명=값
	
	
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
			document.querySelector('.oldfile').innerHTML = r.bimg
		},
		error : e => {}
	});
}
// 2. 수정하기
function onUpdate(){
	
	let writeForm = document.querySelectorAll('.writeForm')[0]
	let formData = new FormData(writeForm);
		// 3. form 객체에 데이터 추가 [ bno ]
			// set( 속성명 , 값 ) // form에 속성 추가
		formData.set( "bno" , bno );
	$.ajax({
		url : "/jspweb/BoardInfoController" ,
		method : "put" , 
		data : formData,
		contentType : false ,
		processData : false , 
		success : r => {console.log(r)
			if( r ) { alert('수정성공'); location.href=`/jspweb/board/view.jsp?bno=${bno}`;}
			else alert('수정실패')
		} , 
		error : e => {} 
	})
	
	
	
}





