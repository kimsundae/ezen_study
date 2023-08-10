package 과제.과제11.model.dao;

import java.util.ArrayList;

import 과제.과제11.controller.BoardController;
import 과제.과제11.model.dto.BoardDto;

public class BoardDao extends Dao{
	// 싱글톤
	private static BoardDao boardDao = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() {return boardDao;}
	public boolean boardWrite( BoardDto boardDto) {
		
		try {
			// 1. SQL작성한다.
			String sql = "insert into board( btitle,bcontent,mno) values ( ? , ? , ?)";
			// 2. 작성한 SQL 조작할 인터페이스 PS 객체 반환한다.	
			ps = conn.prepareStatement(sql);
			// 3. SQL에 매개변수 대입 (조작)
			ps.setString( 1 , boardDto.getBtitle());
			ps.setString( 2 , boardDto.getBcontent());
			ps.setInt( 3 , boardDto.getMno());
			// 4. SQL실행 / 실행 후 저장된 레코드 개수 반환
			int row = ps.executeUpdate();
			
			if( row == 1) { return true; }
			
		}
		catch(Exception e) { System.out.println(e);}
		return false;
	}
	// 6. boardPrint : 모든 게시물 출력
	public ArrayList<BoardDto> boardPrint() {	
		ArrayList<BoardDto> list = new ArrayList<>(); // 여러개 BoardDto를 저장할 리스트객체 선언
		try {
			
			String sql = "select * from board order by bdate desc"; // 1. 최신순[desc내림차순]으로 모든 레코드 호출
			ps = conn.prepareStatement(sql);
			// 3. sql에 ? (매개변수) 없으므로 set 생략
			rs = ps.executeQuery(); // 4. 검색결과의 레코드를 여러개 조작하기 위해 resultSet
			//5. 여러개 레코드 조회 [rs.next() : 다음 레코드 이동(존재하면 true/존재하지않으면 false) ]
			// 마지막 레코드까지 하나씩 레코드 이동}
			while( rs.next() ) { 
				// [레코드 개수만큼 반복 ]
				// 레코드 1개마다 1개의 DTO 변환
				BoardDto dto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3) , rs.getString(4) , rs.getInt(5) , rs.getInt(6) , null);
				list.add(dto);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return list;
		
	}
	// 7. boardView	 : 개별 게시물 출력
	public BoardDto boardView( int bno) {
		try {
			
			String sql = "select b.* , m.mid from board b natural join member m where b.bno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1 , bno);
			rs = ps.executeQuery();
			if(rs.next()) {
				// 레코드1개 --> Dto 변환
				BoardDto dto = new BoardDto(rs.getInt(1), rs.getString(2), 
												rs.getString(3) , rs.getString(4) , 
													rs.getInt(5) , rs.getInt(6) , rs.getString(7));
				return dto;
			}
		}catch(Exception e) {System.out.println(e);}
		return null;
		
	}
	// 조회수 증가함수
	public boolean boardViewCount() {return false;}
	// 8. boardUpdate : 게시물 수정
	public void boardUpdate() {}
	// 9. boardDelete : 게시물 삭제
	public void boardDelete() {}
	// 10. 게시물 증가함수
	public boolean viewAdd( int bno ) {
		// 입력 게시물 번호에 해당하는 레코드를 가져와서 view 값을 찾는다. 기본값은 0
		// view를 증가시키려면 view값에 1을 더한 후 update를 해주어야한다.
		try {
			String sql = "select bview from board where bno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1 , bno );
			rs = ps.executeQuery();
			if(rs.next()) {
				String sql2 = "update board set bview = ? where bno = ?";
				ps = conn.prepareStatement(sql2);
				ps.setInt(1, rs.getInt(1)+1);
				ps.setInt(2, bno);		
				ps.executeUpdate();
				return true;
			}
		}
		catch(Exception e) {System.out.println(e);}
		return false;
	}
}

/*
 
 
 */

