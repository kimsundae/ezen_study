package 복습.part7.view;

import java.util.Scanner;

import 복습.part7.controller.BoardController;

public class MainPage {
	
	private static MainPage mainPage = new MainPage();
	private MainPage() {}
	public static MainPage getInstance() {
		return mainPage;
	}
	private Scanner sc = new Scanner(System.in);
	public void mainPage() {
		while(true) {
			System.out.println("1.회원가입 2.로그인");
			System.out.print("선택>");  int ch = sc.nextInt();
			
			if( ch == 1) {
				signUp();
			}else if(ch ==2) {
				login();
			}
		}
	}
	public void signUp() {
		System.out.println("아이디 입력"); String id = sc.next();
		System.out.println("비밀번호 입력"); String pw = sc.next();
		System.out.println("이름 입력"); String name = sc.next();
		System.out.println("전화번호 입력"); String phone = sc.next();
		System.out.println("나이 입력"); int age = sc.nextInt();
		boolean result = BoardController.getInstance().signUp( id , pw , name , phone , age);
		if(result)
			System.out.println("회원가입 성공");
		else {
			System.out.println("회원가입 실패");
		}
	}
	public void login() {
		System.out.println("아이디 입력"); String id = sc.next();
		System.out.println("비밀번호 입력"); String pw = sc.next();
		boolean result = BoardController.getInstance().login( id , pw);
		if(result) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
	}
}
