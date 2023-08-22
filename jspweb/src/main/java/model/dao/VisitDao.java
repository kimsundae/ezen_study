package model.dao;

import java.util.ArrayList;

import controller.member.VisitDto;

public class VisitDao extends Dao{
	// 싱글톤
	private static VisitDao visitDao = new VisitDao();
	private VisitDao() {}
	public static VisitDao getInstance() {return visitDao;}
	
	// 1. 저장 [ 인수 : 저장할 내용이 담긴 DTO , 리턴 : 성공/실패(boolean) = true/false ]
	public boolean vwrite( VisitDto visitDto) {
		// 0. try{} catch()
		try {
		// 1. SQL 작성
			String sql = "insert into visitlog( vwriter , vpw , vcontent ) values( ? , ? , ? )";
		// 2. SQL 연결
			ps = conn.prepareStatement(sql);
		// 3. SQL 매개변수 대입
			ps.setString(1,visitDto.getVwriter());
			ps.setString(2, visitDto.getVpw());
			ps.setString(3, visitDto.getVcontent());
		// 4. SQL 실행
			int row = ps.executeUpdate();
		// 5. 결과 반환	
			if(row == 1)
				return true;		
		}catch(Exception e) {System.out.println(e);}
		return false;
	}
	// 2. 호출 [ 인수 : x , 리턴 : 여러개(ArrayList)의 방문록DTO ]
	public ArrayList<VisitDto> vread(){
		ArrayList<VisitDto> arr = new ArrayList<>();
		try {
			String sql = "select * from visitlog";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				VisitDto visitdto = new VisitDto( rs.getInt(1) , rs.getString(2) , rs.getString(4) , rs.getString(5));
				arr.add(visitdto);
			}
			return arr;
		}catch(Exception e) {System.out.println(e);}
		return null;
	}
	// 3. 수정 [ 인수 : 수정할번호(int)/수정할방문록내용(String) , 리턴 : 성공/실패 = true/false ]
	public boolean vupdate( int vno , String vcontent ) {
		return false;	
	}
	// 4. 삭제 [ 인수 : 삭제할방문록번호(int) , 리턴 : 성공/실패(boolean) = true/false ] 
	public boolean vdelete( int vno ) {
		return false;
	}
}
