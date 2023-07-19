package 과제.과제5;

import java.util.Scanner;

public class 과제5_키오스크 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String 재고관리 = "";
		/* 재고관리 변수 샘플  */
		재고관리 = "300 200 100 0 0 0 10 10 10 콜라 환타 사이다";
		/* ----------- */
		
		while(true) {
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.print(">>>>>> 선택 : "); int ch = scanner.nextInt();
			
			/* 문제풀이 위치 */
			
			//콜라위치  3번째 환타 : 4번째 사이다 : 5번째
			if( ch == 1) {
				//유효성검사
				if(Integer.parseInt(재고관리.split(" ")[6]) == 0) {
					System.out.println("재고가 부족합니다.");
				}else
				재고관리 = 재고관리.split(" ")[0]	+ " " + 재고관리.split(" ")[1]	+ " " + 재고관리.split(" ")[2]	+ " " + String.valueOf(Integer.parseInt(재고관리.split(" ")[3])+1)	+ " " + 재고관리.split(" ")[4]	+ " "
													+ 재고관리.split(" ")[5]	+ " " + String.valueOf(Integer.parseInt(재고관리.split(" ")[6])-1)	+ " " + 재고관리.split(" ")[7]	+ " " + 재고관리.split(" ")[8] + " 콜라 환타 사이다";
			}
			else if(ch == 2) {
				//유효성검사
				if(Integer.parseInt(재고관리.split(" ")[7]) == 0) {
					System.out.println("재고가 부족합니다.");
				}else
				재고관리 = 재고관리.split(" ")[0]	+ " " + 재고관리.split(" ")[1]	+ " " + 재고관리.split(" ")[2]	+ " " + 재고관리.split(" ")[3]	+ " " + String.valueOf(Integer.parseInt(재고관리.split(" ")[4])+1)	+ " "
						+ 재고관리.split(" ")[5]	+ " " +재고관리.split(" ")[6]	+ " " + String.valueOf(Integer.parseInt(재고관리.split(" ")[7])-1)	+ " " + 재고관리.split(" ")[8] + " 콜라 환타 사이다";
			}else if (ch == 3) {
				//유효성검사
				if(Integer.parseInt(재고관리.split(" ")[8]) == 0) {
					System.out.println("재고가 부족합니다.");
				}else
				재고관리 = 재고관리.split(" ")[0]	+ " " + 재고관리.split(" ")[1]	+ " " + 재고관리.split(" ")[2]	+ " " + 재고관리.split(" ")[3]	+ " " + 재고관리.split(" ")[4]	+ " "
							+ String.valueOf(Integer.parseInt(재고관리.split(" ")[5])+1)	+ " " +재고관리.split(" ")[6]	+ " " + 재고관리.split(" ")[7]	+ " " + String.valueOf(Integer.parseInt(재고관리.split(" ")[8])-1) + " 콜라 환타 사이다";
			}else if (ch == 4) {
				System.out.println("현재 장바구니 현황 표시 목록");
				System.out.println("--------------------------");
				System.out.println("제품명    수량    가격");
				
					if(Integer.parseInt(재고관리.split(" ")[3]) > 0) {
						System.out.print(재고관리.split(" ")[9]+ "     ");
						System.out.print(재고관리.split(" ")[3]+ "     ");
						System.out.println(Integer.parseInt(재고관리.split(" ")[3]) * Integer.parseInt(재고관리.split(" ")[0]));
					}
					if(Integer.parseInt(재고관리.split(" ")[4]) > 0) {
						System.out.print(재고관리.split(" ")[10]+ "     ");
						System.out.print(재고관리.split(" ")[4]+ "     ");
						System.out.println(Integer.parseInt(재고관리.split(" ")[4]) * Integer.parseInt(재고관리.split(" ")[1]));
					}
					if(Integer.parseInt(재고관리.split(" ")[5]) > 0) {
						System.out.print(재고관리.split(" ")[11]+ "     ");
						System.out.print(재고관리.split(" ")[5]+ "     ");
						System.out.println(Integer.parseInt(재고관리.split(" ")[5]) * Integer.parseInt(재고관리.split(" ")[2]));
					}		
				
				System.out.println("총가격 : " + ((Integer.parseInt(재고관리.split(" ")[3]) * Integer.parseInt(재고관리.split(" ")[0])) + (Integer.parseInt(재고관리.split(" ")[4]) * Integer.parseInt(재고관리.split(" ")[1]))
																	+ (Integer.parseInt(재고관리.split(" ")[4]) * Integer.parseInt(재고관리.split(" ")[2]))));
				
				System.out.println("결제메뉴");
				System.out.println("  1.결제 2.취소");
				int tmp = scanner.nextInt();
				//결제
				if( tmp == 1) {
					System.out.println("금액을 넣어주세요.");
					int inputMoney = scanner.nextInt();
					if( inputMoney >= (Integer.parseInt(재고관리.split(" ")[3]) * Integer.parseInt(재고관리.split(" ")[0])) + (Integer.parseInt(재고관리.split(" ")[4]) * Integer.parseInt(재고관리.split(" ")[1]))
																	+ (Integer.parseInt(재고관리.split(" ")[4]) * Integer.parseInt(재고관리.split(" ")[2]))) {
						System.out.println("잔액" + ( inputMoney - ((Integer.parseInt(재고관리.split(" ")[3]) * Integer.parseInt(재고관리.split(" ")[0])) + (Integer.parseInt(재고관리.split(" ")[4]) * Integer.parseInt(재고관리.split(" ")[1]))
																	+ (Integer.parseInt(재고관리.split(" ")[4]) * Integer.parseInt(재고관리.split(" ")[2])))));
						System.out.println("결제성공");
						//장바구니 초기화							
			재고관리 = 재고관리.split(" ")[0]	+ " " + 재고관리.split(" ")[1]	+ " " + 재고관리.split(" ")[2]	+ " " +  0	+ " " + 0	+ " "
							+ 0	+ " " + 재고관리.split(" ")[6]	+ " " + 재고관리.split(" ")[7]	+ " " + 재고관리.split(" ")[8] + " 콜라 환타 사이다";	
						
					}//잔액부족
					else {
						System.out.println("잔액부족");
						// 재고 되돌리기
						int 콜라재고 = Integer.parseInt(재고관리.split(" ")[3]);
						int 환타재고 = Integer.parseInt(재고관리.split(" ")[4]);
						int 사이다재고 = Integer.parseInt(재고관리.split(" ")[5]);
						재고관리 = 재고관리.split(" ")[0]	+ " " + 재고관리.split(" ")[1]	+ " " + 재고관리.split(" ")[2]	+ " " + 0	+ " " + 0 + " "
								+ 0	+ " " + (Integer.parseInt(재고관리.split(" ")[6])+콜라재고)	+ " " + (Integer.parseInt(재고관리.split(" ")[7]) + 환타재고)	+ " " + (Integer.parseInt(재고관리.split(" ")[8]) + 사이다재고);
					}
					
				}//취소
				else {
					System.out.println("취소");
					// 재고 되돌리기
					int 콜라재고 = Integer.parseInt(재고관리.split(" ")[3]);
					int 환타재고 = Integer.parseInt(재고관리.split(" ")[4]);
					int 사이다재고 = Integer.parseInt(재고관리.split(" ")[5]);
					재고관리 = 재고관리.split(" ")[0]	+ " " + 재고관리.split(" ")[1]	+ " " + 재고관리.split(" ")[2]	+ " " + 0	+ " " + 0 + " "
							+ 0	+ " " + (Integer.parseInt(재고관리.split(" ")[6])+콜라재고)	+ " " + (Integer.parseInt(재고관리.split(" ")[7]) + 환타재고)	+ " " + (Integer.parseInt(재고관리.split(" ")[8]) + 사이다재고);
				}				
			}
			
			System.out.println(재고관리);
			
			
			/* ----------- */
			
			
			//재고관리 = 재고관리.split(" ")[0]	+ " " + 재고관리.split(" ")[1]	+ " " + 재고관리.split(" ")[2]	+ " " + 재고관리.split(" ")[3]	+ " " + 재고관리.split(" ")[4]	+ " "
			//+ 재고관리.split(" ")[5]	+ " " +재고관리.split(" ")[6]	+ " " + 재고관리.split(" ")[7]	+ " " + 재고관리.split(" ")[8];
		} // while end 
	} // main end 
	
} // class end 

