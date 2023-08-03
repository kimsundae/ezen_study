package 복습.part7.model.dao;

import 복습.part7.controller.BoardController;
import 복습.part7.model.dto.BoardDto;

public class BoardDao {
	private static BoardDao boardDao = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() {
		return boardDao;
	}
	
	//여러개 MemberDto객체를 저장하기 위한 MemberDto[] 객체배열 = new MemberDto[100]; 선언합니다.
	public BoardDto[] memberList = new BoardDto[100];
} 
