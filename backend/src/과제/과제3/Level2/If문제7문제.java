package 과제.과제3.Level2;
import java.util.Scanner;

public class If문제7문제 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/* -------문제1----- */
		System.out.println("문제 1 -----");
		System.out.println("정수 1 : ");
		System.out.print("정수 2 : ");
		int mun1_1 = sc.nextInt();
		int mun1_2 = sc.nextInt();
		if( mun1_1 > mun1_2 ) {
			System.out.println("더 큰 수 : " + mun1_1);
		}else {
			System.out.println("더 큰 수 : " + mun1_2);
		}
				
		/* -------문제2----- */
		System.out.println("문제2--------------");
		int mun2_1 = sc.nextInt();
		int mun2_2 = sc.nextInt();
		int mun2_3 = sc.nextInt();
		
		int max = mun2_1;
		if( mun2_1 > mun2_2) {
			max = mun2_1;
		}
		else if( mun2_1 < mun2_2) {
			max = mun2_2;
		}				
		if (max < mun2_3) {
			max = mun2_3;
		}
		System.out.println("가장 큰 수 : " + max);
						
		/* -------문제3----- */
		System.out.println("문제3 ----------------------");
		int mun3_1 = sc.nextInt();
		int mun3_2 = sc.nextInt();
		int mun3_3 = sc.nextInt();
		int top = 0;
		int middle = 0;
		int bottom = 0;
		if( mun3_1 > mun3_2 && mun3_1 > mun3_3) {
			top = mun3_1;
		}else if( mun3_2 > mun3_1 && mun3_2 > mun3_3) {
			top = mun3_2;
		}else {
			top = mun3_3;
		}
		if( mun3_2 > mun3_1 && mun3_3 > mun3_1) {
			bottom = mun3_1;
		}else if( mun3_3 > mun3_2 && mun3_1 > mun3_2) {
			bottom = mun3_2;
		}else {
			bottom = mun3_3;
		}
		if( top > mun3_1 && mun3_1 > bottom) {
			middle = mun3_1;
		}else if ( top > mun3_2 && mun3_2 > bottom) {
			middle = mun3_2;
		}else {
			middle = mun3_3;
		}
		System.out.println("오름차순 :  " + bottom + " " + middle + " " + top);
		System.out.println("내림차순 :  " + top + " " + middle + " " + bottom);
		
		
		
		/* -------문제4----- */
		System.out.println("문제4-=---------");
		int mun4 = sc.nextInt();
		if (mun4 >= 90) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
		
		/* -------문제5----- */
		System.out.println("문제5---------------");
		int mun5 = sc.nextInt();
		if (mun5 >= 90) {
			System.out.println("A등급");
		}else if(mun5 >= 80) {
			System.out.println("B등급");
		}else if(mun5 >= 70) {
			System.out.println("C등급");
		}else {
			System.out.println("재시험");
		}
		
		
		/* -------문제6----- */
		System.out.println("문제6==========");
		int po = sc.nextInt();
		int math = sc.nextInt();
		int eng = sc.nextInt();
		if((po + math + eng) / 3 >= 90) {
			if(po == 100) {
				System.out.println("국어우수");
			}
			if(eng == 100) {
				System.out.println("영어우수");
			} 
			if(math == 100) {
				System.out.println("수학우수");
			}						
		}else if((po + math + eng) / 3 >= 80) {
			if(po >= 90) {
				System.out.println("국어장려");
			}
			if(eng >= 90) {
				System.out.println("영어장려");
			}
			if(math >= 90) {
				System.out.println("수학장려");
			}				
		}else {
			System.out.println("재시험");
		}
		
		
		
		/* -------문제7----- */
		System.out.println("문제7------------");
		String id = sc.next();
		String password = sc.next();
		if( id.equals("admin") && password.equals("1234")) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
		
		
	}
	
}

/*
 	 문제1 : 2개의 정수를 입력받아서 더 큰수 출력 [ 경우의수 : 3개(크다,작다,같다=그외) ]
 	 문제2 : 3개의 정수를 입력받아서 가장 큰수 출력 
 	 문제3 : 3개의 정수를 입력받아서 오름차순[>] / 내림차순[<] [ 경우의수 :  3 7 5 : 3>7 , 3>5 , 7>5     총 : 3개  ] 
 	 문제4 : 점수를 입력받아 점수가 90점 이상이면 합격 아니면 불합격 출력 [ 경우의수 : 2개 ]
 	
 	 문제5 : 
			// 점수를 입력받아 점수가 90점 이상이면 A등급
			//				점수가 80점 이상이면 B등급
			//				점수가 70점 이상이면 C등급
			//				그외 재시험
	
	
 	 문제6	[ 경우의수 3개 , 첫번째 경우의수 : 3개 , 두번째 경우의수 : 3개 ] 총 9개  
			[ 입력 ] : 국어,영어,수학 입력받기
			[ 조건 ]
				평균이 90점 이상이면서 
					국어점수 100점 이면 '국어우수' 출력
					영어점수 100점 이면 '영어우수' 출력
					수학점수 100점 이면 '수학우수' 출력
				평균이 80점 이상이면서 
					국어점수 90점이상 이면 '국어장려' 출력
					영어점수 90점이상 이면 '영어정려' 출력
					수학점수 90점이상 이면 '수학장려' 출력
				그외 재시험 
		 
	문제7 로그인페이지
	 		[ 입력 ] : 아이디와 비밀번호를 입력받기
	 		[ 조건 ] : 회원아이디가 admin 이고 
	           			비밀번호가 1234 일 경우에는 
	          			로그인 성공 아니면 로그인 실패 출력
 */
