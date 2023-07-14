package java1.day02; // 현재 클래스의 패키지 경로

public class Ex2_연산자 { // class s // 모든 자바 코드는 클래스에서 작성
		
	public static void main(String[] args) { // main s // 모든 실행 코드는 main 함수에서 작성
		
		// [ p.78 ] 연산자
		int x = +10; // + 생략 가능
		int y = -10; 
		
		System.out.println(" x : " + x);
		System.out.println(" y : " + y);
		
		// 1. 산술연산자
		System.out.println(" x + y : " + (x+y) ); // +
		System.out.println(" x - y : " + (x-y) ); // -
		System.out.println(" x * y : " + (x*y) ); // *
		System.out.println(" x / 3 : "+ (x/3) ); // / 나누기 후 몫
		System.out.println(" x % 3 : " + (x%3) ); // % 나누기 후 나머지
		
		// 2. 비교연산자 [ p.88 ]
		System.out.println(" x == y : " + (x==y) ); // == 같다
		System.out.println(" x != y : " + (x!=y)); // != 다르다
		System.out.println(" x > y : " + ( x > y) ); // x는 y보다 초과 / y는 x보다 미만
		System.out.println(" x < y : " + (x < y)); // x는 y보다 미만 / y는 x보다 초과
		System.out.println(" x >= y : " + (x >= y)); //x는 y보다 이상이다.
		System.out.println(" x <= y : " + (x <= y)); // x는 y보다 이하이다.
			// if( true ) , if( x==y )
		
		// 3. 논리 연산자 [ p.91 ]
		System.out.println(" x>= 10 and y>= 10 : " + ( x>=10 && y>=10 ) ); // 조건이 모두 true 이면 true / true and false => false
		System.out.println(" x >= 10 or y >= 10 : " + ( x>=10 || y >= 10)); // 조건이 하나라도 true 이면 true / true or false => true
		System.out.println(" 부정 : " + (!true));
		
		// 4. 대입 연산자 [ p.102 ]
		int a = 30; // = 대입연산자 : 오른쪽 데이터를 왼쪽에 대입/저장
		a += x ; // += : 오른쪽 데이터를 왼쪽데이터에 더한 후에 대입/저장 [ *누적 ]
			System.out.println( a );
		a -= x; a*= x; a/=x; a%=x;
		
		// 5. 삼항 연산자 [ p.103 ] : 조건 ? 참 : 거짓
			// 조건 ? 조건 ? 참 : 거짓 : 거짓
			// 조건 ? 참 : 조건 ? 참 : 거짓
		String result = ( x >= 20 ) ? "합격" : "불합격" ;
			System.out.println(result);
						// (조건) ? (참) : (거짓)
						// (조건) ? (참) : ( ( 조건 ) ? ( 참 ) : (거짓 ) )
		String result2 = ( x>=10 ) ? "1차합격" : (y>=10) ? "2차합격" : "최종탈락";
		
		// 6. 증감연산자
		System.out.println("++x : " + ( ++x ) ); // 출력우선이야? 증가가 우선이야??
		System.out.println(" x++ : " + ( x++ ));
		System.out.println(" x : " +  x );
		
		System.out.println(" --x : " + ( --x ));
		System.out.println(" x-- : " + ( x-- ));
		System.out.println(" x : " +  x );
		
		// 7. 연결연산자
				// + 연결연산자
		System.out.println( 3 + 3 ); // 더하기
		System.out.println(("연결 : " + 3 + 3 )); // 연결 // 응용 
		
		// 7. 증감연산자
	} // main e

} // class e
