package controller.chatting;

import java.io.IOException;
import java.util.ArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dto.ClientDto;
import model.dto.MsgDto;

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

	// 1.
	@OnOpen // 클라이언트가 서버소켓의 접속했을 때 매핑/연결
	public void onOpen(Session session, @PathParam("mid") String mid) {
		System.out.println("클라이언트 소켓 접속 :" + session);
		System.out.println("접속한 회원아이디:" + mid);
		System.out.println(session.getRequestURI());
		// 1-1 : 접속된 클라이언트소켓을 리스트에 저장하자.
		ClientDto clientDto = new ClientDto(session, mid);
		clientList.add(clientDto);

		System.out.println("접속명단 : " + clientList);
	}
	@OnMessage 
	public void onMessage( Session session , String msg) throws Exception {
		System.out.println("보낸 클라이언트소킷[누가] : "+ session +" 보낸 내용[무엇을] : " + msg);
		
		// 2-2 메세지를 보낼 내용 구성. [보낸사람 , 보낸내용]
		MsgDto dto = null;
			// - 보낸사람 찾기 [보낸 세션을 이용한 보낸 mid찾기]
			for( ClientDto clientDto : clientList) {
				if( clientDto.getSession() == session) {
					// 회원목록 중에 보낸 세션과 일치하면
					dto = new MsgDto( clientDto.getMid() , msg);
					break;
				}
			}
			// - msgDto를 JSON 사용할 수 있도록 형변환
			ObjectMapper mapper = new ObjectMapper();
			String jsonMsg = mapper.writeValueAsString(dto);
			
		
		// 2-1 받은 메시지를 접속된 회원들에게 모두 전송
		for( ClientDto clientDto : clientList) {
			clientDto.getSession().getBasicRemote().sendText(jsonMsg);
		}
	}
	@OnError
	public void onError( Session session , Throwable throwable) throws Exception{}
	@OnClose
	public void onClose( Session session  ) throws Exception {
		// * 접속목록에서 세션 제거
		for( ClientDto clientDto : clientList ) {
			if( clientDto.getSession() == session) {
				clientList.remove(clientDto);
				break;
			}		
		}
		
	}
	/*
	 * // 2. 클라이언트가 서버소켓과 연결이 닫혔을 때 매핑/연결 (JS에서 웹소켓 객체를 초기화 = 새로고침[F5],페이지전환 등등
	 * 
	 * @OnClose public void onClose(Session session) { clientList.remove(session); }
	 * //3.
	 * 
	 * @OnMessage public void onMessage( Session session , String msg) {
	 * System.out.println(msg); // 현재 접소괸 명단들에게 메세지 전달
	 * 
	 * for( int i = 0; i < 접속명단.size(); i++) { Session s = 접속명단.get(i); } for(
	 * Session s : 접속명단 ) {}
	 * 
	 * clientList.forEach( s -> { try { s.getBasicRemote().sendText(msg);
	 * }catch(Exception e) {e.printStackTrace();}
	 * 
	 * });
	 * 
	 * }
	 */
	/* @OnOpen
	 * 		public void onOpen( Session session) {}
	 * @OnClose
	 * 		public void OnClose( Session session , Throwable throwable ){} 
	 * OnError
	 * 		public void OnError( Session session , Throwable throwable ){} 
	 * @OnMessage
	 * 		public void onMessage( Session session , String msg ){} 
	 * 		getBasicRemote().sendText(msg)
	 */

}
