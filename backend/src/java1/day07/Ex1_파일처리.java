package java1.day07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex1_파일처리 {

	public static void main(String[] args) throws IOException {
/*		
		 스택영역 : 함수는 호출{ 시 메모리할당 종료} 시 메모리초기화 * 지역변수
		 힙영역 : 객체/배열은 참조하는 스택이 없으면 자동으로 메모리가 초기화/삭제
			 ----> RAM 주기억장치 : 현재 처리된 처리된 명령어 저장 --> 전기X저장X -> 휘발성[타서 날라감]
		 영구저장
			 ---> 보조기억장치 : 명령어 영구 저장 --> 전기X저장O	-> 비휘발성
		 Ex1_파일처리.java
			 저장위치 : c:~~~ 보조기억장치
			 실행[ctrl+f11] : 실행 중에 필요한 메모리(변수,객체,배열 등) -> 주기억장치
			 실행 중인 메모리를 다음에 또 사용하려면 주기억장치 메모리를 보조기억장치 저장 / 불러오기
		
			 String a = scanner.next(); --------------> c: 저장	[ 파일처리 , 데이터베이스 ]
			 컴퓨터 종료 후 다음날
			 String b =				<--------------- c: 불러오기
		
		 파일처리 라이브러리(미리 만들어진 클래스/메소드 )
			 * 스트림 : 자바 외부의 통신할 때 사용 통로 [ * 바이트 단위 ]
				 * 통신하다가 갑자기 오류 발생할 수도 있음 [ * 필수 : 미리 예외처리/오류처리 ]
			 1. FileOutputStream : 파일 내보내기/저장 관련된 메소드 제공
				 new FileOutputStream("파일경로"); 해당파일과 연동/연결
					만약에 파일경로에 해당 파일이 존재하지 않으면 해당 파일 생성
				 new FileOutputStream("파일경로" true); 해당파일과 연동/연결
					만약에 파일경로에 해당 파일이 존재하지 않으면 해당 파일 생성 , 이어쓰기
				 파일경로 :
					 상대경로 : 프로젝트명생략 -> ./src/패키지명/파일명.java
					 절대경로 : C:~~
		
		 2. FileInputStream : 파일 불러오기 관련된 메소드 제공하는 클래스
			new FileInputStream("파일경로")		: 해당파일과 연동/연결
		
			 2. 제공하는 함수 /메소드
				1. write( 바이트배열 )	:	1~2바이트=한글자	바이트배열 = 여러글자
				 2. read(바이트배열)	 	:	해당 객체와 연결된 파일의 바이트 읽어와서 바이트배열에 저장 
			 1. 문자열.getBytes() :  해당 문자열을 바이트배열 반환
			 2. new String(바이트배열);	: 해당 바이트배열을 문자열로 반환
		
			 3. File			: 파일에 정보/제어 관련 메소드 제공
				메소드
					1. .exists()	:	
*/		
		Scanner scanner = new Scanner(System.in); // 입력객체 = 입력한 값이 바이트로 들어옴
		String instr = scanner.nextLine(); // 입력받은 값 바이트열을 문자열로 반환
		
		// 1. 파일처리 [ 저장 ]
			// 1. 파일출력스트림 객체 선언 [ 파일경로 ]
		FileOutputStream fileOutputStream = new FileOutputStream("./src/java1/day07/Ex2_테스트.txt" , true);
			// 2. 파일출력스트림 객체를 이용한 내보내기 메소드 사용 [ 바이트 단위 ]
		byte[] outstrArray = instr.getBytes(); // 문자열을 바이트배열로 변환후
		fileOutputStream.write( outstrArray ); // 바이트배열을 내보내기
		
		// 2. 파일처리 [ 불러오기 ]
			// 1. 파일입력스트림 객체선언 [ 파일경로 ]
		FileInputStream fileInputStream = new FileInputStream("./src/java1/day07/Ex2_테스트.txt");
			// 2. 파일입력스트림 객체를 이용한 파일내용 읽어오기 [ 바이트 단위 ]
		byte[] intstrArray = new byte[1000]; //파일의 바이트 만큼 배열 선언 [ * 정확한 파일의 용량 알 수 없어서 임의로 ]
			// 2. 바이트 읽어서 해당 바이트 배열에 저장
		fileInputStream.read( intstrArray );
			// 3. 바이트배열을 문자열 반환
		String str = new String( intstrArray ); 
		System.out.println( str );
		
		// 3. 외부파일 불러오기 [ CSV 불러오기 ]
			// 1. 역대 로또 번호 [ CSV ]
		FileInputStream 복권파일 = new FileInputStream("./src/java1/day07/로또.csv");
			// 2.해당파일의 용량 알기 [ 40,960바이트]
		File file = new File("./src/java1/day07/로또.csv");
			System.out.println("해당 경로에 파일존재여부 : " + file.exists());
		//file.delete();
			System.out.println("해당 파일의 경로 : " + file.getPath());
			System.out.println("해당 파일의 용량(바이트) : " + file.length());
		byte[] 복권파일바이트배열 = new byte[(int)file.length()]; //용량만큼 배열 선언
			// 3. 읽어오기
		복권파일.read( 복권파일바이트배열 );
			// 4. 바이트배열 --> 문자열 변환
		String 복권파일정보 = new String( 복권파일바이트배열 );
		System.out.println( 복권파일정보 );
		
		// 4. 외부파일 불러오기 [ CSV 불러오기]
		String 경로 = "./src/java1/day07/전국관광지정보표준데이터.csv";
			// 1. 관광지 파일 호출
		FileInputStream 관광지파일 = new FileInputStream(경로);
			// 2. 파일 정보 객체 생성
		File file2 = new File(경로); // 2. 파일 정보 객체 생성
		byte[] 관광지파일바이트배열 = new byte[ (int)file2.length()]; // 3. 파일 용량만큼의 바이트배열 선언
		관광지파일.read(관광지파일바이트배열); // 4. 읽어온 바이트를 해당 배열에 저장
		//String 관광지파일정보 = new String(관광지파일바이트배열); // 5. 바이트배열 --> 문자열 변환
		//String 관광지파일정보 = new String(관광지파일바이트배열 , "UTF-8"); // 문자열 변환시 한글이 존재하면 UTF-8 방식으로 변환
		String 관광지파일정보 = new String(관광지파일바이트배열 , "EUC-KR"); // 문자열 변환시 한글이 존재하면 EUC-KR 방식으로 변환
		System.out.println(관광지파일정보.split("\n")[0]); // 한글 인코딩(번역) 방법 대표적으로 2가지 : UTF-8 , EUC-KR
		
	}

}
