package model.dao;

import java.time.LocalDateTime;

import model.dto.MemberDto;

public class MemberDao extends Dao{
	private static MemberDao memberDao = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() {return memberDao;}
	
	
	
	// 1. 회원가입
	public boolean signup( MemberDto dto ) {
		try {
			String sql = "insert into member(mid , mpwd , memail , mimg) values( ? , ? , ? , ? )";
			ps = conn.prepareStatement(sql);
			ps.setString(1 , dto.getMid());
			ps.setString(2, dto.getMpwd());
			ps.setString(3, dto.getMemail());
			ps.setString(4 , dto.getMimg());
			int row = ps.executeUpdate();
			if(row == 1 ) return true;
		}catch(Exception e) {System.out.println(e);}
		
		return false;
	}
	// 2. 로그인
	public boolean login( String mid , String mpwd ) {
		try {
			String sql = "select * from member where mid= ? and mpwd = ?";
			ps = conn.prepareStatement(sql);
			ps.setString( 1 , mid );
			ps.setString( 2 , mpwd);
			rs = ps.executeQuery();
			if( rs.next() ) 
				return true;
			
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	// 3. 아이디찾기
	
	// 4. 비밀번호 찾기
	
	// 5. 내정보 호출
	public MemberDto info( String mid ) {
		try {
			String sql = "select mno , mid , memail , mimg from member where mid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if(rs.next()) {
				MemberDto memberDto = new MemberDto( LocalDateTime.now().toString() , 
						rs.getInt(1) , 
						rs.getString(2) ,
						rs.getString(3)  , 
						rs.getString(4) );
				return memberDto;
			}
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	// 6. 아이디/이메일 중복검사
	public boolean findIdOrEmail( String type , String data ) {
		try {
			String sql = "select * from member where "+ type +" = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, data);
			rs = ps.executeQuery();
			if( rs.next() ) return true;
		}catch(Exception e) {System.out.println(e);}
		return false;
	}
	// 7. 회원수정
	
	// 8. 회원탈퇴
	public boolean deleteId( int mno , String mpwd) {
		try {
			System.out.println("실행");
			String sql = "delete from member where mno = ? and mpwd = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			ps.setString(2, mpwd);
			int row = ps.executeUpdate();
			if(row == 1)
				return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	
}
