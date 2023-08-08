package 과제.과제11.model.dao;

import 과제.과제11.model.dto.MemberDto;

public class MemberDao extends Dao{
	
	// 0. 싱글톤 객체
	private static MemberDao memberDao = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() {
		return memberDao;
	}
	// 1. 회원정보 check SQL
	public boolean infoCheck( String type , String values) {
		
		try {
			String sql="select * from member where " + type + " = "+"'"+ values +"'"  ;
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			if(rs.next()) {System.out.println("실행");return true;}
		}
					
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
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
	public int login( String id , String pw ) {
		
		try {
			// 1단계 : SQL 작성한다. [ 추천 : MYSQL 워크벤치에서 임의의값으로 테스트하고 ]
			String sql = "select * from member where mid = ? and mpw = ?";
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
				return rs.getInt(1); // 로그인 성공
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	//4. 
		public String findById( String name , String phone ) {
			// 1단계 : sql 작성.
			String sql = "select mid from member where mname = ? and mphone = ?";
			// 2단계 : 작성된 sql을 조작할 Preparedstatement객체를 연동객체로부터 반환
			
			try {
				ps = conn.prepareStatement(sql);
				// 3단계 : sql조작[ 매개변수 대입 ]
				ps.setString(1, name); // 1. sql문에 있는 첫번째 ? 에 name 변수 대입
				ps.setString(2, phone);	// 2. sql문에 있는 두번째 ? 에 phone 변수 대입
				// 4단계 : sql조작 [ sql 실행 (select = executeQuery() , insert , update , delete)]
				// 5단계 : sql 결과를 조작할 ResultSet 객체를 executeQuery 메소드로부터 반환
				rs = ps.executeQuery();
				// 6단계 : sql 결과 조작 
						// rs.next() : 검색된 레코드 중 다음 레코드 이동 
						// rs.get타입( 검색필드순서번호 )
						// rs.getString(검색필드순서번호) : 현재 위치한 레코드의 필드값 호출
						// rs.getInt(검색필드순서번호) : 현재 위치한 레코드의 필드값 정수 호출
				if(rs.next()) {
					return rs.getString(1);	// 검색된 레코드 중 1번째 필드인 id값 반환
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
			return null;// 실패
		}
		//5.
		public String findByPw( String id , String phone) {
			String sql = "select mpw from member where mid = ? and mphone = ?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, phone);
				rs = ps.executeQuery();
				if(rs.next()) {
					return rs.getString(1);	// 검색된 레코드 중 1번째 필드인 pw값을 반환
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
			return null;
		}
		// 6.
		public MemberDto info( int mno ) {
			try {
				String sql = "select * from member where mno = ?";
				ps = conn.prepareStatement(sql); // 2. SQL조작할 객체
				ps.setInt( 1 , mno ); // 3. SQL 조작
				rs = ps.executeQuery(); // 4. sql 실행 // 5. sql 결과 조작 객체
				if(rs.next()) { // 6. sql결과 조작 // 만약에 다음 레코드가 존재하면
					// * 현재 레코드[ 1:회원번호 , 2:아이디 3:비밀번호 4:이름 5:전화번호]를 DTO로 만들기
					MemberDto dto = new MemberDto(rs.getInt(1) , rs.getString(2),
								null , rs.getString(4) , rs.getString(5));
					return dto;
				}
			}
			catch(Exception e) { System.out.println(e);}
			return null; // 실패
		}
		// 7. 비밀번호 수정
		public boolean fixPw( int mno , String newPw ) {
			try {
				String sql = "update member set mpw = ? where mno = ?"; // 1. SQL작성한다.
				ps = conn.prepareStatement(sql); // 2. 작성한 SQL 조작할 객체 반환
				ps.setString(1 , newPw);
				ps.setInt(2, mno);
				int row = ps.executeUpdate(); // 4.SQL실행 [ 업데이트한 레코드 개수 반환 ]
				if(row == 1) return true;
			}
			catch(Exception e){
				System.out.println(e);
			}
			return false;
		}
		//8. 회원 탈퇴
		public boolean infoDelete(int mno) {
			try {
				String sql = "delete from member where mno = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, mno);
				int row = ps.executeUpdate(); // [ 삭제한 레코드 개수 반환 ]
				if( row == 1) return true;
			}catch(Exception e) { System.out.println(e);}
			
			return false; // 실패
		}
		
		//. 글쓰기
		public boolean boardWrite( String title , String content) {
			return false;
		}
	
}