package 과제.과제11.controller;

import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.MemberDto;

public class MemberController {
	private static MemberController memberController = new MemberController();
	private MemberController() {}
	public static MemberController getInstance() {
		return memberController;
	}
	// 0. 로그인된 회원의 번호를 저장하는 필드 = 웹세션
	private int loginSession = 0; // 0 : 로그인 안한상태 , 1이상 : 로그인된 회원의 번호
	public int getLoginSession() { return loginSession; }
	
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
	//3-1. 로그인 처리
	public boolean login(String id , String pw) {			
		int result = MemberDao.getInstance().login( id , pw);
		if(result >= 1) {this.loginSession = result; return true;}
		else {return false;}
	}
	//3-2 로그아웃 처리
	public void logOut() { this.loginSession = 0; }
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
	//6.
	public MemberDto info( ) {
		// 현재 로그인된 회원번호[loginSession]는 view에서 전달 받지않고 컨트롤안에 저장
		// 현재 로그인된 회원번호로 회원정보 요청하기
		return MemberDao.getInstance().info(loginSession);
	}
	//7. 비밀번호 수정
	public boolean infoUpdate( String newPw ) {
		return MemberDao.getInstance().fixPw(loginSession , newPw);
	}
	// 8. 회원 탈퇴
	public boolean infoDelete() {
		return MemberDao.getInstance().infoDelete(loginSession);
	}

		
			
		
}
