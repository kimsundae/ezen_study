package 복습.part5;

import java.util.Scanner;

public class MemberSys {

	public static void main(String[] args) {
		//여러개 Member객체를 저장하기 위한 Member[] 객체배열 = new Member[100]; 선언합니다.
		Member[] memberList = new Member[100];
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1.회원가입 2.로그인");
			System.out.print("선택>"); int ch = sc.nextInt();
			if( ch == 1) {
				System.out.println("======== 회원가입 =========");
				System.out.print("아이디 : "); String id = sc.next();
				System.out.print("비밀번호 : "); String pw = sc.next();
				System.out.print("이름 : "); String name = sc.next();
				System.out.print("전화번호 : "); String phone = sc.next();
				System.out.print("나이 : "); int age = sc.nextInt();
				
				Member member = new Member( id , pw , name , phone , age);
				for(int i = 0; i < memberList.length; i++) {
					if(memberList[i] == null) {
						memberList[i] = member;
						break;
					}
				}							
			}
			else if( ch == 2) {
				System.out.println("========== 로그인 =========");
				System.out.print("아이디 : "); String id = sc.next();
				System.out.print("비밀번호 : "); String pw = sc.next();
				//로그인 성공 여부
				boolean result = false;
				for(int i = 0; i < memberList.length; i++) {
					if( memberList[i] == null) break;
					else if( memberList[i].id.equals(id) && memberList[i].pw.equals(pw)) {
						System.out.println("안내) 로그인 성공");
						result = true;
						break;
					}
				}
				if(!result) {
					System.out.println("안내) 로그인 실패");
				}				
			}
		}
	}
}
