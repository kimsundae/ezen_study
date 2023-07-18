package java1.day04;
import java.util.Scanner;

public class Ex2_확인문제7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			//예금액
			int inputMoney = 0;
			//출금액
			int outMoney = 0;
			//잔고
			int money = 0;
		while(true) {			
			System.out.println("-----------------------------------");
			System.out.println("1.예금\t|2.출금\t|3.잔고\t|4.종료");
			System.out.println("-----------------------------------");
			System.out.println("선택>");		int choice = sc.nextInt();
					
			if( choice == 1) {
				System.out.println("예금액>");	
				inputMoney = sc.nextInt();
				money += inputMoney;
			}
			else if (choice == 2){
				System.out.println("출금액>");	
				outMoney = sc.nextInt();	
				money -= outMoney;
			}
			else if ( choice == 3) {
				System.out.print("잔고>");
				System.out.println(money);
			}
			else if(choice == 4) {
				System.out.println("프로그램 종료");
				break;
			}						
		}		
	}
}
