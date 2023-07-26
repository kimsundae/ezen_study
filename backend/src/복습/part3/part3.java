package 복습.part3;

import java.util.Scanner;

public class part3 {
	
	public static void main(String[] args) {
		
		 String[] 재고관리 = { "10,0,300,콜라" , "3,0,200,환타" , "2,0,100,사이다"};
		Scanner sc = new Scanner(System.in);
		 while(true) {		
			 System.out.println(" 1. 콜라 2.사이다 3.환타 4.결제");
			 System.out.print("선택>"); int num = sc.nextInt();
			 
			 if(num == 1 || num == 2 || num==3) {
				int 재고 = Integer.parseInt(재고관리[num-1].split(",")[0]);
				int 바구니 = Integer.parseInt(재고관리[num-1].split(",")[1]);
				int	가격 = Integer.parseInt(재고관리[num-1].split(",")[2]);
				String 이름 = 재고관리[num-1].split(",")[3];
				
				if(재고 > 0) {
					재고--;
					바구니++;
				}else {
					System.out.println("재고가 부족합니다.");
				}
				재고관리[num-1] = 재고 + "," + 바구니 + "," + 가격 + "," + 이름;				
			 }else if(num == 4) {
				 System.out.println(" - 현재 바구니 현황 표시 목록");
				 System.out.println(" ----------------------------------");
				 System.out.println("    제품명 수량 가격");
				 int 총가격 = 0;
				 for(int i = 0; i < 재고관리.length; i++) {
					 
					 int 재고 = Integer.parseInt(재고관리[i].split(",")[0]);
					int 바구니 = Integer.parseInt(재고관리[i].split(",")[1]);
					int	가격 = Integer.parseInt(재고관리[i].split(",")[2]);
					String 이름 = 재고관리[i].split(",")[3];
					if(바구니 > 0)
						System.out.println("    "+ 이름 + "  " + 바구니 + "  " + (바구니*가격) );		
					 총가격 += 바구니*가격;
				 }
				 System.out.println("   총가격 : " + 총가격);
			 }
			
			 
		 }
		
		
	}
}
