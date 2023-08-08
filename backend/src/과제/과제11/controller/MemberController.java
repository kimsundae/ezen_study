package 과제.과제11.controller;

import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.MemberDto;

public class MemberController {
	private static MemberController memberController = new MemberController();
	private MemberController() {}
	public static MemberController getInsatance() {
		return memberController;
	}
	// 2. 회원가입 처리[ 반환 : 1:성공 2:실패[db오류] 3:아이디중복실패 4.전화번호중복실패
	public int signup( String id , String pw , String name , String phone) {	
		MemberDto member = new MemberDto( id , pw , name , phone );
		// 1. 아이디중복체크
		if(MemberDao.getInstance().infoCheck("mid" , id)) return 3;
		// 2. 전화번호중복체크
		if(MemberDao.getInstance().infoCheck("mphone", phone))return 4;
		
		
		// 2. Dao에게 전달 하고 SQL 결과 받기
		boolean result = MemberDao.getInstance().signup(member);
		// 3. 결과를 view에게 전달
		if(result) return 1;
		else return 2;
	}
	//3. 로그인 처리
	public boolean login(String id , String pw) {			
		boolean result = MemberDao.getInstance().login( id , pw);
		return result;
	}
	//4. 
	public String findById( String name , String phone ) {
		// - 테스트. view 전달받은 매개변수 확인
		System.out.println("view value : " + name + phone);
		// Dao에게 매개변수 전달하고 찾은 아이디 반환 받기
		String result = MemberDao.getInstance().findById(name, phone);
		if ( result != null ) { return result;}
		else return null;
	}
	//5.
	public String findByPw( String id , String phone ) {
		System.out.println("view value : " + id + phone);
		// Dao에게 매개변수 전달하고 찾은 비밀번호 반환 받기
		String result = MemberDao.getInstance().findByPw(id, phone);
		if( result != null)return result;
		else return null;
	}
	
}
