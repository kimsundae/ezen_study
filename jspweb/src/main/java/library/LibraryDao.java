package library;

import java.util.ArrayList;

import model.dao.Dao;

public class LibraryDao extends Dao{
   
   //싱글톤
   private  static LibraryDao libraryDao = new LibraryDao();
   public static LibraryDao getInstance() {return libraryDao;}
   private LibraryDao() {}

   
   
   //입실정보등록
   public void checkIn(){
      
      
   }
   
   //퇴실정보등록 (입실정보수정)
   public void checkOut() {
      
      
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
