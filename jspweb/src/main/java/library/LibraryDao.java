package library;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.dao.Dao;

public class LibraryDao extends Dao{
   
   //싱글톤
   private  static LibraryDao libraryDao = new LibraryDao();
   public static LibraryDao getInstance() {return libraryDao;}
   private LibraryDao() {}

   

 //입실정보등록
   public boolean checkIn(LibraryDto dto){

      String sql = "insert into library ( lname, lphone, lseatno ) values(?,?,?)";
      try {
         ps= conn.prepareStatement(sql);
         ps.setString(1, dto.getLname());
         ps.setString(2, dto.getLphone());
         ps.setInt(3, dto.getLseatno());

         int rs = ps.executeUpdate();
         // library 정보가 정상등록되면 seat테이블을 업데이트
         if(rs == 1 ) {

            sql = "update seat set  lisuse = ? where lseatno =? ";
            ps= conn.prepareStatement(sql);
            ps.setBoolean(1, dto.isLisuse());
            ps.setInt(2, dto.getLseatno());

            rs = ps.executeUpdate();
            if(rs == 1) {
               System.out.println(" 입실등록이 정상처리되었습니다.");
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
   public boolean checkOut( int nowNum ) {
      try {
    	  String sql = "update seat set lisuse = false where lseatno = ? and lisuse = true";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, nowNum);
      int row = ps.executeUpdate();
      if(row == 1) {
    	  
		  String sql2 = "update library set loutdate = now() where lseatno = "+nowNum;
		  ps = conn.prepareStatement(sql2);
		  int row2 = ps.executeUpdate();
		  if(row2 != 1)
			  return false;
		  
    	  return true;
      }
      }catch(Exception e) { e.printStackTrace();}
	   
      return false;
   }
   // 핸드폰번호 체크
   public boolean checkPhone( int nowNum , String phoneNumber) {
	   try {
		   String sql = "select lphone from library where lseatno = "+nowNum+" and loutdate is null;";
		   ps = conn.prepareStatement(sql);
		   rs = ps.executeQuery();
		   if(rs.next()) {
			  
			  return phoneNumber.equals(rs.getString(1)) == true ? true : false;
			   
		   }
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
