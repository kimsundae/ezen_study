package 과제.과제11.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import 과제.과제11.controller.BoardController;
import 과제.과제11.model.dto.BoardDto;
import 과제.과제11.model.dto.MsgDto;

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
	public boolean boardUpdate( BoardDto dto ) {
		
		try {
			
			String sql = "update board set btitle = ? , bcontent = ? where bno = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getBtitle());
			ps.setString(2, dto.getBcontent());
			ps.setInt(3, dto.getBno());
			
			// Query(resultSet 반환)는 rs를 사용하여 찾은 레코드의 값을 가져올 수 있음 , insert 등은 
			// executeUpdate(int 반환)를 사용하여 업데이트한 레코드 수를 가져올 수 있음 (row) 
			// [select -> rs = ps.executeQuery() / insert,update,delete -> int row]
			int row = ps.executeUpdate(); // 실행하고나서 실행 결과에 대한 레코드 개수 반환 int
			if( row == 1) return true;
			else return false;	
		}catch(Exception e) {System.out.println(e);}
		return false;
	}
	// 9. boardDelete : 게시물 삭제
	public boolean boardDelete(int bno) {
		
		try {
			String sql = "delete from board where bno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int row = ps.executeUpdate();
			if( row == 1) return true;
			else return false;
		}catch(Exception e) {
			System.out.println(e);
		}		
		return false;
	}
	// 10. 게시물 증가함수
	public void viewAdd( int bno ) {
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
				
			}
		}
		catch(Exception e) {System.out.println(e);}
	
	}
	// 쪽지 보내기
	public boolean sendMsg( int bno , int mno , String content) {
		
	
		try {
			// 게시글 작성자의 멤버번호를 알아야함
			String sql1 = "select mno from board where bno = ?";
			ps = conn.prepareStatement(sql1);
			ps.setInt(1, bno);
			rs = ps.executeQuery();
			int value = 0;
			if(rs.next()) {
				value = rs.getInt(1);
			}
			
			// 쪽지 업데이트
			String sql2 = "insert into tableMsg(smno , rmno , mcontent ) values( ? , ? , ? )";
			ps = conn.prepareStatement(sql2);
			ps.setInt( 1, mno);
			ps.setInt(2, value);
			ps.setString(3, content);
			ps.executeUpdate();
			
			return true;
			
		}catch(Exception e) {System.out.println(e);	}
		return false;		
	}
	// 쪽지 확인하기
	public ArrayList<MsgDto> viewMsg( int mno ) {
		ArrayList<MsgDto> dtoArr = new ArrayList<>(); 
		try {
			// 멤버 번호에 해당하는 쪽지 갖고오기
			String sql = "select * from tableMsg where rmno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			rs = ps.executeQuery();
			while(rs.next()) {
				//보낸 사람의 아이디도 알아야함
				String sql2 ="select mid from member m , tableMsg t where m.mno = t.smno and m.mno = ?";
				ps = conn.prepareStatement(sql2);
				ps.setInt(1, rs.getInt(2));
				ResultSet rs2 = ps.executeQuery();
				String id = "";
				if(rs2.next()) {
					id = rs2.getString(1);
				}
				MsgDto dto = new MsgDto(id , rs.getString(4) , rs.getString(5));
				dtoArr.add(dto);
			}
			return dtoArr;
		}
		catch(Exception e) {
			System.out.println(e);
		}
	return null;	
	}
	public boolean sendMsg( String name , String content , int mno) {
		try {
			String sql = "select mno from member where mname = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			int number = 0;
			if( rs.next()) {
				number = rs.getInt(1);
			}
			sql = "insert into tableMsg(smno , rmno , mcontent ) values( ? , ? , ? )";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			ps.setInt(2, number);
			ps.setString(3, content);
			ps.executeUpdate();
			return true;
			
		}catch(Exception e){
			System.out.println(e);
		}
		return false;
	}
}

/*
 
 
 */

