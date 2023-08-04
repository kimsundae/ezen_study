package 과제.과제11.model.dao;

import 과제.과제11.model.dto.MemberDto;

public class MemberDao extends Dao{
	
	// 0. 싱글톤 객체
	private static MemberDao memberDao = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() {
		return memberDao;
	}
	
	// 2. 회원가입SQL
	public boolean signup( MemberDto member ) { 
	
		System.out.println( member );
		// 1. 회원가입 필요한 SQL을 문자열에 작성해서 저장 (SQL이 아닌 자바 언어여서)
			// 테이블에 레코드 삽입 
		String sql = "insert into member( mid , mpw , mname , mphone ) values(? , ? , ? , ? ) ";
		try {// Connection , PreparedStatement , ResultSet 예외 처리 필수!!!
			// 2. 위에서 작성한 SQL을 DB연동객체에 대입 // 3. 대입한 SQL 조작하기 위해 반환된 prepareStatement를 ps 대입
			ps = conn.prepareStatement( sql ); // db연동객체.prepareStatement(조작할 sql 문자열)
			// conn , ps 필드는 Dao 부모클래스에게 물려받음
			// 4. SQL에서 작성한 매개변수(?)에 대해 값 대입 [ .setString( ?순서번호 , 값 ) ]
			ps.setString( 1 , member.getId());
			ps.setString( 2 , member.getPw());
			ps.setString( 3 , member.getName());
			ps.setString( 4 , member.getPhone());
			
			// 5. SQL 실행						[ps.executeUpdate(); : SQL 실행 ]
			ps.executeUpdate();
			return true;
		}
		catch(Exception e) { System.out.println("경고] 회원가입실패 사유 : " + e);}
		return false;
	}
	// 3. 로그인SQL
	public boolean login( String id , String pw ) {
		
		try {
			// 1단계 : SQL 작성한다. [ 추천 : MYSQL 워크벤치에서 임의의값으로 테스트하고 ]
			String sql = "select mid , mpw from member where mid = ? and mpw = ?";
			// 2단계 : SQL 조작할 수 있는 객체 필요하므로 PreparedStatement 반환받기
			ps = conn.prepareStatement(sql);
			// 3단계 : SQL 조작 [SQL 안에 있는 매개변수[?]에 값 대입]
			ps.setString(1, id);
			ps.setString(2, pw);
			// 4단계 : SQL 실행해서 그 결과객체를 rs객체에 대입 [ * ps는 결과를 조작할 수 없다. ]
			// [ insert/update/delete : ps.executeUpdate(); / select : ps.executeQuery(); ]
			rs = ps.executeQuery();
			// 5단계 : sql 실행 결과 조작 [ rs.next() : 결과 중에서 다음 레코드객체 호출 ]
			// 만약에 결과의 레코드 3개 가정 [ rs = null -> 레코드1 -> 레코드2 -> 레코드3 ]
			if (rs.next()) { // 로그인SQL 결과 레코드는 1개 또는 0개이므로 if 사용해서 .next()1번 호출
				return true; // 로그인 성공
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
		
		
	}
}
