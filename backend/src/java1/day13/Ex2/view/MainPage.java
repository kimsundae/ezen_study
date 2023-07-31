package java1.day13.Ex2.view;

import java.util.Scanner;

import java1.day13.Ex2.controller.BoardController;
import java1.day13.Ex2.model.dto.BoardDto;

public class MainPage {
	
	// ------------------ 싱글톤 --------------------//
	// 싱글톤O : 게시물마다가 아닌 모든 게시물이 동일한 기능 수행
	// 1. 현재클래스 안에 현재클래스로 싱글톤 객체 선언 [ private static ]
	private static MainPage mainPage = new MainPage();
	// 2. 외부로부터 간접적으로 싱글톤이 호출되도록 하는 함수
	public static MainPage getInstance() {
		return mainPage;
	}
	// 3. 외부로부터 객체 생성 차단하는 생성자 선언
	private MainPage() {}
	
	// 입력객체 필드
	private Scanner sc = new Scanner(System.in);
	
	// 글등록 페이지 입출력 함수
	public void mainPage()
	{
		while(true) 
		{
			System.out.println("\n\n >>>> 방문록 프로그램 >>>>");
			System.out.println("1.글등록 2.글보기 3.글삭제 4.글수정 선택>");
			int ch = sc.nextInt();
			if( ch == 1 ) {writeView();}
			else if( ch == 2 ) {printView();}
			else if( ch == 3 ) {deleteView();}
			else if( ch == 4 ) {updateView();}
			
		} // while end
	} // f end
	
	// 글등록 페이지 입출력 함수
	public void writeView()
	{
		
		// 1. 내용(띄어쓰기o)과 작성자(띄어쓰기x)을 입력받아 변수 저장
		sc.nextLine(); // nextLine() 함수 앞에 nextint() 실행되므로 오류 발생 방지
		System.out.print("방문록 : "); String content = sc.nextLine(); // nextLine()함수 앞뒤로 다른 next()가 있을 때 하나의 입력으로 인식[오류]		
		System.out.print("작성자 : "); String writer = sc.next();
		// 2. 입력받은 변수를 컨트롤에게 전달
		// 현재위치도 java 컨트롤도 java이므로 메소드 이용한다.
		// 전달보내기 = 매개변수 / 전달받기 = 리턴
		boolean result = BoardController.getInstance().writerLogic( writer , content );
		if(result) System.out.println("등록 성공");			
		else System.out.println("등록 실패");	
			
		
	}
	// 글출력 페이지 입출력 함수
	public void printView() {
		// 1. 보고자하는 게시물의 인덱스 입력받아서 저장
		System.out.print("출력할 게시물의 인덱스 : "); 
		int index = sc.nextInt();
		viewUp( index );
		// 2. view에서 컨트롤에게 입력받은 인덱스 전달보내고 선택한 인덱스의 게시물 1개 리턴받음
		BoardDto boardDto = BoardController.getInstance().printLogic(index);
		
		// 3. 전달받은 결과를 출력
		System.out.println("검색한 방문록 정보 : ");
		System.out.print("[작성자] : " + boardDto.getWriter() +
				" [내용] : " + boardDto.getContent() +
				" [조회수] : " + boardDto.getView());
	}
	// 글수정 페이지 입출력 함수
	public void updateView() {
		
		System.out.print("수정할 게시물의 인덱스 : "); int index =sc.nextInt();
		sc.nextLine();
		System.out.print("수정할 내용을 입력 : "); String content = sc.nextLine();
		
		boolean result = BoardController.getInstance().updateLogic( index , content);
		if(result) System.out.println("수정이 완료되었습니다.");
		else System.out.println("수정이 실패하였습니다.");
	}
		
	// 글삭제 페이지 입출력 함수
	public void deleteView() {
		
		System.out.print("삭제할 게시물의 인덱스 : "); int index =sc.nextInt();
		boolean result = BoardController.getInstance().deleteLogic( index );
		if(result) System.out.println("삭제가 완료되었습니다.");
		else System.out.println("삭제가 실패하였습니다.");
	}
	// 조회수 증가 함수
	public void viewUp(int index) {
		BoardController.getInstance().viewUpLogic(index);
	}
	
}
