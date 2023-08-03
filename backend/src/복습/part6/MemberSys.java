package 복습.part6;

import java.util.Scanner;

public class MemberSys {
		static Member[] memberList = new Member[100];
		static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		while(true) {
			System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기");
			System.out.print("선택>"); int ch = sc.nextInt();
			if(ch == 1) {
				System.out.print("아이디 입력 >");String id = sc.next();
				System.out.print("비밀번호 입력 >");String pw = sc.next();	
				System.out.print("이름 입력 >");String name = sc.next();
				System.out.print("전화번호 입력 >");String phone = sc.next();	
				System.out.print("나이 입력 >");int age = sc.nextInt();
				
				boolean result = signUp( id , pw , name , phone , age );
				if( result )
					System.out.println("회원가입 성공");
				else
					System.out.println("회원가입 실패");
				
			}else if(ch==2) {
				System.out.print("아이디 입력 >");String id = sc.next();
				System.out.print("비밀번호 입력 >");String pw = sc.next();	
				boolean result = login( id , pw );
				if (result)
					System.out.println("로그인 성공");
				else
					System.out.println("로그인 실패");
				
			}else if(ch==3) {
				System.out.print("이름 입력 >");String name = sc.next();
				System.out.print("전화번호 입력 >");String phone = sc.next();	
				String result = findId( name , phone);
				if( result != null ) {
					System.out.println(result);
				}else
					System.out.println("찾기 실패");
				
			}else if(ch==4) {
				System.out.print("아이디 입력 >");String id = sc.next();
				System.out.print("전화번호 입력 >");String phone = sc.next();	
				String result = findPw( id , phone );
				if( result != null)
					System.out.println(result);
				else
					System.out.println("찾기 실패");
			}
			
		}		
	}
	
	public static boolean signUp( String id , String pw , String name , String phone , int age) {
		Member member = new Member( id , pw , name , phone , age);
		for(int i = 0; i < memberList.length; i++) {
			if(memberList[i] == null ) {
				memberList[i] = member;
				return true;
			}
		}
		return false;		
	}
	public static boolean login( String id , String pw) {
		for(int i = 0; i < memberList.length; i++) {
			if( memberList[i] == null) {
				return false;
			}
			if(memberList[i].id.equals(id) && memberList[i].pw.equals(pw)) {
				return true;
			}
		}
		return false;		
	}
	public static String findId( String name , String phone) {
		for(int i = 0; i < memberList.length; i++) {
			if(memberList[i] == null ) {				
				return null;
			}
			if(memberList[i].name.equals(name) && memberList[i].phone.equals(phone)) {
				return memberList[i].id;
			}
		}
		return null;
	}
	public static String findPw( String id , String phone) {
		for(int i = 0; i < memberList.length; i++) {
			if(memberList[i] == null ) {				
				return null;
			}
			if(memberList[i].id.equals(id) && memberList[i].phone.equals(phone)) {
				return memberList[i].pw;
			}
		}
		return null;
	}
}
