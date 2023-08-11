package 과제.과제11.view;

import java.util.ArrayList;
import java.util.Scanner;

import 과제.과제11.controller.BoardController;
import 과제.과제11.controller.MemberController;
import 과제.과제11.model.dto.BoardDto;
import 과제.과제11.model.dto.MemberDto;
import 과제.과제11.model.dto.MsgDto;

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
			
			boardPrint();
			
			System.out.println("\n\n ================");
			System.out.print("1.로그아웃 2.회원정보 3.글쓰기 선택 4.글조회");
			try {
				int ch = sc.nextInt(); // 만약에 타입과 일치하지 않는 값을 입력하면 InputMismatchException
				if( ch == 1 ) {MemberController.getInstance().logOut();}
				else if(ch == 2) { info(); }
				else if(ch == 3) { boardWrite(); }
				else if(ch == 4) {boardView();}
			}catch( Exception e ) {
				System.out.println("경고] 잘못 입력했습니다."+e);
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
		System.out.print("1.비밀번호수정 2.회원탈퇴 3.뒤로가기 4.쪽지확인 5.쪽지답장 선택 : ");
		int ch = sc.nextInt();
		if(ch == 1) {infoUpdate();}
		else if(ch == 2) {infoDelete();}
		else if(ch == 3) {return;} // 생략가능
		else if(ch == 4) { viewMsg();}
		else if(ch == 5) { System.out.print("답장 받을 사람의 아이디");
		String id = sc.next();
		sendMsg(id);
		}
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
		System.out.print("--- post write ---"); 
		System.out.print("제목 > "); String title = sc.next();
		System.out.print("내용 > "); String content = sc.next();
		boolean result = BoardController.getInstance().boardWrite( title , content );
		if(result)System.out.println("글쓰기 성공");
		else System.out.println("글쓰기 실패");
	}
	// 6. boardPrint : 모든 게시물 출력
	public void boardPrint() {
		System.out.println("----- post List -----");
		// 1. 여러개의 게시물을 요청해서 반환된 결과 저장
		ArrayList<BoardDto> result = 
				BoardController.getInstance().boardPrint();
		// 2. 출력
		System.out.printf("%-3s %-4s %-19s %-10s %s \n" , "no" , "view" , "date" , "mno" , "title");
				for(int i = 0; i < result.size(); i++) {
					BoardDto dto = result.get(i);
					System.out.printf("%-3s %-4s %-19s %-10s %s \n" ,
							dto.getBno() , dto.getBview(), dto.getBdate() , dto.getMno() , dto.getBtitle() );
				}
		
	}
	// 7. boardView	 : 개별 게시물 출력
	public void boardView() {		
		System.out.println(" ------ post VIEW ------");
		// 1. 보고자하는 게시물의 게시물번호를 입력받기[ 식별번호 ]
		System.out.print("게시물번호 : " ); int bno = sc.nextInt();
		// 2.
		BoardDto result = BoardController.getInstance().boardView(bno);
		//3.출력
		System.out.printf("bno : %3s view : %3s mid : %10s date : %19s \n" ,
				result.getBno() , result.getBview() ,
				result.getMid() , result.getBdate()
			);
		System.out.printf("title : %s \n" , result.getBtitle());
		System.out.printf("content : %s \n" , result.getBcontent());
		viewAdd(bno);
		// 4. 추가메뉴	
		System.out.println("1.뒤로가기 2.수정 3.삭제 선택 4.쪽지보내기>"); int ch = sc.nextInt();
		if( ch == 1 ) {}
		else if( ch == 2 ) {boardUpdate(bno , result.getMno());}
		else if( ch == 3 ) {boardDelete(bno , result.getMno());}
		else if( ch == 4) {sendMsg( bno );}
	}
	
	// 8. boardUpdate : 게시물 수정
	public void boardUpdate(int bno ,  int Mno ) {
		System.out.print("수정할 게시물 제목"); String title = sc.next();
		System.out.println("수정할 게시물 내용"); String content = sc.next();
		int result = BoardController.getInstance().boardUpdate( bno , Mno ,title , content );
		if(result == 1) {System.out.println("글 수정 성공");}
		else if(result == 2) {System.out.println("글 수정 실패 : 관리자 오류");}
		else if(result == 3) {System.out.println("본인 글만 수정 가능합니다");}
		else if(result == 4) {System.out.println("수정할 제목을 1~50글자 사이로 입력해주세요.");}
					
	}
	// 9. boardDelete : 게시물 삭제
	public void boardDelete(int bno , int mno) {
		int result = BoardController.getInstance().boardDelete( bno , mno );
		if( result == 1) {System.out.println("안내] 글 삭제 성공");}
		else if(result == 2) {System.out.println("안내] 글 삭제 실패 : 관리자 오류.");}
		else if(result ==3) {System.out.println("경고] 본인 글만 삭제 가능 합니다.");}
		
	}
	// 10. viewAdd : 조회수 증가
	public void viewAdd(int bno) {
		BoardController.getInstance().viewAdd(bno);				
	}
	// 쪽지 확인
	public void viewMsg() {
		ArrayList<MsgDto> result = BoardController.getInstance().viewMsg();
		System.out.println("보낸사람     쪽지내용    수신일");
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getSname() +"   "+
					result.get(i).getMcontent() + "   " +
					result.get(i).getMdate());
		}
	}
	// 쪽지 보내기
	public void sendMsg( int bno ) {
		System.out.print("쪽지 내용을 입력해주세요"); String content = sc.next();
		boolean result = BoardController.getInstance().sendMsg(bno , content);
		if(result)System.out.println("쪽지 보내기 성공");
		else System.out.println("쪽지 보내기 실패");
	}
	// 쪽지 답장 보내기
	public void sendMsg(String name) {
		System.out.print("쪽지 내용을 입력해주세요"); String content = sc.next();
		boolean result = BoardController.getInstance().sendMsg(name , content);
		if(result)System.out.println("쪽지 보내기 성공");
		else System.out.println("쪽지 보내기 실패");
	}
}
