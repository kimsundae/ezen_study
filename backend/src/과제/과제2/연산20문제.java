package 과제.과제2;
import java.util.Scanner;

public class 연산20문제 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//------ 문제1 여기에 풀이-------//
		System.out.println("	|\\_/|");
		System.out.println("	|q p|   /}");
		System.out.println("	( 0 )\"\"\"\\");
		System.out.println("	|\"^\"`    |");
		System.out.println("	||_/=\\\\__|");
		//------ 문제2 여기에 풀이-------//
		System.out.println("------문제2--------------");
		int i = 1;
		String writer = sc.next();
		String content = sc.next();
		String date = sc.next();
		System.out.println("------------방문록-------------");
		System.out.println("| 순번 | 작성자 | 내용    | 날짜 |");
		System.out.println("| "+i + "  |  " + writer + "    |   " + content + "   |      " + date);
		//------ 문제3 여기에 풀이-------//
		System.out.println("------문제3--------------");
		int Nmoney = sc.nextInt();
		int Gmoney = sc.nextInt();
		int Rmoney = Nmoney + Gmoney - Nmoney%10;
		System.out.println((int)Rmoney);
		
		//------ 문제4 여기에 풀이-------//
		System.out.println("------문제4--------------");
		int money4 = sc.nextInt();
		int sib = money4 / 100000;
		int man = (money4 % 100000) / 10000 ;
		int chon = ((money4 % 100000) % 10000 )/ 1000;
		int back = (((money4 % 100000) % 10000 )% 1000)/100;
		System.out.println("십만원 : " + sib +"장");
		System.out.println("만원 : " + man +"장");
		System.out.println("천원 : " + chon +"장");
		System.out.println("백원 : " + back +"개");
		
		//------ 문제5 여기에 풀이-------//
		System.out.println("------문제5--------------");
		int mun5 = sc.nextInt();
		System.out.println(mun5 % 7 == 0 ? "O" : "X");
		
		//------ 문제6 여기에 풀이-------//
		
		System.out.println("------문제6--------------");
		int mun6 = sc.nextInt();
		System.out.println(mun6 % 2 == 1 ? "O" : "X");
		
		//------ 문제7 여기에 풀이-------//
		
		System.out.println("------문제7--------------");
		int mun7 = sc.nextInt();
		System.out.println(mun7 % 7 == 0 ? mun7 % 2 == 0 ? "O" : "X" : "X");
		
		//------ 문제8 여기에 풀이-------//
		
		System.out.println("------문제8--------------");
		int mun8 = sc.nextInt();
		System.out.println(mun8 % 7 == 0 ? "O" : mun8 % 2 == 1 ? "O" : "X");	
		
		//------ 문제9 여기에 풀이-------//
		
		System.out.println("------문제9--------------");
		int mun9_1 = sc.nextInt();
		int mun9_2 = sc.nextInt();
		System.out.println(mun9_1 > mun9_2 ? mun9_1 : mun9_2);
		
		//------ 문제10 여기에 풀이-------//
		
		System.out.println("------문제10--------------");
		int mun10 = sc.nextInt();
		System.out.println("원 넓이 : " +( mun10 * mun10 * 3.14) );		
		
		//------ 문제11 여기에 풀이-------//
		
		System.out.println("------문제11--------------");
		
		double mun11_1 = sc.nextDouble();
		double mun11_2 = sc.nextDouble();
		System.out.println((mun11_1 / mun11_2) * 100);
		
		//------ 문제12 여기에 풀이-------//
		
		System.out.println("------문제12--------------");
		int mun12_1 = sc.nextInt();
		int mun12_2 = sc.nextInt();
		int mun12_3 = sc.nextInt();
		System.out.println((mun12_1+mun12_2) * mun12_3 / 2);
		
		
		//------ 문제13 여기에 풀이-------//
		
		System.out.println("------문제13--------------");
		int mun13 = sc.nextInt();
		System.out.println((mun13 - 100) * 0.9);
		
		//------ 문제14 여기에 풀이-------//
		
		System.out.println("------문제14--------------");
		System.out.println("몸무게 : ");
		System.out.println("키 : ");
		int mun14_1 = sc.nextInt();
		int mun14_2 = sc.nextInt();
		System.out.println("BMI 계산식 : "+(mun14_1 / ((mun14_2 / 100)*(mun14_2 / 100))));
		
		//------ 문제15 여기에 풀이-------//
		
		System.out.println("------문제15--------------");
		System.out.println("inch 입력 : ");
		int inch = sc.nextInt();
		System.out.println("inch : " + inch * 2.54);
		
		//------ 문제16 여기에 풀이-------//
		
		System.out.println("------문제16--------------");
		int middle = sc.nextInt();
		int last = sc.nextInt();
		int test = sc.nextInt();
		System.out.printf("중간고사 : %.2f  기말고사 : %.2f  수행평가 : %.2f" , middle%30.0 , last%30.0 , test%40.0);
		System.out.println();
		
		//------ 문제17 여기에 풀이-------//
		
		System.out.println("------문제17--------------");
		int x = 10;
		int y = 23;
		// x 1후위감소 --> 10+5 --> x 1선위감소 (x-1) --> 15+9
		System.out.println("x의 값 : "+x +" y의 값 : " + y);		
		//------ 문제18 여기에 풀이-------//
		
		System.out.println("------문제18--------------");
		
		int age = sc.nextInt();
		System.out.println(age >= 10 && 20 > age  ? "학생" :40 > age && age >= 20 ? "성인" : age >= 40 ? "중년" : "에러");
		
		//------ 문제19 여기에 풀이-------//
		
		System.out.println("------문제19--------------");
		int t = sc.nextInt();
		int e = sc.nextInt();
		int m = sc.nextInt();
		System.out.printf("총점 : %d  평균 : %.2f"  ,(t+e+m) , ((t+e+m)/3.0));
		System.out.println();
		
		//------ 문제20 여기에 풀이-------//
		
		System.out.println("------문제20--------------");
		String admin = sc.next();
		String password = sc.next();
		System.out.println( admin.equals("admin") ? password.equals("1234") ? "로그인성공" : "로그인실패" : "로그인실패" );
		
		
		//------ 문제21 여기에 풀이-------//
		System.out.println("------문제21--------------");
		int 수1 = sc.nextInt();
				int 수2 = sc.nextInt();
				int 수3 = sc.nextInt();
				int 순서1 = 수1 > 수2 ? 
								수1 > 수3 ? 
											수1 : 수3 : 수2 > 수3 ? 
																수2 : 수3;
				int 순서2 = 수1 > 수2 ?
								 수2 > 수3 ? 
								 			수2 : 수1 > 수3 ? 
								 							수3 : 수1 : 수1> 수3	? 
								 												수1 : 수2 > 수3 ? 
								 																수3 : 수2;
				int 순서3 = 수1 > 수2 ? 
								수2 > 수3 ? 
											수3 : 수2 : 수1 > 수3 ? 
																	수3 : 수1;
				System.out.println("[1] : " + 순서1 + " [2] : " + 순서2 + " [3] : " + 순서3);							
	}	
}



