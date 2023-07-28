package 복습.part4;

import java.io.*;
import java.util.Scanner;


public class part4 {
	public static void main(String[] args) throws IOException {
	
			while(true) {
				 String filePath = "C:\\Users\\504\\git\\ezen_study\\backend\\src\\복습\\part4\\재고관리.txt";
				 FileOutputStream fileOutputStream = new FileOutputStream(filePath , true);
				 FileInputStream fileInputStream = new FileInputStream(filePath);
				 File file = new File(filePath);
				 Scanner sc = new Scanner(System.in);
				 byte[] insByte = new byte[(int)file.length()];
				 fileInputStream.read(insByte);
				 String fileInfo = new String(insByte);
				 String[] 재고관리 = fileInfo.split("\n");
			
				 System.out.print(" -1: 재고등록  0:결제  ");
				 if ( 재고관리.length > 1) {
						 for(int i = 0; i < 재고관리.length; i++) {
						 String name = 재고관리[i].split(",")[0];
						 int stock = Integer.parseInt(재고관리[i].split(",")[1]);
						 int price = Integer.parseInt(재고관리[i].split(",")[2]);					 
						 if(stock > 0)
						 System.out.print(" "+ (i+1)+ "." + name + "[" + price + "]");
						 else 
							 System.out.print(" "+ (i+1) +"."+ name + "[재고없음]");
					 }				 					 
				 }
				 System.out.println();
				 System.out.print("선택>"); int ch = sc.nextInt();
				 if( ch == -1 ) {
					 System.out.print("제품명을 입력해주세요"); String name = sc.next();
					 System.out.print("재고를 입력해주세요"); int stock = sc.nextInt();
					 System.out.print("가격을 입력해주세요"); int price = sc.nextInt();
					 int basket = 0;
					 
					 String out = name + "," + stock + "," + price + "," + basket + "\n";
					 fileOutputStream.write(out.getBytes());
				 }
				 if( ch > 0 && 재고관리.length >= ch) {
					 String name = 재고관리[ch-1].split(",")[0];
					 int stock = Integer.parseInt(재고관리[ch-1].split(",")[1]);
					 int price = Integer.parseInt(재고관리[ch-1].split(",")[2]);
					 int basket = Integer.parseInt(재고관리[ch-1].split(",")[3]);
					 if(stock > 0) {
						stock--;
						basket++;
					 }else {
						 System.out.println("재고가 부족합니다.");
					 }
					 재고관리[ch-1] = name + "," + stock + "," + price + "," + basket;
					 String out = "";
					 for(int i = 0; i < 재고관리.length; i++) 
						 out += 재고관리[i]+"\n";
					 FileOutputStream fileOutputStream2 = new FileOutputStream(filePath);
					 fileOutputStream2.write(out.getBytes());
				 }
				 if(ch == 0) {
					 
					 System.out.println("- 현재 바구니 현황 표시 목록");
					 System.out.println(" ---------------------");
					 for(int i = 0; i < 재고관리.length; i++) {
						 String name = 재고관리[i].split(",")[0];
						 int stock = Integer.parseInt(재고관리[i].split(",")[1]);
						 int price = Integer.parseInt(재고관리[i].split(",")[2]);
						 int basket = Integer.parseInt(재고관리[i].split(",")[3]);
						 if( basket > 0) {
							 System.out.println(" " + name + " " + basket + " " + (basket*price));
						 }						 
					 }
				 }
			}
	}		
}
