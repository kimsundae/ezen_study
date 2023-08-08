package 과제.과제11.view;

import java.util.Scanner;

import 과제.과제11.controller.MemberController;
import 과제.과제11.model.dto.MemberDto;

public class LoginPage {
	// 0.싱글톤
	private static LoginPage loginPage = new LoginPage();
	private LoginPage() {}
	public static LoginPage getInstance() {return loginPage;}
	// 0. 입력객체
	private Scanner sc = new Scanner(System.in);
	// 1. loginMenu : 로그인 했을 때 메뉴 페이지
	public void loginMenu() {
		while( MemberController.getInstance().getLoginSession() != 0) {// 로그인이 되어 있는 경우에만
			System.out.println("\n\n ================");
			System.out.print("1.로그아웃 2.회원정보 3.글쓰기 선택 ");
			try {
				int ch = sc.nextInt(); // 만약에 타입과 일치하지 않는 값을 입력하면 InputMismatchException
				if( ch == 1 ) {MemberController.getInstance().logOut();}
				else if(ch == 2) { info(); }
				else if(ch == 3) { boardWrite(); }
			}catch( Exception e ) {
				System.out.println("경고] 잘못 입력했습니다.");
				sc = new Scanner(System.in); // 입력객체의 메모리를 새롭게 만들어주기
			}
		}
	}
	// 2. info		: 로그인 된 회원정보 페이지
	public void info() {
		System.out.println("\n\n===== info =====");
		// 1. 컨트롤에게 회원정보 요청해서 1명의 회원정보[DTO] 반환 받기
		MemberDto result = MemberController.getInstance().info();
		// 2. 반환받은 회원정보객체[memberDto]의 각필드를 출력
		System.out.println(" >ID : " + result.getId());
		System.out.println(" >NAME : " + result.getName());
		System.out.println(" >PHONE : " + result.getPhone());
		
		// 2. 서브메뉴
		System.out.print("1.비밀번호수정 2.회원탈퇴 3.뒤로가기 선택 : ");
		int ch = sc.nextInt();
		if(ch == 1) {infoUpdate();}
		else if(ch == 2) {infoDelete();}
		else if(ch == 3) {return;} // 생략가능
	}
	// 3. infoUpdate : 비밀번호수정 페이지
	public void infoUpdate() {
		System.out.print("수정할 비밀번호를 입력해주세요."); String newPw = sc.next();
		boolean result = MemberController.getInstance().infoUpdate( newPw );
		if( result ) {
			System.out.println("안내]비밀번호 수정 완료:로그아웃됩니다.");
			MemberController.getInstance().logOut();
		}
		else {System.out.println("경고]비밀번호 수정 실패 : 관리자에게 문의");}
		
	}	
	// 4. infoDelete : 회원탈퇴 페이지
	public void infoDelete() {
		System.out.println("\n\n ====== member delete ====== ");
		System.out.print("정말 탈퇴하시겠습ㅂ니까?? 1.예 2.아니오 : ");
		int ch = sc.nextInt();
		if( ch == 1) {
			boolean result = MemberController.getInstance().infoDelete();
			if( result ) {
				System.out.println("회원 탈퇴 성공");
				MemberController.getInstance().logOut();
			}else {
				System.out.println("경고]회원탈퇴실패 : 관리자에게 문의");
			}
		}
	}
	// 5. boardWrite : 게시물쓰기 페이지
	public void boardWrite() {
		System.out.print("글 제목 입력"); String title = sc.next();
		sc.nextLine();
		System.out.print("내용 입력"); String content = sc.nextLine();
		boolean result = MemberController.getInstance().boardWrite( title , content);
		if(result)System.out.println("글쓰기 성공");
		else System.out.println("글쓰기 실패");
	}
	// 6. boardPrint : 모든 게시물 출력
	public void boardPrint() {}
	// 7. boardView	 : 개별 게시물 출력
	public void boardView() {}
	// 8. boardUpdate : 게시물 수정
	public void boardUpdate() {}
	// 9. boardDelete : 게시물 삭제
	public void boardDelete() {}
	
}
