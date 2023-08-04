package database;

import java.sql.DriverManager;
import java.sql.Connection;

public class JDBC연동 {
	public static void main(String[] args) {
		
		// --------------------- 예외가 발생할 것 같은 코드들 try{} 안  ------------------------//
		try { // JDBC 드라이버 클래스들의 예외처리
		
		// 1. p 908 : 현재 프로젝트에 JDBC 파일을 build path add 하기
		// 2. p 909 : DB연결하기 위해 JDBC Driver 클래스를 찾아서 메모리 로딩 하기
			// Class.forName("oracle.jdbc.OracleDriver"); // 오라클 기준
		Class.forName("com.mysql.cj.jdbc.Driver");
			// 만약에 해당 JDBC 드라이버 클래스가 검색이 실패하면 예외발생 -> 예외처리
		// 3. DB연결 [ DriverManager.getConnection() 메소드가 연결 성공하면 DB와 연결된 객체 리턴
													// -> 만약에 실패하면 예외 발생 -> 예외처리
//		Connection conn = DriverManager.getConnection("DB주소" , "계정명" , "비밀번호") ;
		/* 1. DB주소 :	- jdbc:mysql://ip주소:port번호/db명
		 				1. jdbc:oracle:thin:@localhost:1521/orcl
		 				2. jdbc:mysql://localhost:3306/orcl
		 */
		Connection coon = DriverManager.getConnection( "jdbc:mysql://localhost:3306/sqldb4web" , "root", "1234");
		System.out.println("안내) 연동성공 " + coon);
		}
		// --------------------- 만약에 try{}에서 예외가 발생했으면 실행되는 catch{} 코드 ------------------------// 
		catch( Exception e ) { // Exception클래스 : 모든 예외 정보를 담아주는 객체
			System.out.println("안내) 연동실패 사유: " + e); // 객체 출력하면 왜 예외가 발생했는지 사유 출력됨.
		}
	}
}

/*
	1. 자바 프로젝트에 JDBC 라이
 */

/*
 	예외처리 : 
 		- Exception 클래스
 		- 예외[오류] 발생했을 때 흐름 제어 [ *만약에 오류 발생했을 때 다른 코드로 흐름 제어 ]
 		- try{} catch{}
 			try{ 예외[오류]가 발생할 것 같은 코드 }
 			catch( 예외클래스명 객체변수명 ) { 예외가 발생했을 때 실행할 코드 }
 			
 			* try{} 안에서 예외가 발생하는 순간 바로 catch 이동하기 때문에 예외발생한 코드 아래로는 실행 안됨!
 		- 예외[오류]가 발생할 것 같은 코드
 			- 일반 예외 : 컴파일 과정에서 발생하는 예외	[ - 컴파일 체크하기 때문에 미리 처리가능 ] - 파일처리 , DB연동 , 입출력 등등
 				- 파일처리 , DB연동 , 입출력 등등
 			- 실행 예외 : 실행 도중에 발생하는 예외	[ - 개발자 경험으로 판단 ]
 				- 실행 중 각종 오류 [ 타입에러 , 인덱스부족 ]
 	
 */
