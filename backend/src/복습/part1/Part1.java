package 복습.part1;
import java.util.Scanner;

public class Part1 {

	public static void main(String[] args) {
		  int 콜라재고 = 10 ; int 환타재고 = 3; int 사이다재고 = 2;
		    int 콜라바구니 = 0 ; int 환타바구니 = 0 ; int 사이다바구니 = 0;
		    int 콜라가격 = 300 ; int 환타가격 = 200 ; int 사이다가격 = 100 ;
		    
		    Scanner sc = new Scanner(System.in);
		    while(true) {
		    	System.out.println("1.콜라 2.환타 3.사이다 4.결제");
		    	System.out.print("선택>");
		    	int num = sc.nextInt();
		    	if(num == 1) {		    		
		    		if(콜라재고 > 0) {
		    			콜라재고--;
		    			콜라바구니++;
		    		}else {
		    			System.out.println("재고 부족");
		    		}
		    	}else if(num ==2) {
		    		if(환타재고>0) {
		    			환타재고--;
		    			환타바구니++;
		    		}else {
		    			System.out.println("재고 부족");
		    		}
		    		
		    	}else if(num == 3) {
		    		if(사이다재고>0) {
		    			사이다재고--;
		    			사이다바구니++;
		    		}else {
		    			System.out.println("재고 부족");
		    		}
		    		
		    	}else if(num == 4) {
		    		System.out.println("- 현재 바구니 현황 표시 목록");
		    		if(콜라바구니 > 0) 
		    			System.out.println("콜라 "+ 콜라바구니 + " " + (콜라바구니 * 콜라가격));		    		
		    		if(환타바구니 > 0) 
		    			System.out.println("콜라 "+ 환타바구니 + " " + (환타바구니 * 환타가격));		    		
		    		if(사이다바구니 > 0) 
		    			System.out.println("콜라 "+ 사이다바구니 + " " + (사이다바구니 * 사이다가격));
		    		System.out.println("총 가격 : " + ((콜라바구니 * 콜라가격) + (환타바구니 * 환타가격) + (사이다바구니 * 사이다가격)));
		    		
		    		System.out.println("결제 메뉴");
		    		System.out.println("1.결제 2.취소");
		    		int ch = sc.nextInt();
		    		if(ch == 1) {
		    			System.out.println("금액을 입력해주세요>");
		    			int money = sc.nextInt();
		    			if(money - ((콜라바구니 * 콜라가격) + (환타바구니 * 환타가격) + (사이다바구니 * 사이다가격)) >= 0) {
		    				System.out.println("결제가 완료되었습니다. [잔액 : " + (money - ((콜라바구니 * 콜라가격) + (환타바구니 * 환타가격) + (사이다바구니 * 사이다가격))) + "]");
		    				콜라바구니 = 0; 환타바구니 = 0; 사이다바구니 = 0;
		    			}else {
		    				System.out.println("잔액 부족");
		    				콜라재고 += 콜라바구니; 환타재고 += 환타바구니; 사이다재고 += 사이다바구니;
		    				콜라바구니 = 0; 환타바구니 = 0; 사이다바구니 = 0;		    				
		    			}
		    		}else if(ch == 2) {
		    			System.out.println("구매 취소");
	    				콜라재고 += 콜라바구니; 환타재고 += 환타바구니; 사이다재고 += 사이다바구니;
	    				콜라바구니 = 0; 환타바구니 = 0; 사이다바구니 = 0;		  
		    		}
		    	}
		    	
		    }
	}

}
