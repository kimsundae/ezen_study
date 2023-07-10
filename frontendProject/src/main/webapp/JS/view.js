
// 1. list.js 에서 클릭된 게시물 번호 호출 [ 세션 ]
let no = sessionStorage.getItem( 'no' );
let boardList = JSON.parse(localStorage.getItem('boardList'));
console.log( ' list.js 에서 저장된 세션정보: ' + no);

// 2. 클릭된 게시물번호의 게시물찾아서 출력
onView();
function onView(){
	// 식별자 : 게시물번호 = 인덱스 찾기
	
	// 1. 어디에
	let title = document.querySelector('.title');
	let writedate = document.querySelector('.writedate');
	let content = document.querySelector('.content');
	
	for( let i = 0; i < boardList.length; i++){
		let b = boardList[i] // i번째 게시물을 꺼내기
		if( b.no == no ){
			// 만약에 i번째 게시물번호와 클릭된 게시물 번호와 같으면
			console.log( b ); 
			// 3. 대입
			title.innerHTML = b.title;
			writedate.innerHTML = ` 작성자 : ${b.writer} 작성일 : ${ b.date } `
			content.innerHTML = b.content
			break; // 반복문 종료
		}
	}
}

// 3.현재 보고 있는 게시물 삭제하기 [ 실행조건 : 삭제하기 버튼을 클릭했을 때 ]
function onClear( ){ // 삭제할 식별자 x 전역변수에 no에 있기 때문에
	
	// 1. 삭제할 게시물 찾기
	for( let i = 0; i < boardList.length; i++){
		// 2. 클릭된 게시물(현재 보고 있는 게시물) 와 i번째 게시물과 번호가 같으면
		if( no = boardList[i].no ){
			// 3. 삭제하기
			boardList.splice( i , 1 ); // i번째 인덱스 1개 삭제하기
				// 배열에 변화된 결과를 쿠키/세션 [ JS메모리 X ]에 반영
				localStorage.setItem( 'boardList' , JSON.stringify(boardList));
				// 클릭된 게시물 번호는 세션에서 삭제
				sessionStorage.removeItem('no'); 
				//페이지 전환
				location.href="list.jsp"
			// 4. 삭제 후 다음 인덱스는 확인할 필요가 없다.
			break;
		}
		
	}
	/*for( let i = 0; i < boardList.length; i++){
		let b = boardList[i] // i번째 게시물을 꺼내기
		if( b.no == no ){
			boardList.splice( i , 1);
			localStorage.setItem( 'boardList' , JSON.stringify(boardList) )
		}
	}		

	console.log(boardList)
	location.href="list.jsp"*/
}