/*

문제1 : 강아지 console 출력
	|\_/|
	|q p|   /}
	( 0 )"""\
	|"^"`    |
	||_/=\\__|

문제2 : 입력받은 3개 데이터를 이용한 표 만들기 
	[입력변수]
		1. 작성자[문자열] , 내용[문자열] , 날짜[문자열] 입력받아 각 변수에 저장 
	[출력 예]
		   --------------방문록--------------------
		   | 순번  | 작성자  | 	내용 	| 날짜       |
		   |  1   | 강호동  |안녕하세요  |  09-28    |
		  ----------------------------------------
	
문제3 : 급여 계산
	[입력조건]
		기본급[정수] , 수당[정수]
	[ 조건 ] 
		 실수령액 = 기본급 + 수당 - 세금[기본급10%] 
	[출력조건] 
		실수령액 출력[ 소수점 없이  ]

문제4 : 지폐 세기 
	 [입력조건 ] 
		금액 
	 [조건 ] 
		 십만원 부터 백원 까지의 개수 세기 
	[ 출력조건 ]
		예) 356789 입력시 
		 십만원 3장 
		 만원 5장
		 천원 6장 
		 백원 7개

문제5 : 하나의 정수를 입력받아 7의 배수인지 출력[ 'O' 혹은 'X' 로 출력]

문제6 : 하나의 정수를 입력받아 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력]

문제7 : 하나의 정수를 입력받아 7의 배수 이면서 짝수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]

문제8 : 하나의 정수를 입력받아 7의 배수 이거나 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]

문제9 : 두개의 정수를 입력받아 더 큰수 출력 

문제10 : 반지름을 입력받아 원 넓이 출력하기 
	계산식) 원 넓이 공식 => 반지름 * 반지름 * 원주율[3.14]

문제11 : 두 실수를 입력받아 앞실수의 값이 뒤의 값의 몇% 인지 출력하기 
	예) 54.5   84.3 실수 2개입력시 결과는   64.285714%

문제12 : 사다리꼴 넓이 구하기[윗변과 밑변 높이를 입력받아 출력하기 
	계산식) 사다리꼴 계산식 = > (윗변 + 밑변) * 높이 / 2

문제13: 키를 정수를 입력받아 표준체중 출력하기 
	계산식) 표준체중 계산식 = > (키 - 100) * 0.9

문제14: 키와 몸무게를 입력받아 BMI 출력하기 
	계산식) BMI 계산식 = > 몸무게 / ((키 / 100) * (키 / 100))

문제15: inch 를 입력받아 cm 로 변환하기 
	계산식) 1 inch -> 2.54cm

문제16:  중간고사, 기말고사, 수행평가를 입력받아 반영비율별 계산하여 소수 둘째자리까지 점수 출력하시오 
	계산식 반영비율)  중간고사 반영비율 => 30 %  / 기말고사 반영비율 => 30 %   / 수행평가 반영비율 => 40 %

문제17 :  연산 순서 나열 하고 printf() 에 출력되는 x 와 y 값을 예측하시오.
	int x = 10;
	int y = x-- + 5 + --x;
	printf(" x의 값 : %d , y의값 :  %d ", x, y)

문제18 : 나이를 입력받아 나이가 10세이상이면 학생 , 20세이상이면 성인 , 40세이상이면 중년 으로 출력하기

문제19 : 국어 , 영어 , 수학 점수를 입력받아 각 변수에 저장하고 총점(소수점 0자리) 출력 , 평균(소수점 2자리 까지) 출력

문제20 : 아이디[문자열] 와 비밀번호[문자열] 를 입력받아 아이디가 'admin' 이고 비밀번호가 '1234' 와 일치하면 로그인성공 아니면 로그인실패 출력

문제21 : 세 정수를 입력받아 가장 큰수 출력 

  
 */
