package 과제.과제11.view;

import java.util.Scanner;

import 과제.과제11.controller.MemberController;

public class MainPage {

	private static MainPage mainPage = new MainPage();
	private MainPage() {}
	public static MainPage getInsatance() {return mainPage;	}
	
	// 0.
	private Scanner sc = new Scanner(System.in);
	
	// 1. 메인메뉴
	public void mainPage() {
		while(true) {
			System.out.println("\n\n ===== 회원제 커뮤니티 =====");
			System.out.print("1.회원가입 2.로그인 선택 3.아이디 찾기 4.비밀번호 찾기 ");
			try {
				int ch = sc.nextInt(); // 만약에 타입과 일치하지 않는 값을 입력하면 InputMismatchException
				if( ch == 1 ) {signup();}
				else if(ch == 2) { login(); }
				else if(ch == 3) { findById(); }
				else if(ch == 4) { findByPw(); }
			}catch( Exception e ) {
				System.out.println("경고] 잘못 입력했습니다.");
				sc = new Scanner(System.in); // 입력객체의 메모리를 새롭게 만들어주기
			}
			
		}
			
	}
	// 2. 회원가입
	public void signup() {
		try {
			System.out.print("아이디 입력"); String id = sc.next();
			System.out.print("비밀번호 입력"); String pw = sc.next();
			System.out.print("이름 입력"); String name = sc.next();
			System.out.print("전화번호 입력"); String phone = sc.next();
		int result = MemberController.getInstance().signup( id , pw , name , phone);
		if(result == 1)
			System.out.println("회원가입 성공");
		else if( result == 2)
			System.out.println("회원가입 실패");
		else if (result == 3)
			System.out.println("회원가입 실패) 아이디 중복");
		else if ( result ==4)
			System.out.println("회원가입 실패) 전화번호 중복");
		}// try e 
		
		catch( Exception e) {
			System.out.println("경고) 잘못 입력했습니다.");
			sc = new Scanner(System.in);
		}				
				
	}
	// 3. 로그인
	public void login() {
		try {
			System.out.print("아이디 입력"); String id = sc.next();
			System.out.print("비밀번호 입력"); String pw = sc.next();		
			boolean result = 
						MemberController.getInstance().login( id , pw );
			if( result ) {
				System.out.println("로그인 성공");
				LoginPage.getInstance().loginMenu();
			}
			else { System.out.println("로그인 실패");}
		
		
		}
		catch( Exception e) {
			System.out.println("------로그인 페이지------");
			System.out.println("경고) 잘못 입력했습니다.");
			sc = new Scanner(System.in);
		}				
		
	}
	
	//4. 
	public void findById() {
		System.out.println("--------아이디 찾기 페이지------");
		System.out.print("이름 입력"); String name = sc.next();
		System.out.print("전화번호 입력"); String phone = sc.next();	
		String result = MemberController.getInstance().findById(name ,  phone);
		
		if( result != null)System.out.println("회원님의 아이디 : " + result );
		else System.out.println("경고] 정보가 일치한 아이디가 없습니다.");
	}
	//5.
	public void findByPw() {
		System.out.println("--------비밀번호 찾기 페이지------");
		System.out.print("아이디 입력"); String id = sc.next();
		System.out.print("전화번호 입력"); String phone = sc.next();	
		String result = MemberController.getInstance().findByPw(id ,  phone);
		
		if( result != null)System.out.println("회원님의 비밀번호 : " + result );
		else System.out.println("경고] 정보가 일치한 비밀번호가 없습니다.");
	}
}
