package java1.day08.Ex5;
// 목적 : 실행
import java.util.Scanner;

public class Ex5_객체배열 { // class s
	
	public static void main(String[] args) { // main s
		
		Member[] memberList = new Member[100]; // member 객체 100개를 저장할 수 있는 배열
		
		while( true ) {// w s
			System.out.print("1.회원가입 : ");
			Scanner sc = new Scanner(System.in);
			int ch = sc.nextInt();
			if( ch == 1) {
				System.out.print("아이디 : "); String id = sc.next();
				System.out.print("비밀번호 : "); String pw = sc.next();
				System.out.print("이름 : "); String name = sc.next();
				// 1.객체 선언 : 클래스명 객체변수명 = new 생성자명();
				Member m = new Member();	//1.객체생성
				m.id = id; m.pw = pw; m.name = name;		// 2. 생성된 객체로부터 .접근연산자를
				// 2. 배열에 저장
				for( int i = 0; i < memberList.length; i++) {
					if( memberList[i] == null ) {
						memberList[i] = m; // i번째 인덱스의 생성된 객체를 대입
						break;
					}//if end
				}//for end
			}//if end						
		}// w end		
	} // main e	
} // class e

/*	---------------------------------
	|재고명	|	재고	|	가격	| 장바구니 |
	---------------------------------
	|콜라		|	4	|	300	|	0	|
	|사이다	|	6	|	700	|	0	|
	|환타		|	12	|	400	|	0	|
	|제로콜라	|	7	|	600	|	0	|
	|밀키스	|	2	|	400	|	0	|

 */
