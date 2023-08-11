package 과제.과제11.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {	// 각종 Dao 클래스를 대표하는 부모클래스
	
	// 1. 필드
	// [ import java.sql ]
	public Connection conn; // DB연동 객체 
	public PreparedStatement ps; // 연동된 DB 조작 객체
	public ResultSet rs;		// SQL 조작 결과를 가져오는 객체
	// 2. 생성자 : 객체 생성 시 초기화 담당
		// 기본생성자에 DB연동 코드 작성 *DAO객체 생성 시 바로 DB 연동
	public Dao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb4web" , "root" ,"0000" );
			
		}
		catch( Exception e) { 
			System.out.println("경고] DB연동 실패 : " + e);
		}		
	}
		// 기본생성자에 DB연동 코드 작성 *DAO객체 생성 시 바로 DB연동
}
