package model.dto;

import javax.websocket.Session;

public class ClientDto {
	
	private Session session;
	private String mid;
	public ClientDto() {
		// TODO Auto-generated constructor stub
	}
	public ClientDto(Session session, String mid) {
		super();
		this.session = session;
		this.mid = mid;
	}
	
}
