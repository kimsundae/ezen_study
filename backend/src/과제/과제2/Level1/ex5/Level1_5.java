package 과제.과제2.Level1.ex5;

public class Level1_5 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level1_5 answer >> \n");
		
		byte value1 = 100;				
		short value2 = 30000;			
		int value3 = 2000000000;		
		long value4 = 40000000000L;		
		float value5 = 3.123123123F;
		
		/* 문제풀이 위치 */
		short change1 = 0;
		int change2 = 0;
		long change3 = 0l;
		float change4 = 0f;
		double change5 = 0.0;
		System.out.println("byte -> short : " + (change1+value1));
		System.out.println("short -> int : " + (change2+value2));
		System.out.println("int -> long : " + (change3+value3));
		System.out.println("long -> float : " + (change4+value4));
		System.out.println("float -> double : " + (change5+value5));
		/* ----------- */
	}
}
/* 
	[문제] 그림과 같이 기본자료형을 이용하여 변수 5개 선언되어 있습니다. 그림과 같이 자동 형변환을 하여 출력하시오.
	[조건] 
		1. 문제풀이 위치 외 코드는 수정 불가 합니다.
		2. 자동 형변환 만 사용하여 그림과 같이 출력합니다.
		
*/
