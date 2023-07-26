package 과제.과제10;

import java.util.Arrays;
import java.util.Scanner;



public class MemberSys {
	
	static Member[] memberList = new Member[100];
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while(true) {
			
			System.out.println("\n\n--------- 회원 시스템 ---------"); 
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기    \n선택> ");
			int ch = sc.nextInt(); 
			
			if( ch == 1 ) { 회원가입 (); }
			else if( ch == 2 ) { 로그인 (); } 
			else if( ch == 3 ) { 아이디찾기 (); } 
			else if( ch == 4 ) { 비밀번호찾기 (); } 
			
		} // w e 
	}
	
	static void 회원가입 ()
	{	
		System.out.println("------[회원가입]-----");
		System.out.print("아이디를 입력해주세요"); String id = sc.next();		
		System.out.print("비밀번호를 입력해주세요"); String password = sc.next();
		System.out.print("이름을 입력해주세요"); String name = sc.next();
		System.out.print("전화번호를 입력해주세요"); String phoneNumber = sc.next();
		System.out.print("나이를 입력해주세요"); int age = sc.nextInt();
		
		Member member = new Member( id , password , name , phoneNumber , age);
		for(int i = 0; i < memberList.length; i++) 
		{
			if( memberList[i] == null ) 	
			{
					memberList[i] = member;
					System.out.println("회원가입이 완료되었습니다.");
					return;
			}//if
		}// for
	}// 회원가입 끝
	static void 로그인 ()
	{
		System.out.println("------[로그인]-------");
		System.out.print("아이디를 입력해주세요"); String id = sc.next();
		System.out.print("비밀번호를 입력해주세요"); String password = sc.next();
		for( int i = 0; i < memberList.length; i++) 
		{
			if(memberList[i] != null)
			{
				if( (memberList[i].id).equals(id) && memberList[i].password.equals(password))
				{
					System.out.println("[로그인 되었습니다.]");
					return;
				}
			}
		}
	}
	static void 아이디찾기 ()
	{ 
		System.out.println("-----[아이디 찾기]-----");
		System.out.print("이름을 입력해주세요."); String name = sc.next();
		System.out.println("전화번호를 입력해주세요."); String phoneNumber = sc.next();
		for( int i = 0; i < memberList.length; i++) 
		{
			if(memberList[i] != null) 
			{
				if( (memberList[i].name).equals(name) && memberList[i].phoneNumber.equals(phoneNumber))
				{
					System.out.println(memberList[i].id);
					return;
				}		
			}
				
		}
		System.out.println("일치하는 정보가 없습니다.");
	}
	static void 비밀번호찾기 () 
	{ 
		System.out.println("-----[비밀번호 찾기]-----");
		System.out.print("아이디를 입력해주세요."); String id = sc.next();
		System.out.println("전화번호를 입력해주세요."); String phoneNumber = sc.next();
		for( int i = 0; i < memberList.length; i++) 
		{
			if(memberList[i] != null) 
			{
				if( (memberList[i].id).equals(id) && memberList[i].phoneNumber.equals(phoneNumber))
				{	
					// 임시 비밀번호
					String insPassword = "";
					
					for(int j = 0; j < 4; j++) 				
						insPassword += (char)((int)(Math.random() * 26) + 65);
					
					System.out.println(insPassword);
					return;
				}		
			}			
		}// for e
		System.out.println("일치하는 정보가 없습니다.");
	}	
}
/*
	주제 : 회원제 시스템 
		0. 회원클래스 설계 = Member
			아이디 , 비밀번호 , 이름 , 전화번호 , 나이
		0. Member 객체를 여러개 저장하는 배열 
			Member[] 객체배열 = new Member[100];
		
		1. 초기 메뉴 [ 24시간 ]
			1. 회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기
			
		2. 조건 기능 
			1. 회원가입 메소드 
				1. 아이디 , 비밀번호 , 이름 , 전화번호 , 나이  각 입력받아 저장 
				2. Member 객체화
				3. 객체를 배열 저장 
				 
			2. 로그인 메소드
				1. 아이디 , 비밀번호 입력받아 저장 
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 로그인 성공 
					- 아니면 실패
					 
			3. 아이디찾기 메소드
				1. 이름 , 전화번호 입력받아 저장
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 찾은 아이디 출력 
					- 아니면 없다.
					 
			4. 비밀번호찾기 메소드 
				1. 아이디 , 전화번호 입력받아 저장
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 *임시 비밀번호(문자4자리 난수생성 ) 업데이트후 출력 
					- 아니면 없다.
*/














