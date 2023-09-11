package controller.chatting;

import java.util.ArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import model.dto.ClientDto;

/*
 * 	1. 서버 웹소켓 만들기
 * 		1. 클래스 선언
 * 		2. 클래스 위에 @ServerEndpoint("서버소켓의 URL 정의") : 클라이언트소켓들이 접속하는 위치
 * 		3. 서버 웹소켓의 필수 메소드
 * 				@OnOpen : 클라이언트소켓이 서버소켓에 연결이 접속했을 때
 * 				@Onclose : 클라이언트소켓이 서버소켓과 연결이 닫혔을 때
 * 				@OnMessage : 클라이언트소켓이 메세지를 보냈을 때
 * 				@OnError : 클라이언트소켓이 연결에 에러가 발생했을 때
 * 		
 * 
 */
@ServerEndpoint("/ChattingSocket/{mid}")
public class ChattingSocket {
	
	static ArrayList<ClientDto> clientList = new ArrayList<>();
	
	//1.
	@OnOpen // 클라이언트가 서버소켓의 접속했을 때 매핑/연결
	public void onOpen( Session session , @PathParam("mid") String mid ) {
		System.out.println("클라이언트 소켓 접속 :" + session);
		System.out.println("접속한 회원아이디:" + mid);
		System.out.println(session.getRequestURI());
		// 1-1 : 접속된 클라이언트소켓을 리스트에 저장하자.
		ClientDto clientDto = new ClientDto(session , mid);
		clientList.add( clientDto );

		System.out.println("접속명단 : " + clientList);
	}
	// 2. 클라이언트가 서버소켓과 연결이 닫혔을 때 매핑/연결 (JS에서 웹소켓 객체를 초기화 = 새로고침[F5],페이지전환 등등
	@OnClose
	public void onClose(Session session) {
		clientList.remove(session);
	}
	//3.
	@OnMessage
	public void onMessage( Session session , String msg) {
		System.out.println(msg);
		// 현재 접소괸 명단들에게 메세지 전달
		/*
		 * for( int i = 0; i < 접속명단.size(); i++) { Session s = 접속명단.get(i); } for(
		 * Session s : 접속명단 ) {}
		 */
		clientList.forEach( s -> {
			try {
				s.getBasicRemote().sendText(msg);
			}catch(Exception e) {e.printStackTrace();}
					
		});
		
	}
	
	
}
