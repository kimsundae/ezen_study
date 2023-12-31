// ajax(기본값 비동기통신)가 응답의 결과를 가지고 오기 전에 아래코드 실행.[loginState 변경되기 전에 실행되므로 문제발생]

if(loginState == false){alert('회원전용 페이지입니다.'); location.href = "/jspweb/member/login.jsp";}
console.log('채팅방에 입장한 아이디 : ' + loginMid); console.log('loginState : ' + loginState);
// 1. 클라이언트 소켓 만들기
let clientSocket = new WebSocket(`ws://localhost:80/jspweb/ChattingSocket/${loginMid}`)
//-------------------------------------------------------//
clientSocket.onopen = e=> {
	console.log('서버와 접속이 성공')
	let msg = {type : 'alarm' , content : `${loginMid}님이 입장했습니다`}
	
	clientSocket.send(JSON.stringify(msg));
};
clientSocket.onclose = '';
clientSocket.onerror = '';
clientSocket.onmessage = e => onMsg(e);

//3. 서버에게 메시지 전송
function onSend(){
	// 3-1 textarea 입력값 호출
	let msgValue = document.querySelector('.msg').value
	if( msgValue == '' || msgValue == '\n'){alert('내용을 입력해주세요.');document.querySelector('.msg').value = ``; return;}
	
	let msg = {type : 'message' , content : msgValue}
	// 3-2 메시지 전송
	clientSocket.send(JSON.stringify(msg));
	// 3-3 메세지 전송 성공 시 
	document.querySelector('.msg').value = ``;
}
function onEnterKey(){
	
	
	// 2. 만약에 ctrl + 엔터이면 줄바꿈 
	if( window.event.keyCode == 13 && window.event.ctrlKey){
		document.querySelector('.msg').value += `\n`;return;
	}
	// 1. 만약에 입력한 키가 [엔터]이면 메시지 전송
	if( window.event.keyCode == 13){onSend();return;}
}
function onMsg( e ){
	console.log( "e :" +e)
	console.log("e.data : " + e.data)
	let msgBox = JSON.parse(e.data);		
	msgBox.msg = JSON.parse(msgBox.msg);
	
	// 2. msg속성 내 content \n -> <br>
	msgBox.msg.content = msgBox.msg.content.replace(/\n/g , '<br>')
	
	
	
	/*// 1. 어디에 출력할건지
	
	
	
	//let content = msgBox.msg.replace('\n' , '<br/>')
	console.log('msgBox: ' +msgBox.msg)
	// 2. 특정 문자열 찾아서 찾은 문자열 모두 치환/바꾸기/교체 => java : .replaceAll(); js: 정규표현식
 	let content = msgBox.msg.replace( /\n/g , '<br>')
 	console.log('content : ' + content)
 	msgBox.msg = JSON.parse(content);*/
 	
 	let chatcont = document.querySelector('.chatcont');
	let html = ``;
	// 2. 무엇을
	if(msgBox.msg.type == 'alarm'){
		html = `${typeHTML(msgBox.msg)}`
	}
	else if(msgBox.frommid == loginMid){
		html =  `			
							<div class="rcont">
								<div class="subcont">
									<div class="date">${msgBox.date}</div>
									${typeHTML(msgBox.msg)}
								</div>
							</div>
					`;
	}else{
		html = `
				<div class="lcont">					
					<img class="pimg" src="/jspweb/member/img/${msgBox.frommimg}">
					<div class="tocont">
						<div class="name">${msgBox.frommid}</div><!-- 보낸사람 -->
						<div class="subcont">
							${typeHTML(msgBox.msg)}
							<div class="date"> ${msgBox.date} </div>
						</div>					
					</div>
				</div>
				`;
	}
	
	// 3. 누적 대입 [기존채팅이 존재]
	chatcont.innerHTML += html;
	// ------------- 스크롤 최하단으로 내리기( 스크롤 이벤트 ) ----//
	// 1. 현재 스크롤의 상단 위치 좌표.
	let topHeight = chatcont.scrollTop; // dom객체.scrollTop : 해당 div객체
		console.log( topHeight )
	let scrollHeight = chatcont.scrollHeight; // dom객체.scrollHeight
		console.log( scrollHeight )
	// 3. 전체 높이 값을 현재 스크롤 상단 위치에 대입
	chatcont.scrollTop = chatcont.scrollHeight;
	
}

getEno();
function getEno(){
	
	// -
	for( let i = 1; i<=43; i++){
		document.querySelector('.emolistbox').innerHTML 
				+= `<img onclick="onEmoSend(${i})" src="/jspweb/img/imoji/emo${i}.gif">` 
	}
}
// 7. 클릭한 이모티콘 서버로 보내기
function onEmoSend(i){
	
	let msg = { type : 'emo' , content : i+""};
		// type : msg[메시지] , emo[이모티콘] , img[사진]
		// content : 내용물
	
	// 2. 보내기
	clientSocket.send( JSON.stringify(msg) );
}
// 8. msg 타입에 따른 HTML 반환 함수
function typeHTML( msg ){
	let html = ``;
	
	// 1. 메시지 타입 일때는 <div> 반환  
	if( msg.type == 'message'){
		html += `<div class="content"> ${ msg.content } </div>`;
	}
	// 2. 이모티콘 타입 일때는 <img> 반환 
	else if( msg.type == 'emo' ){
		html += `<img src="/jspweb/img/imoji/emo${msg.content}.gif" />`;
	}
	else if(msg.type == 'alarm'){
		html += `<div class="alarm">${msg.content}</div>`
	}
	return html;
}

/*
	JS[ HTML파일 종속된 파일 - HTML 안에서 실행되는 구조 ]

	* 
		클라이언트 : 사용 데이터 요청 하는 PC
		서버 : 데이터 제공하는 PC
	* URL[주소]상의 매개변수 전달하는 방법
		1. 쿼리스트링 방식 : URL?매개변수명1=데이터1&매개변수명2=데이터2&매개변수명3=데이터3
		2. 경로매개변수 : URL/데이터1/데이터2/데이터3
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
		
	
	동기화									비동기화[ 여러 기능을 별도로 처리] 
	
	Client			Server					Client			Server
	
		-----요청1------>							-----요청1------>
	대기상태			요청1처리중					대기상태x				요청1처리중[5분]
		<----응답1------							-----요청2------>
																요청2처리중[1분]
		-----요청2------>							<-----응답2-------
					요청2처리중
		<-----응답2-----							<-----응답1------

*/
	