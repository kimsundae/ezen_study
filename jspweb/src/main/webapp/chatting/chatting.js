
// 1. 클라이언트 소켓 만들기

	// 1. JS웹 소켓 만들기 [WebSocket클래스]
		// new WebSocket('서버소켓 URL'); 
	let 클라이언트소켓 = new WebSocket('ws://localhost:8080/jspweb/ChattingSocket'); console.log(클라이언트소켓)
	
	// 내가 만든 함수를 클라이언트소켓 속성에 대입
	클라이언트소켓.onmessage = ( event ) => onmsg(event);
	
function msgsend(){
	
	let msg = document.querySelector('.inputcontent').value;
	// 2. 클라이언트소켓 .send()
	클라이언트소켓.send(msg); 
}
// 연결된 서버소켓으로부터 메세지를 받았을 때
function onmsg(e){
	console.log(e)
	console.log(e.data);
	
	document.querySelector('.contentbox')
			.innerHTML += `<div>${e.data}</div>`
}