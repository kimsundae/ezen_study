package 과제.과제2.Level1.ex7;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level1_7 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level1_7 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		
		String output = "";
		
		/* 문제풀이 위치 */
		System.out.print("회원명 String : \n");		
		System.out.print("상태 boolean : \n");
		System.out.print("회원번호 byte : \n");
		System.out.print("성별 char : \n ");
		System.out.print("나이 short : \n");
		System.out.print("포인트 int : \n");
		System.out.print("예금액 long : \n");
		System.out.print("키 float : \n");
		System.out.print("몸무게 double : \n");
		String name = scanner.next();
		boolean bool = scanner.nextBoolean();
		byte b = scanner.nextByte();
		char c = scanner.next().charAt(0);
		short s = scanner.nextShort();
		int i = scanner.nextInt();
		long l = scanner.nextLong();
		float f = scanner.nextFloat();
		double d = scanner.nextDouble();
		System.out.println("==========회원 개인정보============");
		System.out.println("	회원명 : " + name );
		System.out.println("	상태 : " + bool);
		System.out.println("	회원번호: " + b);
		System.out.println("	성별 : " + c);
		System.out.println("	나이 : " + s);
		System.out.println("	포인트 : " + i);
		System.out.println("	예금액 : " + l);
		System.out.println("	평균 : " + f);
		System.out.println("	평균 : " + d);

		/* ----------- */
	}
}
/* 
	[문제조건] 
		1. 문제풀이 위치 외 코드는 수정 불가 합니다.
		2. 기본 자료형8개 + 문자열클래스 변수 1개 를 이용한 9개변수를 입력 받습니다.
		3. 입력받은 9개 변수를 그림과 같이 출력합니다.
		4. 기존에 미리 작성된 변수를 최대한 활용합니다.
		
*/