/*

	 주제 : 키오스크(변수버전)
	 	- 실행예시 사진은 없습니다.
		조건 
		1. 제품 가격/재고/바구니 상태를 하나의 문자열 변수에서 관리 
			// 샘플 : 
					이름 : 콜라 , 환타 , 사이다
					가격 : 300 , 200 , 100
					바구니 : 0 , 0 , 0
			
		2. 키오스크 메뉴 [ 무한루프 : 종료 없음(24시간) ] 
			1. 콜라 2.사이다 3.환타 4.결제
			[ 1~3 선택시 ]
				- 재고가 있을경우 장바구니 담기 / 없으면 '재고부족' 출력
				 
			[ 4 선택시 ] 
				- 현재 장바구니 현황 표시 목록 
				----------------------------------
				제품명	수량	가격
				사이다	1	400
				환타		2	1000
				총가격 : 1400
				- 결제메뉴 표시
					1. 결제 2.취소 
					[결제]
						- 금액 입력받아 총가격에 뺀 잔액 출력 -> 결제 성공시 장바구니 초기화 
						- 만약에 금액이 부족하면 결제 취소 -> 장바구니 초기화 / 재고 다시 되돌리기
					[취소]
						- [ 장바구니 초기화 / 재고 다시 되돌리기 ]
 
 */







