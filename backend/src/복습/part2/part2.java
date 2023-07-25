package 복습.part2;

import java.util.Scanner;

public class part2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		 String 재고관리 = "10,0,300\n3,0,200\n2,0,100\n";
		 while(true) {
			 
			 String 콜라정보 = 재고관리.split("\n")[0];
			 String 환타정보 = 재고관리.split("\n")[1];
			 String 사이다정보 = 재고관리.split("\n")[2];
			 int 콜라재고 = Integer.parseInt(콜라정보.split(",")[0]); 
			 int 콜라바구니 = Integer.parseInt(콜라정보.split(",")[1]); 
			 int 콜라가격 = Integer.parseInt(콜라정보.split(",")[2]); 
			 
			 int 환타재고 = Integer.parseInt(환타정보.split(",")[0]); 
			 int 환타바구니 = Integer.parseInt(환타정보.split(",")[1]); 
			 int 환타가격 = Integer.parseInt(환타정보.split(",")[2]); 
			 
			 int 사이다재고 = Integer.parseInt(사이다정보.split(",")[0]); 
			 int 사이다바구니 = Integer.parseInt(사이다정보.split(",")[1]); 
			 int 사이다가격 = Integer.parseInt(사이다정보.split(",")[2]); 
			
			 
			 System.out.println("1. 콜라 2.사이다 3.환타 4.결제");
			 System.out.print("선택>");
			 int num = sc.nextInt();
			 if(num == 1) {
				 if(콜라재고 > 0) {
					 콜라바구니++;
					 콜라재고--;
				 }else {
					 System.out.println("재고부족");
				 }
				 
			 }else if(num == 2) {
				 if(환타재고 > 0) {
					 환타바구니++;
					 환타재고--;
				 }else {
					 System.out.println("재고부족");
				 }
			 }else if(num == 3) {
				 if(사이다재고 > 0) {
					 사이다바구니++;
					 사이다재고--;
				 }else {
					 System.out.println("재고부족");
				 }
			 }else if (num == 4) {
				 System.out.println("- 현재 바구니 현황 표시 목록");
				 System.out.println("  ----------------------------------");
				 System.out.println(" 제품명 수량 가격");
				 if(콜라바구니 > 0) {
						 System.out.println("콜라   " + 콜라바구니 + "  "+ (콜라바구니*콜라가격));
					 }
				 if(환타바구니 > 0) {
					 System.out.println("환타   " + 환타바구니 + "  "+(환타바구니*환타가격));
				 }
				 if(사이다바구니 > 0) {
					 System.out.println("사이다   " + 사이다바구니 + "  "+(사이다바구니*사이다가격));
				 }
				 System.out.println("총가격 : " + ((콜라바구니*콜라가격) +(환타바구니*환타가격) + (사이다바구니*사이다가격)));
				 
				 System.out.println(" 1.결제 2.취소");
				 int ch = sc.nextInt();
				 if(ch == 1) {
					 System.out.print("금액을 입력해주세요>");
					 int money = sc.nextInt();
					 if(money - ((콜라바구니*콜라가격) + (환타바구니*환타가격) + (사이다바구니*사이다가격)) >= 0) {
						 System.out.println("결제 완료");
						 콜라바구니 = 0;
						 환타바구니 = 0;
						 사이다바구니 = 0;
					 }else {
						 System.out.println("잔액 부족");
						 콜라재고 += 콜라바구니;
						 환타재고 += 환타바구니;
						 사이다재고 += 사이다바구니;
						 콜라바구니 = 0;
						 환타바구니 = 0;
						 사이다바구니 = 0;						 
					 }
				 }else if(ch==2) {
					 System.out.println("결제 취소");
					 콜라재고 += 콜라바구니;
					 환타재고 += 환타바구니;
					 사이다재고 += 사이다바구니;
					 콜라바구니 = 0;
					 환타바구니 = 0;
					 사이다바구니 = 0;	
				 }
			 }
			 재고관리 = 콜라재고 + "," + 콜라바구니 + "," + 콜라가격 + "\n" + 환타재고 + "," + 환타바구니 + "," + 환타가격 + "\n" + 사이다재고 + "," + 사이다바구니 + "," + 사이다가격; 
			 
			 
		 }
		
	}		
}
