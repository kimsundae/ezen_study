package 팀과제.팀과제3;

import java.util.Scanner;

// 실행
public class Go {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Fishing fishing = new Fishing();
		Bobber bobber = new Bobber();
		
		while(true) {
			System.out.println("낚시대를 선택해주세요");
			System.out.println("1. 민물낚시대 2. 바다낚시대");
			int ch1 = sc.nextInt();
			
			System.out.println("미끼를 선택해주세요");
			System.out.println("1. 갯지렁이 2. 조갯살 3. 소라");
			int ch2 = sc.nextInt();
			
			fishing.input(bobber.낚시대[ch1-1], bobber.미끼[ch2-1]);
			System.out.println("1");
			while(true) {
				
				if(fishing.내구도>0) {
					fishing.fishing();			
				} else {
					System.out.println("낚시대를 교체해주세요");
					break;
				}
			}
		}
	}
}