package java1.day11.Ex4디자인패턴2.view;

import java.util.Scanner;

import java1.day11.Ex4디자인패턴2.controller.MemberController;

public class MainPage { // 입출력 담당하는 클래스 // view -> HTML/JS
	// 0. 싱글톤 생성
		// 1. 현재 클래스로 static 객체 생성 , 필드는 무조건 잠금
	private static MainPage mainPage = new MainPage();
		// 2. 외부객체에서 해당 싱글톤 호출하기 위한 메소드
	public static MainPage getInstance() {return mainPage;}
		// 3. 외부 해당 클래스로 객체 생성 잠금
	private MainPage() {}
	// 1. 필드
	private Scanner sc = new Scanner(System.in);
	// 2. 생성자
	
	// 3. 함수
	public void mainPage() {
		while(true) {			
			System.out.println("\n\n--------- 회원 시스템 ---------"); 
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기    \n선택> ");
			int ch = sc.nextInt(); 			
			if( ch == 1 ) { singupPage(); }
			else if( ch == 2 ) { loginPage(); } 
			else if( ch == 3 ) {findIdPage(); } 
			else if( ch == 4 ) { findPwPage(); } 			
		} // w e 
	}
	
	void singupPage() {
		System.out.println("------[회원가입]-----");
		System.out.print("아이디를 입력해주세요"); String id = sc.next();		
		System.out.print("비밀번호를 입력해주세요"); String password = sc.next();
		System.out.print("이름을 입력해주세요"); String name = sc.next();
		System.out.print("전화번호를 입력해주세요"); String phoneNumber = sc.next();
		System.out.print("나이를 입력해주세요"); int age = sc.nextInt();
		// ---> 컨트롤러/서빙에게 전달 // 컨트롤 클래스내 메소드 호출
		boolean result = MemberController.getInstance().singupLogic( id , password , name , phoneNumber , age);
		if(result) 	System.out.println("회원가입 성공.");
		else System.out.println("회원가입 실패");
	}
	void loginPage() 
	{
		System.out.println("------[로그인]-------");
		System.out.print("아이디를 입력해주세요"); String id = sc.next();
		System.out.print("비밀번호를 입력해주세요"); String password = sc.next();
		boolean result = MemberController.getInstance().loginPage( id , password);
		if(result) 	System.out.println("로그인 성공.");
		else System.out.println("로그인 실패");
	}
	void findIdPage() 
	{
		System.out.println("-----[아이디 찾기]-----");
		System.out.print("이름을 입력해주세요."); String name = sc.next();
		System.out.println("전화번호를 입력해주세요."); String phoneNumber = sc.next();
		
		String result = MemberController.getInstance().findIdPage( name , phoneNumber);		
		if(result.equals("notExist"))		
			System.out.println("일치하는 정보가 없습니다.");	
		else		
			System.out.println("아이디 : " + result);		
	}
	void findPwPage() 
	{
		System.out.println("-----[비밀번호 찾기]-----");
		System.out.print("아이디를 입력해주세요."); String id = sc.next();
		System.out.println("전화번호를 입력해주세요."); String phoneNumber = sc.next();
		String result = MemberController.getInstance().findPwPage( id , phoneNumber);
		if(result.equals("notExist"))		
			System.out.println("일치하는 정보가 없습니다.");	
		else		
			System.out.println("임시비밀번호 : " + result);	
	}
}
