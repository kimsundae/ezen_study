package 팀과제.팀과제2;

import java.util.Scanner;

public class 팀과제2_도서대여 {

	public static void main(String[] args) {
			// 책 배열
		   String[] books = null;
		   // 책 대여 상태
		   boolean[] status = null;
		   // 총 책의 개수
		   int booksList = 0;
		   // 책 존재 여부
		   boolean existBooks = false;
		   		   		   
		   Scanner sc = new Scanner(System.in);
		   while(true) {
			   	System.out.println("-------------------------------------------------------");
				System.out.println("1.도서등록 | 2.도서목록 | 3.대여 | 4.반납 | 5.도서수정 | 6.도서삭제 ");
				System.out.println("-------------------------------------------------------");	
			   
				int num = sc.nextInt();
				sc.nextLine();
			   switch(num) {
			   		case 1: // 도서등록		   			
			   			booksList++;
			   			if(books != null ) {
			   				String[] instanceBooks = books;
			   				books = new String[booksList];
			   				boolean[] instanceStatus = status;
			   				status = new boolean[booksList];
				   			for(int i = 0; i < instanceBooks.length; i++) {
				   				books[i] = instanceBooks[i];
				   				status[i] = instanceStatus[i];
				   			}			   			
			   			}
			   			else {
			   				status = new boolean[booksList];
			   				books = new String[booksList];
			   			}		   					   			
			   			System.out.print("도서등록 :");
			   			String newBooks = sc.nextLine();
			   			books[books.length-1] = newBooks; break;		   					   			
			   		case 2: // 도서목록
			   			System.out.println("---------------------도서목록---------------------");
			   			for(int i =1, k = 1; i <= books.length; i++) {		  
			   				if(books[i-1].equals("0")) continue;
			   				System.out.print(books[i-1] + " | "); 
			   				
			   				if(k % 3 == 0)
			   					System.out.println();
			   				k++;
			   			}
			   			System.out.println();
			   			break;
			   			// 해리포터 , 스파이더맨 , 미녀와 야수 , 오만과 편견
			   			
			   		case 3: // 대여
			   			System.out.print("대여할 책을 입력해주세요.");
			   			String rentBooks = sc.nextLine();
			   			// 책 존재 여부
			   			existBooks = false;
			   			for(int i = 0; i < books.length; i++) {
			   				if( books[i].equals(rentBooks)) {
			   					existBooks = true;
			   					if( status[i] != true ) {		   						
			   						System.out.println("대여가 완료되었습니다.");
			   						status[i] = true;
			   					}else {
			   						System.out.println("이미 대여된 책입니다.");
			   					}
			   					break;	
			   				}
			   			}
			   			if( existBooks == false )System.out.println("잘못된 책 정보 입니다.");
			   			break;
			   		case 4: // 반납
			   			System.out.print("반납할 책을 입력해주세요.");
			   			String giveBooks = sc.nextLine();
			   			// 책 존재 여부
			   			existBooks = false;
			   			for(int i = 0; i < books.length; i++) {
			   				if( books[i].equals(giveBooks)) {
			   					existBooks = true;
			   					if( status[i] == true ) {
			   						System.out.println("반납이 완료되었습니다.");
			   						status[i] = false;
			   					}else {
			   						System.out.println("이미 반납된 책입니다.");
			   					}
			   					break;	
			   				}	   				
			   			}
			   			if( existBooks == false )System.out.println("잘못된 책 정보 입니다.");
			   			
			   			break;
			   		case 5: // 도서수정
			   			System.out.print("수정할 책을 입력해주세요.");
			   			String fixBooks = sc.nextLine();
			   			// 책 존재 여부
			   			existBooks = false;
			   			for(int i = 0; i < books.length; i++) {
			   				if( books[i].equals(fixBooks)) {
			   					System.out.println("수정 : ");
			   					String fix = sc.nextLine();
			   					books[i] = fix;
			   					existBooks = true;
			   					System.out.println("수정이 완료되었습니다.");		   								   						   					
			   				}
			   			}
			   			if( existBooks == false )System.out.println("잘못된 책 정보 입니다.");
			   			
			   			break;
			   		case 6: // 도서삭제
			   			System.out.print("삭제할 책을 입력해주세요.");
			   			String deleteBooks = sc.nextLine();
			   			// 책 존재 여부
			   			existBooks = false;
			   			for(int i = 0; i < books.length; i++) {
			   				if( books[i].equals(deleteBooks)) {
			   					books[i] = "0";
			   					existBooks = true;
			   					System.out.println("삭제가 완료되었습니다.");		   								   						   					
			   				}
			   			}
			   			if( existBooks == false )System.out.println("잘못된 책 정보 입니다.");
			   			
			   			break;
			   }
			   
		   }

	}

}
