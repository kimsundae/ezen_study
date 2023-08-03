package 복습.part7.controller;

import 복습.part7.model.dao.BoardDao;
import 복습.part7.model.dto.BoardDto;

public class BoardController {
	private static BoardController boardController = new BoardController();
	private BoardController() {}
	public static BoardController getInstance() {
		return boardController;
	}
	
	
	public boolean signUp( String id , String pw , String name , String phone , int age) {
		BoardDto member = new BoardDto( id , pw , name , phone , age);
		for(int i = 0; i < BoardDao.getInstance().memberList.length; i++) {
			if(BoardDao.getInstance().memberList[i] == null) {
				BoardDao.getInstance().memberList[i] = member;
				return true;
			}
		}
		return false;
	}
	public boolean login( String id , String pw) {
		for(int i = 0; i < BoardDao.getInstance().memberList.length; i++) {
			if ( BoardDao.getInstance().memberList[i] == null) {
				return false;
			}
			if( BoardDao.getInstance().memberList[i].getId().equals(id) && BoardDao.getInstance().memberList[i].getPw().equals(pw)) {
				return true;
			}		
		}
		return false;
	}
	
}
