package java1.day6;
import java.util.Scanner;

public class Ex2_확인문제9 {

	public static void main(String[] args) {
		int[] scores = new int[3];
		int 학생수 = 0;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("--------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("--------------------------------------------");			
			System.out.print("선택>");
			int num = sc.nextInt();
			if(num == 1) {
				System.out.print("학생수 : ");
				 학생수 = sc.nextInt();
				scores = new int[학생수];
			}
			else if(num == 2) {			
				for(int i = 0; i < scores.length; i++) {
					System.out.print("scores["+i+"]>");
					scores[i] = sc.nextInt();
				}
			}else if(num == 3) {				
				for(int i = 0; i <scores.length; i++)
					System.out.println("scores["+i+"]: " + scores[i]);
			}else if(num == 4) {				
				int max = scores[0];
				for(int i = 0; i < scores.length; i++)
					max = max > scores[i] ? max : scores[i]; 
				System.out.println("최고 점수: " + max);
				System.out.print("평균 점수: " );
				int sum = 0;
				for(int i = 0; i < scores.length; i++)
					sum += scores[i];
				System.out.println(sum/(double)(scores.length));
			}else if(num == 5) {				
				System.out.println("프로그램 종료");
				break;
			}						
		}//while e				
	}// main e
}//class e


// .nextLine() 사용시 주의할 점
	//nextLine 사용시 다른 next~~() 앞뒤로 존재 했을 때 하나로 인식 [ 오류처럼 보일 수 있다. ]
	// 1. 해결 방안1
		//Integer.parseInt( scanner.nextLine() );
	// 2. 해결 방안2
		
		