package model.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.dto.MemberDto;
import model.dto.mpointDto;

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
	public boolean mupdate( int mno , String mimg ) {
		try {
			String sql = "update member set mimg = ? where mno = ?";
			ps = conn.prepareStatement(sql);			
			ps.setString(1,mimg);ps.setInt(2, mno);
			int row = ps.executeUpdate();
			if(row == 1)
				return true;		
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	public boolean mpwdUpdate( int mno , String mpwd , String newmpwd ) {
		try {
			String sql = "update member set mpwd = ? where mno = ? and mpwd = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, newmpwd);
			ps.setInt( 2, mno);
			ps.setString(3, mpwd);
			int row = ps.executeUpdate();
			System.out.println("실행");
			if(row == 1)
				return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
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
	// 9. 포인트 지급/사용에 대한 함수
	public boolean setPoint( mpointDto dto ) {
		try {
			String sql = "insert into mpoint( mpno , mno , mpamont, mpcomment) values(?,?,?,?) "; 
			ps = conn.prepareStatement(sql);
			ps.setString(1 , dto.getMpno()); ps.setInt(2, dto.getMno());
			ps.setLong(3, dto.getMpamount()); ps.setString(4, dto.getMpcomment());
			if( ps.executeUpdate() == 1) {return true;}
		} catch (Exception e) {e.printStackTrace();}				
		return false;
	}
	// 10. 내 포인트 수 확인 함수[ 로그인한 사람의 현재 포인트 합계 ]
	public long getPoint( int mno ) {
		try {
			String sql = "select sum( mpamount ) from mpoint where mno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			rs = ps.executeQuery();
			if( rs.next() ) return rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	// 11. 내 포인트 사용 내역 출력하는 함수 [ ]
	public List< mpointDto > getPointList( int mno ){
		List< mpointDto > list = new ArrayList<>();
		try {
			String sql = "select * from mpoint where mno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			rs = ps.executeQuery();
			while(rs.next()) {			
				mpointDto dto = new mpointDto(
						rs.getString(1) , rs.getInt(2),
						rs.getLong(3) , rs.getString(4),rs.getString(5));
				list.add(dto);					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		
}
