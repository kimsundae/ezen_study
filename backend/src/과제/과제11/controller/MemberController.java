package 과제.과제11.controller;

import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.MemberDto;

public class MemberController {
	private static MemberController memberController = new MemberController();
	private MemberController() {}
	public static MemberController getInsatance() {
		return memberController;
	}
	// 2. 회원가입 처리
	public boolean signup( String id , String pw , String name , String phone) {	
		MemberDto member = new MemberDto( id , pw , name , phone );
		// 2. Dao에게 전달 하고 SQL 결과 받기
		boolean result = MemberDao.getInstance().signup(member);
		// 3. 결과를 view에게 전달
		return result;
	}
	//3. 로그인 처리
	public boolean login(String id , String pw) {	
		boolean result = MemberDao.getInstance().login( id , pw);
		return result;
	}
	
}
