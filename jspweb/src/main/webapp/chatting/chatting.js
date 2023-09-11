if(loginState == false){alert('회원전용 페이지입니다.'); location.href = "/jspweb/member/login.jsp";}

// 1. 클라이언트 소켓 만들기
let 클라이언트소켓 = new WebSocket("ws://localhost:8080/jspweb/ChattingSocket")
//-------------------------------------------------------//

/*
	JS[ HTML파일 종속된 파일 - HTML 안에서 실행되는 구조 ]

	* 
		클라이언트 : 사용 데이터 요청 하는 PC
		서버 : 데이터 제공하는 PC

	* 소켓이란.
		- 통신의 종착점[데이터가 전달되는 위치 -받는사람 -보낸사람]
	
		-예시
		[클라이언트소켓]							[서버소켓]
		강호동집								 우체국
			- 안산
		
		신동엽집
			- 수원	
		
		
		
	* WebSocket 웹소켓 라이브러리
		- 소켓 관련된 함수들을 제공하는 클래스
		


*/
	