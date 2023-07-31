package java1.day13.Ex2.controller;

import java1.day13.Ex2.model.dao.BoardDao;
import java1.day13.Ex2.model.dto.BoardDto;

public class BoardController {

	// 싱글톤O : 게시물마다가 아닌 모든 게시물이 동일한 기능 수행
	private static BoardController boardController = new BoardController();
	private BoardController() {}
	public static BoardController getInstance() {
		return boardController;
	}
	// 글쓰기 처리 기능함수
	public boolean writerLogic( String writer , String content)
	{
		BoardDto boardDto = new BoardDto( writer , content );
		for(int i = 0; i < BoardDao.getInstance().boardDtoArray.length; i++) 
		{
			if(BoardDao.getInstance().boardDtoArray[i] == null)
			{
				BoardDao.getInstance().boardDtoArray[i] = boardDto;
				// 2. 객체를 리스트에 저장
				//BoardDao.getInstance().boardList.add(boardDto);
				return true;
			}
		}// for end				
		// 성공[true]또는 실패[false]
		return false;
	}
	// 글출력 처리 기능함수
	public BoardDto printLogic( int index )
	{						
		return BoardDao.getInstance().boardDtoArray[index-1];										
	}
	// 글삭제 처리 기능함수
	public boolean updateLogic( int index , String content ) 
	{
		BoardDao.getInstance().boardDtoArray[index-1].setContent(content);
		return true;
	}
	// 글수정 처리 기능함수
	public boolean deleteLogic( int index ) 
	{
		for(int i = 0; i < BoardDao.getInstance().boardDtoArray.length;i++) {
			if( BoardDao.getInstance().boardDtoArray[index+i] != null) {
				BoardDao.getInstance().boardDtoArray[index-1+i] = BoardDao.getInstance().boardDtoArray[index+i];
			}else {
				BoardDao.getInstance().boardDtoArray[index-1+i] = null;
				return true;
			}			
		}
		return false;
	}
	public void viewUpLogic(int index) {
		BoardDao.getInstance().boardDtoArray[index-1].setView(BoardDao.getInstance().boardDtoArray[index-1].getView()+1);
	}
}
