package 과제.과제2.Level1.ex3;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level1_3 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level1_3 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		
		/* 문제풀이 위치 */
		System.out.print("input boolean : \n");		
		System.out.print("input byte : \n");
		System.out.print("input char : \n");
		System.out.print("input short : \n ");
		System.out.print("input int : \n");
		System.out.print("input long : \n");
		System.out.print("input float : \n");
		System.out.print("input double : \n");
		boolean bool = scanner.nextBoolean();
		byte b = scanner.nextByte();
		char c = scanner.next().charAt(0);
		short s = scanner.nextShort();
		int i = scanner.nextInt();
		long l = scanner.nextLong();
		float f = scanner.nextFloat();
		double d = scanner.nextDouble();
		System.out.println("output boolean : " + bool );
		System.out.println("output byte : " + b);
		System.out.println("output char : " + c);
		System.out.println("output short : " + s);
		System.out.println("output int : " + i);
		System.out.println("output long : " + l);
		System.out.println("output float : " + f);
		System.out.println("output double : " + d);
		/* ----------- */
	}
}
/* 
	[문제] 그림과 같이 기본자료형을 이용하여 변수 8개를 출력하시오.
	[조건] 
		1. 모든 기본자료형 8개 사용
		2. print() 메소드 사용
		3. scanner 객체 사용하여 입력받기
*/
