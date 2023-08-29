package library;

import java.util.ArrayList;

import model.dao.Dao;

public class LibraryDao extends Dao{
   
   //싱글톤
   private  static LibraryDao libraryDao = new LibraryDao();
   public static LibraryDao getInstance() {return libraryDao;}
   private LibraryDao() {}
   //이미 입실한 좌석인지 확인
   public boolean isSeatUsing( int seatNum ) {
	   try {
		   String sql = "select * from library where loutdate is null and lseatno = ?";
		   ps = conn.prepareStatement(sql);
		   ps.setInt( 1, seatNum);
		   rs = ps.executeQuery();
		   if(rs.next())
			   // 이미 입실해 있는 경우
			   return true;
	   }catch(Exception e) {e.printStackTrace();}
	   return false;
   }

   //입실정보등록
   public boolean checkIn(LibraryDto dto){
	   
	  if(isSeatUsing(dto.getLseatno()) == true)
		  return false;
	  
      String sql = "insert into library ( lname, lphone, lseatno ) values(?,?,?)";
      try {
         ps= conn.prepareStatement(sql);
         ps.setString(1, dto.getLname());
         ps.setString(2, dto.getLphone());
         ps.setInt(3, dto.getLseatno());

         int rs = ps.executeUpdate();
         // library 정보가 정상등록되면 seat테이블을 업데이트
         if(rs == 1 ) {

            sql = "update seat set lisuse = ? where lseatno =? ";
            ps= conn.prepareStatement(sql);
            ps.setBoolean(1, dto.isLisuse());
            ps.setInt(2, dto.getLseatno());

            rs = ps.executeUpdate();
            if(rs == 1) {
               return true;
            } else {
               sql = "delete from library where lseatno = ? and lphone=?";
               ps= conn.prepareStatement(sql);
               ps.setInt(1, dto.getLseatno());
               ps.setString(2, dto.getLphone());
               rs = ps.executeUpdate();
               if(rs == 1 ) {
                  System.out.println("seat 테이블 업데이트에 문제로 먼저 입력된 libary 정보가 삭제되어었습니다.");
                  return false;
               }
            }
         }
      } catch (Exception e) {e.printStackTrace(); } return false;
   }
   
   //퇴실정보등록 (입실정보수정)
   public boolean checkOut( int nowNum , String phoneNumber ) {
      try {
    	  String sql = "update library l , seat s set l.loutdate = now() , s.lisuse = false where l.lseatno = s.lseatno and s.lisuse = true and l.lphone = ? and l.loutdate is null and l.lseatno = ?";
      ps = conn.prepareStatement(sql);
      ps.setString(1, phoneNumber);
      ps.setInt(2, nowNum);
      int row = ps.executeUpdate();
      if(row == 2)	  
    	  return true;
      
      }catch(Exception e) { e.printStackTrace();}
	   
      return false;
   }
   // 핸드폰번호 체크
   public boolean checkPhone( int nowNum , String phoneNumber) {
	   try {
		   String sql = "select * from library l , seat s where l.lseatno = s.lseatno and l.lphone = ? and l.loutdate is null and l.lseatno = ?";
		   ps = conn.prepareStatement(sql);
		   ps.setString( 1, phoneNumber);
		   ps.setInt( 2, nowNum);
		   rs = ps.executeQuery();
		   if( rs.next() ) 		
			   return true;			     
		   
	   }catch(Exception e) {e.printStackTrace();}
	   return false;
   }
   
   //좌석정보출력
   public ArrayList<LibraryDto> showSeat(){
      ArrayList<LibraryDto> seatArr = new ArrayList<LibraryDto>();
      try {
    	  String sql = "select * from seat";
    	  ps = conn.prepareStatement(sql);
    	  rs = ps.executeQuery();
    	  while(rs.next()) {
    		  LibraryDto dto = new LibraryDto( rs.getInt(1) , rs.getBoolean(2) );
    		  seatArr.add(dto);
    	  }
    	  return seatArr;
      }catch(Exception e) {System.out.println(e);}
      return null;
   }
}
