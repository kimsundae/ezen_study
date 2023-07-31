package java1.day13.Ex2.model.dao;

import java.util.ArrayList;

import java1.day13.Ex2.model.dto.BoardDto;

public class BoardDao {
	// 싱글톤(공유)O :
	private static BoardDao boardDao = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() {
		return boardDao;
	}
	// 게시물 여러개 저장하는 곳
		// 1. 배열
	public BoardDto[] boardDtoArray = new BoardDto[100];
		// 2. 리스트 : 배열을 쉽게 사용할 수 있도록 다양한 함수 제공
	public ArrayList<BoardDto> boardList = new ArrayList<>();
		// ArrayList : 배열처럼 사용가능한 클래스 객체 선언
			// <클래스> : 리스트 안에 여러개 객체를 저장할 객체의 타입
				// boardList : 리스트객체 변수명
}
