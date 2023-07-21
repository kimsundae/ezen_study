package 과제.과제5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class 과제5_키오스크_파일처리 {

	public static void main(String[] args) throws IOException {

		while (true) {
			Scanner scanner = new Scanner(System.in); // 입력객체
			String filePath = "./src/과제/과제5/재고파일.txt";
			FileOutputStream fileOutputStream = new FileOutputStream(filePath, true); // 파일출력객체
			FileInputStream fileInputStream = new FileInputStream(filePath); // 파일입력객체
			File file = new File( filePath ); // 파일정보객체

			/* -------- 파일내 제품 정보 -- 스트림[바이트]--> 바이트배열로 옮기기 -----> 문자열 변환 -------- */
			byte[] inByteArray = new byte[ (int)file.length() ]; // 파일의 용량만큼 배열 선언
			fileInputStream.read( inByteArray ); // 읽어온 바이트를 바이트배열에 저장
			String fileInfo = new String(inByteArray);
			System.out.println(fileInfo);
			/* ------ 파일내 제품정보 하나의 문자열 ----> 각 제품별로 된 배열 저장----------------------------------- */
				//문자열 가공
				String[] 재고관리  = fileInfo.split("\n"); System.out.println("제품별 분리 : " + Arrays.toString(재고관리));
				
			
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.print("-1:제품등록 0:결제");
				// 재고관리 배열에 있는 제품만 선택 가능 하도록 출력
				for(int i =0; i < 재고관리.length; i++) { // 배열 하나씩 출력
					if( !재고관리[i].equals("")) { // 배열내 데이터가 공백이 아니면
						String product = 재고관리[i];
						String name = product.split(",")[0]; // 제품명
						int stock = Integer.parseInt(product.split(",")[1]) ; // 재고
						int price = Integer.parseInt(product.split(",")[2]) ; // 가격
						int basket = Integer.parseInt(product.split(",")[3]) ; // 바구니
						if( stock == 0 ) { // 재고 없으면
							System.out.print(" "+ (i+1) + ":" + name  + "[재고없음]");
						}else { // 재고가 있으면
							System.out.print(" "+ (i+1) + ":" + name  + "[" + price + "] ");
						}	
					}
				}
			System.out.print(">>>>>> 선택 : ");
			int ch = scanner.nextInt();

			if (ch == -1) {// 만약에 -1번을 입력했으면 제품 등록 기능
				System.out.print("제품명 : ");
				String name = scanner.next();
				System.out.print("초기재고 : ");
				String stock = scanner.next();
				System.out.print("가격 : ");
				int price = scanner.nextInt();
				int basket = 0; // 바구니 0부터 시작
				// 2. 해당 변수들을 하나의 데이터 구성 [ CSV파일형식 : 제품구별 \n / 제품내정보구분 , ]
				String outStr = name + "," + stock + "," + price + "," + basket + "\n";

				// 3. 파일에 내보내기// 1. 파일출력스트림 객체(if밖에) 2. 문자열 -> 바이트열변환 3. 바이트배열 내보내기
				fileOutputStream.write(outStr.getBytes()); // 2,3

				System.out.println("안내)제품 등록이 되었습니다.");
			} // if end
			//--------------------------------선택한 제품을 바구니 담기 -----------------------------
			else if(ch > 0 && 재고관리.length >= ch) {
				
				// 1. 선택한 제품번호의 각 정보 호출
				String product = 재고관리[ch-1];
				String name = product.split(",")[0]; // 제품명
				int stock = Integer.parseInt(product.split(",")[1]) ; // 재고
				int price = Integer.parseInt(product.split(",")[2]) ; // 가격
				int basket = Integer.parseInt(product.split(",")[3]) ; // 바구니
				// 2. 재고가 0보다 크면 재고/바구니 증감 , 없으면 행동x
				if( stock > 0) {stock--; basket++; System.out.println( name + " 제품을 담았습니다.");}	
				else { System.out.println( name + " 제품의 재고가 부족합니다.");}
				// 3. 배열 상태 업데이트
				재고관리[ch-1] = name + "," + stock + "," + price + "," + basket;
				
				// 3. 파일에 내보내기 // 파일내 제품들의 변화가 있으므로 업데이트 // 현재 재고관리배열 상태를 파일에 저장
				String outStr = "";
				for(int i =0; i< 재고관리.length; i++) {
					outStr += 재고관리[i].split(",")[0] + "," + 재고관리[i].split(",")[1] + 
							"," + 재고관리[i].split(",")[2] + "," + 재고관리[i].split(",")[3] + "\n";
				}//for end
				// 4. 재고관리 배열을 하나의 문자열로 변환된 문자열을 바이트 배열로 변환후 내보내기
				FileOutputStream fileOutputStream2 = new FileOutputStream( filePath );// 이어쓰기 x
				fileOutputStream2.write( outStr.getBytes() );
					
				
							
			}									
			//--------------------------------------결제 ---------------------------------------

			
			
			/* ----------- */

		} // while end
	} // main end
} // class end
