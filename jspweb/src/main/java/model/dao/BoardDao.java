package model.dao;

import java.util.ArrayList;

import model.dto.BoardDto;

public class BoardDao extends Dao{
	private static BoardDao boardDao = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() {return boardDao;}
	
	// 1. 글쓰기
	public boolean write( BoardDto boardDto) {
		try {
			String sql = "insert into board( btitle , bcontent , bimg , mno , cno) values( ? , ? , ? , ? , ? )";
			ps = conn.prepareStatement(sql);
			ps.setString( 1 , boardDto.getBtitle() );
			ps.setString( 2 , boardDto.getBcontent());
			ps.setString( 3 , boardDto.getBimg());
			ps.setInt(4, boardDto.getMno());
			ps.setInt(5, boardDto.getCno());
			int row = ps.executeUpdate();
			if( row  == 1)
				return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	// 2. 모든 글 출력
	public ArrayList<BoardDto> listRead(){
		ArrayList<BoardDto> dtoList = new ArrayList<>();
		try {	
			String sql = " select b.* , m.mid , m.mimg , bc.cname from "
					+ "board b natural join category bc "
					+ "natural join member m order by b.bwriteTime desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardDto dto = new BoardDto( rs.getInt("bno") ,
						rs.getString("btitle") , rs.getString("bcontent")
						,rs.getString("bimg") , rs.getString("bwriteTime")
						,rs.getInt("bview") , rs.getInt("mno")
						,rs.getInt("cno") , rs.getString("mid")
						,rs.getString("cname"),rs.getString("mimg") );
				dtoList.add(dto);
			}
			return dtoList;
			
		}catch(Exception e) {e.printStackTrace();}
		
		return null;
	}
	// 3. 개별 글 출력
	
	// 4. 게시물 수정
	
	// 5. 게시물 삭제
	
	// 6. 조회수 증가
	
}
